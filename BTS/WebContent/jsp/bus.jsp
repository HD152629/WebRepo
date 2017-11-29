<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script type="text/javascript">
	
</script>

<style type="text/css">
.busbtn1 {
	left: 0.8% !important;
}

.busbtn2 {
	display: inline;
	width: 100%;
}

.btn {
	margin-bottom: 20px;
	left: 0.8%;
}

table {
	margin-bottom: 60px;
}

.registerbtn {
	margin-top: 1.8px;
	margin-bottom: 0px !important;;
}
</style>

</head>

<!-- Sidenav -->
<ul id="slide-out" class="side-nav fixed">
	<li><div class="userView">
			<a href="${contextPath }/jsp/main.jsp"><span
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
		<div class="row">

			<h3 class="left-align2">버스 노선 조회</h3>

			<form class="col s12" action="/BTS/bussearch.do" method="post">
				<div class="row">

					<div class="input-field col s6 busbtn1">
						<input id="last_name" type="text" class="validate"
							placeholder="센트럴" name="terminalNm" required> <label
							for="last_name">출발터미널ID</label>
					</div>
					<div class="input-field col busbtn2">
						<button class="btn waves-effect waves-light tsubmit-btn sendbtn2"
							type="submit" name="action">
							Submit <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form>

			<table class="bordered train-result-table">
				<thead>
					<tr>
						<th>터미널 ID</th>
						<th>터미널명</th>
					</tr>
				</thead>

				<tbody>

					<c:if test='${ !empty idresult }'>
						<c:forEach var="busid" items='${ idresult }' varStatus="status">
							<tr>
								<td>${ busid.terminalId }</td>
								<td>${ busid.terminalNm }</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>

			<!-- form - 입력값 -->
			<form class="col s12" action="/BTS/bus.do">
				<div class="row">

					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"
							placeholder="NAEK010" name="depTerminalId"> <label
							for="last_name">출발터미널ID</label>
					</div>

					<div class="input-field col s6">
						<input id="last_name2" type="text" class="validate"
							placeholder="NAEK300" name="arrTerminalId"> <label
							for="last_name">도착터미널ID</label>
					</div>

					<div class="input-field col s6">
						<input id="last_name2" type="text" class="validate"
							placeholder="20161001" name="depPlandTime"> <label
							for="last_name">출발일</label>
					</div>

					<div class="input-field col sendbtn2-div">
						<button class="btn waves-effect waves-light tsubmit-btn sendbtn2"
							type="submit" name="action">
							Submit <i class="material-icons right">send</i>
						</button>
					</div>

				</div>
			</form>

			<div class="tablediv">
				<table class="bordered train-result-table">
					<thead>
						<tr>
							<th>버스등급</th>
							<th>출발시간</th>
							<th>도착시간</th>
							<th>출발지</th>
							<th>도착지</th>
							<th>운임</th>
						</tr>
					</thead>

					<tbody>


						<c:if test='${ !empty list }'>
							<c:forEach var="bus" items='${ list }' varStatus="status">
								<tr>
									<td>${ bus.gradeNm  }</td>
									<td>${ bus.depPlandTime }</td>
									<td>${ bus.arrPlandTime }</td>
									<td>${ bus.depPlaceNm }</td>
									<td>${ bus.arrplaceNm }</td>
									<td>${ bus.charge }</td>
								</tr>
							</c:forEach>
						</c:if>

					</tbody>
				</table>

			</div>

		</div>
	</div>

</div>

<%@ include file="modal3.jsp"%>

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
<c:if test="${ error2!=null }">
	<script>
		$('.modal').modal();
		$('#modal').modal('open');
	</script>
</c:if>


</body>
</html>

