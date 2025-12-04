package gr.aueb.cf.payroll.model;

import gr.aueb.cf.payroll.policy.CompensationPolicy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    // Personal Info
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // Job Info
    private Department department;
    private Role role;
    private EmploymentType employmentType;

    // Family / Benefits
    private LocalDate birthday;
    private MaritalStatus maritalStatus;
    private int numberOfChildren;

    // Compensation
    private BigDecimal baseSalary;
    private int overtimeHours; // TODO: move to PayrollRecord (monthly data)
    private CompensationPolicy policy;



    public Employee(String firstName, String lastName, String email, String phone, Department department,
                    Role role, EmploymentType employmentType, LocalDate birthday,
                    MaritalStatus maritalStatus, int numberOfChildren, BigDecimal baseSalary, int overtimeHours,
                    CompensationPolicy policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.role = role;
        this.employmentType = employmentType;
        this.birthday = birthday;
        this.maritalStatus = maritalStatus;
        this.numberOfChildren = numberOfChildren;
        this.baseSalary = baseSalary;
        this.overtimeHours = overtimeHours;
        this.policy = policy;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Department getDepartment() {
        return department;
    }

    public Role getRole(){
        return role;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public MaritalStatus getMaritalStatus(){
        return maritalStatus;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public CompensationPolicy getPolicy(){
        return policy;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void addOvertime(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Overtime cannot be negative");
        }
        this.overtimeHours += hours;
    }


    public void setPolicy(CompensationPolicy policy) {
        this.policy = policy;
    }

    public String summary(){
        return String.format("%s %s - %s%n" +
                "Dept: %s%n" +
                "Married: %s%n" +
                "Overtime: %dh",
                firstName, lastName, role, department.getName(), getMaritalStatus().getLabel(), overtimeHours);
    }

}
