package jpabook.jpashop.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/") // 첫번째 화면으로 잡힘
    public String home() {
        log.info("home controller");
        return "home";
    }
}
