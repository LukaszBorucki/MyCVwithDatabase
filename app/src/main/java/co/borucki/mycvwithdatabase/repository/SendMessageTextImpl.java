package co.borucki.mycvwithdatabase.repository;


import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.persistence.MyCVSharedPreferences;

public class SendMessageTextImpl implements SendMessageText {
    private static SendMessageTextImpl mInstance = new SendMessageTextImpl();
    private final MyCVSharedPreferences mSharedPreferences;

    public static SendMessageTextImpl getInstance() {
        return mInstance;

    }

    private SendMessageTextImpl() {
        mSharedPreferences = AndroidApplication.getSharedPreferences();
    }

    @Override
    public void setText(String text) {
        mSharedPreferences.setMessageText(text);
    }

    @Override
    public String getText() {
        return mSharedPreferences.getMessageText();
    }
}
