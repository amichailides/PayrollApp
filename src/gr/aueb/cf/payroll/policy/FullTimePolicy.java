package gr.aueb.cf.payroll.policy;

import gr.aueb.cf.payroll.model.Employee;
import gr.aueb.cf.payroll.model.MaritalStatus;
import gr.aueb.cf.payroll.model.Role;

import java.math.BigDecimal;

public class FullTimePolicy implements CompensationPolicy{

    @Override
    public BigDecimal computeSalary(Employee emp){
        BigDecimal salary = emp.getBaseSalary();

        if (emp.getMaritalStatus() == MaritalStatus.MARRIED){
            salary = salary.add(MARRIED_BONUS);
        }

        if (emp.getNumberOfChildren() > 0){
            salary = salary.add(
                    CHILD_BONUS.multiply(BigDecimal.valueOf(emp.getNumberOfChildren()))
            );
        }

        if (emp.getRole() == Role.MANAGER){
            salary = salary.add(MANAGER_BONUS);
        }

        if (emp.getOvertimeHours() > 0 ){
            salary = salary.add(
                    BigDecimal.valueOf(emp.getOvertimeHours()).multiply(OVERTIME_HOURLY_RATE)
            );
        }

        return salary;
    }


}
