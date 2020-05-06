package com.my.judgeresign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

public class SignatureWithJava {

    private static String TAG = "resign";
    private static int originCode = 1459663815;

    public static int getSignature(Context context) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pi;
        String result = "";
        try {
            pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature[] signatures = pi.signatures;
            Log.e(TAG, "length : " + signatures.length);
            result = signatures[0].toCharsString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "sign : \n" + result);
        return result.hashCode();
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
