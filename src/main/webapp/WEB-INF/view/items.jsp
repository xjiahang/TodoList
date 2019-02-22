<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="nathan.todolist.util.Mappings"%>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <div align="center">
         <c:url var="addUrl" value="${Mappings.ADD_ITEM}"/>
         <a href="${addUrl}">Add Todo</a>
        <h2>Todo List</h2>
        <table>
            <tr>
                <th>Id</th>
                <th>Details</th>
                <th>DeadLine</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${todoData.items}" var="todoItem">
            <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
                <c:param name="id" value="${todoItem.id}"/>
            </c:url>
            <tr>
                <th><c:out value="${todoItem.id}"/></th>
                <th><c:out value="${todoItem.details}"/></th>
                <th><c:out value="${todoItem.deadline}"/></th>
                <th>
                    <a href="${deleteUrl}"> Delete </a>
                </th>
            </tr>
            </c:forEach>

        <table>
    </div>
</body>
</html>