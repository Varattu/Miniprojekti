package bibibi.domain;

import bibibi.models.Citation;

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
        ret += formatPublisher();
        ret += formatPages();
        ret += formatAddress();
        ret += formatVolume();
        ret += formatNumber();
        ret += "}\n\n";
        ret = replaceScandicCharacters(ret);
        return ret;
    }

    private String formatTypeAndBibtexKey() {
        String ret = "@";
        ret += cite.getType() == null ? "" : cite.getType().toString();
        ret += "{" + cite.getBibtexkey() + ",\n";
        return ret;
    }

    private String formatAuthor() {
        if (cite.getAuthor() == null) {
            return "";
        } else {
            return "author = {" + cite.getAuthor() + "},\n";
        }
    }

    private String formatTitle() {
        if (cite.getTitle() == null) {
            return "";
        } else {
            return "title = {" + cite.getTitle() + "},\n";
        }
    }

    private String formatYear() {
        if (cite.getYear() == 0) {
            return "";
        } else {
            return ("year = {" + cite.getYear() + "},\n");
        }
    }

    private String formatPublisher() {
        if (cite.getPublisher()== null) {
            return "";
        } else {
            return "publisher = {" + cite.getPublisher() + "},\n";
        }
    }

    private String formatPages() {
        if (cite.getPages()== null) {
            return "";
        } else {
            return "pages = {" + cite.getPages() + "},\n";
        }
    }

    private String formatAddress() {
        if (cite.getAddress() == null) {
            return "";
        } else {
            return "adress = {" + cite.getAddress() + "},\n";
        }
    }

    private String formatVolume() {
        if (cite.getArticle() != null) {
            return ("volume = {" + cite.getArticle().getVolume() + "},\n");
        } else {
            return "";
        }
    }

    private String formatNumber() {
        if (cite.getArticle() != null) {
            return ("number = {" + cite.getArticle().getNumber() + "},\n");
        } else {
            return "";
        }
    }

    private String replaceScandicCharacters(String cit) {
        cit = cit.replace("å", "\\aa");
        cit = cit.replace("Å", "\\AA");
        cit = cit.replace("ä", "\\\"{a}");
        cit = cit.replace("ö", "\\\"{o}");
        cit = cit.replace("Ä", "\\\"{A}");
        return cit.replace("Ö", "\\\"{O}");
    }
}
