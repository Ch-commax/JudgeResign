package com.my.judgeresign;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView showTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTV = (TextView) findViewById(R.id.showTVId);
    }

    public void judge_func_java(View view) {
        if (SignatureWithJava.checkSignature(this)) {
            String resultStr = "签名验证:通过 ---> Java";
            showTV.setText(resultStr);
        } else {
            String resultStr = "签名验证:失败 ---> Java";
            showTV.setText(resultStr);
        }
    }

    public void judge_func_cpp(View view) {
        String resultStr = SignatureWithCpp.getToken(this, "12345");
        showTV.setText(resultStr);
    }
}
