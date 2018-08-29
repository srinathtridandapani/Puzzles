package timesavers;

import java.util.Date;
import java.util.Objects;

public class Employee {

    private String employeeName;
    private int employeeId;
    private int salary;
    private Date employeeStartDate;

    public Employee(String employeeName, int employeeId, int salary, Date employeeStartDate) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
        this.employeeStartDate = employeeStartDate;
    }

    public Employee() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getEmployeeStartDate() {
        return employeeStartDate;
    }

    public void setEmployeeStartDate(Date employeeStartDate) {
        this.employeeStartDate = employeeStartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                salary == employee.salary &&
                Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(employeeStartDate, employee.employeeStartDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeName, employeeId, salary, employeeStartDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId=" + employeeId +
                ", salary=" + salary +
                ", employeeStartDate=" + employeeStartDate +
                '}';
    }
}
