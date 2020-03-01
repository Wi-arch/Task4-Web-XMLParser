package by.training.parser.exception;

@SuppressWarnings("serial")
public class XMLParserException extends Exception {

	public XMLParserException() {
	}

	public XMLParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public XMLParserException(String message, Throwable cause) {
		super(message, cause);
	}

	public XMLParserException(String message) {
		super(message);
	}

	public XMLParserException(Throwable cause) {
		super(cause);
	}
}
