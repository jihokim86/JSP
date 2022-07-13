package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

/**
 * Servlet implementation class ProductDeleteServlet
 */
@WebServlet("/ProductDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO pVo = pDao.selectProductByCode(code);
		
		request.setAttribute("product", pVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productDelete.jsp");
		dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.deleteProduct(code);
		
		response.sendRedirect("ProductList.do");
	
	}

}
