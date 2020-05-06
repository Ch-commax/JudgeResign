package com.my.judgeresign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

public class SignatureWithJava {

    private static String TAG = "resign";
    private static int originCode = 1459663815;//签名信息

    //返回签名的hash值
    public static int getSignature(Context context) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pi;
        StringBuilder sb = new StringBuilder();
        try {
            pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature[] signatures = pi.signatures;
            for (Signature signature : signatures) {
                sb.append(signature.toCharsString());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "sign : " + sb.toString());
        return sb.toString().hashCode();
    }

    public static boolean checkSignature(Context context) {
        int nowCode = getSignature(context);
        if (nowCode == originCode) {
            return true;
        } else {
            return false;
        }
    }
}
