/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.controllers;

import bibibi.models.Citation;
import bibibi.models.CitationType;
import bibibi.repositories.CitationRepository;
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

/**
 *
 * @author ola
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CitationsTest {
    
    @Autowired
    private CitationRepository crepo;
    
    private Citation citation;
    
    public CitationsTest() {
    }
    
    @Before
    public void setUp() {
        citation = new Citation();
        citation.setAuthor("Guy, Some");
        citation.setTitle("Best paper eva!");
        citation.setYear(2018);
        citation.setType(CitationType.ARTICLE);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void citationIsSavedProperlyInDatabase() {
        crepo.save(citation);
        Citation retrieved = crepo.findOne((long)1);
        
        assertNotNull(retrieved);
        assertEquals(retrieved.getAuthor(), "Guy, Some");
    }
    
    @Test
    public void citationsAreListedProperly() {
        
    }
}
