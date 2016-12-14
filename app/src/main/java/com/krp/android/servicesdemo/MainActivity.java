package com.krp.android.servicesdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startInboundService(View v) {
        // use this to start and trigger a service
        Intent i= new Intent(this, InboundService.class);
        // potentially add data to the intent
        i.putExtra("KEY1", "Value to be used by the service");
        startService(i);
    }

    /**
     * You stop a service via the stopService() method.
     * No matter how frequently you called the startService(intent) method,
     * one call to the stopService() method stops the service.
     */
    public void stopInboundService(View v) {
        stopService(new Intent(MainActivity.this, InboundService.class));
    }


    public void bindLocalService(View v) {
        startActivity(new Intent(MainActivity.this, LocalBindServiceActivity.class));
    }

    public void bindIPCMessengerService(View v) {
        startActivity(new Intent(MainActivity.this, LocalMessengerServiceActivity.class));
    }

    public void bindIPCAIDLService(View v) {
        startActivity(new Intent(MainActivity.this, IPCAIDLServiceActivity.class));
    }
}
