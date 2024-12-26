<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<%= request.getAttribute("newFio")%>
<%= session.getAttribute("fioage")%>
<% session.setAttribute("user","admin"); %>
<% session.setAttribute("counter",1); %>

<a href="info?fio=Ivan&age=25">Info Servlet</a>

<form name="test" method="post" action="info">
    <input name="id" type="hidden">
    Fill full name: <input name="fio" type="text"> <br/>
    Fill age: <input name="age" type="text"> <br/>
    Fill mark: <input name="mark" type="text"> <br/>
    <input name="browser" type="radio" value="IE"> Ie <br/>
    <input name="browser" type="radio" value="CHROME"> Ie <br/>
    <button>Send</button>
</form>
<%@include file="include.jsp"%>

</body>
</html>
