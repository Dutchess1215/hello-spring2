//package org.launchcode.hellospring.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
////created by Nathan Murray
//@Controller
//@ResponseBody
//@RequestMapping("hello")
//public class HelloController {
//
////    @GetMapping("hello")  //handles requests at /hello
////    @ResponseBody
////    public String hello(){
////        return "Hello, Spring!";
////    }
//    @GetMapping("goodbye")  //handles requests at /hello/goodbye
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }
//
//    //handles requests of the form hello?name=LaunchCode -- could be anything
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){//name= is the param initaialized here
//        return "Hello, " + name;
//    }
//
//    //handles requests/hello/LaunchCode -- part of the path not a query string as before
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name;
//    }
//
//    //handles form submission
//    @GetMapping("form")
//    public String helloForm(){
//        return"<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" + //submits request to /hello which we made already
//                "<input type='text' name= 'name'>" +
//                "<input type = 'submit' value='greet me'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }
//}
package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay - copied for exercise
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' />" +
                "</br></br>" +
                "<select name = 'language' id='lang'>" +
                "<option value = 'Fi'>Finnish</option>" +
                "<option value = 'Ta'>Tagalog</option>" +
                "<option value = 'Po'>Polish</option>" +
                "<option value = 'Ir'>Irish</option>" +
                "<option value = 'Si'>Sinhala</option>" +
                "</select>" +
                "</br></br>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }
    //    Exercises
    @RequestMapping(method = RequestMethod.POST, value = "hello")
    public static String createMessage(@RequestParam String name, @RequestParam String language ) {
        if(name.equals("")){
            name = "World";
        }
        String greeting = "";

        if (language.equals("Fi")) {
            greeting =  "Moi, ";
        } else if (language.equals("Ta")) {
            greeting = "Kumusta, ";
        } else if (language.equals("Po")) {
            greeting = "Siema, ";
        } else if (language.equals( "Ir")) {
            greeting = "Dia duit, ";
        } else if (language.equals("Si")) {
            greeting = "Subha davasak, ";
        }

        return greeting + name + "!";
    }
}
