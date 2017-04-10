package bibibi.models;

/**
 *
 * @author akkuJii
 */
public class CitationToBibTex {
    Citation cite;
    org.jbibtex.BibTeXFormatter bibtexFormatter;
    
    public CitationToBibTex(Citation cite) {
        this.cite = cite;
        new org.jbibtex.BibTeXFormatter();
    }
    
    public String convert() {
        String ret;
        switch (cite.getType()) {
            case ARTICLE : ret = convertArticle();
            break;
            case BOOK : ret = convertBook();
            break;
            case INPROCEEDINGS : ret = convertInproceedings(); 
            break;
        }
        return ret;
    }
    
    public String convertArticle() {
        String ret = "@Article{";
        
        return ret;
    }
    
    public String convertBook() {
        String ret = "@Book{";
        
        return ret;
    }
    
    public String convertInproceedings() {
        String ret = "@Book{";
        
        return ret;
    }
}
