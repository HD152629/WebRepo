<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/footer.css">
</head>
<body>

<%
	Calendar c = Calendar.getInstance(); 
%>
	<footer class="footer">
		<div class="container">
			<span class="text-muted">&copy; <%=c.get(Calendar.YEAR) %> mycompany.com</span>
		</div>
	</footer>

</body>
</html>