package com.tawk.jhonny;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/simpleAPI")
    public String simpleAPICall() {

        return "Simple API Call";
    }

}
