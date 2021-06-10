package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String home() {
        return "dice-roll";
    }

    @PostMapping("/roll-dice/{number}")
    public String result(@RequestParam(name = "number") int number, Model model) {
        int random = (int) (Math.random() * 6 + 1);

    }

}