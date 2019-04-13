package com.example.xp_test;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.app.hook.CaiYunTong;
import com.app.hook.ChuangBaoWang;
import com.app.hook.OutputStreamHook;
import com.app.hook.yaobeibei;

import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TransferQueue;
import java.util.logging.Logger;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;
import static de.robv.android.xposed.XposedHelpers.newInstance;
import static de.robv.android.xposed.XposedHelpers.removeAdditionalInstanceField;

public class HookMain implements IXposedHookLoadPackage {
    private String TAG ="HookMain";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        //OutputStreamHook.exe(loadPackageParam);
        //ChuangBaoWang.exe(loadPackageParam);
        yaobeibei.exe(loadPackageParam);
    }


}
