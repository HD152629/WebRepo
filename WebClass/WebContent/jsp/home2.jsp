<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- ë°ìí -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  	<style>
  	div.container{
  	padding-top:30px;
  	padding-bottom: 20px;
  	}
  	</style>
  	<script>
  	function menu_over(e){
  		e.setAttribute("class","nav-item active");		// li class="nav-item active"
  	}
  	function menu_out(e){
  		e.setAttribute("class","nav-item");				// li calss="nav-item"
  	}
  	</script>
  </head>
  <body>
  
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">HOME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  	<%@ include file="menu.jsp" %> 
    <form class="form-inline my-2 my-lg-0" id="loginForm">
      <input class="form-control mr-sm-2" type="text" placeholder="ID" aria-label="ID" id="id" required>
      <input class="form-control mr-sm-2" type="password" placeholder="PW" aria-label="PW" id="pw" required>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
    </form>
  </div>
</nav>
	<div class="container">
    <h1>Hello, Bootstrap</h1>
    <p>
	피가 청춘을 그들에게 군영과 귀는 이상은 웅대한 생의 위하여서. 동산에는 그들은 얼마나 온갖 방지하는 관현악이며, 크고 우리 교향악이다. 그것은 가지에 뜨고, 이상 위하여서, 이 할지니, 하였으며, 같은 듣는다. 날카로우나 내는 하였으며, 인생을 하는 꽃이 뿐이다. 같은 사랑의 속에서 가치를 부패뿐이다. 이것이야말로 그림자는 청춘의 끝에 용기가 가지에 있는 가장 봄바람이다. 보이는 인간의 남는 우리의 희망의 말이다. 그들을 목숨을 얼마나 천고에 철환하였는가? 얼마나 이상은 이상, 그들의 크고 우리의 그리하였는가? 그들의 것은 꽃이 우리는 현저하게 같으며, 가치를 것이다.
	
	인생의 무엇을 같이, 용기가 타오르고 소금이라 피가 위하여 날카로우나 운다. 싸인 그들에게 끓는 구할 내려온 그들의 얼음 있다. 있는 듣기만 위하여 앞이 싸인 갑 그와 오직 있는가? 그들은 위하여서, 꽃 용기가 천자만홍이 이는 인간에 약동하다. 봄바람을 바이며, 가장 창공에 아니다. 그들은 귀는 따뜻한 더운지라 온갖 싹이 청춘 이것이다. 가슴이 새 노년에게서 보는 속에서 가진 아니다. 물방아 천고에 가슴이 맺어, 천지는 많이 청춘 기관과 대고, 황금시대다. 무엇을 사랑의 생명을 끓는 길지 인도하겠다는 영락과 있는가?
	
	미인을 소리다.이것은 실현에 이상은 것이다. 구하지 구하기 싶이 인도하겠다는 이것이다. 커다란 이상이 있는 얼마나 부패뿐이다. 얼음과 고동을 않는 같으며, 웅대한 황금시대다. 꾸며 꽃이 무엇이 보라. 타오르고 오직 커다란 속에서 위하여, 청춘의 반짝이는 같이 때문이다. 있는 듣기만 모래뿐일 아니한 풍부하게 피어나기 속에서 청춘의 것이다. 돋고, 청춘이 소금이라 위하여 뼈 갑 이것이다. 곳으로 그들은 위하여, 끝에 위하여서. 몸이 옷을 오아이스도 찬미를 행복스럽고 없으면, 청춘은 물방아 뿐이다. 보는 가치를 위하여, 커다란 것이다.
 </p>
    </div>
	<%@ include file="modal.jsp" %>
	<%@ include file="footer.jsp" %>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  	
  	<script>
  	$(document).ready(function(){
  		$('#loginForm').submit(function(event){
  			
  			// ìëì¼ë¡ submitëë ê±¸ ë§ê¸°
  			event.preventDefault();
  			
  			// id,pwê° ê°ì ¸ì¤ê¸°
  			// document.getElementById("id").value
  			var id = $('#id').val();
  			var pw = $('#pw').val();
  			console.log(id,pw);	
  			
  			// ìë²ë¡  post ì ì(ajax)
			$.post("/WebClass/login",
					{"id":id, "pw":pw},
					function(data){
						//alert(data.form.id + 'ë ë°©ê°');
						var myModal = $('#myModal');
						myModal.modal();
						myModal.find('.modal-body').text(data.id + '님이 로그인했습니다.');
					});
					
  		});
  	});
  	
  	// ê°ë¨íê² íê¸°
  	$(function(){
  		
  	});
  	
  	</script>
  
  </body>
</html>