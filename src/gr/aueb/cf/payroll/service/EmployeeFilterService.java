package gr.aueb.cf.payroll.service;

import gr.aueb.cf.payroll.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilterService {

    public static List<Employee> filterByDepartment(List<Employee> employees, String department){
        List<Employee> filtered = new ArrayList<>();

        for (Employee emp : employees){
            if(emp.getDepartment().getName().equalsIgnoreCase(department)){
                filtered.add(emp);
            }
        }
        return filtered;
    }
}
