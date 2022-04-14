package com.ve.lib_network.utils;

import static android.content.Context.CONNECTIVITY_SERVICE;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.ve.lib.application.BaseApplication;


public class NetUtil {

    private static final String TAG = "NetUtil";

    /**
     * 判断网络是否连接
     *
     * @return 网络是否连接
     */
    public static boolean isConnected() {

        ConnectivityManager connectivity = (ConnectivityManager) BaseApplication.context
                .getSystemService(CONNECTIVITY_SERVICE);

        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                return info.getState() == NetworkInfo.State.CONNECTED;
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     *
     * @return 是否是wifi连接
     */
    public static boolean isWifi() {
        ConnectivityManager cm = (ConnectivityManager) BaseApplication.context
                .getSystemService(CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;

    }

}
