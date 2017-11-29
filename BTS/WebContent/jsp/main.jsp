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
.row .col.s12 {
	width: 50%;
	margin-top: 20px;
}

.loginbtn {
	background-color: #1C1C1C;
}

.loginbtn:HOVER {
	background-color: #6E6E6E;
}

.btn {
	background-color: #1C1C1C;
}

.btn:HOVER {
	background-color: #6E6E6E;
}

form {
	padding: 0 !important;
	position: relative;
	left: -1% !important;
}

table {
	margin-top: 3rem;
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


		<%-- 세션이 없는 경우 --%>
		<%
			UserVO user = (UserVO) session.getAttribute("user");
		%>
		<c:if test="${ empty user }">

			<h1 class="left-align welcome-phrase">
				Welcome to BTS!
				</h5>
				<p class="flow-text">We provide Service for the Bus, Train,
					Subway. Enjoy your time!</p>

				<div class="icon">
					<a href="#"><img src="${contextPath }/assets/facebook.png"
						alt="facebook-icon" class="fb"></a> <a href="#"><img
						src="${contextPath }/assets/twitter.png" alt="twitter-icon"
						class="twi"></a> <a href="#"><img
						src="${contextPath}/assets/kakao.png" alt="kakao-icon" class="ka"></a>
				</div>

				<form class="col s12" action="/BTS/login.do" method="post">

					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"
							placeholder="홍길동" name="id" required> <label
							for="last_name">Enter your id</label>
					</div>

					<div class="input-field col s6">
						<input id="last_name" type="password" class="validate"
							placeholder="1234" name="pw" required> <label
							for="last_name">Enter your password</label>
					</div>

					<div class="input-field col subwaybtn2">
						<button class="btn waves-effect waves-light tsubmit-btn loginbtn"
							type="submit" name="action">
							Login<i class="material-icons right">send</i>
						</button>
					</div>
					<div class="input-field col subwaybtn2">
						<a class="waves-effect waves-light btn"
							href="${contextPath }/jsp/signup.jsp">SIGNUP<i
							class="material-icons right">send</i></a>
					</div>

				</form>
		</c:if>


		<c:if test="${ !empty user }">

			<%-- 세션이 있는 경우 --%>
			<h1 class="left-align welcome-phrase">Welcome to BTS
				${user.name}!</h1>
			<p class="flow-text">We provide Service for the Bus, Train,
				Subway. Enjoy your time!</p>

			<div class="icon">
				<a href="#"><img src="${contextPath }/assets/facebook.png"
					alt="facebook-icon" class="fb"></a> <a href="#"><img
					src="${contextPath }/assets/twitter.png" alt="twitter-icon"
					class="twi"></a> <a href="#"><img
					src="${contextPath}/assets/kakao.png" alt="kakao-icon" class="ka"></a>
			</div>

			<p>
			<form class="col s12" action="/BTS/logout.do" method="post">

				<div class="input-field col subwaybtn2">
					<button class="btn waves-effect waves-light loginbtn" type="submit"
						name="action">
						LOGOUT <i class="material-icons right">send</i>
					</button>
				</div>

			</form>

			</p>

		</c:if>
	</div>

</div>

<%@ include file="modal.jsp"%>


<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="${contextPath}/js/jquery-3.2.1.min.js"></script>
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
