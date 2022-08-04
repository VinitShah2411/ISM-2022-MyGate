	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Instruction For Security</title>
	<link
		href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<style type="text/css">
	legend {
		background-color: powderblue;
		text-align: center;
	}
	</style>
	</head>
	<body>
		<% String userid = request.getParameter("userid"); %>
		<form  action="NoteforSecurityController?userid=<%=userid %>"class="form-horizontal" method="post">
			<fieldset>
	
				<!-- Form Name -->
				<legend>Instruction</legend>
	
				<!-- Text input-->
				
				<div class="form-group" required="">
					<label class="col-md-4 control-label">Name</label>
					<div class="col-md-4">
						<input type="text" name="name" placeholder="Name"
							class="form-control input-md">
					</div>
				</div>
	
				<div class="form-group">
					<label class="col-md-4 control-label">Description</label>
					<div class="col-md-4">
						<input type="text" name="description" placeholder="Enter Description"
							class="form-control input-md">
					</div>
				</div>
					<div class="form-group">
					<label class="col-md-4 control-label">Permission</label>
					<div class="col-md-4">
						<select class="form-control input-md" name="permission">
							<option>Select Option</option>
							<option>Yes</option>
							<option>No</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Timer</label>
					<div class="col-md-4">
						<input type="time" name="approx_time" placeholder="Enter Approx Time"
							class="form-control input-md">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-primary">Submit</button>
						${msg} <a href="Home.jsp" button type="submit"
							class="btn btn-primary ">Back To Home</a>
					</div>
				</div>
			</fieldset>
		</form>
	</body>
	</html>
