package com.codeup.anameforyourprojectwithoutspaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {

        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        model.addAttribute("topAd", adDao.findByTitle(""));
        model.addAttribute("searchAds", adDao.findByTitleLike(""));
        return "ads/index";
    }
}
