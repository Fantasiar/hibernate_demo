package com.fouter.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

import com.fouter.domain.Customer;
import com.fouter.service.CustomerService;
import com.fouter.service.impl.CustomerServiceImpl;

import javassist.CodeConverter.DefaultArrayAccessReplacementMethodNames;

/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService cs = new CustomerServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cust_name=request.getParameter("cust_name");
		
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		
		if (cust_name!=null && !"".equals(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		
		List<Customer> list=cs.getAll(dc);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
