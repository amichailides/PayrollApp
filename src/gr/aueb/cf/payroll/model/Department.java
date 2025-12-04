package gr.aueb.cf.payroll.model;

public class Department {
    private String name;
    private String code;
    private Employee manager;

    public Department(String name, String code, Employee manager) {
        this.name = name;
        this.code = code;
        this.manager = manager;
    }

    public String getName(){
        return name;
    }

    public String getCode() {
        return code;
    }

    public Employee getManager() {
        return manager;
    }
}
