
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

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public final static String[] perms = new String[]{Manifest.permission.READ_PHONE_STATE};
    TextView sputgetText;
    final static int GREEN_TRANSPARENT = 0x6600ff00;
    static String imei = "unassigned";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sputgetText = findViewById(R.id.sputget_test_text);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) ==
                PackageManager.PERMISSION_GRANTED) {
            //Tests
            sgetsputIMEITest();
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String phone_num = telephonyManager.getLine1Number();
            //Log.d("TESTAPP", "phone number: " + phone_num);

            if(phone_num != null) {
                Log.d("TESTAPP", phone_num);
            }

        } else {
            // The app will remember permissions it has been granted on startup.
            // So, we try to run the tests.  But, if the permissions are missing
            // we come here and request them (giving up on the tests this time).
            ActivityCompat.requestPermissions(this, perms, 1);
        }


    }

    //Simply log that permissions are granted
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        Log.d("infostigmatestapp", "Permissions granted: " + Arrays.toString(perms));

        //Tests
        sgetsputIMEITest();

    }


    private void sputIMEI(){
        Context ctx = getApplicationContext();
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();
    }

    private void sgetsputIMEITest(){
        sputIMEI();
        String temp = imei;
        // unique app name to help in filtering logcat
        Log.d("sgetsput IMEI", temp);
        //Test complete
        if(!(imei.equals("unassigned")))
            sputgetText.setBackgroundColor(GREEN_TRANSPARENT);


        //End Tests Flag
        Log.d("endstigmatestapp", "end");
    }
}