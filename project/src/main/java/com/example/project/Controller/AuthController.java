package com.example.project.Controller;

import com.example.project.Entity.Client;
import com.example.project.Entity.Freelancer;
import com.example.project.servives.ClientServiceImp;
import com.example.project.servives.FreelancerServiceImp;
import com.example.project.servives.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/auth")
public class AuthController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private ClientServiceImp clientServiceImp;

    @Autowired
    private FreelancerServiceImp freelancerServiceImp;
    @ResponseBody
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
    }

    @ResponseBody
    @RequestMapping(value = "/login/{username}/{password}")
    public ResponseEntity<Object> saveFreelancer(@PathVariable("username") String username,@PathVariable("password") String password) {

        boolean ok = userServiceImp.findByUsernamePassword(username,password);
        if (ok) return new ResponseEntity<>("Login Succefull",HttpStatus.OK);
            else return new ResponseEntity<>("Login failed",HttpStatus.NOT_FOUND);
    }
}
