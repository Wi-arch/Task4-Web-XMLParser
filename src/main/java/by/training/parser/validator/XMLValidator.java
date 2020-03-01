package by.training.parser.validator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.training.parser.exception.XMLParserException;

public class XMLValidator extends DefaultHandler {

	private static final Logger LOGGER = Logger.getLogger(XMLValidator.class);
	private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	private static final String XML_REGEX = "(?i).*\\.xml";

	public void isXMLTypeFile(String fileName) throws XMLParserException {
		if (fileName == null || !fileName.matches(XML_REGEX)) {
			LOGGER.warn("File not valid");
			throw new XMLParserException("File not valid");
		}
	}

	public void validateXMLFile(InputStream sourceFile, String schemaName) throws XMLParserException {
		if (sourceFile == null || schemaName == null) {
			throw new XMLParserException("source file null");
		}
		SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
		try {
			Schema schema = factory.newSchema(new File(getClass().getClassLoader().getResource(schemaName).toURI()));
			Validator validator = schema.newValidator();
			validator.setErrorHandler(this);
			validator.validate(new StreamSource(sourceFile));
		} catch (IOException | SAXException | URISyntaxException e) {
			LOGGER.warn("File is not valid because " + e.getMessage());
			throw new XMLParserException(e);
		}
	}

	@Override
	public void warning(SAXParseException e) {
		LOGGER.warn(getLineAddress(e) + "-" + e.getMessage());
	}

	@Override
	public void error(SAXParseException e) {
		LOGGER.error(getLineAddress(e) + " - " + e.getMessage());
	}

	@Override
	public void fatalError(SAXParseException e) {
		LOGGER.fatal(getLineAddress(e) + " - " + e.getMessage());
	}

	private String getLineAddress(SAXParseException e) {
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
}
