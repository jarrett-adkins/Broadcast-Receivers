package com.example.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION = "actionToOtherApp";
    public static final String KEY = "data";

    MyReceiver myReceiver;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById( R.id.tvMessage );
    }

    @Override
    protected void onStart() {
        super.onStart();

        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction( ACTION );
        registerReceiver( myReceiver, intentFilter );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver( myReceiver );
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            switch ( action ) {
                case ACTION:

                    textView.setText( intent.getStringExtra( KEY ) );

                    break;
            }
        }
    }
}
