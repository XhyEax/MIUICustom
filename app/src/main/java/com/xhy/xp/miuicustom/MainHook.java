package com.xhy.xp.miuicustom;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import com.xhy.xp.miuicustom.dispatch.SecurityCenterHook;

import java.lang.reflect.Method;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        String packageName = lpparam.packageName;
        switch (packageName) {
            case "com.miui.securitycenter":
                SecurityCenterHook.handleLoadPackage(lpparam);
                break;
        }

    }
}
