package com.example.demo.DAL.Helpers;
import com.deepl.api.*;


public class TranslationNation {
    private static final Translator translator = new Translator("17dc983f-22da-4603-952f-1c3476aadeaf:fx");

    //target is language you want input translated into
    //target must be string ISO 639-1 language code, for example "de" for german, "en-us" for english
    public static String translate(String input, String target) {
        String output = "";
        try {
            output = translator.translateText(input, null, target).getText();
        } catch (Exception e) {
            output = "error in translating: " + e.getMessage();
        }
        return (output);
    }

}
