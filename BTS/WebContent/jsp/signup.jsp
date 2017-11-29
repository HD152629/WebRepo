<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="${contextPath }/css/main.css">

<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>BTS</title>

<style type="text/css">
h3 {
	position: relative;
	left: 35%;
}

.signup-area {
	width: 100%;
	display: block;
	position: relative;
	padding-right: 30%;
	padding-left: 33%;
	margin: auto;
	background-color: #bdbdbd grey lighten-1;
	display: block;
}

.title {
	display: block;
}

.pw-input {
	width: 47% !important;
}

.signupbtn {
	display: block;
	width: 50.1%;
}
</style>

</head>

<!-- Sidenav -->
<ul id="slide-out" class="side-nav fixed">
	<li><div class="userView">
			<a href="${contextPath}/jsp/main.jsp"><span
				class="black-text  name">BTS</span></a> <span class="black-text email">Bus-Train-Subway</span>
		</div></li>
	<li><div class="divider"></div></li>
	<li><a href="${contextPath}/jsp/subway.jsp">Subway</a></li>
	<li><a href="${contextPath}/jsp/train.jsp">Train</a></li>
	<li><a href="${contextPath}/jsp/bus.jsp">Bus</a></li>

</ul>

<div class="row">

	<div class="col s3">
		<!-- Grey navigation panel -->

	</div>

	<div class="col s9">

		<!-- Teal page content  -->
		<div class="title">
			<h3 class="left-align welcome-phrase">SIGNUP</h3>
		</div>
		<form action="/BTS/signup.do">

			<div class="signup-area">

				<div class="input-field col s6">
					<input id="last_name" type="text" class="validate" name="id" required="required">
					<label for="last_name">ID</label>
				</div>
				<div class="input-field col s12">
					<input id="password" type="password" class="validate pw-input" name="pw" required="required"> <label for="password">PASSWORD</label>
				</div>
				<div class="input-field col s6">
					<input id="last_name" type="text" class="validate" name="name" required="required">
					<label for="last_name">NAME</label>
				</div>

				<button class="btn waves-effect waves-light signupbtn" type="submit"
					name="action">
					SIGNUP <i class="material-icons right">send</i>
				</button>
			</div>

		</form>
	</div>

</div>

<%@ include file="modal2.jsp"%>

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="${contextPath }/js/jquery-3.2.1.min.js"></script>
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<c:if test="${ error!=null }">
	<script>
		$('.modal').modal();
		$('#modal').modal('open');
	</script>
</c:if>
</body>
</html>

</html>
- *-
