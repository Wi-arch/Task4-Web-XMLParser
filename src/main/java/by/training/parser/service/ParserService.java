package by.training.parser.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import by.training.parser.builder.GemBuilder;
import by.training.parser.entity.Gem;
import by.training.parser.exception.ServiceException;
import by.training.parser.exception.XMLParserException;
import by.training.parser.validator.XMLValidator;

public class ParserService {

	private static final Logger LOGGER = Logger.getLogger(ParserService.class);
	private static final XMLValidator XML_VALIDATOR = new XMLValidator();
	private static final String SCHEMA_NAME = "gems.xsd";

	private ParserService() {
	}

	private static class ParserServiceInstance {
		private static final ParserService INSTANCE = new ParserService();
	}

	public static ParserService getInstance() {
		return ParserServiceInstance.INSTANCE;
	}

	public List<Gem> parseXML(Part sourceFile, GemBuilder gemBuilder) throws ServiceException {
		validateXML(sourceFile);
		List<Gem> gemList;
		try {
			gemBuilder.buildGemList(sourceFile.getInputStream());
			gemList = gemBuilder.getGemList();
		} catch (IOException | XMLParserException e) {
			LOGGER.warn("Cannot parse source file");
			throw new ServiceException("Cannot parse source file", e);
		}
		return gemList;
	}

	private void validateXML(Part sourceFile) throws ServiceException {
		try {
			XML_VALIDATOR.isXMLTypeFile(sourceFile.getSubmittedFileName());
			XML_VALIDATOR.validateXMLFile(sourceFile.getInputStream(), SCHEMA_NAME);
		} catch (IOException | XMLParserException e) {
			LOGGER.warn("File is not valid");
			throw new ServiceException("File is not valid", e);
		}
	}
}
