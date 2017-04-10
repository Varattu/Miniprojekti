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
        String ret = formatTypeAndBibtexKey();
        ret += formatAuthor();
        ret += formatTitle();
        ret += formatYear();
        ret += "}\n\n";
        return ret;
    }
    
    public String formatTypeAndBibtexKey() {
        String ret = "@";
        ret += cite.getType() == null ? "" : cite.getType().toString();
        ret += "{" + cite.getBibtexkey() + ",\n";
        return ret;
    }
    
    public String formatAuthor() {
        if (cite.getAuthor() == null) {
            return "";
        }else{
            return "author = {" + cite.getAuthor() + "},\n";
        }
    }
    
    public String formatTitle() {
        if (cite.getAuthor() == null) {
            return "";
        }else{
            return "title = {" + cite.getTitle() + "},\n";
        }
    }
    
    public String formatYear() {
        if (cite.getYear() == 0) {
            return "";
        }else{
            return ("year = {" + cite.getYear() + "},\n");
        }
    }
    
    
    
    
}

