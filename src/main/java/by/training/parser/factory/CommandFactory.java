package by.training.parser.factory;

import javax.servlet.http.HttpServletRequest;

import by.training.parser.command.Command;
import by.training.parser.command.CommandEnum;
import by.training.parser.command.JspParameter;

public class CommandFactory {

	public Command defineCommand(HttpServletRequest request) {
		return CommandEnum.valueOf(request.getParameter(JspParameter.COMMAND.getValue())).getCommand();
	}
}
