package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.beans.Goods;
import com.beans.User;
import com.daos.GoodsDao;

/**
 * Servlet implementation class AddServlet
 */
@SuppressWarnings("unused")
@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filepath = request.getSession().getServletContext().getRealPath("imgs");   
		System.out.println(filepath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		request.setCharacterEncoding("utf-8");
		String name = null;
		String quality = null;
		String img =null;
		String inf = null;
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fileitem:items){
				if(fileitem.isFormField()){
					if(fileitem.getFieldName().equals("name")){
						name = fileitem.getString("utf-8");
					}
					if(fileitem.getFieldName().equals("quality")){
						quality =fileitem.getString();
					}
					if(fileitem.getFieldName().equals("inf")){
						inf = new String(fileitem.getString().getBytes("iso-8859-1"),"utf-8");
					}
				}else{
					img = fileitem.getName();
					try {
						System.out.println(filepath+"\\"+img);
						fileitem.write(new File(filepath+"\\"+img));
						//本地文件写入到服务器上
						
					} catch (Exception e) {
						System.out.println(e);
						System.out.println("图片上传失败");
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Goods goods = new Goods(user.getId(),name,quality, img, inf); //封装Goods字段
		GoodsDao goodsdao = new GoodsDao();
		int i = goodsdao.addGoods(goods);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(i == 1){
			out.print("<script>alert('添加成功!');window.location.href='addGoods.jsp'</script>");
		}else{
			out.print("<script>alert('添加失败，请重新添加!');window.location.href='addGoods.jsp'</script>");
		}
		
	}

}
