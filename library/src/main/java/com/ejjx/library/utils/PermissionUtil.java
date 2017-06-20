package com.ejjx.library.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by liuguang on 2017/4/28 0028.
 * 动态权限获取类
 */
public class PermissionUtil {
     /**
      * 判断是否有权限单一权限
     */
    public static boolean isHasPermission(Context context,String permission){
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
        {
            return false;
        }
        return true;
    }
    /**
     * 判断多个权限
     */
    public static boolean isHasPermissions(Context context, String[] permissions ){
        for (int i = 0; i <permissions.length ; i++) {
            if (ContextCompat.checkSelfPermission(context, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
               return false;
           }
        }
        return true;
    }
    /**
     *获取单一权限,获得权限后在activity中重写onRequestPermissionsResult进行回调处理
     * @param permission 需要获得的单一权限
     * @param falg 申请权限的回调标识
     * */
    public static void getPermission(Activity activity,String permission, int falg){
        ActivityCompat.requestPermissions(activity, new String[]{permission}, falg);
    }
    /**
     *获取多个权限，获得权限后在activity中重写onRequestPermissionsResult进行回调处理
     * @param permissions 需要获得的权限数组
     * @param falg 申请权限的回调标识
     * */
    public static void getPermissions(Activity activity,String[] permissions, int falg){
        ActivityCompat.requestPermissions(activity, permissions, falg);
    }



}
