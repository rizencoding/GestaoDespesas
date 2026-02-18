package com.rizencoding.gestao_custos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/javadevweek")
@RestController
public class FirstController {
    @GetMapping("/helloworld")
    public String hello(){
        return "Hello world!";
    }

}
