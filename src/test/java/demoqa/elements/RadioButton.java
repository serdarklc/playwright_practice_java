package demoqa.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import demoqa.utils.BrowserUtils;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.VariableElement;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RadioButton {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Radio Button").click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateRadioButtonPage() {
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/radio-button");
    }

    @Test
    void visibleRadioButtonText() {
        assertThat(Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Radio Button"))).isVisible();
    }

    @Test
    void visibleQuestionText() {
        assertTrue(Driver.getPage().locator(".mb-3").isVisible());
    }

    @Test
    void enableRadioButton() {
        Driver.getPage().locator("//label[@for='yesRadio']").check();
        assertTrue(Driver.getPage().locator("//label[@for='yesRadio']").isChecked());
        assertEquals(Driver.getPage().locator(".text-success").textContent(), "Yes");

        BrowserUtils.sleepWithThread(3);

        Driver.getPage().locator("//label[@for='impressiveRadio']").check();
        assertTrue(Driver.getPage().locator("//label[@for='impressiveRadio']").isChecked());
        assertEquals(Driver.getPage().locator(".text-success").textContent(), "Impressive");

        assertFalse(Driver.getPage().locator("//label[@for='noRadio']").isEnabled());
    }
}
