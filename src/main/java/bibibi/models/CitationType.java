/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.models;

/**
 *
 * @author ola
 */
public enum CitationType {
    ARTICLE("Article","/addarticle"),
    BOOK("Book","/addbook"),
    INPROCEEDINGS("In Proceedings","/addinproceedings");
    
    private final String displayName;
    private final String address;
    private CitationType(String displayName,String address) {
        this.displayName = displayName;
        this.address = address;
    }
    public String getAdress() {
        return address;
    }
    public String getDisplayName() {
        return displayName;
    }
}
