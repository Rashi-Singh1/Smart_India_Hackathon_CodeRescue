package com.example.coderescue.Classes;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SendMessageUtility {

    public static final int REQUEST_CODE_SEND_MESSAGE_PERMISSION = 1000;

    public static String HELPLINE = "8402028442";

    public static String getHELPLINE() {
        return HELPLINE;
    }

    public static void setHELPLINE(String HELPLINE) {
        Log.i("message util", "HELPLINE updated");
        SendMessageUtility.HELPLINE = HELPLINE;
    }

    //option to send message to specific phone number
    public static void sendMessage(Context context, Activity activity, String message, String phoneNumber){
        if(message == null || message.isEmpty()) {
            Toast.makeText(context, "Message is empty", Toast.LENGTH_SHORT).show();
            Log.i("message util", "Message is invalid");
            return;
        }
        if(phoneNumber.length() < 10){
            Toast.makeText(context, "Invalid phone number", Toast.LENGTH_SHORT).show();
            Log.i("message util", "Invalid phone number");
            return;
        }
        int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phoneNumber, null, message, null, null);
            Log.i("message util", "sendTextMessage called");
        }
        else{
            Log.i("message util", "Requesting SMS send permissions");
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.SEND_SMS}, REQUEST_CODE_SEND_MESSAGE_PERMISSION);
        }
    }

    //send message to a fixed number given in HELPLINE
    public static void sendMessage(Context context, Activity activity, String message){
        if(message == null || message.isEmpty()) {
            Toast.makeText(context, "Message is empty", Toast.LENGTH_SHORT).show();
            Log.i("message util", "Message is invalid");
            return;
        }
        int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(HELPLINE, null, message, null, null);
            Log.i("message util", "sendTextMessage called");
        }
        else{
            Log.i("message util", "Requesting SMS send permissions");
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.SEND_SMS}, REQUEST_CODE_SEND_MESSAGE_PERMISSION);
        }
    }

}
