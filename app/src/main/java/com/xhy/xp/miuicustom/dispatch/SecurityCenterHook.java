package com.xhy.xp.miuicustom.dispatch;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import java.lang.reflect.Method;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SecurityCenterHook {
    public static void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        // miui-countdowntimer-bypass
        findAndHookMethod("com.miui.permcenter.privacymanager.d", lpparam.classLoader, "c", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                Method mtdA = param.thisObject.getClass().getDeclaredMethod("a", boolean.class);
                mtdA.invoke(param.thisObject, true);
                return null;
            }
        });
    }
}
