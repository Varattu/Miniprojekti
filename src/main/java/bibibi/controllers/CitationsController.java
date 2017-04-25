/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.controllers;

import bibibi.domain.BibWriter;
import bibibi.models.Citation;
import bibibi.repositories.CitationRepository;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String getCitations(Model model) {
        model.addAttribute("citations", citationRepository.findAll());
        return "listcitations";
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getCitation(Model model, @PathVariable Long id) {
        Citation citation = citationRepository.findOne(id);
        model.addAttribute("citation", citation);
        return "citationinfo";
    }
    
    @Transactional
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        citationRepository.delete(id);
        return "redirect:/listcitations";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String getAddingPage(Model model) {
        model.addAttribute(new Citation());
        return "addcitation";
    }
    
    @Transactional
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String postCitation(@Valid @ModelAttribute Citation citation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addcitation";
        }
        citationRepository.save(citation);
        return "redirect:/listcitations";
    }
    
    @RequestMapping(value = "/export", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource getFile() throws IOException {
        BibWriter bw = new BibWriter("export", this.citationRepository.findAll());
        bw.writeFile();
        return new FileSystemResource(bw.getFile()); 
    }
}
