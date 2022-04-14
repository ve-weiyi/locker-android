package com.ve.module.main.ui.page.drawer

import android.content.Intent
import android.location.*
import android.os.Bundle
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.lib.utils.LocationUtil
import com.ve.lib.vutils.LogUtil
import com.ve.module.main.databinding.FragmentDrawerProfileBinding
import com.ve.module.main.ui.state.DrawerViewModel
import com.ve.module.sunny.ui.weather.WeatherActivity
import com.ve.module.sunny.util.SkyUtil
import com.ve.module.sunny.util.SunnyConstant


/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/6
 */
class DrawerProfileFragment: BaseVmFragment<FragmentDrawerProfileBinding, DrawerViewModel>() {
    override fun attachViewBinding(): FragmentDrawerProfileBinding {
        return FragmentDrawerProfileBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<DrawerViewModel> {
        return DrawerViewModel::class.java
    }

    lateinit var location: Location
    lateinit var placeName:String

    override fun initView(savedInstanceState: Bundle?) {
        LocationUtil.init(this)
        location= LocationUtil.getLocation()!!
        val address=LocationUtil.getAddress(location)
        placeName=address!![0].featureName
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.weatherLiveData.observe(this){
            LogUtil.e(it.daily.toString())
            LogUtil.e(it.realtime.toString())
            mBinding.actionTodayWeather.rightTextView.text="${it.realtime.temperature} °C"
            mBinding.actionTodayWeather.rightImageView.setImageResource(SkyUtil.getSky(it.realtime.skycon).icon)
        }
    }
    override fun initWebData() {
        super.initWebData()
        mViewModel.refreshWeather(location.longitude.toString(),location.latitude.toString())
    }


    override fun initListener() {
        super.initListener()
        mBinding.actionTodayWeather.setOnClickListener {
            LogUtil.e("---"+location.longitude+"---"+location.latitude+"---"+placeName)
            val intent = Intent(requireContext(), WeatherActivity::class.java).apply {
                putExtra(SunnyConstant.KEY_LOCATION_LNG, location.longitude.toString())
                putExtra(SunnyConstant.KEY_LOCATION_LAT, location.latitude.toString())
                putExtra(SunnyConstant.KEY_PLACE_NAME, placeName)
            }
            startActivity(intent)
        }
    }

}