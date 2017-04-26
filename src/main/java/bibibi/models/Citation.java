/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author ola
 */
@Entity
public class Citation extends AbstractPersistable<Long> {
    
    // TODO: validation for this field as well after decided if it's automatically generated or not
    private String bibtexkey;
    
    @NotNull
    private CitationType type;
    
    @NotBlank
    @Pattern(regexp = "([A-ZÅÄÖ][a-zåäö]*, [A-ZÅÄÖ]; )*([A-ZÅÄÖ][a-zåäö]*, [A-ZÅÄÖ])+",
            message = "Authors must be in the correct format (Last name, Initial of first name. Different authors seperated with ;")
    private String author;
    
    @NotBlank
    private String title;
    
    @NotNull
    @Min(1900)
    @Max(2020)
    private int year;
    private String publisher;
    private String pages;
    private String address;
    
    private Article article;
    
    private InProceedings inProceedings;
    
    private Book book;

    public CitationType getType() {
        return type;
    }

    public void setType(CitationType type) {
        this.type = type;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
    
    public InProceedings getInProceedings() {
        return inProceedings;
    }

    public void setInProceedings(InProceedings inProceedings) {
        this.inProceedings = inProceedings;
    }

    

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBibtexkey() {
        return bibtexkey;
    }

    public void setBibtexkey(String bibtexkey) {
        this.bibtexkey = bibtexkey;
    }

}
