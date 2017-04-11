/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.models;

/**
 *
 * @author akkuJii
 */
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class Stepdefs {
    Citation cite = new Citation();
    
    @Given("^User enters title \"The Ultimate Meaning of Life\"$")
    public void user_enters_title(String val) throws Throwable {
        cite.setTitle(val);
    }

    @And("^User enters author \"Doe, John\"$")
    public void user_enters_author(String val) throws Throwable {
        cite.setAuthor(val);
    }

    @And("^User enters year \"1952\"$")
    public void user_enters_year(int val) throws Throwable {
        cite.setYear(val);
    }
    
    @And("^User selects type \"Article\"$")
    public void user_selects_type(int val) throws Throwable {
        cite.setType(CitationType.ARTICLE);
    }
    
    @When("^User presses Add citation -button$")
    public void user_presses_add_citation() throws Throwable {
    }
    
    @Then("^The system gives infomessage about success.")
    public void system_gives_infomessage_about_succ(int val) throws Throwable {
    }
    
}