/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.controllers;

import bibibi.models.Citation;
import bibibi.models.CitationType;
import bibibi.repositories.CitationRepository;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author ola
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CitationsControllerTest {
    
    @Autowired
    private WebApplicationContext webAppContext;
    
    private MockMvc mockMvc;
    
    @Autowired
    private CitationRepository crepo;
    
    public CitationsControllerTest() {
    }
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        Citation citation = new Citation();
        citation.setBibtexkey("Guy2012");
        citation.setAuthor("Guy, S");
        citation.setTitle("Cool Title");
        citation.setYear(2012);
        citation.setType(CitationType.ARTICLE);
        crepo.save(citation);
    }
    
    @After
    public void tearDown() {
        crepo.deleteAll();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/citations"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void responseContainsCorrectCitation() throws Exception {
        MvcResult res = mockMvc.perform(get("/citations"))
                .andReturn();
        
        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Cool Title"));
        assertTrue(content.contains("Guy, S"));
    }
    
    @Test
    public void addCitationPageDisplayedCorrectly() throws Exception {
        MvcResult res = mockMvc.perform(get("/citations/add"))
                .andReturn();
        
        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Fill the form to add a new citation"));
        assertTrue(content.contains("Title:"));
    }
    
    @Test
    public void postingCitationWorksWithValidParameters() throws Exception {
        mockMvc.perform(post("/citations/add")
                .param("bibtexkey", "Guy2012")
                .param("title", "Great title")
                .param("author", "Guy, S").param("year", "2012")
                .param("type", "ARTICLE"))
                .andExpect(redirectedUrl("/listcitations"));
        
        
        Citation saved = crepo.findByTitle("Great title").get(0);
        
        assertNotNull(saved);
        assertEquals("Great title", saved.getTitle());
        assertEquals("Guy, S", saved.getAuthor());
    }
    
    @Test
    public void postingCitationDoesntWorkWithInvalidParameters() throws Exception {
        MvcResult res = mockMvc.perform(post("/citations/add").param("title", "Great title")
                .param("author", "Guy, Some").param("year", "2012")
                .param("type", "ARTICLE"))
                .andReturn();
        
        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Fill the form to add a new citation"));
        assertTrue(content.contains("Title:"));
        assertTrue(content.contains("Authors must be in the correct format"));
        
        List<Citation> saved = crepo.findByTitle("Great title");
        
        assertEquals(0, saved.size());
    }
    
    @Test
    public void showingExistingCitationWorks() throws Exception {
        Citation savedCit = crepo.findByTitle("Cool Title").get(0);
        System.out.println("/citations/"+savedCit.getId().toString());
        MvcResult res = mockMvc.perform(get("/citations/"+savedCit.getId().toString())).andReturn();
        
        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains(savedCit.getTitle()));
        assertTrue(content.contains(savedCit.getAuthor()));
        assertTrue(content.contains(savedCit.getBibtexkey()));
        assertTrue(content.contains("Delete citation"));
        assertTrue(content.contains("Edit citation"));
    }
}
