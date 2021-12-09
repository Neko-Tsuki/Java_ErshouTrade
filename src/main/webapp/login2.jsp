<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><!-- load css -->
<link rel="stylesheet" type="text/css" href="common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="css/login.css" media="all">
</head>
<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
	<h1><strong>烟科二手货交易平台管理员登录</strong></h1>
	
	<!-- 登录form表单 -->
	<form action="AdminLoginServlet" method="post">
		<div class="layui-user-icon larry-login">
			 <input type="text" name="name" placeholder="账号" class="login_txtbx"/>
		</div>
		<div class="layui-pwd-icon larry-login">
			 <input type="password" name="password" placeholder="密码" class="login_txtbx"/>
		</div>
	    
	    <div class="layui-submit larry-login">
	    	<input type="submit" value="立即登陆" class="submit_btn"/>
	    </div>
	   
	</form>
	   
</div>
<script type="text/javascript" src="common/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
$(function(){
	$(".layui-canvs").jParticle({
		background: "#141414",
		color: "#E6E6E6"
	});
});
</script>
</body>
</html>