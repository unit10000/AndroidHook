package com.app.hook;

import android.util.Log;

import com.example.xp_test.HookMethod;
import com.example.xp_test.JgHook;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class yaobeibei {
    private static String TAG = "yaobeibei";
    public static void exe(XC_LoadPackage.LoadPackageParam loadPackageParam){
        JgHook.loaderHook("com.zwang.fastlib.utils.MD5Util", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "textToMD5U32",String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.d(TAG, "beforeHookedMethod: 3333333333333333333333");
//                        Log.d(TAG, "textToMD5U32: "+param.args[0]);
////                        Log.d(TAG, "textToMD5U32 return: "+param.getResult());
                        //Log.d(TAG, "desData4GetCode return: "+(HashMap<String, String>)param.getResult().toString());

                    }
                });
            }
        });

    }
}
