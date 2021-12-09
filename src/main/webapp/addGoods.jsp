<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><link rel="stylesheet" type="text/css" href="common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="css/personal.css" media="all">
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<div class="larry-personal-body clearfix">
			<form enctype="multipart/form-data" class="layui-form col-lg-5" action="AddGoodsServlet" method="post">
				
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-block">
						<input type="text" name="name"  autocomplete="off" class="layui-input" placeholder="请输入商品名称">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">商品成色</label>
					<div class="layui-input-block">
						<input type="radio" name="quality" value="100" title="全新"><div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>全新</span></div>
						<input type="radio" name="quality" value="90" title="九成新" checked><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>九成新</span></div>
						<input type="radio" name="quality" value="80" title="八成新"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>八成新</span></div>
						<input type="radio" name="quality" value="50" title="五成新"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>五成新</span></div>
					
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">商品介绍</label>
					<div class="layui-input-block">
						<textarea name="inf" placeholder="请简单介绍下你的商品" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品实拍</label>
					<div class="layui-input-block">
						<input type="file" name="img" >
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });

	});
</script>
</body>
</html>