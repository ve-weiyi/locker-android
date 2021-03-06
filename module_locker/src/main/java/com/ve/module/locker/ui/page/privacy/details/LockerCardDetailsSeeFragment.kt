package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.utils.DialogUtil
import com.ve.lib.view.ext.setOnclickNoRepeatListener
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.common.event.RefreshDataEvent
import com.ve.module.locker.databinding.LockerFragmentSeeCardBinding
import com.ve.module.locker.model.db.entity.PrivacyCardDetails
import com.ve.module.locker.model.db.entity.PrivacyCardInfo
import com.ve.module.locker.model.db.vo.PrivacyCard
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.viewmodel.LockerPrivacyCardViewModel
import com.ve.module.locker.utils.StickUtils
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class LockerCardDetailsSeeFragment:BaseVmFragment<LockerFragmentSeeCardBinding,LockerPrivacyCardViewModel>(),
    View.OnClickListener {

    companion object{
        const val PRIVACY_DATA_KEY="DetailsCard"

    }
    override fun attachViewBinding(): LockerFragmentSeeCardBinding {
        return LockerFragmentSeeCardBinding.inflate(layoutInflater)
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
        mBinding.tvCopyOwner.setOnclickNoRepeatListener(this)
        mBinding.tvCopyAccount.setOnclickNoRepeatListener(this)
        mBinding.tvCopyPassword.setOnclickNoRepeatListener(this)
        mBinding.tvCopyPhone.setOnclickNoRepeatListener(this)
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.deletePrivacyCardResult.observe(this){

            if(it>0){
                showMsg("???????????????$it")
                mEventBus?.post(RefreshDataEvent(PrivacyCardInfo::class.java.name))
                activity?.finish()
            }else{
                showMsg("???????????????$it")
            }
        }
    }
    override fun onClick(v: View?) {
        val account=mBinding.etDetailAccount.text.toString()
        val password=mBinding.etDetailPassword.text.toString()
        val phone=mBinding.tvCopyPhone.text.toString()
        when(v?.id){
            R.id.btn_edit->{
                val bundle=Bundle()
                bundle.putInt(LockerCardDetailsEditFragment.FRAGMENT_TYPE_KEY,EditType.EDIT_TAG_TYPE)
                bundle.putSerializable(LockerCardDetailsEditFragment.FRAGMENT_DATA_KEY,mPrivacyInfoCard)
                LockerContainerActivity.start(
                    mContext,
                    LockerCardDetailsEditFragment::class.java,
                    "??????:${mPrivacyInfoCard?.privacyName}",
                    bundle
                )
            }
            R.id.btn_delete->{
                DialogUtil.getConfirmDialog(
                    mContext,
                    "?????????????????????:$account",
                    onOKClickListener = { d, w ->
                        mViewModel.deletePrivacyCard(mPrivacyInfoCard!!)
                    },
                    onCancelClickListener = { d, w ->
                        showMsg("????????????")
                    }
                ).show()
            }
            R.id.btn_copy->{
                StickUtils.copy(mContext,"??????:$account\n??????:$password")
            }
            R.id.tv_copy_owner->{
                StickUtils.copy(mContext, account)
            }
            R.id.tv_copy_account->{
                StickUtils.copy(mContext, account)
            }
            R.id.tv_copy_password->{
                StickUtils.copy(mContext, password)
            }
            R.id.tv_copy_phone->{
                StickUtils.copy(mContext, phone)
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
            tvPrivacyCreateTime.text=privacyInfoCard.createTime
            tvPrivacyUpdateTime.text=privacyInfoCard.updateTime
        }
    }


    private fun showPrivacyDetails(privacyDetails : PrivacyCardDetails){
        mBinding.apply {
            etDetailOwner.setText(privacyDetails.owner)
            etDetailAccount.setText(privacyDetails.number)
            etDetailPassword.setText(privacyDetails.password)
            etDetailPassword.transformationMethod= PasswordTransformationMethod.getInstance()
            etDetailPhone.setText(privacyDetails.phone)
            etDetailRemark.setText(privacyDetails.remark)
        }
    }
    /**
     * Refresh Data Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onRefreshDataEvent(event: RefreshDataEvent) {
        if(PrivacyCardInfo::class.java.name==event.dataClassName){
            LogUtil.d("$mViewName receiver event "+event.dataClassName)
            if(event.data is PrivacyCard){
                mPrivacyInfoCard=event.data.privacyInfo
                shoPrivacyInfo(mPrivacyInfoCard!!)
                showPrivacyDetails(mPrivacyInfoCard!!.getPrivacyDetails())
            }
            hasLoadData=false
        }
    }
}