package by.training.parser.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.parser.command.Command;
import by.training.parser.command.PageEnum;
import by.training.parser.factory.CommandFactory;

@SuppressWarnings("serial")
@WebServlet("/controller")
@MultipartConfig(maxFileSize = 10240)
public class Controller extends HttpServlet {

	private static final CommandFactory COMMAND_FACTORY = new CommandFactory();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = COMMAND_FACTORY.defineCommand(request);
		String path = command.execute(request, response);
		request.getRequestDispatcher(path != null ? path : PageEnum.HOME_PAGE.getValue()).forward(request, response);
	}
}
