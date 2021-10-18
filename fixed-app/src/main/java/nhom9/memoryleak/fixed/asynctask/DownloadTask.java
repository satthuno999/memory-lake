package nhom9.memoryleak.fixed.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;

import java.lang.ref.WeakReference;

import nhom9.memoryleak.fixed.DownloadListener;

public class DownloadTask extends AsyncTask<Void, Void, Void> {

    /**
     * The WeakReference allows the Activity to be garbage collected.
     * garbage collected dose not protect the weak reference from begin reclaimed.
     **/
    private WeakReference<DownloadListener> listener;

    public DownloadTask(DownloadListener listener) {
        this.listener = new WeakReference<>(listener);
    }

    @Override
    protected Void doInBackground(Void... params) {
        /**
         * Check if cancelled.
         * **/
        while (!isCancelled()) {
            SystemClock.sleep(2000 * 10);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (listener.get() != null) {
            listener.get().onDownloadTaskDone();
        }
    }
}