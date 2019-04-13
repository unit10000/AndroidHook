package com.app.hook;

import android.util.Log;

import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class OutputStreamHook {
    private static  String TAG = "OutputStreamHook";
    public static void exe(XC_LoadPackage.LoadPackageParam loadPackageParam){
        findAndHookMethod("java.io.OutputStream", loadPackageParam.classLoader, "write", byte[].class,int.class,int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(TAG, "hahahha: "+new String((byte[])param.args[0]));
            }
        });

    }
}
