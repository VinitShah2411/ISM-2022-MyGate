<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Member</title>
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
	<%
	String userid = request.getParameter("userid");
	%>

	<form method="post" action="AddMemberController?userid=<%=userid%>"
		class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Add Member</legend>

			<!-- Text input-->

			<div class="form-group" required="">
				<label class="col-md-4 control-label">First Name</label>
				<div class="col-md-4">
					<input type="text" name="firstname" placeholder="First Name"
						class="form-control input-md">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">contact_number</label>
				<div class="col-md-4">
					<input type="text" name="contact_number"
						placeholder="contact Number" class="form-control input-md">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">Age</label>
				<div class="col-md-4">
					<input type="text" name="age" placeholder="Age"
						class="form-control input-md">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">Gender</label>
				<lable class="col-md-4"> <input type="radio" name="gender"
					value="male"> Male <input type="radio" name="gender"
					value="female"> FeMale </label>
			</div>

			<!-- Button -->
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