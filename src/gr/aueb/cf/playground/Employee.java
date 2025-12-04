package gr.aueb.cf.playground;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String department;
    private boolean active = true;
    private BigDecimal salary;

    public Employee(String name, String department, BigDecimal salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isActive() {
        return active;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setActive (Boolean active){
        this.active = active;
    }

    @Override
    public String toString(){
        return String.format("%s (%s) - %s€", name, department, salary);
    }

    public String toLine(){
        return String.format("%s,%s,%s", name, department, salary );
    }

    public static List<Employee> createEmployees(Path path) throws IOException {
        List<Employee> newUsers = new ArrayList<>();
        List<String> lines = FileUtils.readLines(path);

        for(String line : lines){
            String[] parts = line.split(",");
            String name = parts[0];
            String department = parts[1];
            BigDecimal salary = new BigDecimal(parts[2]);

            Employee emp = new Employee(name, department, salary);
            newUsers.add(emp);

        }
        return newUsers;
    }
}
