package bibibi.models;

/**
 *
 * @author akkuJii
 */
public class CitationToBibTex {
    Citation cite;
    
    public CitationToBibTex(Citation cite) {
        this.cite = cite;
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
}
