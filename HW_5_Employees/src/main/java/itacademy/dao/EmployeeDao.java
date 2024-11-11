package itacademy.dao;

import itacademy.JDBCResources;
import itacademy.api.IEmployeeDao;
import itacademy.dto.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {
    private static final int PAGE_SIZE = 10;

    private static final String LIMIT = " LIMIT ?  OFFSET  ?";

    private static final String ORDER_BY_LAST_NAME = " ORDER BY last_name";

    private static final String ORDER_BY_SALARY = " ORDER BY salary";

    private static final String INSERT_EMPLOYEE = "INSERT INTO employees " +
            "(first_name, last_name, email, department, salary, hire_date) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_EMPLOYEE_INFO = "UPDATE employees " +
            "SET first_name = ?, last_name = ?, email = ?, department = ?, salary = ?, hire_date = ? " +
            "WHERE id = ?";

    private static final String DELETE_EMPLOYEE = "DELETE from employees WHERE id = ?";

    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE id = ?";

    private static final String SELECT_ALL_EMPLOYEES = "SELECT *, (SELECT COUNT(*) FROM employees) as count FROM employees";

    private static final String SELECT_EMPLOYEES_BY_DEPARTMENT = "SELECT *, (SELECT COUNT(*) " +
            "FROM employees WHERE department = ?) as count" +
            " FROM employees WHERE department = ?";

    private static final String SELECT_EMPLOYEES_BY_SALARY = "SELECT *, (SELECT COUNT(*) " +
            "FROM employees WHERE salary > ?) as count FROM employees WHERE salary > ?";

    private final Connection connection;

    private boolean isSortByLastName;

    private boolean isSortBySalary;

    private int currentPage = 0;

    private long totalPages;

    public EmployeeDao() throws SQLException{
        this.connection = DriverManager.getConnection(JDBCResources.getURL(),
                JDBCResources.getUser(),JDBCResources.getPassword());
    }

    public void nextPage() {
        currentPage++;
    }

    public void previousPage() {
        currentPage--;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public long getTotalPages() {
        return totalPages;
    }

    /**
     * Метод для перехода на конкретную страницу.
     * В данном приложении испоьзуется для сброса {@link #currentPage}
     * перед каждой новой выборкой
     *
     * @param currentPage страница, на которую нужно переключиться
     */
    @Override
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public void sortByLastName() {
        isSortByLastName = true;
    }

    @Override
    public void sortBySalary() {
        isSortBySalary = true;
    }

    @Override
    public void notSorted() {
        isSortByLastName = false;
        isSortBySalary = false;
    }

    /**
     * Метод для добавления сотрудника в БД
     *
     * @param employeeData сведения о сотруднике
     */
    @Override
    public void addEmployee(Employee.EmployeeData employeeData) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(INSERT_EMPLOYEE)) {
            addEmployeeData(preparedStatement, employeeData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод для обновления сведений о сотруднике в БД
     *
     * @param employeeId уникальный идентификатор сотрудника в БД
     * @param employeeData новые сведения о сотруднике
     */
    @Override
    public void updateEmployee(int employeeId, Employee.EmployeeData employeeData) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(UPDATE_EMPLOYEE_INFO)) {
            preparedStatement.setInt(7, employeeId);
            addEmployeeData(preparedStatement, employeeData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод удаляет сотрудника из БД
     *
     * @param employeeId уникальный идентификатор сотрудника, которого нужно удалить
     */
    @Override
    public void deleteEmployee(int employeeId) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод получает из БД сотрудника по его id
     *
     * @param employeeId уникальный идентификатор сотрудника
     * @return сотрудник
     */
    @Override
    public Employee getEmployee(int employeeId) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, employeeId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Employee employee = null;
                if (resultSet.next()) {
                    employee = getEmployeeFromDB(resultSet);
                }
                if (employee != null) {
                    return employee;
                }

                throw new IllegalArgumentException("Сотрудник с таким id не найден!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод получает из БД всех сотрудников
     *
     * @return список сотрудников
     */
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(buildQuery(SELECT_ALL_EMPLOYEES))) {
            preparedStatement.setInt(1, PAGE_SIZE);
            preparedStatement.setInt(2, currentPage * PAGE_SIZE);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    totalPages =  (long)(Math.ceil((double) resultSet.getInt("count") / PAGE_SIZE) - 1);
                    employees.add(getEmployeeFromDB(resultSet));
                }

                return employees;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Сетод получает из БД сотрудников из указанного отдела
     *
     * @param department отдел
     * @return список сотрудников
     */
    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(buildQuery(SELECT_EMPLOYEES_BY_DEPARTMENT))) {
            preparedStatement.setString(1, department);
            preparedStatement.setString(2, department);
            preparedStatement.setInt(3, PAGE_SIZE);
            preparedStatement.setInt(4, currentPage * PAGE_SIZE);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    totalPages =  (long)(Math.ceil((double) resultSet.getInt("count") / PAGE_SIZE) - 1);
                    employees.add(getEmployeeFromDB(resultSet));
                }
                resultSet.close();

                return employees;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Сетод получает из БД сотрудников с зарплатой, выше указанной
     *
     * @param salary минимальная зарплата
     * @return список сотрудников
     */
    @Override
    public List<Employee> getEmployeesBySalary(double salary) {
        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(buildQuery(SELECT_EMPLOYEES_BY_SALARY))) {
            preparedStatement.setDouble(1, salary);
            preparedStatement.setDouble(2, salary);
            preparedStatement.setInt(3, PAGE_SIZE);
            preparedStatement.setInt(4, currentPage * PAGE_SIZE);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    totalPages =  (long)(Math.ceil((double) resultSet.getInt("count") / PAGE_SIZE) - 1);
                    employees.add(getEmployeeFromDB(resultSet));
                }

                return employees;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Employee getEmployeeFromDB(ResultSet resultSet) throws SQLException {
        Employee.EmployeeData empData = new Employee.EmployeeData(resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("department"),
                resultSet.getDouble("salary"),
                resultSet.getDate("hire_date"));

        Employee employee = new Employee(empData);
        employee.setId(resultSet.getInt("id"));

        return employee;
    }

    private void addEmployeeData(PreparedStatement preparedStatement, Employee.EmployeeData empData) throws SQLException {
        preparedStatement.setString(1, empData.getFirstName());
        preparedStatement.setString(2, empData.getLastName());
        preparedStatement.setString(3, empData.getEmail());
        preparedStatement.setString(4, empData.getDepartment());
        preparedStatement.setDouble(5, empData.getSalary());
        preparedStatement.setDate(6, empData.getHireDate());

        preparedStatement.executeUpdate();
    }

    /**
     * Метод строит запрос в зависимости от необходимости сортировки при выводе результата
     *
     * @param query изначальный запрос
     * @return окончательный запрос со всеми условиями
     */
    private String buildQuery(String query) {
        if (isSortByLastName) {
            query += ORDER_BY_LAST_NAME;
        }
        if (isSortBySalary) {
            query += ORDER_BY_SALARY;
        }
        query += LIMIT;

        return query;
    }
}
