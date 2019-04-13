package com.app.hook;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

public abstract class HookApp {
     abstract  void exe(XC_LoadPackage.LoadPackageParam loadPackageParam);
}
