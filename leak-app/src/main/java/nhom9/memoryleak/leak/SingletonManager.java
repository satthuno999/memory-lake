package nhom9.memoryleak.leak;

import android.content.Context;

public class SingletonManager {

    private static SingletonManager singleton;
    private Context context;

    private SingletonManager(Context context) {
        this.context = context;
    }

    public synchronized static SingletonManager getInstance(Context context) {
        if (singleton == null) {
            /**
             * Saving the activity context. Leak!
             * the activity will stack in the memory until the end of the application.
             * **/
            singleton = new SingletonManager(context);
        }
        return singleton;
    }

}
