package nhom9.memoryleak.fixed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import nhom9.memoryleak.fixed.R;

public class SingletonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        /**
         * Using application context instead (Take a a look at the @SingletonManager).
         * **/
        SingletonManager.getInstance(this);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SingletonActivity.class);
        context.startActivity(starter);
    }

}