import bibibi.models.Citation;
import bibibi.models.CitationToBibTex;
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
    
    Citation cite;
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
        cite = new Citation();
        cite.setType(CitationType.BOOK);
        cite.setBibtexkey("PAIN14");
        cite.setAuthor("Jules PainOla");
        cite.setTitle("Pelkoa ja pedagogiikkaa");
        cite.setYear(2014);
        cbt = new CitationToBibTex(cite);
    }

    @Test
    public void convertWorks() {
        String expectedOutput = "@BOOK{PAIN14,\n" +
                                "author = {Jules PainOla},\n" +
                                "title = {Pelkoa ja pedagogiikkaa},\n" + 
                                "year = {2014},\n" +
                                "}\n\n";
        assertEquals(cbt.convert(), expectedOutput);
        
    }
}
