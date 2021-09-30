package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
public class HelloController {

//    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles request at path /goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Form where you enter name, pick a language, and hit the Greet me! button
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" +
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='italian'>Italian</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    // Customizes greeting based on language selected
    public static String createMessage(String usersName, String chosenLanguage) {
        String greeting = "";

        if (chosenLanguage.equals("english")) {
            greeting = "Hello";
        } else if (chosenLanguage.equals("german")) {
            greeting = "Guten Tag";
        } else if (chosenLanguage.equals("french")) {
            greeting = "Bonjour";
        } else if (chosenLanguage.equals("spanish")) {
            greeting = "Hola";
        } else if (chosenLanguage.equals("italian")) {
            greeting = "Bonjourno";
        } else {
           return "Whoa.  Something broke. Please contact mmedei6@wgu.edu.";
        }

        return greeting + ", " + usersName + "!!";
    }

}
