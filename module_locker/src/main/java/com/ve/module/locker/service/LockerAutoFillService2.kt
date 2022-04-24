package com.ve.module.locker.service

import android.app.assist.AssistStructure
import android.app.assist.AssistStructure.ViewNode
import android.app.assist.AssistStructure.WindowNode
import android.service.autofill.*
import android.view.autofill.AutofillId
import android.view.autofill.AutofillValue
import android.widget.RemoteViews
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R


//此填充服务以name作为主键，通过此字段来去重，也通过此字段来作为显示时的表单标题
//当应用没有name字段时，也可以设置一个隐藏的自动填充控件，来设置自己想要的主键和表单标题
//当用户保存表单时，如果确实没有name字段，服务将会根据当前时间来生成一个name主键
//此填充服务不支持同一个控件拥有多个字段，当同一控件拥有多个字段时，将以第一个字段为准
//此填充服务不支持多个控件使用同一个字段，当多个控件使用同一字段时，只有最后的控件内容会被保存
public class LockerAutoFillService2 : AutofillService() {
    companion object {
        val HINT_TYPE_NAME: String = "name"
        val HINT_TYPE_PASSWORD: String = "password"
        val HINT_TYPE_PHONE: String = "phone"
        val HINT_TYPE_PACKAGE: String = "package"
        val HINT_TYPE_COLLECTIONS: MutableList<String?> = ArrayList()

        //模拟数据库中的数据，实际应用中，应该将这个数据保存在数据库中
        private val suggestions: MutableList<Map<String?, String>> =
            ArrayList()

        init {
            HINT_TYPE_COLLECTIONS.add(HINT_TYPE_NAME)
            HINT_TYPE_COLLECTIONS.add(HINT_TYPE_PASSWORD)
            HINT_TYPE_COLLECTIONS.add(HINT_TYPE_PHONE)
            HINT_TYPE_COLLECTIONS.add(HINT_TYPE_PACKAGE)
        }

        init {
            //模拟数据库中的数据，实际应用中，应当把表单保存到数据库中，填充时再从数据库读取
            val suggestion1: MutableMap<String?, String> =
                HashMap()
            suggestion1.put(HINT_TYPE_NAME, "表单1")
            suggestion1.put(HINT_TYPE_PASSWORD, "123456")
            suggestion1.put(HINT_TYPE_PHONE, "18420015500")
            suggestions.add(suggestion1)
            val suggestion2: MutableMap<String?, String> =
                HashMap()
            suggestion2.put(HINT_TYPE_NAME, "表单2")
            suggestion2.put(HINT_TYPE_PASSWORD, "abcdefg")
            suggestion2.put(HINT_TYPE_PHONE, "17935842251")
            suggestions.add(suggestion2)
        }
    }

    override fun onFillRequest(
        request: FillRequest,
        cancellationSignal: android.os.CancellationSignal,
        callback: FillCallback
    ) {
        LogUtil.msg("1.onFillRequest")
        //获取所有自动填充节点的AutofillId和HintType
        val structures: List<AssistStructure> = request.fillContexts.stream().map { obj: FillContext -> obj.getStructure() }
                .collect(java.util.stream.Collectors.toList())
        val hintTypeMap: Map<AutofillId?, String> =
            parseAllHintType(structures)

        LogUtil.msg("2.onFillRequest "+structures.toString())
        LogUtil.msg("3.onFillRequest "+hintTypeMap.toString())
        LogUtil.msg(suggestions.toString())
        //每条建议记录对应填充服务中的一个Dataset对象
        //每个Dataset代表了一套数据，包含name，password，phone等所有保存的字段
        //我们用Map来记录Dataset的数据，从而可以方便得将其存储到数据库或内存中
        val fillResponseBuilder: FillResponse.Builder = FillResponse.Builder()
        for (suggestion: Map<String?, String> in suggestions) {
            val datasetBuilder: Dataset.Builder = Dataset.Builder()
            val name: String? = suggestion.get(HINT_TYPE_NAME)
            val presentation: RemoteViews = createPresentation(name)
            for (autofillId: AutofillId? in hintTypeMap.keys) {
                //将suggestion中的单个字段加入dataset
                val hintType: String? = hintTypeMap.get(autofillId)
                val value: String? = suggestion.get(hintType)
                if (value != null) datasetBuilder.setValue(
                    (autofillId)!!,
                    AutofillValue.forText(value),
                    presentation
                )

                //设置需要保存的表单节点，这一步一定要有，否则Activity退出时不会保存表单
                val saveInfoBuilder: SaveInfo.Builder = SaveInfo.Builder(
                    HINT_TYPE_COLLECTIONS.indexOf(hintType),
                    arrayOf(autofillId)
                )
                //设置关联的节点，如果不设置，只有所有节点值发生变化时，系统才认为表单发生了变更，才会询问是否要保存表单
                saveInfoBuilder.setOptionalIds(
                    hintTypeMap.map { it.key }.toTypedArray()
//                    hintTypeMap.keys.stream()
//                        .toArray((null))

                )
                val saveInfo: SaveInfo = saveInfoBuilder.build()
                fillResponseBuilder.setSaveInfo(saveInfo)
            }
            val dataset: Dataset = datasetBuilder.build()
            fillResponseBuilder.addDataset(dataset)
        }
        val fillResponse: FillResponse = fillResponseBuilder.build()
        //成功
        callback.onSuccess(fillResponse)
    }

