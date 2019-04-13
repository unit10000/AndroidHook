package com.app.hook;

import android.util.Log;

import com.example.xp_test.HookMethod;
import com.example.xp_test.JgHook;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Target;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.getLongField;
import static de.robv.android.xposed.XposedHelpers.getObjectField;
import static de.robv.android.xposed.XposedHelpers.setStaticBooleanField;

public class CaiYunTong{
    private static String TAG = "CaiYunTong";
    public static void exe(XC_LoadPackage.LoadPackageParam loadPackageParam){
        JgHook.loaderHook("cof", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookConstructor(clazz,
                        String.class,
                        String.class,
                        int.class,
                        int.class,
                        boolean.class,
                        boolean.class,
                        boolean.class,
                        int.class,
                        new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                super.beforeHookedMethod(param);
                                //Log.d(TAG, "cof1: "+param.args[0]);
                                XposedBridge.log("cof1: "+param.args[0]);
                                XposedBridge.log("cof2: "+param.args[1]);
                                XposedBridge.log("cof3: "+param.args[2]);
                                XposedBridge.log("cof4: "+param.args[3]);
                                XposedBridge.log("cof5: "+param.args[4]);
                                XposedBridge.log("cof6: "+param.args[5]);
                                XposedBridge.log("cof7: "+param.args[6]);
                                XposedBridge.log("cof8: "+param.args[7]);

                            }
                        });
            }
        });
        JgHook.loaderHook("crx", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "a",
                        int.class,
                        int.class,
                        int.class,
                        int.class,
                        String.class,
                        boolean.class,
                        boolean.class,
                        new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                super.beforeHookedMethod(param);
                                Log.d(TAG, "传人参数i1: "+param.args[0]);
                                XposedBridge.log("传人参数i1: "+param.args[0]);
                                XposedBridge.log("传人参数i2: "+param.args[1]);
                                XposedBridge.log("传人参数i3: "+param.args[2]);
                                XposedBridge.log("传人参数i4: "+param.args[3]);
                                XposedBridge.log("传人参数 str: "+param.args[4]);
                                XposedBridge.log("传人参数z1: "+param.args[5]);
                                XposedBridge.log("传人参数z2: "+param.args[6]);
                                Log.d(TAG, "返回参数133: "+param.getResult());
                                XposedBridge.log("返回参数133: "+param.getResult());
                            }
                        });
            }
        });

        JgHook.loaderHook("crx", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "a",
                        int.class,
                        int.class,
                        String.class,
                        byte[].class,
                        int.class,
                        int.class,
                        int.class,
                        int.class,
                        boolean.class,
                        int.class,
                        boolean.class,
                        new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                super.beforeHookedMethod(param);

                                XposedBridge.log("传人参数i1: "+param.args[0]);
                                XposedBridge.log("传人参数i2: "+param.args[1]);

                                XposedBridge.log("传人参数 str: "+param.args[2]);
                                XposedBridge.log("传人参数i3: "+param.args[4]);
                                XposedBridge.log("传人参数i4: "+param.args[5]);
                                XposedBridge.log("传人参数i5: "+param.args[6]);
                                XposedBridge.log("传人参数i6: "+param.args[7]);

                                XposedBridge.log("传人参数z1: "+param.args[8]);
                                XposedBridge.log("传人参数i7: "+param.args[9]);
                                XposedBridge.log("传人参数z2: "+param.args[10]);
                                Log.d(TAG, "返回参数133: "+param.getResult());
                                XposedBridge.log("返回参数133: "+param.getResult());
                            }
                        });
            }
        });


        JgHook.loaderHook("cwm", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "close",  new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        XposedBridge.log("cwm.close:进入hook");
                        java.io.ByteArrayOutputStream s =  (ByteArrayOutputStream)getObjectField(param.thisObject,"b");
                        XposedBridge.log("cwm.close:"+new String(s.toByteArray()));

                    }
                });

            }
        });


        JgHook.loaderHook("cwm", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "writeChars",  String.class,new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        XposedBridge.log("cwm.writeBytes:进入before");
                        java.io.ByteArrayOutputStream s =  (ByteArrayOutputStream)getObjectField(param.thisObject,"b");
                        XposedBridge.log("cwm.writeBytes:before"+new String(s.toByteArray()));
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                        XposedBridge.log("cwm.writeBytes调用:"+param.args[0]);


                        XposedBridge.log("cwm.writeBytes:进入after");
                        java.io.ByteArrayOutputStream s =  (ByteArrayOutputStream)getObjectField(param.thisObject,"b");

                        XposedBridge.log("cwm.writeBytes:after"+ Arrays.toString(s.toByteArray()));

                    }
                });

            }
        });

        JgHook.loaderHook("csi", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "e", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("csi.e 属性----"+getLongField(param.thisObject,"d"));
                        XposedBridge.log("csi.d 属性----"+getLongField(param.thisObject,"e"));
                        XposedBridge.log("csi.e 返回----"+ param.getResult());
                    }
                });

            }
        });

        JgHook.loaderHook("cwm", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "writeInt", int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("cwm.writeInt----"+ param.args[0]);
                    }
                });

            }
        });

        JgHook.loaderHook("cwm", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "writeShort", int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("cwm.writeShort----"+param.args[0]);
                    }
                });

            }
        });


        JgHook.loaderHook("crx", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "b", byte[].class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        XposedBridge.log("crx.b:"+new String((byte[]) param.args[0]));
                        XposedBridge.log("crx.b return:"+new String((byte[]) param.getResult()));
                        XposedBridge.log("crx.b return:"+Arrays.toString((byte[]) param.getResult()));
                    }
                });

            }
        });

        JgHook.loaderHook("cvu", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "g", int.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        XposedBridge.log("cvu.g:"+ param.args[0]);
                        XposedBridge.log("cvu.g return:"+Arrays.toString((byte[]) param.getResult()));
                    }
                });

            }
        });

        JgHook.loaderHook("cqf", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "g", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        XposedBridge.log("cqf.g:"+ Arrays.toString((byte[]) param.getResult()));
                    }
                });

            }
        });

        JgHook.loaderHook("chg", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                setStaticBooleanField(clazz,"b",true);
                setStaticBooleanField(clazz,"a",true);
                //XposedBridge.log("chg.b:"+clazz.b);
            }
        });
        JgHook.loaderHook("chg", new HookMethod() {
            @Override
            public void hook(Class<?> clazz) {
                super.hook(clazz);
                findAndHookMethod(clazz, "c", String.class, String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.d(TAG,(String) param.args[0]+" --------------------"+ (String )param.args[1]);
                    }
                });



                //XposedBridge.log("chg.b:"+clazz.b);
            }
        });
    }
}
