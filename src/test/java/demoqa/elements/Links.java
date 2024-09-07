package demoqa.elements;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import demoqa.utils.BrowserUtils;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Links {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Links", new Page.GetByTextOptions().setExact(true)).click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateElementsPage() {
        // Navigating the Buttons page check URL
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/links");
    }

    @Test
    void textWebTablesVisible() {
        // Assert to Button title is visible after clicking Text Box
        assertThat(Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Links"))).isVisible();
    }

    @Test
    void allLinks() {
        List<ElementHandle> links = Driver.getPage().querySelectorAll("#linkWrapper a");
        for (ElementHandle link : links) {
            System.out.println(link.textContent());
        }
    }
}
