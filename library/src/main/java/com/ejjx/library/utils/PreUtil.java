package com.ejjx.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 数据本地存储
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/6/7.
 */

public class PreUtil {

    private final String DB_NAME = "config";
    private static PreUtil prefrenceUtil = null;

    private Context context;
    private SharedPreferences preferences;

    private PreUtil(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 实例化当前类
     *
     * @param context
     * @return
     */
    public static PreUtil getInstance(Context context) {
        if (prefrenceUtil == null)
            synchronized (PreUtil.class) {
                if (prefrenceUtil == null)
                    prefrenceUtil = new PreUtil(context.getApplicationContext());
            }
        return prefrenceUtil;
    }

    /**
     * 设置字符串
     *
     * @param key   存储key
     * @param value 存储的value
     */
    public void setString(String key, String value) {
        SharedPreferences.Editor sharedata = preferences.edit();
        sharedata.putString(key, value);
        sharedata.commit();
    }


    /**
     * 获取存储的字符串
     *
     * @param key 存储的索引
     * @param def 获取的为空时，默认value
     * @return
     */
    public String getString(String key, String def) {
        return preferences.getString(key, def);
    }

    /**
     * 设置Long
     *
     * @param key   存储key
     * @param value 存储的value
     */
    public void setLong(String key, long value) {
        SharedPreferences.Editor sharedata = preferences.edit();
        sharedata.putLong(key, value);
        sharedata.commit();
    }

    /**
     * 获取存储的Long
     *
     * @param key 存储的索引
     * @param def 获取的为空时，默认value
     * @return
     */
    public Long getLong(String key, long def) {
        return preferences.getLong(key, def);
    }


    /**
     * 存储Boolean
     *
     * @param key   存储索引
     * @param value 存储的value
     */
    public void setBoolean(String key, boolean value) {
        SharedPreferences.Editor sharedata = preferences.edit();
        sharedata.putBoolean(key, value);
        sharedata.commit();
    }


    /**
     * 获取存储布尔值
     *
     * @param key 索引
     * @param def @null 设置成默认值
     * @return
     */
    public boolean getBoolean(String key, boolean def) {
        return preferences.getBoolean(key, def);
    }

}
