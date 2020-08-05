package guru.springframework.controllers;

import guru.springframework.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> persistPerson(@RequestBody User user) {

        System.out.println(user);

        if("tharaka@gmail.com".equals(user.getFirstName()) && "1234".equals(user.getLastName())) {
            return new ResponseEntity<String>(user.getFirstName(), HttpStatus.OK);
        }
        return new ResponseEntity<String>(user.getLastName(), HttpStatus.UNAUTHORIZED);
    }
}
