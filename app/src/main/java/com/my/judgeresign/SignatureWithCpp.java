package com.my.judgeresign;

import android.content.Context;

public class SignatureWithCpp {

    public native static String getToken(Context context, String userId);

}
