package demoqa.elements;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import demoqa.utils.BrowserUtils;
import demoqa.utils.CRMUtil;
import demoqa.utils.*;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static demoqa.utils.CRMUtil.fillRegistrationForm;
import static org.junit.jupiter.api.Assertions.*;

public class WebTables {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Web Tables").click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateElementsPage() {
        // Navigating the webtables page
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/webtables");
    }

    @Test
    void textWebTablesVisible() {
        // Assert to Web Table title is visible after clicking Text Box
        assertThat(Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Web Tables"))).isVisible();
    }

    @Test
    void tableTitleVisible() {
        // Identifing expected table header
        String[] listTableHeader = {"First Name", "Last Name", "Age", "Email", "Salary", "Department", "Action"};
        // Asserting expected titles and actuals
        for (int i = 0; i < listTableHeader.length; i++) {
            String textTableHeaders = Driver.getPage().locator(".rt-resizable-header-content").nth(i).textContent();
            assertEquals(listTableHeader[i], textTableHeaders);
        }
    }

    @Test
    void editRow() {
        // asserting the first user name is visible
        Locator firstName = Driver.getPage().locator(".rt-tr.-odd>div").nth(0);
        assertTrue(firstName.isVisible());
        // editing first user's name and salary
        Driver.getPage().locator("#edit-record-1").click();
        BrowserUtils.sleepWithThread(3);
        // asserting Registration Form is opened or not
        assertEquals("Registration Form", Driver.getPage().locator("#registration-form-modal").textContent());
        // Updating user data
        Driver.getPage().getByPlaceholder("First Name").fill("Serdar");
        Driver.getPage().getByPlaceholder("Salary").fill("120000");
        Driver.getPage().locator("#submit").click();
        assertEquals(firstName.textContent(), "Serdar");
    }

    @Test
    void addDeleteRow() {
        // adding new user
        Driver.getPage().locator("#addNewRecordButton").click();
        CRMUtil.registrationForm1();
        Driver.getPage().locator("#submit").click();
        BrowserUtils.sleepWithThread(3);
        // listing all rows for users
        List<ElementHandle> users = Driver.getPage().querySelectorAll(".rt-tr-group > div:nth-child(1)");
        // writing all user infos
        for (ElementHandle user : users) {
            String textContent = user.textContent();
            if (!textContent.isEmpty()) {
                System.out.println("User: " + textContent);
            }
        }
        // deleting first user
        BrowserUtils.sleepWithThread(3);
        Locator firstUserMail = Driver.getPage().locator(".rt-tr.-odd>div").nth(3);
        System.out.println(firstUserMail.textContent());
        Driver.getPage().locator("#delete-record-1").click();
        Locator newUserFirstMail = Driver.getPage().locator(".rt-tr.-odd>div").nth(3);
        // asserting old first user mail and new first user mail
        assertNotEquals(firstUserMail, newUserFirstMail);
        System.out.println(newUserFirstMail.textContent());
    }

    @Test
    void pagination() {
        // Create a list of users
        List<User> userList = new ArrayList<>();

        // Add users to the list
        userList.add(new User("John", "Doe", "john.doe@gmail.com", "40", "120000", "Payment"));
        userList.add(new User("Tom", "Cruise", "tom.cruise@gmail.com", "60", "1000", "Artist"));
        userList.add(new User("Tom", "Hanks", "tom.hanks@gmail.com", "70", "1000", "Actor"));
        userList.add(new User("Jane", "Doe", "jane.doe@gmail.com", "35", "90000", "HR"));
        userList.add(new User("Emily", "Blunt", "emily.blunt@gmail.com", "38", "110000", "Marketing"));
        userList.add(new User("Brad", "Pitt", "brad.pitt@gmail.com", "58", "12000", "Entertainment"));
        userList.add(new User("Will", "Smith", "will.smith@gmail.com", "53", "25000", "Entertainment"));
        userList.add(new User("Leonardo", "DiCaprio", "leonardo.dicaprio@gmail.com", "48", "30000", "Film"));
        userList.add(new User("Angelina", "Jolie", "angelina.jolie@gmail.com", "46", "9000", "Film"));
        userList.add(new User("Scarlett", "Johansson", "scarlett.johansson@gmail.com", "37", "70000", "Actress"));
        userList.add(new User("Robert", "Downey Jr.", "robert.downey@gmail.com", "58", "45000", "Actor"));
        userList.add(new User("Chris", "Evans", "chris.evans@gmail.com", "42", "40000", "Actor"));
        userList.add(new User("Gal", "Gadot", "gal.gadot@gmail.com", "38", "20000", "Actress"));
        userList.add(new User("Mark", "Ruffalo", "mark.ruffalo@gmail.com", "56", "15000", "Actor"));
        userList.add(new User("Chris", "Hemsworth", "chris.hemsworth@gmail.com", "40", "38000", "Actor"));

        // Loop through the list and fill the form for each user
        for (User user : userList) {
            fillRegistrationForm(user);
        }
    }
}
