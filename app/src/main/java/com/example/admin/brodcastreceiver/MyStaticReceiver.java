package com.example.admin.brodcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {

    private static final String TAG = "StaticReveiverTag";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        //Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show();
    }
}
