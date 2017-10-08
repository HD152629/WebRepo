<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyBlog</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="/WebClass/css/myblog.css">

</head>
<body>

	<!-- Navbar   -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="myblog-home.html">Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item" onmouseover="menu_over(this);"
					onmouseout="menu_out(this);"><a class="nav-link"
					href="myblog-home.html">Intro <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item" onmouseover="menu_over(this);"
					onmouseout="menu_out(this);"><a class="nav-link"
					href="myblog-favor.html">Favor</a></li>
				<li class="nav-item" onmouseover="menu_over(this);"
					onmouseout="menu_out(this);"><a class="nav-link"
					href="myblog-bucketlist.html">BucketList</a></li>
			</ul>
			
			<%-- 세션이 없는 경우 --%>
		    <%
		       UserVO user = (UserVO) session.getAttribute("user");
		       if(user == null){
		    %>

			<form class="form-inline my-2 my-lg-0" action="/WebClass/bloglogin" method="post" id="loginForm">
				<input class="form-control mr-sm-2" type="email" name="id" placeholder="ID" aria-label="ID" id="id" required
				<%if(request.getParameter("id")==null){ %>
				value=""
				<%}
				else{%>
				value="<%=request.getParameter("id") %>"
				<%} %>
				>
				<input class="form-control mr-sm-2" type="password" name="pwd" placeholder="PASSWORD" aria-label="Password" id="pw" required>
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="login">Login</button>
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="signup" onclick="location.href='myblog-signup.html'">
				Sign Up</button>
			</form>
			<%-- 세션이 있는 경우 --%>
			<%} 
		     else{
		     %>

			<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
				<li class="nav-item dropdown"><a
					class="nav-item nav-link dropdown-toggle mr-md-2" href="#"
					id="bd-versions" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <%=user.getName()%> 님
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="bd-versions">
						<form action="/WebClass/bloglogout" method="post">
							<button type="submit" class="dropdown-item">Sign out</button>
						</form>
						<div class="dropdown-divider"></div>
						<button type="button" class="dropdown-item">Action1</button>
						<button type="button" class="dropdown-item">Action2</button>

					</div>
				</li>
			</ul>

			<%
				}
			%>
		</div>
	</nav>

	<!-- header? -->
	<div class="jumbotron jumbotron-fluid" id="jumbo">
		<div class="container" id="jumbo-cont1">
			<h1 class="display-3">Welcome to My Blog</h1>
			<p class="lead">"Hi, I'm KOREA DIGITAL MEDIA SCHOOL student. I'm
				really happy that you visit my website"</p>
		</div>
	</div>

	<!-- article -->
	<div class="jumbotron jumbotron-fluid" id="jumbo-article">
		<div class="container" id="container-article">
			<p class="lead" id="jumbo-article-title">Introduce</p>
			<hr id="hr1">
			<p class="lead" id="jumbo-article-main">
				I'm Korea Digital Media High School student in Ansan. This is my
				blog for the school task.<br />I'm using Bootstrap to make
				it.Teacher said you can do it simple but I will do my best for the
				first page.
			</p>
		</div>
	</div>


	<!-- footer -->
	<div class="jumbotron jumbotron-fluid" id="footer">
		<div class="container" id="footer-article">
			<h1 class="display-6">Jeon Byeong Hyeon</h1>
			<p class="lead" id="address">
				Danwon-gu, Ansan-si, Gyeonggi-do<br>sasaechoong-gil korea
				digital media high school
			</p>
			<p class="lead" id="phone">
				<img src="/WebClass/image/call.png" alt="call" id="call-img"> 010-2637-3087
			</p>
			<p class="lead" id="mail">
				<img src="/WebClass/image/mail.png" alt="mail" id="mail-img">
				qudgus0522@gmail.com
			</p>
			<hr id="hr2">
			<p class="lead" id="sns">
				<img src="/WebClass/image/facebook.png" alt="fb"> <img src="/WebClass/image/twitter.png"
					alt="tw"> <img src="/WebClass/image/instagram.png" alt="it">
			</p>

		</div>
	</div>

	<!-- Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Login</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Modal body text goes here.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>




	<!-- Optional JavaScript -->

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
    </script>
    <script>
	<%
	
	if ("error".equals(request.getAttribute("msg"))) {
	
	%>
	
	var myModal = $('#myModal');
	myModal.find('.modal-title').text('Sign in Error');
	myModal.find('.modal-body').text('Wrong Identification');
	myModal.modal();
	
	<%
	}
	%>
	
    </script>

</body>
</html>