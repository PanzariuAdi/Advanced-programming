package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class LocaleExplore {

    private static LocaleExplore localeExplore = null;
    private ResourceBundle messages;

    private LocaleExplore() {
        Locale locale = Locale.getDefault();
        messages = ResourceBundle.getBundle("res.messages",locale);
    }

    public static LocaleExplore getInstance(){
        if(localeExplore == null)
            localeExplore = new LocaleExplore();

        return localeExplore;
    }

    public void setMessages(ResourceBundle messages) {
        this.messages = messages;
    }

    public void run() throws IOException {
        boolean state = true;
        do {
            System.out.print(messages.getString("prompt")) ;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String command = null;

            try {
                command = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (Objects.requireNonNull(command)) {
                case "quit" -> state = false;
                case "display" -> {
                    System.out.print(messages.getString("locales"));
                    new DisplayLocales().execute();
                }
                case "set" -> {
                    String language;
                    String country;
                    System.out.print(messages.getString("locale.set"));

                    System.out.println("\nLanguage : ");
                    language = bufferedReader.readLine();
                    System.out.println("Country : ");
                    country = bufferedReader.readLine();
                    new SetLocale().execute(language, country);
                }
                case "current" -> System.out.println(Locale.getDefault().toString());
                case "info" -> new Info().execute(Locale.getDefault());
                default -> System.out.println(messages.getString("invalid"));
            }
        } while(state);


    }
}
