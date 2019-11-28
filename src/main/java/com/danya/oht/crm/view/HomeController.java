package com.danya.oht.crm.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView homePage(@RequestParam(name="name", required=false, defaultValue="World") String name, ModelMap model) {
        model.addAttribute("name", name);
        return new ModelAndView("index", model);
    }
}
