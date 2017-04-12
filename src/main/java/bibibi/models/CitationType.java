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
    ARTICLE("Article"),
    BOOK("Book"),
    INPROCEEDINGS("In Proceedings");
    
    private final String displayName;
    
    private CitationType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
