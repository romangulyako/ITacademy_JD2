<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="itacademy.dto.StudentDto" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Students</h2>
<%= request.getAttribute("students") %>
<table>
    <% List<StudentDto> studentDtos = (List<StudentDto>) request.getAttribute("students");
        for (StudentDto studentDto : studentDtos) {
    %>
    <tr>
        <td><%= studentDto.getName() %>
        </td>
        <td><%= studentDto.getAge() %>
        </td>
        <td><%= studentDto.getMark() %>
        </td>
        <td>
            <form name="test" method="post" action="info">
                <input name="id" type="hidden" value="<%= studentDto.getId()%>">
                <input name="action" type="hidden" value="delete">
                <button>delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
