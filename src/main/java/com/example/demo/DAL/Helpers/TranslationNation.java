package com.example.demo.DAL.Helpers;
import com.deepl.api.*;


public class TranslationNation {
    private static final SingletonTranslator translator = SingletonTranslator.singletonTranslator;

    //target is language you want input translated into
    //target must be string ISO 639-1 language code, for example "de" for german, "en-us" for english
    public static String translate(String input, String target) {
        return translator.translate(input, target);
    }
}

class SingletonTranslator {
    private Translator translator;

    private SingletonTranslator() {
        translator = new Translator("17dc983f-22da-4603-952f-1c3476aadeaf:fx");
    }

    public String translate(String input, String target) {
        String output = "";
        try {
            output = translator.translateText(input, null, target).getText();
        } catch (Exception e) {
            output = "error in translating: " + e.getMessage();
        }
        return output;
    }

    public static final SingletonTranslator singletonTranslator = new SingletonTranslator();
}
