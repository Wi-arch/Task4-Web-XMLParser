package by.training.parser.validator;

import by.training.parser.exception.XMLParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XMLValidatorTest {

    private final static Logger LOGGER = LogManager.getLogger(XMLValidatorTest.class);
    private final static String VALID_XML = "gems.xml";
    private final static String INVALID_XML = "invalid.xml";
    private final static String SCHEMA_NAME = "gems.xsd";
    private XMLValidator xMLValidator;
    private InputStream validXMLFile;
    private InputStream invalidXMLFile;

    @Before
    public void init() {
        this.xMLValidator = new XMLValidator();
        try {
            validXMLFile = new FileInputStream(getClass().getClassLoader().getResource(VALID_XML).getFile());
            invalidXMLFile = new FileInputStream(getClass().getClassLoader().getResource(INVALID_XML).getFile());
        } catch (FileNotFoundException e) {
            LOGGER.warn("Cannot find source file");
        }
    }

    @Test
    public void testIsXMLTypeFilePositive() throws XMLParserException {
        String fileName = "web.xml";
        xMLValidator.isXMLTypeFile(fileName);
    }

    @Test(expected = XMLParserException.class)
    public void testIsXMLTypeFileNegative() throws XMLParserException {
        xMLValidator.isXMLTypeFile(SCHEMA_NAME);
    }

    @Test
    public void testValidateXMLFilePositive() throws XMLParserException {
        xMLValidator.validateXMLFile(validXMLFile, SCHEMA_NAME);
    }

    @Test(expected = XMLParserException.class)
    public void testValidateXMLFileNegative() throws XMLParserException {
        xMLValidator.validateXMLFile(invalidXMLFile, SCHEMA_NAME);
    }
}
