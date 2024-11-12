package itacademy;

import itacademy.api.IEmployeeDao;
import itacademy.dao.EmployeeDao;
import itacademy.dto.Employee;
import itacademy.utils.ConsoleUtils;
import itacademy.utils.MenuUtils;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static String ADDED_SUCCESSFULLY = "Сотрудник успешно добавлен.";
    private final static String UPDATED_SUCCESSFULLY = "Информация успешно обновлена.";
    private final static String DELETED_SUCCESSFULLY = "Сотрудник успешно удален.";
    private final static String REQUEST_FOR_ID_ENTRY = "Введите id сотрудника: ";
    private final static String REQUEST_FOR_FIRST_NAME_ENTRY = "Введите имя : ";
    private final static String REQUEST_FOR_LAST_NAME_ENTRY = "Введите фамилию : ";
    private final static String REQUEST_FOR_EMAIL_ENTRY = "Введите E-mail : ";
    private final static String REQUEST_FOR_DEPARTMENT_ENTRY = "Введите название отдела: ";
    private final static String REQUEST_FOR_SALARY_ENTRY = "Введите зарплату: ";
    private final static String REQUEST_FOR_HIRE_DATE_ENTRY = "Введите дату приема на работу: ";
    private final static String FAILED_ENTRY = "Неверный ввод, повторите попытку!";
    private final static String NEW_LINE_SYMBOL = "\n";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean isEnd = false;

        try (IEmployeeDao dao = new EmployeeDao()) {
            while (!isEnd) {
                ConsoleUtils.printText(MenuUtils.getGlobalMenu().toString());
                int itemGlobalMenu = ConsoleUtils.inputInt(console);

                switch (itemGlobalMenu) {
                    case 1: {
                        dao.addEmployee(createEmployeeData(console));
                        ConsoleUtils.printText(ADDED_SUCCESSFULLY);
                        break;
                    }
                    case 2: {
                        ConsoleUtils.printText(REQUEST_FOR_ID_ENTRY);
                        int employeeId = ConsoleUtils.inputInt(console);
                        // проверка, есть ли такой сотрудник в БД
                        dao.getEmployee(employeeId);

                        dao.updateEmployee(employeeId,createEmployeeData(console));
                        ConsoleUtils.printText(UPDATED_SUCCESSFULLY);
                        break;
                    }
                    case 3: {
                        ConsoleUtils.printText(REQUEST_FOR_ID_ENTRY);
                        int employeeId = ConsoleUtils.inputInt(console);
                        // проверка, есть ли такой сотрудник в БД
                        dao.getEmployee(employeeId);
                        dao.deleteEmployee(employeeId);
                        ConsoleUtils.printText(DELETED_SUCCESSFULLY);
                        break;
                    }
                    case 4: {
                        ConsoleUtils.printText(MenuUtils.getSortedMenu().toString());
                        int choice = ConsoleUtils.inputInt(console);

                        MenuUtils.handleSortedMenu(dao,choice);

                        int pageChoice;
                        do {
                            ConsoleUtils.printText(getEmployeesInfo(dao.getAllEmployees()));
                            ConsoleUtils.printText(MenuUtils.getPagesMenu(dao).toString());
                            pageChoice = ConsoleUtils.inputInt(console);
                        } while (MenuUtils.handlePagesMenu(dao,pageChoice));

                        break;
                    }
                    case 5: {
                        ConsoleUtils.printText(REQUEST_FOR_DEPARTMENT_ENTRY);

                        console.nextLine();
                        String department = console.nextLine();

                        ConsoleUtils.printText(MenuUtils.getSortedMenu().toString());
                        int choice = ConsoleUtils.inputInt(console);
                        MenuUtils.handleSortedMenu(dao,choice);

                        int pageChoice;
                        do {
                            ConsoleUtils.printText(getEmployeesInfo(dao.getEmployeesByDepartment(department)));
                            ConsoleUtils.printText(MenuUtils.getPagesMenu(dao).toString());
                            pageChoice = ConsoleUtils.inputInt(console);
                        } while (MenuUtils.handlePagesMenu(dao,pageChoice));
                        break;
                    }
                    case 6: {
                        ConsoleUtils.printText(REQUEST_FOR_SALARY_ENTRY);
                        double salary = ConsoleUtils.inputDouble(console);

                        ConsoleUtils.printText(MenuUtils.getSortedMenu().toString());
                        int choice = ConsoleUtils.inputInt(console);

                        MenuUtils.handleSortedMenu(dao,choice);

                        int pageChoice;
                        do {
                            ConsoleUtils.printText(getEmployeesInfo(dao.getEmployeesBySalary(salary)));
                            ConsoleUtils.printText(MenuUtils.getPagesMenu(dao).toString());
                            pageChoice = ConsoleUtils.inputInt(console);
                        } while (MenuUtils.handlePagesMenu(dao,pageChoice));

                        break;
                    }
                    case 7: {
                        ConsoleUtils.printText(REQUEST_FOR_ID_ENTRY);
                        int employeeId = ConsoleUtils.inputInt(console);

                        ConsoleUtils.printText(dao.getEmployee(employeeId).toString());
                        break;
                    }
                    case 0: {
                        isEnd = true;
                        break;
                    }
                    default: {
                        ConsoleUtils.printText(FAILED_ENTRY);
                    }
                }
            }
        } catch (Exception e) {
            ConsoleUtils.printText(createExceptionMessage(e));
        }
    }

    private static String createExceptionMessage(Exception e) {
        return "Ошибка: " + LocalDateTime.now() + " - "
                + e.getClass() + " - " + e.getMessage();
    }

    private static Employee.EmployeeData createEmployeeData(Scanner console) {
        System.out.print(REQUEST_FOR_FIRST_NAME_ENTRY);
        String firstName = console.next();
        System.out.print(REQUEST_FOR_LAST_NAME_ENTRY);
        String lastName = console.next();
        System.out.print(REQUEST_FOR_EMAIL_ENTRY);
        String email =  console.next();
        System.out.print(REQUEST_FOR_DEPARTMENT_ENTRY);
        console.nextLine();
        String department = console.nextLine();
        System.out.print(REQUEST_FOR_SALARY_ENTRY);
        double salary =  ConsoleUtils.inputDouble(console);
        System.out.print(REQUEST_FOR_HIRE_DATE_ENTRY);
        Date hireDate = Date.valueOf(console.next());

        return new Employee.EmployeeData(firstName, lastName, email,
                department, salary, hireDate);
    }

    private static String getEmployeesInfo (List<Employee> employees) {
        StringBuilder builder = new StringBuilder();

        for (Employee employee : employees) {
            builder.append(NEW_LINE_SYMBOL).append(employee);
        }

        return builder.toString();
    }
}
