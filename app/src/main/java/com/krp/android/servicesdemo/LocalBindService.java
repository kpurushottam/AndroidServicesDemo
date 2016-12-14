package com.krp.android.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class LocalBindService extends Service {

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();

    // Random number generator
    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        LocalBindService getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocalBindService.this;
        }
    }

    public LocalBindService() {
    }


    /**
     * Is called when service is started
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    /**
     * Is called when service is stopped
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /** method for clients */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
}