    override fun onSaveRequest(request: SaveRequest, callback: SaveCallback) {
        //获取所有自动填充的节点
        val structures: List<AssistStructure> =
            request.getFillContexts().stream().map(
                { obj: FillContext -> obj.getStructure() }
            ).collect(java.util.stream.Collectors.toList())
        val viewNodes: MutableList<ViewNode> = ArrayList()
        parseAllAutofillNode(structures, viewNodes)
        //保存表单内容
        //每条建议记录对应一个Map，Map每个键值対代表控件的HintType和文本值
        val suggestion: MutableMap<String?, String> = HashMap()
        for (viewNode: ViewNode in viewNodes) {
            val hintType: String = viewNode.getAutofillHints()!!.get(0)
            val value: String = viewNode.getText().toString()
            suggestion.put(hintType, value)
        }
        suggestions.add(suggestion)
        //成功
        callback.onSuccess()
    }

    //获取所有自动填充的节点
    private fun parseAllAutofillNode(
        structures: List<AssistStructure>,
        autofillNodes: MutableList<ViewNode>
    ) {
        for (structure: AssistStructure in structures) {
            val windowNodeCount: Int = structure.getWindowNodeCount()
            for (i in 0 until windowNodeCount) {
                val windowNode: WindowNode = structure.getWindowNodeAt(i)
                val rootViewNode: ViewNode = windowNode.getRootViewNode()
                parseAllAutofillNode(rootViewNode, autofillNodes)
            }
        }
    }

    //获取所有自动填充的节点
    private fun parseAllAutofillNode(
        viewNode: ViewNode,
        autofillNodes: MutableList<ViewNode>
    ) {
        if (viewNode.getAutofillHints() != null) autofillNodes.add(viewNode)
        val childCount: Int = viewNode.getChildCount()
        for (i in 0 until childCount) parseAllAutofillNode(viewNode.getChildAt(i), autofillNodes)
    }

    //获取所有Autofill节点的HintType
    private fun parseAllHintType(structures: List<AssistStructure>): Map<AutofillId?, String> {
        val hintTypeMap: MutableMap<AutofillId?, String> = HashMap()
        for (structure: AssistStructure in structures) {
            val windowNodeCount: Int = structure.getWindowNodeCount()
            for (i in 0 until windowNodeCount) {
                val windowNode: WindowNode = structure.getWindowNodeAt(i)
                val rootViewNode: ViewNode = windowNode.getRootViewNode()
                parseAllHintType(rootViewNode, hintTypeMap)
            }
        }
        return hintTypeMap
    }

    //获取所有Autofill节点的HintType
    private fun parseAllHintType(
        viewNode: ViewNode,
        hintTypeMap: MutableMap<AutofillId?, String>
    ) {
        if (viewNode.getAutofillHints() != null) hintTypeMap.put(
            viewNode.getAutofillId(), viewNode.getAutofillHints()!!
                .get(0)
        )
        val childCount: Int = viewNode.getChildCount()
        for (i in 0 until childCount) parseAllHintType(viewNode.getChildAt(i), hintTypeMap)
    }

    //创建一个表单建议对应的View
    private fun createPresentation(name: String?): RemoteViews {
        val presentation: RemoteViews = RemoteViews(packageName, R.layout.locker_item_autofill2)
        presentation.setTextViewText(R.id.text, name)
        return presentation
    }
}