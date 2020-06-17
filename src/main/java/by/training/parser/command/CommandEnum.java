package by.training.parser.command;

import by.training.parser.command.parser.DOMParserCommand;
import by.training.parser.command.parser.SAXParserCommand;
import by.training.parser.command.parser.StAXParserCommand;

public enum CommandEnum {

    PARSE_DOM(new DOMParserCommand()), PARSE_SAX(new SAXParserCommand()), PARSE_STAX(new StAXParserCommand());

    CommandEnum(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
