package com.example.demo.Controllers;

import com.example.demo.DAL.Helpers.TranslationNation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translation")
public class TranslationController {

    //idk if I need to have a 'Translation service'
    public TranslationController() {}

    //target is the language we want to translate into, input is the string we want to translate
    @GetMapping("/{target}/{input}")
    public String translate(@PathVariable String target, @PathVariable String input) {
        return(TranslationNation.translate(input, target));
    }
}
