package by.training.parser.command.parser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import by.training.parser.command.Command;
import by.training.parser.command.JspParameter;
import by.training.parser.command.PageEnum;
import by.training.parser.entity.Gem;
import by.training.parser.exception.ServiceException;
import by.training.parser.factory.GemBuilderFactory;
import by.training.parser.service.ParserService;

public class DOMParserCommand implements Command {

	private static final Logger LOGGER = Logger.getLogger(DOMParserCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		String page;
		try {
			Part filePart = request.getPart(JspParameter.FILE.getValue());
			List<Gem> gemList = ParserService.getInstance().parseXML(filePart,GemBuilderFactory.getInstance().getDomGemBuilder());
			request.setAttribute(JspParameter.PARSER_RESULT.getValue(), gemList);
			page = PageEnum.PARSE_RESULT_PAGE.getValue();
		} catch (IOException | ServletException | ServiceException e) {
			LOGGER.warn("Cannot parse file", e);
			request.setAttribute(JspParameter.ERROR.getValue(), JspParameter.PARSER_ERROR_MESSAGE.getValue());
			page = PageEnum.HOME_PAGE.getValue();
		}
		return page;
	}
}
