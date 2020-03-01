package by.training.parser.command;

public enum JspParameter {

	COMMAND("command"), PARSER_RESULT("parserResult"), FILE("file"), ERROR("error"),
	PARSER_ERROR_MESSAGE("File processing error");

	private String value;

	private JspParameter(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
