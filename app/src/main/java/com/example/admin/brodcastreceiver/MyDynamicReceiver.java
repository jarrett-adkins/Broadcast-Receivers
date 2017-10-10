package com.example.admin.brodcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.admin.brodcastreceiver.utils.Constants;

public class MyDynamicReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        switch( action ) {
            case Constants.ACTION.ACTION1:

                String data = intent.getStringExtra( Constants.KEYS.DATA_MAIN );
                Toast.makeText(context, "" + data, Toast.LENGTH_SHORT).show();

                break;
            case Constants.ACTION.ACTION2:
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean isAirplaneModeOn = intent.getBooleanExtra( "state", false );

                if( isAirplaneModeOn )
                    Toast.makeText(context, "Airplane Mode is on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Airplane Mode is off", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
