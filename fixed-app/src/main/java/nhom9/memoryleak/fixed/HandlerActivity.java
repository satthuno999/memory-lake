package nhom9.memoryleak.fixed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.util.Log;

import nhom9.memoryleak.fixed.R;

public class HandlerActivity extends Activity {

    private final DownloadTask downloadTask = new DownloadTask();

    /**
     * The handler attached to the main thread
     **/
    private final Handler handler = new TaskHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        /**
         * Post a message and delay its execution for 10 minutes.
         *
         * that's mean post a message to the  queue, to be run after the specified amount of time elapses,
         * The downloadTask will be run on the thread to which this handler is attached on (MainThread)
         * **/
        handler.postDelayed(downloadTask, 1000 * 60 * 10);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /**
         * Remove any pending posts of Runnable @downloadTask that
         * are in the message queue, ot prevent leak.
         * **/
        handler.removeCallbacks(downloadTask);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, HandlerActivity.class);
        context.startActivity(starter);
    }

    /**
     * Use static class instead of inner class.
     * static class does not have reference to the containing activity
     **/
    private static class DownloadTask implements Runnable {
        @Override
        public void run() {
            Log.e("HandlerActivity", "in run()");
        }
    }

    /**
     * Use static class instead of inner class.
     * static class does not have reference to the containing activity
     **/
    private static class TaskHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.e("HandlerActivity", "handle message");
        }
    }

}