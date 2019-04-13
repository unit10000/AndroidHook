package com.app.hook;

import android.util.Log;

import com.example.xp_test.HookMethod;
import com.example.xp_test.JgHook;

import java.util.HashMap;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class ChuangBaoWang {
    public static String TAG = "ChuangBaoWang";
    public static void exe(XC_LoadPackage.LoadPackageParam loadPackageParam){
        JgHook.loaderHook("com.pingan.genbao.util.EncryUtil", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "desData4GetCode", String.class, String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.d(TAG, "desData4GetCode: "+param.args[0]);
                        Log.d(TAG, "desData4GetCode: "+param.args[1]);
                        //Log.d(TAG, "desData4GetCode return: "+(HashMap<String, String>)param.getResult().toString());

                    }
                });
            }
        });

        JgHook.loaderHook("com.pingan.genbao.util.EncryUtil", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "checkData", String.class, String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.d(TAG, "checkData: "+param.args[0]);
                        Log.d(TAG, "checkData: "+param.args[1]);
                        //Log.d(TAG, "desData4GetCode return: "+(HashMap<String, String>)param.getResult().toString());

                    }
                });
            }
        });

        JgHook.loaderHook("com.pingan.genbao.util.EncryUtil", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "desData", String.class, String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.d(TAG, "desData: "+param.args[0]);
                        Log.d(TAG, "desData: "+param.args[1]);
                        //Log.d(TAG, "desData4GetCode return: "+(HashMap<String, String>)param.getResult().toString());

                    }
                });
            }
        });

        JgHook.loaderHook("com.pingan.genbao.activity.BaseActivity", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "getUpdateInfo", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                        return null;
                    }
                });
            }
        });

    }
}
