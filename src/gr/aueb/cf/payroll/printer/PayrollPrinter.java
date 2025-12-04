package gr.aueb.cf.payroll.printer;
import gr.aueb.cf.payroll.model.Employee;
import gr.aueb.cf.payroll.service.PayrollService;

import java.util.List;

public class PayrollPrinter {

    public static void printAllSummaries(List<Employee> employees){
        System.out.println("=== Employee Summaries ===");

        for (Employee emp : employees) {
            System.out.println("------------------------------");
            System.out.println(emp.summary());
        }
        System.out.println("==========================");

    }

    public static void printDepartmentPayroll(String department,List<Employee> employees, PayrollService payrollService){
        System.out.printf("%n======== %s Department Payroll ========%n", department);
        printSeparator();

        for (Employee emp : employees) {
            System.out.printf("%s %s (%s) : %.2f €%n", emp.getFirstName(), emp.getLastName(), emp.getRole(), payrollService.getSalary(emp));
        }

        System.out.println("Total: " + payrollService.getTotalPayroll(employees) + " €");
        printSeparator();
        System.out.println();

    }

    private static void printSeparator() {
        System.out.println("-----------------------------------------");
    }


}
