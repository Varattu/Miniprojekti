/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.models;

import bibibi.repositories.CitationRepository;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.After;
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
    
    private static Validator validator;
    
    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Before
    public void setUp() {
        citation = new Citation();
        citation.setBibtexkey("Guy2018");
        citation.setAuthor("Guy, S");
        citation.setTitle("Best paper eva!");
        citation.setYear(2018);
        citation.setType(CitationType.ARTICLE);
    }
    
    @After
    public void tearDown() {
        crepo.deleteAll();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void citationIsSavedProperlyInDatabase() {
        Citation saved = crepo.save(citation);
        
        assertNotNull(saved);
        assertEquals(saved.getAuthor(), "Guy, S");
    }
    
    @Test
    public void citationWithNoAuthorIsntSavedInTheDatabase() {
        citation = new Citation();
        citation.setBibtexkey("Some2012");
        citation.setTitle("Best paper eva!");
        citation.setYear(2018);
        citation.setType(CitationType.ARTICLE);
        
        Set<ConstraintViolation<Citation>> constraintViolations = validator.validate(citation);
        
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty",
                constraintViolations.iterator().next().getMessage());
        
    }
    
    @Test
    public void citationWithNoTitleIsntSavedInTheDatabase() {
        citation = new Citation();
        citation.setBibtexkey("Guy2018");
        citation.setAuthor("Guy, S");
        citation.setYear(2018);
        citation.setType(CitationType.ARTICLE);
        
        Set<ConstraintViolation<Citation>> constraintViolations = validator.validate(citation);
        
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty",
                constraintViolations.iterator().next().getMessage());
        
    }
    
    @Test
    public void citationWithNoTypeIsntSavedInTheDatabase() {
        citation = new Citation();
        citation.setBibtexkey("Guy2012");
        citation.setAuthor("Guy, S");
        citation.setTitle("Epic title");
        citation.setYear(2012);
        
        Set<ConstraintViolation<Citation>> constraintViolations = validator.validate(citation);
        
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null",
                constraintViolations.iterator().next().getMessage());
        
    }
    
    @Test
    public void citationWithTooOldYearIsntSavedInTheDatabase() {
        citation.setYear(123);
        
        Set<ConstraintViolation<Citation>> constraintViolations = validator.validate(citation);
        
        assertEquals(1, constraintViolations.size());
        assertEquals("must be greater than or equal to 1900",
                constraintViolations.iterator().next().getMessage());
        
    }
    
    @Test
    public void citationWithYearInTheFutureIsntSavedInTheDatabase() {
        citation.setYear(3000);
        
        Set<ConstraintViolation<Citation>> constraintViolations = validator.validate(citation);
        
        assertEquals(1, constraintViolations.size());
        assertEquals("must be less than or equal to 2020",
                constraintViolations.iterator().next().getMessage());
        
    }
    
    @Test
    public void citationWithArticleInfoIsSavedCorrectly() {
        Article article = new Article();
        article.setJournal("Some real cool journal");
        article.setNumber(1);
        article.setVolume(2);
        
        citation.setArticle(article);
        Citation saved = crepo.save(citation);
        
        assertEquals("Some real cool journal", saved.getArticle().getJournal());
        assertEquals(1, saved.getArticle().getNumber());
        assertEquals(2, saved.getArticle().getVolume());
    }
    
    @Test
    public void citationWithInProceedingsInfoIsSavedCorrectly() {
        InProceedings inpro = new InProceedings();
        inpro.setBooktitle("Cool name for this booktitle");
        
        citation.setInProceedings(inpro);
        Citation saved = crepo.save(citation);
        
        assertEquals("Cool name for this booktitle", saved.getInProceedings().getBooktitle());
    }
    
}
