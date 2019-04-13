package com.example.xp_test;

import android.app.Application;
import android.content.Context;
import android.content.SyncStats;
import android.os.Bundle;
import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.removeAdditionalInstanceField;

public class JgHook {
    static String  TAG = "JgHook";
    public static void attachHook(XC_LoadPackage.LoadPackageParam loadPackageParam, final String packgeName , final HookMethod hookMethod){
        //360加壳hook
        if (loadPackageParam.packageName.equals(packgeName)) {
            XposedBridge.log("开始hook:"+packgeName);
            findAndHookMethod(Application.class,
                    "attach",
                    Context.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            XposedBridge.log( "hook到拉"+packgeName);
                            ClassLoader loader = ((Context)param.args[0]).getClassLoader();
                            //hook com.bytedance.sdk.openadsdk.core.a
                            hookMethod.hook(loader);
                        }
                    }
            );

        }
    }
    public static void loaderHook(final String className , final HookMethod hookMethod){
        findAndHookMethod(ClassLoader.class, "loadClass", String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (param.hasThrowable()) return;
                String classname = (String) param.args[0];
                if (className.equals(classname)) {
                    XposedBridge.log("HOOK class: " + classname);
                    Class<?> clazz = (Class<?>) param.getResult();
                    hookMethod.hook(clazz);
                }
            }
        });
    }
}
