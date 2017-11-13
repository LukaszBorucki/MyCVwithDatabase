package co.borucki.mycvwithdatabase.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;


public class MyCVSharedPreferences {
    private static final String PERSONAL_DATA_SHARED_PREFERENCES = "personalDatar";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PHONE = "phone";
    private static final String EMAIL = "mail";
    private static final String ACCESS_PERMISSION = "access_permission";
    private static final String ACCESS_PERMISSION_PASSWORD = "access_permission_password";
    private static final String ACCESS_PERMISSION_MAIL = "access_permission_mail";
    private static final String WEB_SERVICE = "web_service";
    private static final String HOME_ADDRESS_CITY = "home_address_city";
    private static final String HOME_ADDRESS_STREET = "home_address_street";
    private static final String HOME_ADDRESS_NO = "home_address_no";
    private static final String HOME_ADDRESS_POST = "home_address_post";
    private static final String HOME_ADDRESS_GOOGLE_LOCATION = "home_address_google_location";
    private static final String SKYPE_USER_NAME = "skype_user_name";
    private static final String LINKEDIN_PROFILE = "linked_in_profile";
    private static final String GITHUB_PROFILE = "github_profile";
    private static final String PERSONAL_PHOTO = "my_photo";
    private static final String APP_LANGUAGE = "language";
    private static final String ABOUT_PL = "about_pl";
    private static final String ABOUT_EN = "about_en";
    private static final String MAIL_MESSAGE = "mail_message";

    private final SharedPreferences mSharedPreferences;

    public MyCVSharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(PERSONAL_DATA_SHARED_PREFERENCES, context.MODE_PRIVATE);
    }

    public String getName() {
        return mSharedPreferences.getString(NAME, "N/A");
    }

    public String getSurname() {
        return mSharedPreferences.getString(SURNAME, "N/A");
    }

    public String getPhone() {
        return mSharedPreferences.getString(PHONE, "N/A");

    }

    public String getEmail() {
        return mSharedPreferences.getString(EMAIL, "N/A");
    }

    public String getWebService() {
        return mSharedPreferences.getString(WEB_SERVICE, "N/A");
    }

    public String getHomeAddressCity() {
        return mSharedPreferences.getString(HOME_ADDRESS_CITY, "N/A");
    }

    public String getHomeAddressStreet() {
        return mSharedPreferences.getString(HOME_ADDRESS_STREET, "N/A");
    }

    public String getHomeAddressNo() {
        return mSharedPreferences.getString(HOME_ADDRESS_NO, "N/A");
    }

    public String getHomeAddressPost() {
        return mSharedPreferences.getString(HOME_ADDRESS_POST, "N/A");
    }

    public String getHomeAddressGoogleLocation() {
        return mSharedPreferences.getString(HOME_ADDRESS_GOOGLE_LOCATION, "N/A");
    }

    public String getSkypeUserName() {
        return mSharedPreferences.getString(SKYPE_USER_NAME, "N/A");
    }

    public String getLinkedInProfile() {
        return mSharedPreferences.getString(LINKEDIN_PROFILE, "N/A");
    }

    public String getGitHubProfile() {
        return mSharedPreferences.getString(GITHUB_PROFILE, "N/A");
    }

    public String getPhoto() {
        return mSharedPreferences.getString(PERSONAL_PHOTO, "");
    }


    public void setName(String name) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(NAME, name);
        editor.apply();
    }


    public void setSurname(String surname) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SURNAME, surname);
        editor.apply();
    }

    public void setPhone(String phone) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(PHONE, phone);
        editor.apply();

    }

    public void setEmail(String email) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(EMAIL, email);
        editor.apply();
    }

    public void setWebService(String webService) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(WEB_SERVICE, webService);
        editor.apply();
    }

    public void setHomeAddressCity(String city) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(HOME_ADDRESS_CITY, city);
        editor.apply();
    }

    public void setHomeAddressStreet(String street) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(HOME_ADDRESS_STREET, street);
        editor.apply();
    }

    public void setHomeAddressNo(String no) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(HOME_ADDRESS_NO, no);
        editor.apply();
    }

    public void setHomeAddressPost(String post) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(HOME_ADDRESS_POST, post);
        editor.apply();
    }

    public void setHomeAddressGoogleLocation(String googleLocation) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(HOME_ADDRESS_GOOGLE_LOCATION, googleLocation);
        editor.apply();
    }

    public void setSkypeUserName(String skype) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SKYPE_USER_NAME, skype);
        editor.apply();
    }

    public void setLinkedInProfile(String linkedIn) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(LINKEDIN_PROFILE, linkedIn);
        editor.apply();
    }

    public void setGitHubProfile(String gitHub) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(GITHUB_PROFILE, gitHub);
        editor.apply();
    }

    public void setPhoto(String photo) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(PERSONAL_PHOTO, photo);
        editor.apply();
    }

    public boolean isAccessPermited() {
        return mSharedPreferences.getBoolean(ACCESS_PERMISSION, false);
    }

    public void setAccessPermission(boolean accessPermission) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(ACCESS_PERMISSION, accessPermission);
        editor.apply();

    }

    public void setAccessPermissionPassword(String password) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ACCESS_PERMISSION_PASSWORD, password);
        editor.apply();

    }

    public String getAccessPermissionPassword() {
        return mSharedPreferences.getString(ACCESS_PERMISSION_PASSWORD, "N/A");
    }

    public String getAccessPermissionMail() {

        return mSharedPreferences.getString(ACCESS_PERMISSION_MAIL, "mail");
    }

    public void setAccessPermissionMail(String mail) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ACCESS_PERMISSION_MAIL, mail);
        editor.apply();

    }

    public String getAccessPermissionAppLanguage() {
        return mSharedPreferences.getString(APP_LANGUAGE, "");

    }

    public void setAccessPermissionAppLanguage(String language) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(APP_LANGUAGE, language);
        editor.apply();
    }

    public void setAboutPl(String aboutPl) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ABOUT_PL, aboutPl);
        editor.apply();
    }

    public String getAboutPl() {
        return mSharedPreferences.getString(ABOUT_PL, "N/A");
    }

    public void setAboutEn(String aboutEn) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ABOUT_EN, aboutEn);
        editor.apply();

    }

    public String getAboutEn() {
        return mSharedPreferences.getString(ABOUT_EN, "N/A");
    }

    public String getMessageText() {
        return mSharedPreferences.getString(MAIL_MESSAGE, "");
    }

    public void setMessageText(String text) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(MAIL_MESSAGE, text);
        editor.apply();
    }
}
