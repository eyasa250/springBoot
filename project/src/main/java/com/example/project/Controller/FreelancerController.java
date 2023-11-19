package com.example.project.Controller;

import com.example.project.Entity.Client;
import com.example.project.Entity.Freelancer;
import com.example.project.servives.FreelancerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/freelancer")
public class FreelancerController {

    @Autowired
    private FreelancerServiceImp freelancerServiceImp;

    @GetMapping("/getone/{Id}")
    public ResponseEntity<Object> getClient(@PathVariable("Id") long id) {


        Freelancer f1 = freelancerServiceImp.getFreelancerByID(id);

        if (f1 != null) {
            return new ResponseEntity<>(f1 , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getone/{Nom}")
    public ResponseEntity<Object> getFreelancer(@PathVariable("Fullname") String fullname) {


        Freelancer f1 = freelancerServiceImp.getFreelancerByFullname(fullname);

        if (f1 != null) {
            return new ResponseEntity<>(f1 , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(fullname , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Object> getAllFreelancers() {
        List<Freelancer> freelancers = freelancerServiceImp.getAllFreelancer();

        return new ResponseEntity<>(freelancers , HttpStatus.OK);

    }

    @PostMapping("update/{id}")
    public ResponseEntity<Object> updateFreelancer(@PathVariable("id") long id, @RequestBody Freelancer freelancer) {
        Freelancer f1 = freelancerServiceImp.getFreelancerByID(id);

        if (f1 != null) {
            freelancer.setId(id);
            freelancerServiceImp.updateFreelancer(freelancer);
            return new ResponseEntity<>(id , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id , HttpStatus.NOT_FOUND);
        }


    }



    @GetMapping("delete/{id}")
    public ResponseEntity<Object> deleteFreelancer(@PathVariable("id") long id) {

        Freelancer f1 = freelancerServiceImp.getFreelancerByID(id);

        if (f1 != null) {
            freelancerServiceImp.deleteFreelancer(id);
            return new ResponseEntity<>(id , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id , HttpStatus.NOT_FOUND);
        }
    }
}
