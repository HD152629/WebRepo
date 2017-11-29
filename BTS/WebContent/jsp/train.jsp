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

<style type="text/css">
.row .col.s12 {
	left: 1%;
}

.findid {
	left: 1%;
}

.select-wrapper span.caret {
	right: 50%;
}

.select-wrapper input.select-dropdown {
	width: 50%;
}

.sendbtn2-div {
	display: block;
	width: 100%;
}

table {
	position: relative;
	left: 1%;
	margin-bottom: 60px;
}
}
</style>

<title>BTS</title>

</head>

<!-- Sidenav -->
<ul id="slide-out" class="side-nav fixed">
	<li><div class="userView">
			<a href="${contextPath}/jsp/main.jsp"><span
				class="black-text name">BTS</span></a> <span class="black-text email">Bus-Train-Subway</span>
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

			<h3 class="left-align2">기차 시간표 조회</h3>

			<form action="/BTS/trainsearch.do">

				<div class="input-field col s12">
					<select name="cityCode">
						<option value="" disabled selected>찾고 싶은 역의 도시를 찾으세요</option>
						<optgroup label="특별시">
							<option value="11">서울특별시</option>
							<option value="12">세종특별시</option>
						</optgroup>
						<optgroup label="광역시">
							<option value="24">광주광역시</option>
							<option value="22">대구광역시</option>
							<option value="25">대전광역시</option>
							<option value="21">부산광역시</option>
							<option value="26">울산광역시</option>
							<option value="23">인천광역시</option>
						</optgroup>
						<optgroup label="일반도">
							<option value="32">강원도</option>
							<option value="31">경기도</option>
							<option value="38">경상남도</option>
							<option value="37">경상북도</option>
							<option value="36">전라남도</option>
							<option value="35">전라북도</option>
							<option value="34">충청남도</option>
							<option value="33">충청북도</option>
						</optgroup>
					</select> <label>Location</label>

					<button class="btn waves-effect waves-light sendbtn1" type="submit"
						name="action">
						Submit <i class="material-icons right">send</i>
					</button>
					<p id="idresult"></p>
				</div>
			</form>

			<table class="bordered train-result-table">
				<thead>
					<tr>
						<th>기차역ID</th>
						<th>기차역명</th>
					</tr>
				</thead>

				<tbody>

					<c:if test='${ !empty idresult }'>
						<c:forEach var="trainid" items='${ idresult }' varStatus="status">
							<tr>
								<td>${ trainid.nodeId }</td>
								<td>${ trainid.nodeName }</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>

			<!-- form - 입력값 -->
			<form class="col s12" action="/BTS/train.do" method="get">
				<div class="row">

					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"
							placeholder="NAT010000" name="leavestation" required> <label
							for="last_name">출발 기차역 ID</label>
					</div>

					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"
							placeholder="NAT011668" name="arrivestation" required> <label
							for="last_name">도착 기차역 ID</label>
					</div>

					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"
							placeholder="ex)20171122 이 형식에 맞춰주세요" name="departdate" required>
						<label for="last_name"> 출발날짜</label>
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
							<th>차량종류</th>
							<th>출발시간</th>
							<th>도착시간</th>
							<th>출발지</th>
							<th>도착지</th>
							<th>운임</th>
						</tr>
					</thead>

					<tbody>


						<c:if test='${ !empty list }'>
							<c:forEach var="train" items='${ list }' varStatus="status">
								<tr>
									<td>${ train.traingradename  }</td>
									<td>${ train.depplandtime }</td>
									<td>${ train.arrplandtime }</td>
									<td>${ train.arrplacename }</td>
									<td>${ train.depplacename }</td>
									<td>${ train.adultcharge }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>

			</div>

		</div>

	</div>

</div>

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src="${contextPath }/js/jquery-3.2.1.min.js"></script>
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

<script type="text/javascript" src="${contextPath }/js/main.js"></script>
<script type="text/javascript" src="${contextPath }/js/train.js"></script>

<script>
	
</script>


</body>
</html>

</html>
- *-
