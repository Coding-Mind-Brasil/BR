
<!DOCTYPE html>
<html>
<head>
	<title>POST & GET AJAX COM JQUERY</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<form id="">
		Username
		<input type="text" name="username" placeholder="Username" id="username"  />
		
		Password
		<input type="password" name="passcode" placeholder="Password"  id="password" />
		
		<button id="login_btn"/> Log in </button>

	</form>
	<div class="result">
		
	</div>
	
	<script type="text/javascript">
		var r; 
		$("#login_btn").click((e)=>{
			e.preventDefault();
			let dados = {username:$("#username").val(),
						 password:$("#password").val()}
			$.post("controller.php",dados,function(result, status){
				$("form")[0].remove();

				o = JSON.parse(result);
				html_resul = "Ola "+ o.username; 
				$(".result").html(html_resul);
				console.log(status)
				console.log(result)

			} )
		});
		

		
	</script>
</body>
</html>

	



