<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h1>Add new task</h1>
    <form:form method="post" modelAttribute="task">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors cssClass="text-warning" path="description"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors cssClass="text-warning" path="targetDate"/>
        </fieldset>

        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="taskIsDone"/>
        <input type="submit" class="btn btn-success" value="Add new task"/><br>
    </form:form>
</div>
<%@include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
