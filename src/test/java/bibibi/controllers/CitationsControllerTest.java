/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.controllers;

import bibibi.models.Citation;
import bibibi.models.CitationType;
import bibibi.repositories.CitationRepository;
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
        citation.setAuthor("Guy, Some");
        citation.setTitle("Cool Title");
        citation.setYear(2012);
        citation.setType(CitationType.ARTICLE);
        crepo.save(citation);
    }
    
    @After
    public void tearDown() {
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
        assertTrue(content.contains("Guy, Some"));
    }
}
