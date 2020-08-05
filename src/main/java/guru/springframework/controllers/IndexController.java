package guru.springframework.controllers;

import guru.springframework.domain.Course;
import guru.springframework.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> listAllUsers() {
        List<Course> users = new ArrayList<>();

        Course c1 = new Course();
        c1.setId("1");
        c1.setDescription("Angular Basic");
        c1.setLongDescription("sdfdf");
        c1.setUrl("getting-started-with-angular2");

        Course c2 = new Course();
        c2.setId("2");
        c2.setDescription("Angular Advance");
        c2.setLongDescription("sdfdf");
        c2.setUrl("angular2-http");

        users.add(c1);
        users.add(c2);


        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Course>>(users, HttpStatus.OK);
    }


    @RequestMapping(value = "/newsletter", method = RequestMethod.POST)
    public ResponseEntity<String> persistPerson(@RequestBody String person) {

        System.out.print("********* Username :"+person);

        return new ResponseEntity<String>(person, HttpStatus.OK);
    }


}
