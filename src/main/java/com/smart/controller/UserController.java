package com.smart.controller;

import com.smart.entity.User;
import com.smart.paylod.LoginDTO;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/signup")
    public String signup(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "signup";
    }
    @RequestMapping("/login")
    public String login(Model model){
        LoginDTO user = new LoginDTO();
        model.addAttribute("user",user);
        return "login";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user ,@RequestParam(value="terms" ,defaultValue = "false") boolean terms, Model model){
        try {

            if (terms) {
                user.setRole("ROLE_USER");
                user.setEnabled(true);
                User save = userService.adduser(user);
                System.out.println(save);
                model.addAttribute("alert","alert-success");
                model.addAttribute("message","successfully registered!");
            }
            else{
                model.addAttribute("alert","alert-danger");
                model.addAttribute("message","please agree to terms and conditions");
                return "signup";
            }
            return "login";
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("alert","alert-danger");
            model.addAttribute("message","something went wrong!");
            return "signup";
        }

    }

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("user") LoginDTO user ){
        try {
                System.out.println(user);
                User save = userService.getUser(user.getEmail());
                if(user.getPassword().equals(save.getPassword()))
                {
                    System.out.println(save);
                    return "contacts";
                }
                return "login";
            }catch(Exception e){
            e.printStackTrace();
            return "login";
        }

    }



}
