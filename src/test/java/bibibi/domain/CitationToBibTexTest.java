package bibibi.domain;

import bibibi.models.Citation;
import bibibi.domain.CitationToBibTex;
import bibibi.models.Article;
import bibibi.models.Citation;
import bibibi.models.CitationType;
import bibibi.models.CitationType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akkuJii
 */
public class CitationToBibTexTest {
    
    Citation allfields;
    Citation fourfields;
    CitationToBibTex cbt;
    
    public CitationToBibTexTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        allfields = new Citation();
        allfields.setType(CitationType.BOOK);
        allfields.setBibtexkey("PAIN14");
        allfields.setAuthor("Jules PainOla");
        allfields.setTitle("Pelkoa ja pedagogiikkaa");
        allfields.setYear(2014);
        allfields.setPublisher("BassGeek Publishing");
        allfields.setPages("48--66");
        allfields.setAddress("BassGeek Building, USA");
        Article article = new Article();
        article.setVolume(1);
        article.setNumber(77);
        allfields.setArticle(article);

        fourfields = new Citation();
        fourfields.setType(CitationType.ARTICLE);
        fourfields.setBibtexkey("JHWN16");
        fourfields.setTitle("This is how we do");
        fourfields.setYear(1972);        
    }

    @Test
    public void convertsAllFields() {
        cbt = new CitationToBibTex(allfields);
        String expectedOutput = "@BOOK{PAIN14,\n" +
                                "author = {Jules PainOla},\n" +
                                "title = {Pelkoa ja pedagogiikkaa},\n" + 
                                "year = {2014},\n" +
                                "publisher = {BassGeek Publishing},\n" +
                                "pages = {48--66},\n" +
                                "adress = {BassGeek Building, USA},\n" +
                                "volume = {1},\n" +
                                "number = {77},\n" +
                                "}\n\n";
        assertEquals(cbt.convert(), expectedOutput);
    }
    
    @Test
    public void convertsFourFields() {
        cbt = new CitationToBibTex(fourfields);
        String expectedOutput = "@ARTICLE{JHWN16,\n" + 
                                "title = {This is how we do},\n" +
                                "year = {1972},\n" +
                                "}\n\n";
        assertEquals(cbt.convert(), expectedOutput);
    }
}
