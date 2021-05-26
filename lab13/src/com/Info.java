package com;

import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public void execute(Locale locale) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                                    .ofLocalizedDate(FormatStyle.FULL)
                                    .withLocale(locale);

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String[] months = dateFormatSymbols.getMonths();

        WeekFields weekFields = WeekFields.of(locale);
        DayOfWeek day = weekFields.getFirstDayOfWeek();



        System.out.println("Country  : " + locale.getCountry());
        System.out.println("Language : " + locale.getLanguage());
        System.out.println("Currency : " + Currency.getInstance(locale).getDisplayName());
        System.out.println("Date     : " + today.format(formatter));
        System.out.print("Months     : ");
        for (String month : months)
            System.out.print(month + ", ");

        System.out.println("");
        System.out.print("Days: ");
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            System.out.print(day.getDisplayName(TextStyle.FULL, locale));
            System.out.print(", ");
            day = day.plus(1);
        }

    }
}
