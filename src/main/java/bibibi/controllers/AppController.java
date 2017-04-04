/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ola
 */
@Controller
@EnableAutoConfiguration
public class AppController {

    @RequestMapping("*")
    public String app() {
        return "redirect:/citations";
    }
    
    
    
}
