package com;

import java.text.DateFormat;
import java.util.Locale;

public class DisplayLocales{

    public void execute() {
        Locale[] list = DateFormat.getAvailableLocales();
        for (Locale locale : list) {
            System.out.println(locale.toString());
        }
    }
}
