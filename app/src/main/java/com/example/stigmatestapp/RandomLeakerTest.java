package com.example.stigmatestapp;


import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Random;

public class RandomLeakerTest {

    public static String maybeIMEIField = "not sensitive";

    public RandomLeakerTest(){

    }


    public static void maybeLeak() {

        Random r = new Random();
        if (r.nextInt(1) == 0) {
            maybeIMEIField = MainActivity.imei;
        }

        Log.d("MAYBE TEST", maybeIMEIField);

    }

}
