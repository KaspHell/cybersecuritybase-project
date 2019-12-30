package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;


@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address, @RequestParam String credit){
        signupRepository.save(new Signup(name, address, credit));
        return "redirect:/signup";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String viewSingUp(Model model){
        model.addAttribute("signups", signupRepository.findAll());
        return "signup";
    }

    @RequestMapping(value = "quit", method = RequestMethod.GET)
    @ResponseBody
    public String viewThanks(){
        return "You are now logged out";
    }

}
