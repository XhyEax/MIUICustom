package com.xhy.xp.miuicustom;

import com.xhy.xp.miuicustom.dispatch.PowerKeeperHook;
import com.xhy.xp.miuicustom.dispatch.SecurityCenterHook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        String packageName = lpparam.packageName;
        switch (packageName) {
            case "com.miui.securitycenter":
                SecurityCenterHook.handleLoadPackage(lpparam);
                break;
            case "com.miui.powerkeeper":
                PowerKeeperHook.handleLoadPackage(lpparam);
                break;
        }

    }
}
