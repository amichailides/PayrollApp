package gr.aueb.cf.payroll.service;

import gr.aueb.cf.payroll.model.Employee;
import java.math.BigDecimal;
import java.util.List;

public class PayrollService {

    public BigDecimal getSalary(Employee emp) {

        return emp.getPolicy().computeSalary(emp);
    }

    public BigDecimal getTotalPayroll(List<Employee> itEmployees) {
        BigDecimal ItTotalPayroll = BigDecimal.ZERO;
        for (Employee emp : itEmployees) {
            ItTotalPayroll = ItTotalPayroll.add(getSalary(emp));
        }
        return ItTotalPayroll;
    }

}
