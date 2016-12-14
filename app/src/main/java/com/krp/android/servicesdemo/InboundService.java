package com.krp.android.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class InboundService extends Service {
    public InboundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

            // TYPES OF SERVICES
    /**
     Service.START_STICKY
     Service is restarted if it gets terminated. Intent data passed to the onStartCommand method is null.
     Used for services which manages their own state and do not depend on the Intent data.

     Service.START_NOT_STICKY
     Service is not restarted. Used for services which are periodically triggered anyway.
     The service is only restarted if the runtime has pending startService() calls since the service termination.

     Service.START_REDELIVER_INTENT
     Similar to Service.START_STICKY but the original Intent is re-delivered to the onStartCommand method.
     */

            // KNOW SERVICE TYPE via INTENT
    /**
     * You can check if the service was restarted via the Intent.getFlags() method.
     * START_FLAG_REDELIVERY (in case the service was started with Service.START_REDELIVER_INTENT) or
     * START_FLAG_RETRY (in case the service was started with Service.START_STICKY) is passed.
     */

            // STOPPING A SERVICE
    /**
     * A service can terminate itself by calling the stopSelf() method.
     * This is typically done if the service finishes its work.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // returns an int which  defines its restart behavior
        // in case the service gets terminated by the Android platform
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }
}
