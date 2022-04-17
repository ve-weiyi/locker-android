package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.vutils.LogUtil
import com.ve.lib.vutils.TimeUtil
import com.ve.module.locker.R
import com.ve.module.locker.databinding.LockerFragmentCardEditBinding
import com.ve.module.locker.logic.database.entity.PrivacyCardDetails
import com.ve.module.locker.logic.database.entity.PrivacyFolder
import com.ve.module.locker.logic.database.entity.PrivacyCardInfo
import com.ve.module.locker.logic.database.entity.PrivacyTag
import com.ve.module.locker.ui.state.LockerPrivacyCardViewModel
import org.litepal.LitePal

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class LockerCardDetailsEditFragment:BaseVmFragment<LockerFragmentCardEditBinding,LockerPrivacyCardViewModel>(){
    override fun attachViewBinding(): LockerFragmentCardEditBinding {
        return LockerFragmentCardEditBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCardViewModel> {
        return LockerPrivacyCardViewModel::class.java
    }

    companion object {
        const val FRAGMENT_TYPE_KEY: String = "LockerDetailsCardEditFragment.type"
        const val FRAGMENT_DATA_KEY: String = "LockerDetailsCardEditFragment.data"
    }
    /**
     * 查看,新增,编辑 三种状态
     * 查看，不可以修改，只显示
     */
    private var mType = EditType.SEE_TAG_TYPE
    private lateinit var mData: PrivacyCardInfo

    private lateinit var mPrivacyInfoCard: PrivacyCardInfo
    private lateinit var mPrivacyFolder: PrivacyFolder
    private lateinit var mCardDetails: PrivacyCardDetails
    private var mTagList: MutableList<PrivacyTag>?=null
    private lateinit var mSpinner: Spinner

    override fun initView(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        arguments?.let {
            mType = it.getInt(FRAGMENT_TYPE_KEY, EditType.SEE_TAG_TYPE)
            val data = it.getSerializable(FRAGMENT_DATA_KEY)

            if (data is PrivacyCardInfo) {
                mData = data
                showAtFragment(mData)
            }

        }

        val mAdapter=ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_dropdown_item)
        val folderList=LitePal.findAll(PrivacyFolder::class.java)
        val folderName=folderList.map { it.folderName }
        LogUtil.msg(folderList.toString())
        mAdapter.addAll(folderName)
        mSpinner=mBinding.layoutBaseInfo.spacerFolder
        mSpinner.apply {
            adapter=mAdapter
            onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    mPrivacyFolder=folderList[position]
                    LogUtil.msg(mPrivacyFolder.toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }

    }

    override fun initWebData() {
        super.initWebData()
    }
    override fun initListener() {
        super.initListener()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.locker_privacy_edit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_privacy_check->{
                LogUtil.msg("onOptionsItemSelected")
                mBinding.apply {
                    if (checkValid()){
                        mViewModel.addPrivacyInfo( mPrivacyInfoCard,mCardDetails,mPrivacyFolder,mTagList)
                    }
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.addPrivacyInfoMsg.observe(this){
            LogUtil.msg("346576798090")
            showMsg(it)
            activity?.finish()
        }
    }


    private fun checkValid(): Boolean {
        mBinding.apply {

            val owner = layoutDetailsInfo.etDetailOwner.editText!!.text.toString()
            val account = layoutDetailsInfo.etDetailAccount.editText!!.text.toString()
            var password = layoutDetailsInfo.etDetailPassword.editText!!.text.toString()
            val address = layoutDetailsInfo.etDetailAddress.editText!!.text.toString()
            val phone = layoutDetailsInfo.etDetailPhone.editText!!.text.toString()
            val remark = layoutDetailsInfo.etDetailRemark.editText!!.text.toString()
            if(owner.isEmpty()||account.isEmpty()){
                showMsg("持有人姓名和卡号不能为空哦！ Σ(oﾟдﾟoﾉ)")
                return false
            }
            if(password.isEmpty()){
                showMsg("未设置密码，初始化密码为12345678。")
                password="12345678"
            }

            mCardDetails = PrivacyCardDetails(
                owner = owner,
                number = account,
                password = password,
                phone = phone,
                address = address,
                remark = remark
            )

            var name: String = layoutBaseInfo.etPrivacyName.text.toString()
            val desc = layoutBaseInfo.etPrivacyDesc.text.toString()

            if(name.isEmpty()){
                name=owner+"的卡片 "+TimeUtil.date
            }
            mPrivacyInfoCard = PrivacyCardInfo(
                privacyName = name,
                privacyDesc = desc,
                privacyCover = "#00AA00"

            )
            return  true
        }
    }

    private fun showAtFragment(privacyInfoCard: PrivacyCardInfo) {

        LogUtil.msg(privacyInfoCard.toString())

        val cardDetails=privacyInfoCard.getPrivacyDetails()
        val folder=privacyInfoCard.getPrivacyFolder()
        val tags=privacyInfoCard.getPrivacyTags()
        LogUtil.msg(cardDetails.toString())
        LogUtil.msg(folder.toString())
        LogUtil.msg(tags.toString())
        mBinding.apply {
            layoutDetailsInfo.etDetailOwner.hint=cardDetails.owner
            layoutDetailsInfo.etDetailAccount.hint=cardDetails.number
            layoutDetailsInfo.etDetailPassword.hint==cardDetails.password
            layoutDetailsInfo.etDetailAddress.hint=cardDetails.address
            layoutDetailsInfo.etDetailPhone.hint=cardDetails.phone
            layoutDetailsInfo.etDetailRemark.hint=cardDetails.remark
        }
    }

}