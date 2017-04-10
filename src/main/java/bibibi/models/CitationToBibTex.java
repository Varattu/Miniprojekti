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
        String ret = "@" + cite.getType() + "{" + cite.getBibtexkey() + ",\n";
        ret += "author = {" + cite.getAuthor() + "},\n";
        ret += "{" + cite.getYear() + "},\n";
        ret += "}\n";
        return ret;
    }
}
