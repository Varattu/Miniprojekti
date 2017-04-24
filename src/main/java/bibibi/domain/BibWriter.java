package bibibi.domain;

import bibibi.models.Citation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author akkuJii
 */
public class BibWriter {
    File file;
    FileWriter writer;
    String filename;
    List<Citation> citations;
    
    public BibWriter(String filename, List<Citation> citations) throws IOException {
        this.citations = citations;
        file = new File(filename + ".bib");
        file.createNewFile();
    }
    
    public void writeFile() throws IOException {
        writer = new FileWriter(file);
        for(Citation cite : this.citations) {
            writer.write(new CitationToBibTex(cite).convert());
        }
        writer.flush();
        writer.close();
    }
}
