package gr.aueb.cf.playground;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/gr/aueb/cf/playground/employees.txt");

        /*
        Employee emp = new Employee("Mixos", "IT", BigDecimal.valueOf(200.50));
        Employee emp2 = new Employee("Matsablokos", "IT", BigDecimal.valueOf(23));

        employees.add(emp);
        employees.add(emp2);


        for (Employee e : employees){
            FileUtils.writeLine(path, e.toLine());
        }

        List<Employee> fromFile = Employee.createEmployees(path);
        fromFile.forEach(System.out::println);
         */


        List<Employee> employees = Employee.createEmployees(path);
        /*
        employees.stream()
                .filter(e -> e.getSalary().compareTo(BigDecimal.valueOf(10)) >= 0)
                .sorted(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName)
                .forEach(System.out::println);

                employees.stream()
                .filter(e -> e.getSalary().compareTo(BigDecimal.valueOf(1000)) > 0)
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .forEach(System.out::println);





                employees.stream()
                        .filter(e -> e.getSalary().compareTo(BigDecimal.valueOf(1500)) >0)
                        .map(Employee::getDepartment)
                        .distinct()
                        .forEach(System.out::println);

         */

                Map<String,List<Employee>> departmentGroup = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        BigDecimal maxSalary = BigDecimal.ZERO;
        String maxDepartment = null;
        for (Map.Entry<String, List<Employee>> dep : departmentGroup.entrySet()) {
            String key = dep.getKey();
            List<Employee> value = dep.getValue();

            BigDecimal depSalary = BigDecimal.ZERO;

            for (Employee emp : value) {
                depSalary = depSalary.add(emp.getSalary());
            }
            System.out.printf("%s salary -> %s %n", key, depSalary);

            if (depSalary.compareTo(maxSalary) > 0) {
                maxSalary = depSalary;
                maxDepartment = key;
            }

        }

        System.out.printf("Department with highest total salary: %s (%s) ", maxDepartment, maxSalary);







    }

}
