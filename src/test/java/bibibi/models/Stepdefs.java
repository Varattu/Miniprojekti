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
import static bibibi.models.CitationType.INPROCEEDINGS;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

public class Stepdefs {
    Citation cite;
    
    @Given("^New citation is initialized$")
    public void counter_is_initialized() throws Throwable {
        cite = new Citation();
    }
    
    @When("^User enters article title \"([^\"]*)\"$")
    public void user_enters_article_title(String arg1) throws Throwable {
        cite.setTitle(arg1);
    }
    
    @Then("^The title of a article should be \"([^\"]*)\"$")
    public void the_title_of_a_article_should_be(String arg1) throws Throwable {
        assertEquals(arg1, cite.getTitle());
    }

    @And("^User enters year \"([^\"]*)\"$")
    public void user_enters_year(int val) throws Throwable {
        cite.setYear(val);
    }
    
    @And("^User selects type \"([^\"]*)\"$")
    public void user_selects_type(CitationType val) throws Throwable {
        cite.setType(val);
    }
    
    @When("^User presses Add citation -button$")
    public void user_presses_add_citation() throws Throwable {
    }
    
    @Then("^The system gives infomessage about success.")
    public void system_gives_infomessage_about_succ() throws Throwable {
    }

    @When("^User sets inproceedings citation type \"([^\"]*)\"$")
    public void user_sets_inproceedings_citation_type(String arg1) throws Throwable {
        cite.setType(INPROCEEDINGS);
    }
    
    @Then("^The inproceedings citation type should be \"([^\"]*)\"$")
    public void the_inproceedings_citation_type_should_be(String arg1) throws Throwable {
        assertEquals(cite.getType(), INPROCEEDINGS);
    }
    
    @When("^User sets inproceedings citation key \"([^\"]*)\"$")
    public void user_sets_inproceedings_citation_key(String arg1) throws Throwable {
        cite.setBibtexkey(arg1);
    }
    
    @Then("^The inproceedings citation key should be \"([^\"]*)\"$")
    public void the_inproceedings_citation_key_should_be(String arg1) throws Throwable {
        assertEquals(cite.getBibtexkey(), arg1);
    }
    
    @When("^User sets inproceedings citation title \"([^\"]*)\"$")
    public void user_sets_inproceedings_citation_title(String arg1) throws Throwable {
        cite.setTitle(arg1);
    }

    @Then("^The inproceedings citation title should be \"([^\"]*)\"$")
    public void the_inproceedings_citation_title_should_be(String arg1) throws Throwable {
        assertEquals(arg1, cite.getTitle());
    }
    
    @When("^User sets inproceedings citation year (\\d+)$")
    public void user_sets_inproceedings_citation_year(int arg1) throws Throwable {
        cite.setYear(arg1);
    }

    @Then("^The inproceedings citation year should be (\\d+)$")
    public void the_inproceedings_citation_year_should_be(int arg1) throws Throwable {
        assertEquals(arg1, cite.getYear());
    }
    
}