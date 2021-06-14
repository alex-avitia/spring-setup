package com.codeup.anameforyourprojectwithoutspaces.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String home() {
        return "dice-roll";
    }

    @GetMapping("/roll-dice/{number}")
    public String result(@PathVariable int number, Model model) {
        int random = (int) (Math.random() * 6 + 1);

        model.addAttribute("random", random);
        model.addAttribute("number", number);
        return "dice-result";
    }

}