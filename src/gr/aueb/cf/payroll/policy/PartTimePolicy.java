package gr.aueb.cf.payroll.policy;

import gr.aueb.cf.payroll.model.Employee;
import gr.aueb.cf.payroll.model.MaritalStatus;

import java.math.BigDecimal;

public class PartTimePolicy implements CompensationPolicy{

    @Override
    public BigDecimal computeSalary(Employee emp) {
        BigDecimal salary = emp.getBaseSalary().multiply(new BigDecimal("0.5"));

        if (emp.getMaritalStatus() == MaritalStatus.MARRIED){
            salary = salary.add(MARRIED_BONUS);
        }

        if (emp.getNumberOfChildren() > 0){
            salary = salary.add(
                    CHILD_BONUS.multiply(BigDecimal.valueOf(emp.getNumberOfChildren()))
            );
        }

        if (emp.getOvertimeHours() > 0 ){
            salary = salary.add(
                    BigDecimal.valueOf(emp.getOvertimeHours()).multiply(OVERTIME_HOURLY_RATE)
            );
        }
        return salary;
    }

}
