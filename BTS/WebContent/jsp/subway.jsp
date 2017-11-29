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

<link rel="stylesheet" href="${contextPath}/css/main.css">

<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>BTS</title>

<style type="text/css">
.sendbtn2-div {
	display: block;
	width: 100%;
}

.subwaybtn2 {
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

[type="radio"]+label {
	margin-right: 15px;
}

.radio1 {
	width: 100% !important;
}

.radio2 {
	width: 100% !important;
	margin-bottom: 20px;
}

.subwayidinput {
	margin-bottom: 0 !important;
}

.u-radio {
	margin-right: 2% !important;
}

form p {
	display: block;
	width: 100%;
	position: relative;
	float: right;
	left: 1%;
	color: black;
}

[type="radio"]:not (:checked )+label, [type="radio"]:checked+label {
	color: #424242;
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
		<div class="row">

			<h3 class="left-align2">지하철 시간표 조회</h3>

			<form class="col s12" id="subwayidform" action="/BTS/subwaysearch.do"
				method="post">
				<div class="row">

					<div class="input-field col s6 subwaybtn1">
						<input id="last_name" type="text" class="validate"
							placeholder="서울" name="subwayStationName" required> <label
							for="last_name">지하철역ID</label>
					</div>
					<div class="input-field col subwaybtn2">
						<button class="btn waves-effect waves-light tsubmit-btn sendbtn2"
							type="submit" name="action" id="subwaysearchbtn">
							Submit <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form>

			<table class="bordered train-result-table">
				<thead>
					<tr>
						<th>지하철역ID</th>
						<th>지하철역명</th>
					</tr>
				</thead>

				<tbody>

					<c:if test='${ !empty idresult }'>
						<c:forEach var="subwayid" items='${ idresult }' varStatus="status">
							<tr>
								<td>${ subwayid.subwayStationId }</td>
								<td>${ subwayid.subwayStationName }</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>

			<!-- form - 입력값 -->
			<form class="col s12" action="/BTS/subway.do" method="get">
				<div class="row">

					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate subwayidinput"
							placeholder="DGS118" name="subwayStationId" required> <label
							for="last_name">지하철역 ID</label>
					</div>


					<p>

						<input type="radio" name="dailyTypeCode" class="with-gap code"
							id="test5" value="01" required checked /> <label for="test5">01
							: 평일</label> <input type="radio" name="dailyTypeCode"
							class="with-gap code" id="test6" value="02" /> <label
							for="test6">02 : 토요일</label> <input type="radio"
							name="dailyTypeCode" class="with-gap code" id="test7" value="03" />
						<label for="test7">03 : 일요일</label>

					</p>

					<p>
						<input type="radio" name="upDownTypeCode" class="with-gap code"
							id="test8" value="U" required checked /> <label for="test8"
							class="u-radio">U : 상행</label> <input type="radio"
							name="upDownTypeCode" class="with-gap code" id="test9" value="D" />
						<label for="test9">D : 하행</label>
					</p>

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
							<th>지하철역명</th>
							<th>상하행구분코드</th>
							<th>요일구분코드</th>
							<th>출발시간</th>
							<th>도착시간</th>
							<th>종점지하철역명</th>
						</tr>
					</thead>

					<tbody>

						<c:if test='${ !empty list }'>
							<c:forEach var="subway" items='${ list }' varStatus="status">
								<tr>
									<td>${ subway.subwayStationNm  }</td>
									<td>${ subway.dailyTypeCode }</td>
									<td>${ subway.upDownTypeCode }</td>
									<td>${ subway.depTime }</td>
									<td>${ subway.arrTime }</td>
									<td>${ subway.endSubwayStationNm }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</tablWe>
			</div>
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

</html>
- *-
