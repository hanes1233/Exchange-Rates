package com.example.ExchangeRates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;
import java.lang.String;

@Controller
@RequestMapping("/")
public class RatesController implements WebMvcConfigurer {
    @Autowired
    private UserService userService;

    //Return all data from PostgreSQL
    @GetMapping("/table")
    public String loadTable(Model model) {
        model.addAttribute("usedb", userService.getAllRates());
        return "table";
    }

    //Return exact currency from database
    @RequestMapping(value = "/table/", method =RequestMethod.GET)
    public Object loadCurrency(@RequestParam("name") String name, Model model) {
       Optional<Rates> currency = userService.getRateByCountry(name);
       if(currency.isEmpty()) {
           RedirectView rv = new RedirectView();
           rv.setUrl("https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e");
           return rv;
       }else {
           Rates rate = currency.get();
           model.addAttribute("usedb", rate);
           return "currency";
           }
    }

    //Return main HTML page
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}