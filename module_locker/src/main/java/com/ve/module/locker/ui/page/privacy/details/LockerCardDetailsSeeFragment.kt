package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import android.view.View
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.view.ext.setOnclickNoRepeatListener
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.databinding.LockerFragmentCardSeeBinding
import com.ve.module.locker.logic.database.entity.PrivacyCardDetails
import com.ve.module.locker.logic.database.entity.PrivacyCardInfo
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.state.LockerPrivacyCardViewModel

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class LockerCardDetailsSeeFragment:BaseVmFragment<LockerFragmentCardSeeBinding,LockerPrivacyCardViewModel>(),
    View.OnClickListener {

    companion object{
        const val PRIVACY_DATA_KEY="DetailsCard"

    }
    override fun attachViewBinding(): LockerFragmentCardSeeBinding {
        return LockerFragmentCardSeeBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCardViewModel> {
        return LockerPrivacyCardViewModel::class.java
    }

    var mPrivacyInfoCard:PrivacyCardInfo?=null

    override fun initView(savedInstanceState: Bundle?) {

        mPrivacyInfoCard=arguments?.getSerializable(PRIVACY_DATA_KEY) as PrivacyCardInfo
        LogUtil.msg(mPrivacyInfoCard.toString())
        LogUtil.msg(mPrivacyInfoCard!!.getPrivacyTags().toString())
        LogUtil.msg(mPrivacyInfoCard!!.getPrivacyFolder().toString())
        LogUtil.msg(mPrivacyInfoCard!!.getPrivacyDetails().toString())

        if(mPrivacyInfoCard!=null){
            shoPrivacyInfo(mPrivacyInfoCard!!)
            showPrivacyDetails(mPrivacyInfoCard!!.getPrivacyDetails())
        }

    }

    override fun initListener() {
        super.initListener()
        mBinding.btnEdit.setOnclickNoRepeatListener (this)
        mBinding.btnCopy.setOnclickNoRepeatListener(this)
        mBinding.btnDelete.setOnclickNoRepeatListener(this)
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.deletePrivacyInfoMsg.observe(this){

            if(it>0){
                showMsg("删除成功！$it")
                activity?.finish()
            }else{
                showMsg("删除失败！$it")
            }
        }
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_edit->{
                val bundle=Bundle()
                bundle.putInt(LockerCardDetailsEditFragment.FRAGMENT_TYPE_KEY,EditType.EDIT_TAG_TYPE)
                bundle.putSerializable(LockerCardDetailsEditFragment.FRAGMENT_DATA_KEY,mPrivacyInfoCard)
                LockerContainerActivity.start(
                    mContext,
                    LockerCardDetailsEditFragment::class.java,
                    "编辑:${mPrivacyInfoCard?.privacyName}",
                    bundle
                )
            }
            R.id.btn_delete->{
                mViewModel.deletePrivacyInfo(mPrivacyInfoCard!!)
            }
        }
    }
    private fun shoPrivacyInfo(privacyInfoCard:PrivacyCardInfo){
        val folder=privacyInfoCard.getPrivacyFolder()
        val tags=privacyInfoCard.getPrivacyTags()
        val tagsName=tags.map { it.tagName }
        mBinding.apply {
            tvPrivacyName.text=privacyInfoCard.privacyName
            tvPrivacyDesc.text=privacyInfoCard.privacyDesc
            tvPrivacyFolder.text=folder.folderName
            tvPrivacyTag.text=tagsName.toString()
        }
    }


    private fun showPrivacyDetails(privacyDetails : PrivacyCardDetails){
        mBinding.apply {
            etDetailAccount.setText(privacyDetails.owner)
            etDetailPassword.setText(privacyDetails.password)
            etDetailPhone.setText(privacyDetails.phone)
            etDetailRemark.setText(privacyDetails.remark)
        }
    }

}