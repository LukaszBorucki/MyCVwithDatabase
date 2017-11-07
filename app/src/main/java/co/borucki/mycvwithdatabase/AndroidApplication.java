package co.borucki.mycvwithdatabase;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.database.DatabaseOrmImpl;
import co.borucki.mycvwithdatabase.persistence.MyCVSharedPreferences;


public class AndroidApplication extends Application {
    private static MyCVSharedPreferences mMyCVSharedPreferences;
    private static Database mDatabase;
    @Override
    public void onCreate() {
        super.onCreate();
        mMyCVSharedPreferences = new MyCVSharedPreferences(this);
        mDatabase = OpenHelperManager.getHelper(this, DatabaseOrmImpl.class);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    public static MyCVSharedPreferences getSharedPreferences() {
        return mMyCVSharedPreferences;
    }
    public static Database getDatabase() {
        return mDatabase;
    }
}
