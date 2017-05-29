package org.sawhers.altafhussain.alarmmanager_pendingintent_broadcastreceiver.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by ALTAFHUSSAIN on 1/25/2017.
 */

public class audioListner extends BroadcastReceiver {
    AudioManager audioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        audioManager= (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        Bundle b=intent.getExtras();
        boolean check=b.getBoolean("SILENT");
        if (check){
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            Toast.makeText(context, "Called After 5 sec", Toast.LENGTH_SHORT).show();
        }
        else {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            Toast.makeText(context, "Called After 10 sec", Toast.LENGTH_SHORT).show();
        }

    }
}
