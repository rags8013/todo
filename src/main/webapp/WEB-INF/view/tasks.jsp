<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tasks</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp"/>
	<h2 align="center">Tasks</h2>
	<div style="margin-top: 10px;"
		class="well well-lg col-md-6 col-md-offset-3" align="center">

		<form:form class="form-inline"
			action="${pageContext.request.contextPath}/addTask">
			<div class="form-group">
				<input type="text" class="form-control" name="task" placeholder="Add a task" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-info">
					<span class="glyphicon glyphicon-plus"></span>
				</button>
			</div>
		</form:form>
	</div>
	<div class="well well-lg col-md-6 col-md-offset-3">
		<h3>Pending</h3>
		<ul class="list-group">
			<c:forEach items="${pendingTasks}" var="task">
				<li class="list-group-item clearfix">
					${task.taskName}
					<span class="pull-right">
						<a href="${pageContext.request.contextPath}/finish/${task.id}" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span></a>
						<a data-toggle="modal" data-task="${task.id}" data-name="${task.taskName}" data-target="#editTask" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="${pageContext.request.contextPath}/delete/${task.id}" class="btn btn-warning"><span class="glyphicon glyphicon-trash"></span></a>
					</span>

				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="well well-lg col-md-6 col-md-offset-3">
		<h3>Finished</h3>
		<ul class="list-group">
			<c:forEach items="${finishedTasks}" var="task">
				<li class="list-group-item clearfix">
					${task.taskName}
					<span class="pull-right">
						<a href="${pageContext.request.contextPath}/unfinish/${task.id}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
						<a href="${pageContext.request.contextPath}/delete/${task.id}" class="btn btn-warning"><span class="glyphicon glyphicon-trash"></span></a>
					</span>

				</li>
			</c:forEach>
		</ul>
	</div>
	
	<div class="modal fade" id="editTask" tabindex="-1" role="dialog" aria-labelledby="editTaskLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
    		<div class="modal-content">
    			<div class="modal-header ">
        			<h4 class="modal-title" id="editTaskLabel">Edit Task</h4>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
      				<form:form action="${pageContext.request.contextPath}/edit" class="form-inline">
      					<div class="form-group">
            				<label for="recipient-name" class="col-form-label">Task Name:</label>
            				<input type="text" class="form-control" name="taskname" id="taskname">
            				<input type="hidden" id="taskid" name="taskid"> 
          				</div>
          				<span class="form-group pull-right">
          					<button type="submit" class="btn btn-info">Save</button>
          				</span>
        			</form:form>
      			</div>
      			<div class="modal-footer">
      			</div>
    		</div>
  		</div>
	</div>
	<script type="text/javascript">
	$('#editTask').on('show.bs.modal', function (event) {
	  var task = $(event.relatedTarget) 
	  console.log(task)
	  var taskID = task.data('task')
	  var taskName = task.data('name')
	  var modal = $(this)
	  $('#taskname').val(taskName)
	  $('#taskid').val(taskID)
	})
</script>
</body>
</html>