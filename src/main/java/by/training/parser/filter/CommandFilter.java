package by.training.parser.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.parser.command.CommandEnum;
import by.training.parser.command.JspParameter;
import by.training.parser.command.PageEnum;

@WebFilter(urlPatterns = { "/controller" }, servletNames = { "Controller" })
public class CommandFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String command = request.getParameter(JspParameter.COMMAND.getValue());
		if (command != null && !command.isEmpty()) {
			try {
				CommandEnum.valueOf(command.toUpperCase());
			} catch (IllegalArgumentException e) {
				resp.sendRedirect(req.getContextPath() + PageEnum.HOME_PAGE.getValue());
				return;
			}
		} else {
			resp.sendRedirect(req.getContextPath() + PageEnum.HOME_PAGE.getValue());
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
