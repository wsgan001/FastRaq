package com.securecloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.securecloud.bean.AutoMobile;
import com.securecloud.bean.FileTo;
import com.securecloud.dao.UserdaoImpl;

public class ViewGroupAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AutoMobile rto = new AutoMobile();

		String path = "";
		boolean flag = false;
		String s1 = request.getParameter("s1");

		try {

			Vector v = new UserdaoImpl().retreveFilesFromServer(rto);
			System.out.println(" vector size sanjay " + v.size());
			if (v != null) {

				if ("sanjay".equalsIgnoreCase(s1)) {
					request.setAttribute("tsb", v);

					path = "ShowAllFiles.jsp";
				} else {

					request.setAttribute("tsb", v);

					path = "ShowAllFiles.jsp";
				}
			} else {

				path = "ShowAllFiles.jsp";
			}
		} catch (Exception e) {

			path = "ShowAllFiles.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
