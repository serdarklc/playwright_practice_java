package demoqa.utils;

public class CRMUtil {

    public static void loginTextBox(){
        Driver.getPage().locator("#userName").fill("Serdar KILIC");
        Driver.getPage().getByPlaceholder("name@example.com").fill("test@gmail.com");
        Driver.getPage().locator("#currentAddress").fill("Torun Center / Mecidiyeköy");
        Driver.getPage().locator("#permanentAddress").fill("Kartal");
        Driver.getPage().locator("#submit").click();
    }
}
