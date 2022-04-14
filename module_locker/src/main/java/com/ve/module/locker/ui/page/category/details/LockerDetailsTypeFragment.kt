package com.ve.module.locker.ui.page.category.details

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.lib.common.utils.ImageLoader
import com.ve.lib.view.ext.formatCurrentDate
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.common.event.RefreshDataEvent
import com.ve.module.locker.databinding.LockerFragmentDetailsTypeBinding
import com.ve.module.locker.logic.http.model.PrivacyType
import com.ve.module.locker.ui.page.category.list.LockerListTypeFragment
import com.ve.module.locker.ui.state.LockerPrivacyCategoryViewModel
import java.util.*

/**
 * @Author  weiyi
 * @Date 2022/4/12
 * @Description  current project locker-android
 */
class LockerDetailsTypeFragment :
    BaseVmFragment<LockerFragmentDetailsTypeBinding, LockerPrivacyCategoryViewModel>() {

    companion object {

        const val FRAGMENT_TYPE_KEY: String = "LockerDetailsTypeFragment.type"
        const val FRAGMENT_DATA_KEY: String = "LockerDetailsTypeFragment.key"
    }

    override fun attachViewBinding(): LockerFragmentDetailsTypeBinding {
        return LockerFragmentDetailsTypeBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCategoryViewModel> {
        return LockerPrivacyCategoryViewModel::class.java
    }


    /**
     * 查看,新增,编辑 三种状态
     */
    private var mType = EditType.SEE_TAG_TYPE
    private lateinit var mData: PrivacyType

    private lateinit var tv_date: TextView
    private lateinit var et_id: EditText
    private lateinit var et_title: EditText
    private lateinit var et_content: EditText

    private lateinit var rb0: RadioButton
    private lateinit var rb1: RadioButton
    private lateinit var ll_date: LinearLayout
    private lateinit var btn_save: Button
    private lateinit var iv_arrow_right: ImageView
    private lateinit var ll_priority: LinearLayout
    /**
     * Date
     */
    private var mCurrentDate = formatCurrentDate()

    override fun initView(savedInstanceState: Bundle?) {

        tv_date = mBinding.tvDate
        et_id = mBinding.etId
        et_title = mBinding.etTitle
        et_content = mBinding.etContent
        rb0 = mBinding.rb0
        rb1 = mBinding.rb1
        ll_date = mBinding.llDate
        btn_save = mBinding.btnSave
        iv_arrow_right = mBinding.ivArrowRight
        ll_priority = mBinding.llPriority


        arguments?.let {
            mType = it.getInt(FRAGMENT_TYPE_KEY, EditType.SEE_TAG_TYPE)
            val data = it.getSerializable(FRAGMENT_DATA_KEY)

            if (data is PrivacyType) {
                mData = data
                showAtFragment(mData)
            }

            initTypeView(mType)
        }
    }


    private fun showAtFragment(privacyType: PrivacyType) {
        LogUtil.msg(privacyType.toString())
        mBinding.etId.setText(privacyType.id.toString())
        mBinding.etTitle.setText(privacyType.typeName)
        mBinding.etContent.setText(privacyType.typeDesc)
        ImageLoader.loadView(mContext, privacyType.typeCover, mBinding.ivCover)
    }

    private fun initTypeView(type: Int) {
        mBinding.etId.isEnabled = false
        when (mType) {
            EditType.SEE_TAG_TYPE -> {
                mBinding.etTitle.isEnabled = false
                mBinding.etContent.isEnabled = false
                mBinding.btnSave.visibility = View.GONE
                mBinding.ivArrowRight.visibility = View.GONE
            }
            EditType.EDIT_TAG_TYPE -> {

            }
            EditType.ADD_TAG_TYPE -> {
                mBinding.tvDate.text = mCurrentDate
            }
            else -> {

            }
        }
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.typeAddMsg.observe(this){
            showMsg(it)
            mEventBus?.post(RefreshDataEvent(LockerListTypeFragment::class.java.name))
            activity?.finish()
        }

        mViewModel.typeUpdateMsg.observe(this){
            showMsg(it)
            mEventBus?.post(RefreshDataEvent(LockerListTypeFragment::class.java.name))
            activity?.finish()
        }
    }

    override fun initListener() {
        super.initListener()
        mBinding.btnSave.setOnClickListener {
            val typeName: String = et_title.text.toString()
            val typeCover: String = "#FF0000"
            val typeDesc = et_content.text.toString()

            when (mType) {
                EditType.SEE_TAG_TYPE -> {

                }
                EditType.EDIT_TAG_TYPE -> {
                    val typeId: Int? = mData.id
                    val privacyType = PrivacyType(typeId, typeName, typeCover, typeDesc)
                    mViewModel.typeUpdate(privacyType)
                }
                EditType.ADD_TAG_TYPE -> {
                    val privacyType = PrivacyType(-1, typeName, typeCover, typeDesc)
                    mViewModel.typeAdd(privacyType)
                }
                else -> {

                }
            }
        }

        mBinding.llDate.setOnClickListener{
            var now = Calendar.getInstance()
            val dpd = DatePickerDialog(
                requireActivity(), { view, year, month, dayOfMonth ->
                    mCurrentDate = "$year-${month + 1}-$dayOfMonth"
                    tv_date.text = mCurrentDate
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            dpd.show()
        }
    }

}