package com.example.mylibrary;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

/**
 * Created by acer on 2017/3/27.
 * 常用工具类
 */

public class Utils {
    /**
     * @param context 上下文
     * @param key     键名
     * @param value   键值
     *                保存sp值到setting的sp文件中
     */
    public static void saveInfo(Context context, String key, String value) {
        SharedPreferences sh = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
        sh.edit().putString(key, value).apply();
    }

    /**
     * @param context  上下文
     * @param key      键名
     * @param defValue 默认值，当没有获取到sp值时会返回默认值
     * @return 从setting的sp文件中获取sp值
     */
    public static String getInfo(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    /**
     * @param context 上下文
     * @param key     键名
     * @param value   键值
     *                修改setting中对应键名的值
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * @param context  上下文
     * @param key      键名
     * @param defValue 默认值
     * @return setting中是否存在相关的sp设置
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    /**
     * @param context 上下文
     * @param serviceName 服务的类名：包名+class名
     * @return  返回服务的开启状态
     */
    public static boolean isRunning(Context context , String serviceName){
        boolean isRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = am.getRunningServices(200);
        for (ActivityManager.RunningServiceInfo serviceInfo :
                runningServices) {
            if (serviceInfo.service.getClassName().equals(serviceName)){
                isRunning = true;
                break;
            }

        }
        return isRunning;
    }
}
