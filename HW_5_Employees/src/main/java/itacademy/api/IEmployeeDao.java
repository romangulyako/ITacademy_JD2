package itacademy.api;

import itacademy.dto.Employee;

import java.util.List;

public interface IEmployeeDao extends AutoCloseable{
    void addEmployee(Employee.EmployeeData employeeData);
    void updateEmployee(int employeeId, Employee.EmployeeData employeeData);
    void deleteEmployee(int employeeId);
    Employee getEmployee(int employeeId);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByDepartment(String department);
    List<Employee> getEmployeesBySalary(double salary);
    void sortByLastName();
    void sortBySalary();
    void notSorted();
    void nextPage();
    void previousPage();
    int getCurrentPage();
    long getTotalPages();
    void setCurrentPage(int currentPage);
}
