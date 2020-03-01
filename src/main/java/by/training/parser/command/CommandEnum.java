package by.training.parser.command;

import by.training.parser.command.parser.DOMParserCommand;
import by.training.parser.command.parser.SAXParserCommand;
import by.training.parser.command.parser.StAXParserCommand;

public enum CommandEnum {

	PARSE_DOM {
		{
			this.command = new DOMParserCommand();
		}
	},
	PARSE_SAX {
		{
			this.command = new SAXParserCommand();
		}
	},
	PARSE_STAX {
		{
			this.command = new StAXParserCommand();
		}
	};

	Command command;

	public Command getCommand() {
		return command;
	}
}
