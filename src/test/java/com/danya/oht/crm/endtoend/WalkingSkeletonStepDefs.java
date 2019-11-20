package com.danya.oht.crm.endtoend;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WalkingSkeletonStepDefs {

    @Autowired
    private Browser browser;

    @When("The client opens the main page")
    public void the_client_opens_the_main_page() throws Exception {
        browser.open("");
    }

    @Then("The client sees \"Create order\" submenu on a page")
    public void the_client_sees_Create_order_submenu_on_a_page() {
        browser.findElement(By.name("createorder"));
    }

    @Then("The client sees \"Find order\" submenu on a page")
    public void the_client_sees_Find_order_submenu_on_a_page() {
        browser.findElement(By.name("findorder"));
    }

    @Then("The client sees \"About\" submenu on a page")
    public void the_client_sees_About_submenu_on_a_page() {
        browser.findElement(By.name("about"));
    }

    @When("The client opens the create order page")
    public void the_client_opens_the_create_order_page() {
        browser.openCreateOrder();
    }

    @When("The client fills fields and sends the form")
    public void the_client_fills_fields_and_sends_the_form() {
        browser.findElement(By.name("order_name")).sendKeys("Great Order!");
        browser.findElement(By.name("order_send")).sendKeys(Keys.ENTER);
    }

    @Then("The client sees order page")
    public void the_client_sees_order_page() {
        assertEquals("The title must be correct!", browser.getTitle(), "Order: Great Order!");
        assertEquals("Check fields", browser.findElement(By.name("order_name")).getText(), "Great Order!");
    }

    @Given("There is an existing order")
    public void there_is_an_existing_order() {
        //Deal with it later.
        throw new cucumber.api.PendingException();
    }

    @When("The client fills search box and clicks \\(Find order)")
    public void the_client_fills_search_box_and_clicks_Find_order() {
        browser.findElement(By.name("search_field")).sendKeys("11112");
        browser.findElement(By.name("find_order")).sendKeys(Keys.ENTER);
    }

}
