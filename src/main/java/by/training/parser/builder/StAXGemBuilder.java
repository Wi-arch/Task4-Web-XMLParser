package by.training.parser.builder;

import by.training.parser.entity.Gem;
import by.training.parser.entity.GemColor;
import by.training.parser.entity.PreciousnessType;
import by.training.parser.entity.VisualParameter;
import by.training.parser.exception.XMLParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

import static javax.xml.bind.DatatypeConverter.parseDate;

public class StAXGemBuilder extends GemBuilder {

	private static final Logger LOGGER = LogManager.getLogger(StAXGemBuilder.class);
	private static final String EMPTY_STRING = "";
	private XMLInputFactory inputFactory;

	public StAXGemBuilder() {
		inputFactory = XMLInputFactory.newInstance();
		inputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
	}

	public void buildGemList(InputStream sourceFile) throws XMLParserException {
		gemList.clear();
		String name;
		try {
			XMLStreamReader reader = inputFactory.createXMLStreamReader(sourceFile);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (GemEnum.valueOf(name.toUpperCase()) == GemEnum.GEM) {
						gemList.add(buildGem(reader));
					}
				}
			}
		} catch (XMLStreamException e) {
			LOGGER.warn("Parsing failure", e);
			throw new XMLParserException("Parsing failure", e);
		} finally {
			closeInputStream(sourceFile);
		}
	}

	private Gem buildGem(XMLStreamReader reader) throws XMLStreamException {
		Gem gem = new Gem();
		gem.setId(reader.getAttributeValue(null, GemEnum.ID.getValue()));
		GemEnum currentValue = null;
		int type;
		while (reader.hasNext()) {
			type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				currentValue = GemEnum.valueOf(reader.getLocalName().toUpperCase());
				handleGemCurrentValue(currentValue, reader, gem);
			}
			if (type == XMLStreamConstants.END_ELEMENT) {
				currentValue = GemEnum.valueOf(reader.getLocalName().toUpperCase());
				if (GemEnum.GEM == currentValue) {
					return gem;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag gem");
	}

	private void handleGemCurrentValue(GemEnum currentValue, XMLStreamReader reader, Gem gem)
			throws XMLStreamException {
		switch (currentValue) {
		case NAME:
			gem.setName(getXMLText(reader));
			break;
		case PRECIOUSNESS:
			gem.setPreciousnessType(PreciousnessType.valueOf(getXMLText(reader).toUpperCase()));
			break;
		case ORIGIN:
			gem.setOrigin(getXMLText(reader));
			break;
		case VISUALPARAMETERS:
			setVisualParameter(reader, gem.getVisualParameter());
			break;
		case VALUE:
			gem.setValue(Double.valueOf(getXMLText(reader)));
			break;
		case PRODUCTIONDATE:
			gem.setProductionDate(parseDate(getXMLText(reader)).getTime());
			break;
		default:
			break;
		}
	}

	private void setVisualParameter(XMLStreamReader reader, VisualParameter visualParameter) throws XMLStreamException {
		int type;
		GemEnum currentValue = null;
		while (reader.hasNext()) {
			type = reader.next();
			if (type == XMLStreamConstants.START_ELEMENT) {
				currentValue = GemEnum.valueOf(reader.getLocalName().toUpperCase());
				handleVisualParameterCurrentValue(currentValue, reader, visualParameter);
			}
			if (type == XMLStreamConstants.END_ELEMENT) {
				currentValue = GemEnum.valueOf(reader.getLocalName().toUpperCase());
				if (currentValue == GemEnum.VISUALPARAMETERS) {
					return;
				}
			}
		}
		throw new XMLStreamException("Unknown element in tag visualParameters");
	}

	private void handleVisualParameterCurrentValue(GemEnum currentValue, XMLStreamReader reader,
			VisualParameter visualParameter) throws XMLStreamException {
		switch (currentValue) {
		case COLOR:
			visualParameter.setGemColor(GemColor.valueOf(getXMLText(reader).toUpperCase()));
			break;
		case TRANSPARENCY:
			visualParameter.setTransparencyValue(Integer.valueOf(getXMLText(reader)));
			break;
		case FACETS:
			visualParameter.setFacetCount(Integer.valueOf(getXMLText(reader)));
			break;
		default:
			break;
		}
	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		return XMLStreamConstants.END_ELEMENT == reader.next() ? EMPTY_STRING : reader.getText();
	}
}
