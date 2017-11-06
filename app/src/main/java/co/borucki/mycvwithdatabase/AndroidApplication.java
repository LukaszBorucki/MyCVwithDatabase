package co.borucki.mycvwithdatabase;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;



public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

}
