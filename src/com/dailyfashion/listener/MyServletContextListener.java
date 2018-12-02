package com.dailyfashion.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dailyfashion.service.ItemService;
import com.dailyfashion.service.ItemServiceImpl;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

	private ItemService itemService;

	/**
	 * Default constructor.
	 */
	public MyServletContextListener() {
		itemService = new ItemServiceImpl();
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(this.getClass().getSimpleName() + ">> Creating tables");
		itemService.createItemTable();
		System.out.println(this.getClass().getSimpleName() + "<< Creating tables");
	}

}
