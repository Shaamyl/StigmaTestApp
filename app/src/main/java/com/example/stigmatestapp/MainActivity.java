
package com.example.stigmatestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView sputgetText;
    final static int GREEN_TRANSPARENT = 0x6600ff00;
    static String imei = "unassigned";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sputgetText = findViewById(R.id.sputget_test_text);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);

    }

    //Run code after permissions granted
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        //Tests
        sgetsputIMEITest();

        //End Tests Flag
        Log.d("endstigmatestapp", "end");
    }


    private void sputIMEI(){
        Context ctx = getApplicationContext();
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(ctx, "Phone state permissions required!", Toast.LENGTH_SHORT).show();
        }

        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)
            imei = telephonyManager.getDeviceId();
    }

    private void sgetsputIMEITest(){
        sputIMEI();
        String temp = imei;
        // unique app name to help in filtering logcat
        Log.d("stigmatestapp sgetsput IMEI", temp);
        //Test complete
        if(!(imei.equals("unassigned")))
            sputgetText.setBackgroundColor(GREEN_TRANSPARENT);
    }
}