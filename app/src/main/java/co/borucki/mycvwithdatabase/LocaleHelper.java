package co.borucki.mycvwithdatabase;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.util.Locale;

import co.borucki.mycvwithdatabase.asyncTask.GetAllEducation;
import co.borucki.mycvwithdatabase.asyncTask.GetAllExperienceBranch;
import co.borucki.mycvwithdatabase.asyncTask.GetAllExperienceCompany;
import co.borucki.mycvwithdatabase.asyncTask.GetAllExperiencePeriod;
import co.borucki.mycvwithdatabase.asyncTask.GetAllExperienceProject;
import co.borucki.mycvwithdatabase.asyncTask.GetAllForeignLanguage;
import co.borucki.mycvwithdatabase.asyncTask.GetAllHobbies;
import co.borucki.mycvwithdatabase.asyncTask.GetAllSkill;


public class LocaleHelper {

    public static boolean isOnLine(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {

            try {
                Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
                int returnVal = p1.waitFor();
                return (returnVal == 0);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return false;
    }

    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    public static Context onAttach(Context context) {
        String lang = getPersistedData(context, Locale.getDefault().getLanguage());
        return setLocale(context, lang);
    }

    public static Context onAttach(Context context, String defaultLanguage) {
        String lang = getPersistedData(context, defaultLanguage);
        return setLocale(context, lang);
    }

    public static String getLanguage(Context context) {
        return getPersistedData(context, Locale.getDefault().getLanguage());
    }

    public static Context setLocale(Context context, String language) {
        persist(context, language);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResources(context, language);
        }

        return updateResourcesLegacy(context, language);
    }

    private static String getPersistedData(Context context, String defaultLanguage) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage);
    }

    private static void persist(Context context, String language) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);

        return context.createConfigurationContext(configuration);
    }

    @SuppressWarnings("deprecation")
    private static Context updateResourcesLegacy(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return context;
    }

    public static void importDataInBackground() {
        new GetAllEducation().execute();
        new GetAllExperienceBranch().execute();
        new GetAllExperienceCompany().execute();
        new GetAllExperiencePeriod().execute();
        new GetAllExperienceProject().execute();
        new GetAllForeignLanguage().execute();
        new GetAllHobbies().execute();
        new GetAllSkill().execute();
    }

    public static byte[] decodeImageFromStringToByteArray(String image) {
        return Base64.decode(image, Base64.DEFAULT);
    }

    public static Bitmap decodeImageFromByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public static Bitmap decodeImageFromStringToBitmap(String image) {
        byte[] byteArrayImage = decodeImageFromStringToByteArray(image);
        return decodeImageFromByteArrayToBitmap(byteArrayImage);
    }
}
