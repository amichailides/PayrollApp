package gr.aueb.cf.payroll.model;

public enum MaritalStatus {
    MARRIED,
    SINGLE;


    public String getLabel() {
        return this == MARRIED ? "Yes" : "No";
    }

}
