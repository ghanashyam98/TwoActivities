package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case Intent.ACTION_BATTERY_LOW:
                    toastMessage = "Battery Low";
                    break;
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    boolean state = intent.getBooleanExtra( "state",false );
                    toastMessage = "Airplane Mode is " + (state ? "on" : "off");
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    int value = intent.getIntExtra("randomInt",1);
                    toastMessage = "Custom Broadcast Received\n" +
                            "Square of the random number " + value + " is : " + (value*value);
                    break;
            }


            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }

    }
}
