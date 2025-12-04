package gr.aueb.cf.payroll;

import gr.aueb.cf.payroll.model.*;
import gr.aueb.cf.payroll.policy.FullTimePolicy;
import gr.aueb.cf.payroll.policy.PartTimePolicy;
import gr.aueb.cf.payroll.printer.PayrollPrinter;
import gr.aueb.cf.payroll.service.EmployeeFilterService;
import gr.aueb.cf.payroll.service.PayrollService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        PayrollService payrollService = new PayrollService();
        List<Employee> employees = initializeData();

        //PayrollPrinter.printAllSummaries(employees);


        List<Employee> itEmployees = EmployeeFilterService.filterByDepartment(employees, "IT");
        PayrollPrinter.printDepartmentPayroll("IT", itEmployees, payrollService);

    }

    private static List<Employee> initializeData() {

        Department it = new Department("IT", "D01", null);
        Department hr = new Department("HR", "D02", null);
        Employee femp1 = new Employee(
                "Nikos",
                "Korombos",
                "Korombos@openai.com",
                "698465732",
                hr,
                Role.MANAGER,
                EmploymentType.FULL_TIME,
                LocalDate.of(1986, 5, 7),
                MaritalStatus.SINGLE,
                0,
                new BigDecimal(1000),
                2,
                new FullTimePolicy()
        );

        Employee pemp1 = new Employee(
                "Nikos",
                "Matsablokos",
                "nikolakis@openai.com",
                "6946754982",
                it,
                Role.DEVELOPER,
                EmploymentType.PART_TIME,
                LocalDate.of(1990, 5, 12),
                MaritalStatus.MARRIED,
                1,
                new BigDecimal(1000),
                2,
                new PartTimePolicy()
        );

        List<Employee> employees = new ArrayList<>();
        employees.add(femp1);
        employees.add(pemp1);

        return employees;
    }




}