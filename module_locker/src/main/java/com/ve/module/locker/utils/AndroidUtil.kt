package com.ve.module.locker.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Log
import com.ve.lib.vutils.AppContextUtils
import com.ve.lib.vutils.LogUtil
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.Serializable
import java.security.MessageDigest
import java.util.regex.Pattern
import kotlin.experimental.and

object AndroidUtil {

    fun getAppIcon(context: Context, appId: String): Bitmap? {
        return try {
            val drawable = context.packageManager.getApplicationIcon(appId)
            drawableToBitmap(drawable)
        } catch (e: Exception) {
            Log.e("getAppIcon", "getAppIcon error", e)
            null
        }
    }

    fun getAppByPackageName(context: Context, packageName: String): AppInfo? {
        val packageManager: PackageManager = context.packageManager
        return try {
        val packages = packageManager.getInstalledPackages(0)

        val appInfo = context.packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        LogUtil.msg(appInfo.packageName)
        return AppInfo( appInfo.packageName,appInfo.loadLabel(packageManager).toString(), appInfo.loadIcon(packageManager))
        } catch (e: Exception) {
            LogUtil.msg(e)
            e.printStackTrace()
            return AppInfo(context.applicationInfo,packageManager)
        }
    }

    fun getAppName(context: Context, appId: String): String? {
        return try {
            val appInfo =
                context.packageManager.getApplicationInfo(appId, PackageManager.GET_META_DATA)
            appInfo.loadLabel(context.packageManager).toString()
        } catch (e: Exception) {
            Log.e("getAppName", "getAppName error", e)
            return context.applicationInfo.name
        }
    }


    /**
     * ?????????????????????????????????????????????
     *
     * @param name  ?????????
     * @param isAll ????????????????????????
     * @return ???????????????????????????
     */
    fun findAppsByName(name: String?, isAll: Boolean): ArrayList<AppInfo> {
        val result = ArrayList<AppInfo>()
        val list = getAllAppInfo(AppContextUtils.mContext, isAll)
        // ???????????????
        val pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE)
        for (i in list.indices) {
            val matcher = pattern.matcher(list[i].name)
            if (matcher.find()) {
                result.add(list[i])
            }
        }
        return result
    }

    /**
     * ????????????????????????????????????App
     *
     */

    @SuppressLint("QueryPermissionsNeeded")
    fun getAllAppInfo(context: Context, isSystemApp: Boolean = false): MutableList<AppInfo> {

        val packageManager: PackageManager = context.packageManager
        val packages = packageManager.getInstalledPackages(0)

        val appInfoList = mutableListOf<AppInfo>()

        for (i in packages.indices) {
            val packageInfo = packages[i]
            val appInfo = AppInfo()
            //??????????????????
            appInfo.name = packageInfo.applicationInfo.loadLabel(packageManager).toString()
            //???????????????????????????????????????????????????
            appInfo.packageName = packageInfo.applicationInfo.packageName
            //??????????????????
            appInfo.icon = packageInfo.applicationInfo.loadIcon(packageManager)

            if (isSystemApp) {
                // ????????????
                appInfoList.add(appInfo)
            } else {
                if (packageInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0) {
                    //???????????????
                    appInfoList.add(appInfo)
                }
            }
        }


        return appInfoList
    }


    data class AppInfo(
        /**
         * ???????????????
         */
        var packageName: String = "unknown",

        /**
         * ???????????????????????????
         */
        var name: String = "unknown",

        /**
         * ???????????????icon
         */
        var icon: Drawable? = null,

        ) : Serializable {

            constructor(applicationInfo: ApplicationInfo,packageManager: PackageManager) : this() {
                packageName=applicationInfo.packageName
                name=applicationInfo.loadLabel(packageManager).toString()
                icon=applicationInfo.loadIcon(packageManager)
            }

    }


    fun getCertificatesHash(context: Context, packageName: String): String {
        val pm: PackageManager = context.packageManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val info: PackageInfo =
                pm.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            val hashes = ArrayList<String>(info.signingInfo.apkContentsSigners.size)
            for (sig in info.signingInfo.apkContentsSigners) {
                val cert: ByteArray = sig.toByteArray()
                val md: MessageDigest = MessageDigest.getInstance("SHA-256")
                md.update(cert)
                hashes.add(bytesToHex(md.digest()))
            }
            hashes.sort()
            val hash = StringBuilder()
            for (i in 0 until hashes.size) {
                hash.append(hashes[i])
            }
            return hash.toString()
        } else {
            val info: PackageInfo = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            val hashes = ArrayList<String>(info.signatures.size)
            for (sig in info.signatures) {
                val cert: ByteArray = sig.toByteArray()
                val md: MessageDigest = MessageDigest.getInstance("SHA-256")
                md.update(cert)
                hashes.add(bytesToHex(md.digest()))
            }
            hashes.sort()
            val hash = StringBuilder()
            for (i in 0 until hashes.size) {
                hash.append(hashes[i])
            }
            return hash.toString()
        }
    }

    private fun drawableToBitmap(drawable: Drawable): Bitmap {

        // ?????? drawable ??????
        val width = drawable.intrinsicWidth
        val height = drawable.intrinsicHeight
        drawable.setBounds(0, 0, width, height)

        // ??????drawable???????????????
        val config: Bitmap.Config =
            if (drawable.opacity != PixelFormat.OPAQUE) Bitmap.Config.ARGB_8888 else Bitmap.Config.RGB_565
        // ??????bitmap
        val bitmap: Bitmap = Bitmap.createBitmap(width, height, config)
        // ??????bitmap??????
        val canvas = Canvas(bitmap)
        // ???drawable ?????????????????????
        drawable.draw(canvas)
        return bitmap
    }

    private val HEX_ARRAY = "0123456789ABCDEF".toCharArray()

    fun bytesToHex(bytes: ByteArray): String {
        val hexChars = CharArray(bytes.size * 2)
        for (j in bytes.indices) {
            val v: Int = (bytes[j] and 0xFF.toByte()).toInt()
            hexChars[j * 2] = HEX_ARRAY[v ushr 4]
            hexChars[j * 2 + 1] = HEX_ARRAY[v and 0x0F]
        }
        return String(hexChars)
    }


}