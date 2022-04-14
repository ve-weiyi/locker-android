package com.ve.lib.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.*
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.permissionx.guolindev.PermissionX
import com.ve.lib.application.BaseApplication.Companion.context
import com.ve.lib.vutils.LogUtil
import java.util.*

/**
 * @Description hello word!
 * https://www.jianshu.com/p/fb89ab396bf8
 * @Author weiyi
 * @Date 2022/4/7
 */
object LocationUtil {
    /**
     * Android原生方式获取经纬度两种定位方式：GPS定位和Wifi定位
     *
     * GPS定位相比Wifi定位更精准且可在无网络情况下使用，但在室内基本暴毙无法使用。
     * WiFi定位没有室内外限制，也不需要开启GPS但需要联网。但测试发现WiFi定位时onLocationChanged函数（用于监听经纬度变化）触发间隔无法小于30s。
     *
     * 作者：木木玩Android
     * 链接：https://www.jianshu.com/p/fb89ab396bf8
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    const val LOCATION_CODE = 301
    private var locationManager: LocationManager? = null
    private var locationProvider: String? = null


    fun init(fragment: Fragment) {
        permissionCheck(fragment)
        LogUtil.e("TAG", "LocationUtil init")
        val activity = fragment.requireActivity()
        //1.获取位置管理器
        locationManager = getSystemService(activity, LocationManager::class.java)

        //2.获取位置提供器，GPS或是NetWork
        val providers = locationManager!!.getProviders(true)

        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER
            Log.v("TAG", "定位方式GPS")
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER
            Log.v("TAG", "定位方式Network")
        } else {
            Toast.makeText(context, "没有可用的位置提供器", Toast.LENGTH_SHORT).show()
            return
        }

    }

    //2.获取位置提供器，GPS或是NetWork  返回经纬度
    @SuppressLint("MissingPermission")
    fun getLocation() :Location? {

        val location = locationManager!!.getLastKnownLocation(locationProvider!!)
        if (location != null) {

            LogUtil.e("TAG", "获取上次的位置-经纬度：" + location.longitude + "   " + location.latitude)
        } else {
            //监视地理位置变化，第二个和第三个参数分别为更新的最短时间minTime和最短距离minDistace
            locationManager!!.requestLocationUpdates(locationProvider!!,
                3000,
                1f,
                locationListener)
        }
        return location
    }

    var locationListener: LocationListener = object : LocationListener {
        // Provider被enable时触发此函数，比如GPS被打开
        override fun onProviderEnabled(provider: String) {}

        // Provider被disable时触发此函数，比如GPS被关闭
        override fun onProviderDisabled(provider: String) {}

        //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
        override fun onLocationChanged(location: Location) {
            if (location != null) {
                //如果位置发生变化，重新显示地理位置经纬度
                LogUtil.e("TAG", "监视地理位置变化-经纬度：" + location.longitude + "   " + location.latitude)
            }
        }
    }


    //获取地址信息:城市、街道等信息
    fun getAddress(location: Location?): List<Address>? {
        var result: List<Address>? = null
        try {
            if (location != null) {
                val gc = Geocoder(context, Locale.getDefault())
                result = gc.getFromLocation(location.latitude, location.longitude, 1)

                LogUtil.e("TAG", "获取地址信息：$result")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    fun destroy() {
        locationManager!!.removeUpdates(locationListener)
    }


    fun permissionCheck(fragment: Fragment) {
        val activity = fragment.requireActivity()
        //添加权限检查
        if (ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            LogUtil.e("TAG", "没有权限")

            //请求权限
            PermissionX.init(fragment)
                .permissions(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                .onExplainRequestReason { scope, deniedList ->
                    val message = "PermissionX需要您同意以下权限才能正常使用"
                    scope.showRequestReasonDialog(deniedList, message, "Allow", "Deny")
                }
                .request { allGranted, grantedList, deniedList ->
                    if (allGranted) {
                        Toast.makeText(activity, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, "您拒绝了如下权限：$deniedList", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}