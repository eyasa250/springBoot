package com.example.project.Controller;

import com.example.project.Entity.Client;
import com.example.project.Entity.Freelancer;
import com.example.project.Entity.User;
import com.example.project.Exception.ApiRequestException;
import com.example.project.dto.UserDto;
import com.example.project.servives.ClientServiceImp;
import com.example.project.servives.FreelancerServiceImp;
import com.example.project.servives.UserServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private ClientServiceImp clientServiceImp;

    @Autowired
    private FreelancerServiceImp freelancerServiceImp;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }


    @GetMapping("/login")
    public String showLoginForm(HttpServletRequest request,Model model) {

        AuthenticationException authException = (AuthenticationException) request.getSession()
                .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        if (authException != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        // Clear the session attribute to prevent displaying the same error on subsequent requests
        request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        return "login";
    }


/*    @PostMapping("/login")
    public String processLogin(User user,Model model) {

        boolean ok = userServiceImp.findByUsernamePassword(user.getUsername(),user.getPassword());
        if (ok) return "redirect:/auth/";
        else {
            model.addAttribute("error", "Your username or password is wrong");
            return "login";
        }
}*/

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "sign_up";
    }

    @PostMapping("/signup")
    public String processSignUp(UserDto user,Model model) {

        Client c = null;
        Freelancer f = null;
        try {
            if (user.getRole().name().equals("CLIENT"))
                c =clientServiceImp.createClient(user);
            else if (user.getRole().name().equals("FREELANCER"))
                f =freelancerServiceImp.createFreelancer(user);

        } catch(ApiRequestException e) {
            model.addAttribute("error", e.getMessage());
            return "sign_up";
        }

        if (f==null && c == null) return "sign_up";
        else return "redirect:/auth/login";

        /*clientServiceImp.createClient(client);*/

    }




}
    /*@ResponseBody
    @RequestMapping(value = "/login/{username}/{password}")
    public ResponseEntity<Object> saveFreelancer(@PathVariable("username") String username,@PathVariable("password") String password) {

        boolean ok = userServiceImp.findByUsernamePassword(username,password);
        if (ok) return new ResponseEntity<>("Login Succefull",HttpStatus.OK);
            else return new ResponseEntity<>("Login failed",HttpStatus.NOT_FOUND);
    }*/
/*    @ResponseBody
    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveClient(@RequestBody Client client) {

        clientServiceImp.createClient(client);
        return new ResponseEntity<>(client , HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/freelancer/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveFreelancer(@RequestBody Freelancer freelancer) {

        freelancerServiceImp.createFreelancer(freelancer);
        return new ResponseEntity<>(freelancer , HttpStatus.OK);
    }*/
