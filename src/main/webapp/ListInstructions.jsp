<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Instructions</title>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">


</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>

	
	<div class="container-fluide">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<table class="display" id="instructions">
					<thead class="thead-dark">
						<tr>
							<th>UserId</th>
							<th>HouseId</th>
							<th>Name</th>
							<th>Description</th>
							<th>Permission</th>
							<th>Approx Time</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${instructions}" var="it">
						<tr>
							<td>${it.userid}</td>
							<td>${it.houseid}</td>
							<td>${it.name}</td>
							<td>${it.description}</td>
							<td>${it.permission}</td>
							<td>${it.approx_time}</td>
							<td><a href="DeleteMemberController">Delete</a></td>
						</tr>
							
					</c:forEach>
					</tbody>
				</table>
				<br>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#instructions').DataTable();
		});
	</script>
</body>
</html>
					
					
					
