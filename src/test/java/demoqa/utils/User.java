package demoqa.utils;

import lombok.Getter;
import lombok.Setter;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    // Constructor
    public User(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters for each field
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getAge() { return age; }
    public String getSalary() { return salary; }
    public String getDepartment() { return department; }
}
