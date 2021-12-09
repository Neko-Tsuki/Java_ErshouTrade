package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daos.GoodsDao;

/**
 * Servlet implementation class PullServlet
 */
@WebServlet("/PullServlet")
public class PullServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PullServlet() {
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
		int i = goodsDao.pullGoods(id);
		if (i==1) {
			out.print("<script>alert('Done！');window.location.href='PullGoodsServlet';</script>");			
		}else {
			out.print("<script>alert('Error！');window.location.href='PullGoodsServlet';</script>");			
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
