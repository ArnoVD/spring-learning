<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h1>Your tasks</h1>
    <table class="table">
        <thead>
        <tr>
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
<%@include file="common/footer.jspf" %>