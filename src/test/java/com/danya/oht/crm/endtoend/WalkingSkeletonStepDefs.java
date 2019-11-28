package com.danya.oht.crm.endtoend;

import com.danya.oht.crm.dao.OrderRepository;
import com.danya.oht.crm.data.Order;
import com.danya.oht.crm.view.OrderController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@DataJpaTest
public class WalkingSkeletonStepDefs {

    @Autowired
    private Browser browser;

//    @Autowired
//    private TestEntityManager testEntityManager;

    @Autowired
    private OrderRepository orderRepository;

    private long idToFind;

    @BeforeClass
    public void setup() {

    }

    @Before
    public void onClose() {
        orderRepository.deleteAll();
    }

    @When("The client opens the main page")
    public void the_client_opens_the_main_page() throws Exception {
        browser.open(Browser.HOME_PAGE);
    }

    @Then("The client sees {string} submenu on a page")
    public void the_client_sees_submenu_on_a_page(String submenu) {
        System.out.println(submenu);
        browser.findElement(By.name(submenu));
    }

    @When("The client opens the create order page")
    public void the_client_opens_the_create_order_page() {
        browser.open(Browser.CREATE_ORDER_PAGE);
    }

    @When("The client fills fields: name {string}. Then sends the form")
    public void the_client_fills_fields_and_sends_the_form(String name) {
        browser.findElement(By.name("name")).sendKeys(name);
        browser.findElement(By.name("create_order")).submit();
    }

    @Then("The client sees order page with fields: name {string}")
    public void the_client_sees_order_page(String name) {
        try {
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals("The title must be correct!", "OHT Order", browser.getTitle());
        assertEquals("Check fields", name, browser.findElement(By.name("order_name")).getText());
    }

    @Given("There is an existing order with fields: name {string}")
    public void there_is_an_existing_order(String name) {
        idToFind = orderRepository.save(new Order(name)).getId();
    }

    @When("The client opens the search order page")
    public void the_client_opens_the_search_order_page() {
        browser.open(Browser.FIND_ORDER_PAGE);
    }

    @When("The client fills search box and clicks Find")
    public void the_client_fills_search_box_and_clicks_Find_order() {
        browser.findElement(By.name("value")).sendKeys(String.valueOf(idToFind));
        browser.findElement(By.name("find_order")).sendKeys(Keys.ENTER);
    }
}
