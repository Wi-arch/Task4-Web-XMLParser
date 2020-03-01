package by.training.parser.builder;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import static javax.xml.bind.DatatypeConverter.parseDate;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.training.parser.entity.Gem;
import by.training.parser.entity.GemColor;
import by.training.parser.entity.PreciousnessType;
import by.training.parser.entity.VisualParameter;
import by.training.parser.exception.XMLParserException;

public class DOMGemBuilder extends GemBuilder {

	private static final Logger LOGGER = Logger.getLogger(DOMGemBuilder.class);
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder docBuilder;

	public DOMGemBuilder() {
		try {
			factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			LOGGER.error("Parser configuration error", e);
		}
	}

	public void buildGemList(InputStream sourceFile) throws XMLParserException {
		gemList.clear();
		try {
			Document document = docBuilder.parse(sourceFile);
			Element root = document.getDocumentElement();
			NodeList gemsList = root.getElementsByTagName(GemEnum.GEM.getValue());
			for (int i = 0; i < gemsList.getLength(); i++) {
				Element gemElement = (Element) gemsList.item(i);
				gemList.add(buildGem(gemElement));
			}
		} catch (IOException e) {
			LOGGER.warn("File error", e);
			throw new XMLParserException("File error", e);
		} catch (SAXException e) {
			LOGGER.warn("Parsing failure", e);
			throw new XMLParserException("Parsing failure", e);
		} finally {
			closeInputStream(sourceFile);
		}
	}

	private Gem buildGem(Element gemElement) {
		Gem gem = new Gem();
		gem.setId(gemElement.getAttribute(GemEnum.ID.getValue()));
		gem.setName(getElementContent(gemElement, GemEnum.NAME.getValue()));
		String preciousnessType = getElementContent(gemElement, GemEnum.PRECIOUSNESS.getValue());
		gem.setPreciousnessType(PreciousnessType.valueOf(preciousnessType.toUpperCase()));
		gem.setOrigin(getElementContent(gemElement, GemEnum.ORIGIN.getValue()));
		VisualParameter visualParameter = gem.getVisualParameter();
		Element visualElement = (Element) gemElement.getElementsByTagName(GemEnum.VISUALPARAMETERS.getValue()).item(FIRST_ITEM_INDEX);
		String gemColor = getElementContent(visualElement, GemEnum.COLOR.getValue());
		visualParameter.setGemColor(GemColor.valueOf(gemColor.toUpperCase()));
		visualParameter.setTransparencyValue(Integer.valueOf(getElementContent(visualElement, GemEnum.TRANSPARENCY.getValue())));
		visualParameter.setFacetCount(Integer.valueOf(getElementContent(visualElement, GemEnum.FACETS.getValue())));
		gem.setValue(Double.parseDouble(getElementContent(gemElement, GemEnum.VALUE.getValue())));
		gem.setProductionDate(parseDate(getElementContent(gemElement, GemEnum.PRODUCTIONDATE.getValue())).getTime());
		return gem;
	}

	private static String getElementContent(Element element, String elementName) {
		NodeList nodeList = element.getElementsByTagName(elementName);
		return nodeList.item(FIRST_ITEM_INDEX).getTextContent();
	}
}
