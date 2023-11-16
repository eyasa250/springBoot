package com.example.project.Controller;

import com.example.project.Entity.Client;
import com.example.project.servives.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/client")
public class ClientController {
/*    @RequestMapping("/")
    public String Home(Model model) {
            model.addAttribute("message", "Welcome to the home page!");
            return "index";
        }*/


    @Autowired
    private ClientServiceImp clientServiceImp;

    @GetMapping("/getone/{Id}")
    public ResponseEntity<Object> getClient(@PathVariable("Id") long id) {


        Client c1 = clientServiceImp.getClientByID(id);

        if (c1 != null) {
            return new ResponseEntity<>(c1 , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getone/{Nom}")
    public ResponseEntity<Object> getClient(@PathVariable("Nom") String nom) {


        Client c1 = clientServiceImp.getClientByNom(nom);

        if (c1 != null) {
            return new ResponseEntity<>(c1 , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(nom , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Object> getAllClients() {
        List<Client> clients = clientServiceImp.getAllClient();

        return new ResponseEntity<>(clients , HttpStatus.OK);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
        Client c1 = clientServiceImp.getClientByID(id);

        if (c1 != null) {
            client.setId(id);
            clientServiceImp.updateClient(client);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(client, HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("delete/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable("id") long id) {
        Client c1 = clientServiceImp.getClientByID(id);

        if (c1 != null) {
            clientServiceImp.deleteClient(id);
            return new ResponseEntity<>(id , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id , HttpStatus.NOT_FOUND);
        }
    }






}
