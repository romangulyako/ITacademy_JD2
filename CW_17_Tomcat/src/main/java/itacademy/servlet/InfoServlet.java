package itacademy.servlet;


import itacademy.dto.StudentDto;
import itacademy.service.StudentService;
import itacademy.service.impl.StudentServiceImpl;
import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "infoServlet", value = "/info")
public class InfoServlet extends HttpServlet {
    public static final String FIO = "fio";
    public static final String AGE = "age";
    public static final String STUDENTS = "students";
    public static final String STUDENTS_JSP = "/students.jsp";

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = getParam(req, FIO);
        String age = getParam(req, AGE);

        final List<StudentDto> studentDtoList = studentService.findAll(fio, age);

        req.setAttribute(STUDENTS, studentDtoList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(STUDENTS_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = getParam(req, "id");
        String action = getParam(req, "action");

        if ("delete".equals(action)) {
            System.out.println(id);
        }

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/example2.jsp");
        requestDispatcher.forward(req, resp);
    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }
}
