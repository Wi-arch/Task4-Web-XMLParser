package by.training.parser.command;

public enum PageEnum {

	HOME_PAGE("/index.jsp"), PARSE_RESULT_PAGE("/jsp/parseResult.jsp"), ERROR_PAGE("/jsp/error.jsp");

	private String value;

	private PageEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
