package com.ayhanekin.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String home() {
        System.out.println("Home page has been called");
        return "index";
    }



    @RequestMapping("/add")
    public ModelAndView addalien(@RequestParam("alienId") int alienId, @RequestParam("alienName") String alienName, ModelAndView modelAndView) {
        System.out.println("Add method has been called");

        Alien alien = new Alien();
        alien.setAlienId(alienId);
        alien.setAlienName(alienName);

        modelAndView.addObject("alien", alien);
        modelAndView.setViewName("result");

        return modelAndView;
    }


}






















/*

        @RequestMapping("/add")
        public String add(@RequestParam("num1") int number1, @RequestParam("num2") int number2, Model model) {
        System.out.println("Add method has been called");

        int result = number1 + number2 + 1;
        model.addAttribute("result", result);
        System.out.println(result);
        return "result";
    }

*/

/*


 @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int number1, @RequestParam("num2") int number2, ModelAndView modelAndView) {
        System.out.println("Add method has been called");

        int result = number1 + number2 ;

        modelAndView.addObject("result", result);
        modelAndView.setViewName("result");

       return modelAndView;
    }



*/