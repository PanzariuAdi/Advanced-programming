package com;

import app.LocaleExplore;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale{
    public void execute(String language,String country) {
        Locale.setDefault(new Locale(language,country));
        LocaleExplore localeExplore = LocaleExplore.getInstance();
        localeExplore.setMessages(ResourceBundle.getBundle("res.Messages",Locale.getDefault()));

    }
}
