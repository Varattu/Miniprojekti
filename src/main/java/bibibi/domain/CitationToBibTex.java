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
        return ret;
    }

    public String formatTypeAndBibtexKey() {
        String ret = "@";
        ret += cite.getType() == null ? "" : cite.getType().toString();
        ret += "{" + cite.getBibtexkey() + ",\n";
        return ret;
    }

    public String formatAuthor() {
        return cite.getAuthor() == null ? ""
                : "author = {" + cite.getAuthor() + "},\n";
    }

    public String formatTitle() {
        return cite.getTitle() == null ? ""
                : "title = {" + cite.getTitle() + "},\n";
    }

    public String formatYear() {
        return cite.getYear() == 0 ? "" : "year = {" + cite.getYear() + "},\n";
    }

    public String formatPublisher() {
        return cite.getPublisher() == null ? ""
                : "publisher = {" + cite.getPublisher() + "},\n";
    }

    public String formatPages() {
        return cite.getAuthor() == null ? ""
                : "pages = {" + cite.getPages() + "},\n";
    }

    public String formatAddress() {
        return cite.getAddress() == null ? ""
                : "adress = {" + cite.getAddress() + "},\n";
    }

    public String formatVolume() {
        return cite.getArticle() == null ? ""
                : "volume = {" + cite.getArticle().getVolume() + "},\n";
    }

    public String formatNumber() {
        return cite.getArticle() == null ? ""
                : "number = {" + cite.getArticle().getNumber() + "},\n";
    }
}
