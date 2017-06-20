package com.ejjx.library.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

/**
 * 手机终端设备信息工具类 如： 获取设备的型号、操作系统版本、品牌等
 *
 * @author zcc
 */
public class DeviceUtil {

    /**
     * 获取手机设备管理对象
     *
     * @param context
     * @return
     */
    public static TelephonyManager getTM(Context context) {
        return (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
    }

    /**
     * 手机的品牌
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 手机的型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机操作系统 及版本
     *
     * @return
     */
    public static String getOsVersion() {
        return "android:" + android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取设备的imei号
     *
     * @return
     */
    public static String getIMEI(Context context) {
        return getTM(context).getDeviceId();
    }

    /**
     * 获取设备的sn序列号
     *
     * @return
     */
    public static String getPhoneSn(Context context) {
        if (null != context) {
            return Secure.getString(context.getContentResolver(),
                    Secure.ANDROID_ID);
        }
        return null;
    }

    /**
     * 获取ua信息
     */
    public static String getUa(Context context) {
        return getPhoneBrand() + ";|" + getPhoneModel() + ";|" + getOsVersion()
                + ";|" + getIMEI(context);
    }

    /**
     * 获取当前应用的版本号
     */
    public static String getAppVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                    0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
