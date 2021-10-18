package nhom9.memoryleak.fixed.asynctask;

import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;

import nhom9.memoryleak.fixed.DownloadListener;
import nhom9.memoryleak.fixed.R;


public class BestAsyncTaskActivity extends Activity implements DownloadListener {

    /**
     * NOTE : if the task done before rotate/close the activity every thing will be ok without leak.
     **/

    private TextView textView;
    private DownloadTask downloadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        textView = findViewById(R.id.text_view);
        downloadTask = new DownloadTask(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * cancel the task so it will no invoke onPostExecute().
         * **/
        downloadTask.cancel(true);
    }

    @Override
    public void onDownloadTaskDone() {
        updateText();
    }

    public void updateText() {
        textView.setText(R.string.hello);
    }

}
