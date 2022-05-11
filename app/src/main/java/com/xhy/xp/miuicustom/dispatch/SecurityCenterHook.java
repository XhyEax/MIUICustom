package com.xhy.xp.miuicustom.dispatch;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import java.lang.reflect.Method;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SecurityCenterHook {
    public static void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        // miui-countdowntimer-bypass

        // 5.4.0
        Method mtd_SpecialPermissionIntercept_540 = XposedHelpers.findMethodExactIfExists("com.miui.permcenter.privacymanager.d", lpparam.classLoader, "c");
        if (mtd_SpecialPermissionIntercept_540 != null) {
            XposedBridge.hookMethod(mtd_SpecialPermissionIntercept_540, new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    Method mtdConfirm = param.thisObject.getClass().getDeclaredMethod("a", boolean.class);
                    mtdConfirm.invoke(param.thisObject, true);
                    return null;
                }
            });
        }

        // 5.6.0
        Method mtd_SpecialPermissionIntercept_560 = XposedHelpers.findMethodExactIfExists("com.miui.permcenter.privacymanager.h", lpparam.classLoader, "n");
        if (mtd_SpecialPermissionIntercept_560 != null) {
            XposedBridge.hookMethod(mtd_SpecialPermissionIntercept_560, new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    Method mtdConfirm = param.thisObject.getClass().getDeclaredMethod("d", boolean.class);
                    mtdConfirm.invoke(param.thisObject, true);
                    return null;
                }
            });
        }
    }
}
