package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.GoodsDao;

/**
 * Servlet implementation class ReviewGoodsServlet
 */
@WebServlet("/ReviewGoodsServlet")
public class ReviewGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		GoodsDao goodsDao = new GoodsDao();
		int i = goodsDao.reviewGoods(id);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (i == 1) {
			out.print("<script>alert('審核成功');window.location.href='ReviewLibraryServlet';</script>");
		}else {
			out.print("<script>alert('審核失敗');window.location.href='ReviewLibraryServlet';</script>");
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
