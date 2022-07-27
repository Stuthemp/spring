package tacos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * todo Document type HomeController
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
