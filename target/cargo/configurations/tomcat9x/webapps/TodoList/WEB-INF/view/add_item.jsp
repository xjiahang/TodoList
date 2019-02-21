<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="nathan.todolist.util.Attributes" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <div align="center">
        <form:form method="POST" modelAttribute="${Attributes.TODO_ITEM}">
        <table>
            <tr>
                <th><form:label path="details">details</form:label></th>
                <th><form:input path="details"/></th>
            </tr>
            <tr>
                <th><form:label path="deadline">deadline</form:label></th>
                <th><form:input path="deadline"/></th>
            </tr>
            <tr>
                <td><input type="submit" value="add"/></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>