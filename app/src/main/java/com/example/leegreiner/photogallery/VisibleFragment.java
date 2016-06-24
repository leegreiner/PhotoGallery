package com.example.leegreiner.photogallery;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by leegreiner on 6/24/16.
 */
public class VisibleFragment extends Fragment {
    private static final String TAG = "VisibleFragment";

    @Override
    public void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(PollService.ACTION_SHOW_NOTIFICATIONS);
        getActivity().registerReceiver(mOnShowNotifications, filter,
                PollService.PERM_PRIVATE, null);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(mOnShowNotifications);
    }

    private BroadcastReceiver mOnShowNotifications = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "cancelling notification");
            setResultCode(Activity.RESULT_CANCELED);
        }
    };
}
