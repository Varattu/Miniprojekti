/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.controllers;

import bibibi.models.Citation;
import bibibi.repositories.CitationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ola
 */
@Controller
@RequestMapping("citations")
@EnableAutoConfiguration
public class CitationsController {

    @Autowired
    private CitationRepository citationRepository;

    @RequestMapping(method=RequestMethod.GET)
    public String citations(Model model) {
        model.addAttribute("citations", citationRepository.findAll());
        return "listcitations";
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String citations(Model model, @PathVariable Long id) {
        Citation citation = citationRepository.findOne(id);
        model.addAttribute("citation", citation);
        return "citation";
    }
    
    @Transactional
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        citationRepository.delete(id);
        return "redirect:/listcitations";
    }
    
    @Transactional
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String postCitation(@RequestBody Citation citation) {
        citationRepository.save(citation);
        return "redirect:/listcitations";
    }

}
