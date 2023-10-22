<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Tasks</title>
</head>
<body>
<div class="container">
    <h1>Your tasks</h1>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Task is Done?</th>
            <th>Delete task</th>
            <th>Update task</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.description}</td>
                <td>${task.targetDate}</td>
                <td>${task.taskIsDone}</td>
                <td><a href="delete-task?id=${task.id}" class="btn btn-danger">Delete</a></td>
                <td><a href="update-task?id=${task.id}" class="btn btn-success">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-task" class="btn btn-primary">Add task</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>