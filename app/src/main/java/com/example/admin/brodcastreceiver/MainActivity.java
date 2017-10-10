package com.example.admin.brodcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.brodcastreceiver.utils.Constants;

public class MainActivity extends AppCompatActivity {

    MyDynamicReceiver myDynamicReceiver;
    private EditText dataText;
    private Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataText = (EditText) findViewById( R.id.etData );
        sendMessageButton = (Button) findViewById( R.id.btnSendBroadcast );
    }

    @Override
    protected void onStart() {
        super.onStart();

        //receives broadcast when airplane mode is changed.

        myDynamicReceiver = new MyDynamicReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction( Intent.ACTION_AIRPLANE_MODE_CHANGED );
        intentFilter.addAction( Constants.ACTION.ACTION1 );
        intentFilter.addAction( Constants.ACTION.ACTION_OTHER_APP );

        registerReceiver( myDynamicReceiver, intentFilter );

        //LocalBroadcastManager.getInstance( this ).registerReceiver( myDynamicReceiver, intentFilter );
        //will only listen to broadcasts from this app
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver( myDynamicReceiver );
    }

    public void sendBroadcast(View view) {
        String data = dataText.getText().toString();

        Intent intent = new Intent();
        intent.setAction( Constants.ACTION.ACTION1 );
        intent.putExtra( Constants.KEYS.DATA_MAIN, data );

        sendBroadcast( intent );
    }

    public void sendBroadcastToOtherApp(View view) {
        String data = dataText.getText().toString();

        Intent intent = new Intent();
        intent.setAction( Constants.ACTION.ACTION_OTHER_APP );
        intent.putExtra( Constants.KEYS.DATA_MAIN, data );

        sendBroadcast( intent ); //can also pass a permission string defined in the manifest.
        //receiver will have to use that permission.

        //LocalBroadcastManager.getInstance( this ).sendBroadcast( intent );
        //limit broadcast to this app only
    }
}
