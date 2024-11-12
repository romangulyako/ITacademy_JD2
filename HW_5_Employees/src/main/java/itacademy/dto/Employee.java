package itacademy.dto;

import java.sql.Date;

public class Employee {
    private Integer id;
    private final Employee.EmployeeData employeeData;

    public Employee(Employee.EmployeeData employeeData) {
        this.employeeData = employeeData;
    }



    public void setId(Integer id) {
        if (this.id == null) {
            this.id = id;
        } else {
            throw new RuntimeException("Id already set");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + employeeData.firstName + '\'' +
                ", lastName='" + employeeData.lastName + '\'' +
                ", email='" + employeeData.email + '\'' +
                ", department='" + employeeData.department + '\'' +
                ", salary=" + employeeData.salary +
                ", hireDate=" + employeeData.hireDate +
                '}';
    }

    public static class EmployeeData {
        private final String firstName;
        private final String lastName;
        private final String email;
        private final String department;
        private final double salary;
        private final Date hireDate;

        public EmployeeData(String firstName, String lastName, String email, String department, double salary, Date hireDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.department = department;
            this.salary = salary;
            this.hireDate = hireDate;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public Date getHireDate() {
            return hireDate;
        }
    }
}
