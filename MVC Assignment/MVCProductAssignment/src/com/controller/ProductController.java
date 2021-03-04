package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Product;
import com.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		ProductService ps=new ProductService();
		List<Product> listOfProd=ps.getAllProduct();
		HttpSession hs=request.getSession();
		hs.setAttribute("prodInfo", listOfProd);
		response.sendRedirect("retrieveProduct.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw=response.getWriter();
		String op=request.getParameter("prod");
		ProductService ps=new ProductService();
		if(op.equals("insert"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			float price=Float.parseFloat(request.getParameter("price"));
			String storedate=request.getParameter("storedate");
			Product prod=new Product();
			prod.setId(id);
			prod.setName(name);
			prod.setPrice(price);
			prod.setStoredate(storedate);
			String result=ps.storeProduct(prod);
			RequestDispatcher rd=request.getRequestDispatcher("insertProduct.html");
			pw.print(result);
			rd.include(request, response);
		}
		else if(op.equals("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String res=ps.deleteProduct(id);
			RequestDispatcher rd=request.getRequestDispatcher("deleteProduct.html");
			pw.print(res);
			rd.include(request, response);
			
		}
		else if(op.equals("update"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			float price=Float.parseFloat(request.getParameter("price"));
			//System.out.println("id is"+id+"price is"+price);
			Product prod=new Product();
			prod.setId(id);
			prod.setPrice(price);
			String result1=ps.updateProduct(prod);
			RequestDispatcher rd=request.getRequestDispatcher("updateProduct.html");
			pw.print(result1);
			rd.include(request, response);
		}
		else if(op.equals("custprodinsert"))
		{
			int id=Integer.parseInt(request.getParameter("custprodid"));
			String name=request.getParameter("custprodname");
			float price=Float.parseFloat(request.getParameter("custprodprice"));
			String custproddate=request.getParameter("custproddate");
			Product prod=new Product();
			prod.setId(id);
			prod.setName(name);
			prod.setPrice(price);
			prod.setStoredate(custproddate);
			String result=ps.storeCustomerProduct(prod);
			RequestDispatcher rd=request.getRequestDispatcher("insertCustomerProduct.html");
			pw.print(result);
			rd.include(request, response);
		}
	}

}
