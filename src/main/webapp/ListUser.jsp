%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">


</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>

	<%
	ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>


	<div class="container-fluide">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<table class="display" id="users">
					<thead class="thead-dark">
						<tr>
							<!-- <th scope="col">UserId</th> -->
							<th scope="col">FirstName</th>
							<th scope="col">LastName</th>
							<th scope="col">Email</th>
							<th scope="col">Gender</th>
							<th scope="col">Approved</th>
							<th scope="col">Approve</th>
							<th scope="col">Disable</th>
							<th scope="col">Delete</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (UserBean user : users) {
						%>
						<tr>
							<td><%=user.getFirstname()%></td>
							<td><%=user.getLastname()%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getGender()%></td>
							<td><%=user.getStatus()%></td>
							<td><a
								href="ApproveUserController?userid=<%=user.getUserId()%>">
									<button class="btn btn-success">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-check2" viewBox="0 0 16 16">
  <path
												d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
</svg>
									</button>
							</a></td>
							<td><a
								href="DisableUserController?userid=<%=user.getUserId()%>">
									<button class="btn btn-secondary">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-person-x-fill"
											viewBox="0 0 16 16">
  <path fill-rule="evenodd"
												d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6.146-2.854a.5.5 0 0 1 .708 0L14 6.293l1.146-1.147a.5.5 0 0 1 .708.708L14.707 7l1.147 1.146a.5.5 0 0 1-.708.708L14 7.707l-1.146 1.147a.5.5 0 0 1-.708-.708L13.293 7l-1.147-1.146a.5.5 0 0 1 0-.708z" />
</svg>
									</button>
							</a></td>
							<td><a
								href="DeleteUserController?userid=<%=user.getUserId()%>">
									<button class="btn btn-danger">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-trash3-fill"
											viewBox="0 0 16 16">
  <path
												d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z" />
</svg>
									</button>
							</a></td>
							<td><a
								href="AddHouseDetails.jsp?userid=<%=user.getUserId()%>">
									<button type="button" class="btn btn-info">AddHouse</button>
							</a></td>
							<%
							}
							%>
						</tr>
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
			$('#users').DataTable();
		});
	</script>
</body>
</html>