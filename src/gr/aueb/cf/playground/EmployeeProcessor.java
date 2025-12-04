package gr.aueb.cf.playground;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class EmployeeProcessor {
    private static final BigDecimal BONUS_AMOUNT = BigDecimal.valueOf(200);

    public static final Consumer<Employee> ADD_BONUS =  EmployeeProcessor::giveBonus;
    public static final Consumer<Employee> DEACTIVATE = EmployeeProcessor::deactivateEmployee;
    public static final Consumer<Employee> VALIDATE_NAME = EmployeeProcessor::validateName;
    public static final Consumer<Employee> NORMALIZE_NAME = EmployeeProcessor::normalizeName;
    @SafeVarargs
    public static void process(Employee emp, Consumer<Employee> first, Consumer<Employee>...tasks){
        first.accept(emp);
        for (Consumer<Employee> task : tasks){
            task.accept(emp);
        }
    }


    private static void validateName(Employee e){
        String name = e.getName();
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can not be null or blank.");
        }
        if (name.contains("@")) throw new IllegalArgumentException("'@' is not allowed");
    }

    private static void normalizeName(Employee e){
        String name = e.getName().trim();
        if (name.length() == 1){
            e.setName(name.toUpperCase());
            return;
        }

        String first = name.substring(0,1).toUpperCase();
        String rest = name.substring(1).toLowerCase();

        e.setName(first + rest);
    }

    private static void giveBonus(Employee e){

        e.setSalary(e.getSalary().add(BONUS_AMOUNT));
    }

    private static void deactivateEmployee (Employee e) {
        e.setActive(false);
    }

}


