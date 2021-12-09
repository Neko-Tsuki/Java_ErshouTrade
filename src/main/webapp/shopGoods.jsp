<%@page import="java.util.ArrayList"%>
<%@page import="com.beans.Goods"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
	    <div class="layui-tab">
            <blockquote class="layui-elem-quote news_search">
	</blockquote>
            
		    <div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
		         <!-- 查询商品列表 -->
                <div class="layui-tab-item layui-field-box layui-show">
                     <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                          <thead>
                              <tr>
                                  <th><input type="checkbox" id="selected-all"></th>
                                  <th>商品ID</th>
                                  <th>商品名称</th>
                                  <th>商品成色</th>
                                  <th>商品图片</th>
                                  <th>商品简介</th>           
                              </tr>
                          </thead>
                          <tbody>
                              <%                          
                              	List<Goods> list = (List<Goods>) session.getAttribute("shopList");
                                for (Goods goods : list) {
                              %>
                              <tr>
                                <td><input type="checkbox"></td>
                                <td><%=goods.getG_id() %></td>
                                <td><%=goods.getName() %></td>
                                <td><%=goods.getQuality() %></td>
                                <td><img style="width: 50px;height: 50px" src="imgs/<%=goods.getImg()%>"/></td>
                                <td><%=goods.getInf()%></td>
           					  </tr>
                              <%} %>
                          </tbody>
                     </table>
                     
			    </div>  
			    </div>
		    </div>
		</div>
	
</section>
<script type="text/javascript" src="common/layui/layui.js"></script>
	</body>
</body>
</html>