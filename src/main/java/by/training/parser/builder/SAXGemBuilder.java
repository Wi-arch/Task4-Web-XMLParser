package by.training.parser.builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;

import javax.xml.XMLConstants;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import static javax.xml.bind.DatatypeConverter.parseDate;

import by.training.parser.entity.Gem;
import by.training.parser.entity.GemColor;
import by.training.parser.entity.PreciousnessType;
import by.training.parser.exception.XMLParserException;

public class SAXGemBuilder extends GemBuilder {

	private static final Logger LOGGER = Logger.getLogger(SAXGemBuilder.class);
	private XMLReader reader;

	public SAXGemBuilder() {
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			reader.setContentHandler(new GemHandler());
		} catch (SAXException e) {
			LOGGER.error("Parser configuration error", e);
		}
	}

	@Override
	public void buildGemList(InputStream sourceFile) throws XMLParserException {
		gemList.clear();
		try {
			reader.parse(new InputSource(sourceFile));
		} catch (SAXException e) {
			LOGGER.warn("File error", e);
			throw new XMLParserException("File error", e);
		} catch (IOException e) {
			LOGGER.warn("Parsing failure", e);
			throw new XMLParserException("Parsing failure", e);
		} finally {
			closeInputStream(sourceFile);
		}
	}

	private class GemHandler extends DefaultHandler {
		private Gem currentGem = null;
		private GemEnum currentEnum = null;
		private EnumSet<GemEnum> withText;

		public GemHandler() {
			withText = EnumSet.range(GemEnum.NAME, GemEnum.PRODUCTIONDATE);
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) {
			if (GemEnum.GEM.getValue().equals(localName)) {
				currentGem = new Gem();
				currentGem.setId(attributes.getValue(FIRST_ITEM_INDEX));
			} else {
				GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
				if (withText.contains(temp)) {
					currentEnum = temp;
				}
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) {
			if (GemEnum.GEM.getValue().equals(localName)) {
				gemList.add(currentGem);
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) {
			String currentElement = new String(ch, start, length).trim();
			if (currentEnum != null) {
				switch (currentEnum) {
				case NAME:
					currentGem.setName(currentElement);
					break;
				case PRECIOUSNESS:
					currentGem.setPreciousnessType(PreciousnessType.valueOf(currentElement.toUpperCase()));
					break;
				case ORIGIN:
					currentGem.setOrigin(currentElement);
					break;
				case COLOR:
					currentGem.getVisualParameter().setGemColor(GemColor.valueOf(currentElement.toUpperCase()));
					break;
				case TRANSPARENCY:
					currentGem.getVisualParameter().setTransparencyValue(Integer.valueOf(currentElement));
					break;
				case FACETS:
					currentGem.getVisualParameter().setFacetCount(Integer.valueOf(currentElement));
					break;
				case VALUE:
					currentGem.setValue(Double.valueOf(currentElement));
					break;
				case PRODUCTIONDATE:
					currentGem.setProductionDate(parseDate(currentElement).getTime());
					break;
				case VISUALPARAMETERS:
					break;
				default:
					throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
				}
			}
			currentEnum = null;
		}
	}
}
