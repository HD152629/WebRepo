function menu_over(e){
  e.setAttribute("class","nav-item active");
}

function menu_out(e){
  e.setAttribute("class","nav-item");
}

$(document).ready(function(){
      $('#loginForm').submit(function(event){

        // 자동으로 submit되는 걸 막기
        event.preventDefault();

        // id,pw값 가져오기
        var id = $('#id').val();
        var pw = $('#pw').val();

        // 서버로  post 전속(ajax)
      $.post("http://httpbin.org/post",
          {"id":id, "pw":pw},
          function(data){
            var myModal =$('#myModal1');
            myModal.modal();
            myModal.find('.modal-body').text(data.form.id + '님 로그인되었습니다.');
          });

      });
    });

    $(document).ready(function(){
          $('#signupForm').submit(function(event){

            // 자동으로 submit되는 걸 막기
            event.preventDefault();

            // name값 가져오기
            var name = $('#name').val();

            // 서버로  post 전속(ajax)
          $.post("http://httpbin.org/post",
              {"name":name},
              function(data){
                var myModal1 =$('#myModal2');
                myModal1.modal();
                myModal1.find('.modal-body').text(data.form.name + '님 회원가입되었습니다.');
              });

          });
        });
