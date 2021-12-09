package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Goods;
import com.daos.GoodsDao;

/**
 * Servlet implementation class PutServlet
 */
@WebServlet("/PutServlet")
public class PutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		GoodsDao goodsDao = new GoodsDao();
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int i = goodsDao.putGoods(id);
		if (i==1) {
			out.print("<script>alert('Done！');window.location.href='PutGoodsServlet';</script>");			
		}else {
			out.print("<script>alert('Error！');window.location.href='PutGoodsServlet';</script>");			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
