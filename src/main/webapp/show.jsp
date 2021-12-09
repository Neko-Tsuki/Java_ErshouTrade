<%@page import="net.beans.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.con{
	display:flex;
	flex-wrap:wrap;
	justify-content:space-between
}

</style>
</head>
<body>
<div class="con">
	 <%                          
      	List<Goods> list = (List<Goods>) session.getAttribute("Alllist");
        for (Goods goods : list) {
      %>
		<div style="width: 20%">
			<div style="width: 80%">
				<p><img width="100%" src="imgs/<%=goods.getImg()%>"></p>
				<p><%=goods.getName()%></p>
				<p>新旧程度：<%=goods.getQuality()%>%</p>
			</div>
		</div>
	<%} %>
	
</div>
<p align="center">当前页：${sessionScope.page }/${sessionScope.tpage } <a href="index?page=${page-1<=0? tpage:page-1 }">上一页</a>&nbsp;<a href="index?page=${page+1>tpage? 1:page+1 }">下一页</a></p>
</body>
</html>