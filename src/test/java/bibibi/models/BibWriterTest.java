/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.domain;

import bibibi.models.Citation;
import bibibi.models.CitationType;
import java.io.IOException;
import java.util.ArrayList;
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
public class BibWriterTest {
    
    Citation first;
    Citation second;
    BibWriter writer;
    
    public BibWriterTest() {
    }
    
    @Before
    public void setUp() {
    first = new Citation();
    first.setType(CitationType.BOOK);
    first.setBibtexkey("Martin09");
    first.setAuthor("Martin, Robert");
    first.setTitle("Clean Code: A Handbook of Agile Software Craftsmanship");
    first.setYear(2008);
    first.setPublisher("Prentice Hall");
    
    second = new Citation();
    second.setType(CitationType.BOOK);
    second.setBibtexkey("FDJS54");
    second.setAuthor("Martini, Robert");
    second.setTitle("A Handbook of Agile Software Craftsmanship");
    second.setYear(2008);
    second.setPublisher("Prentice Hall");
    }
    
    @Test
    public void writeOneEntry() throws IOException {
        ArrayList<Citation> citations = new ArrayList<>();
        citations.add(first);
        citations.add(second);
        writer = new BibWriter("samplefile", citations);
        writer.writeFile();
    }
}

