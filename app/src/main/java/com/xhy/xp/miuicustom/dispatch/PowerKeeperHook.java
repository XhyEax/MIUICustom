package com.xhy.xp.miuicustom.dispatch;

import java.lang.reflect.Method;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class PowerKeeperHook {
    public static void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        // 4.2.00
        Method mtd_isFeatureOn_4200 = XposedHelpers.findMethodExactIfExists("com.miui.powerkeeper.statemachine.DisplayFrameSetting",
                lpparam.classLoader, "isFeatureOn");
        if (mtd_isFeatureOn_4200 != null) {
            XposedBridge.hookMethod(mtd_isFeatureOn_4200, new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) {
                    return false;
                }
            });
        }
    }
}
