package gr.aueb.cf.payroll.policy;

import gr.aueb.cf.payroll.model.Employee;

import java.math.BigDecimal;

public interface CompensationPolicy {
    static final BigDecimal CHILD_BONUS = BigDecimal.valueOf(50);
    static final BigDecimal MARRIED_BONUS = BigDecimal.valueOf(100);
    static final BigDecimal MANAGER_BONUS = BigDecimal.valueOf(1000);
    static final BigDecimal OVERTIME_HOURLY_RATE = BigDecimal.valueOf(12.5);

    public BigDecimal computeSalary(Employee emp);

}
