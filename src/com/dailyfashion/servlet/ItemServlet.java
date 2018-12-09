package com.dailyfashion.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailyfashion.model.Item;
import com.dailyfashion.service.ItemService;
import com.dailyfashion.service.ItemServiceImpl;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/items/*")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ItemService itemService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemServlet() {
		itemService = new ItemServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("delete")) {
			String itemId = uri.split("/")[uri.split("/").length - 1];
			itemService.deleteItem(itemId);
			response.sendRedirect("../../items");
		} else if (uri.contains("update")) {
			String itemId = uri.split("/")[uri.split("/").length - 1];
			Item item = itemService.readItem(itemId);
			request.setAttribute("item", item);
			RequestDispatcher rd = request.getRequestDispatcher("../../create-or-update-item.jsp");
			rd.forward(request, response);
		} else {
			List<Item> items = itemService.getItems();
			request.setAttribute("items", items);
			RequestDispatcher rd = request.getRequestDispatcher("/items.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getClass().getSimpleName() + " >> Creating Item");
		String id = request.getParameter("id");
		if (id == null || id == "") {
			String itemName = request.getParameter("name");
			String itemDescription = request.getParameter("description");
			double itemPrice = Double.parseDouble(request.getParameter("price"));
			int itemQuanity = Integer.parseInt(request.getParameter("quantity"));
			String itemImageUrl = request.getParameter("imageUrl");

			Item item = new Item();
			item.setName(itemName);
			item.setDescription(itemDescription);
			item.setPrice(itemPrice);
			item.setQuantity(itemQuanity);
			item.setImageUrl(itemImageUrl);

			int i = itemService.createItem(item);
			if (i > 0) {
				response.sendRedirect("items");
			} else {
				PrintWriter out = response.getWriter();
				out.println("Somthing went wrong...");
			}
		} else {
			String itemName = request.getParameter("name");
			String itemDescription = request.getParameter("description");
			double itemPrice = Double.parseDouble(request.getParameter("price"));
			int itemQuanity = Integer.parseInt(request.getParameter("quantity"));
			String itemImageUrl = request.getParameter("imageUrl");

			Item item = new Item();
			item.setId(id);
			item.setName(itemName);
			item.setDescription(itemDescription);
			item.setPrice(itemPrice);
			item.setQuantity(itemQuanity);
			item.setImageUrl(itemImageUrl);

			int i = itemService.updateItem(item);
			if (i > 0) {
				response.sendRedirect("items");
			} else {
				PrintWriter out = response.getWriter();
				out.println("Somthing went wrong...");
			}
		}

	}

}
