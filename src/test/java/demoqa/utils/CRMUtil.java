package demoqa.utils;

public class CRMUtil {

    public static void loginTextBox(){
        Driver.getPage().locator("#userName").fill("Serdar KILIC");
        Driver.getPage().getByPlaceholder("name@example.com").fill("test@gmail.com");
        Driver.getPage().locator("#currentAddress").fill("Torun Center / Mecidiyeköy");
        Driver.getPage().locator("#permanentAddress").fill("Kartal");
        Driver.getPage().locator("#submit").click();
    }

    public static void registrationForm1(){
        Driver.getPage().getByPlaceholder("First Name").fill("John");
        Driver.getPage().getByPlaceholder("Last Name").fill("Doe");
        Driver.getPage().getByPlaceholder("name@example.com").fill("test@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("40");
        Driver.getPage().getByPlaceholder("Salary").fill("120000");
        Driver.getPage().getByPlaceholder("Department").fill("Payment");
    }

    public static void registrationForm2(){
        Driver.getPage().getByPlaceholder("First Name").fill("Tom");
        Driver.getPage().getByPlaceholder("Last Name").fill("Cruise");
        Driver.getPage().getByPlaceholder("name@example.com").fill("tomcruise@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("60");
        Driver.getPage().getByPlaceholder("Salary").fill("1000");
        Driver.getPage().getByPlaceholder("Department").fill("Artist");
    }

    public static void registrationForm3(){
        Driver.getPage().getByPlaceholder("First Name").fill("Tom");
        Driver.getPage().getByPlaceholder("Last Name").fill("Hanks");
        Driver.getPage().getByPlaceholder("name@example.com").fill("hanks@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("70");
        Driver.getPage().getByPlaceholder("Salary").fill("1000");
        Driver.getPage().getByPlaceholder("Department").fill("Actor");
    }

    public static void registrationForm4(){
        Driver.getPage().getByPlaceholder("First Name").fill("Cem");
        Driver.getPage().getByPlaceholder("Last Name").fill("Yılmaz");
        Driver.getPage().getByPlaceholder("name@example.com").fill("cmylz@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("40");
        Driver.getPage().getByPlaceholder("Salary").fill("1000");
        Driver.getPage().getByPlaceholder("Department").fill("Standup");
    }

    public static void registrationForm5(){
        Driver.getPage().getByPlaceholder("First Name").fill("Selin");
        Driver.getPage().getByPlaceholder("Last Name").fill("İşlek");
        Driver.getPage().getByPlaceholder("name@example.com").fill("selin@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("30");
        Driver.getPage().getByPlaceholder("Salary").fill("1000");
        Driver.getPage().getByPlaceholder("Department").fill("Director");
    }

    public static void registrationForm6(){
        Driver.getPage().getByPlaceholder("First Name").fill("Kaan");
        Driver.getPage().getByPlaceholder("Last Name").fill("KLC");
        Driver.getPage().getByPlaceholder("name@example.com").fill("kaan@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("20");
        Driver.getPage().getByPlaceholder("Salary").fill("1000");
        Driver.getPage().getByPlaceholder("Department").fill("Lawyer");
    }

    public static void registrationForm7(){
        Driver.getPage().getByPlaceholder("First Name").fill("Jack");
        Driver.getPage().getByPlaceholder("Last Name").fill("Lost");
        Driver.getPage().getByPlaceholder("name@example.com").fill("jack@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("50");
        Driver.getPage().getByPlaceholder("Salary").fill("101000000");
        Driver.getPage().getByPlaceholder("Department").fill("Doctor");
    }

    public static void registrationForm8(){
        Driver.getPage().getByPlaceholder("First Name").fill("Steve");
        Driver.getPage().getByPlaceholder("Last Name").fill("jobs");
        Driver.getPage().getByPlaceholder("name@example.com").fill("steve@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("54");
        Driver.getPage().getByPlaceholder("Salary").fill("50000");
        Driver.getPage().getByPlaceholder("Department").fill("CEO");
    }

    public static void registrationForm9(){
        Driver.getPage().getByPlaceholder("First Name").fill("Sawyer");
        Driver.getPage().getByPlaceholder("Last Name").fill("Hands");
        Driver.getPage().getByPlaceholder("name@example.com").fill("sawyer@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("51");
        Driver.getPage().getByPlaceholder("Salary").fill("50000");
        Driver.getPage().getByPlaceholder("Department").fill("Driver");
    }

    public static void registrationForm10(){
        Driver.getPage().getByPlaceholder("First Name").fill("Sam");
        Driver.getPage().getByPlaceholder("Last Name").fill("Uncle");
        Driver.getPage().getByPlaceholder("name@example.com").fill("uncle@gmail.com");
        Driver.getPage().getByPlaceholder("Age").fill("82");
        Driver.getPage().getByPlaceholder("Salary").fill("58000");
        Driver.getPage().getByPlaceholder("Department").fill("Engineer");
    }

    public static void fillRegistrationForm(User user) {
        Driver.getPage().getByPlaceholder("First Name").fill(user.getFirstName());
        Driver.getPage().getByPlaceholder("Last Name").fill(user.getLastName());
        Driver.getPage().getByPlaceholder("name@example.com").fill(user.getEmail());
        Driver.getPage().getByPlaceholder("Age").fill(user.getAge());
        Driver.getPage().getByPlaceholder("Salary").fill(user.getSalary());
        Driver.getPage().getByPlaceholder("Department").fill(user.getDepartment());
    }
}
