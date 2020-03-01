package by.training.parser.builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.training.parser.entity.Gem;
import by.training.parser.exception.XMLParserException;

public abstract class GemBuilder {

	private static final Logger LOGGER = Logger.getLogger(GemBuilder.class);
	protected static final int FIRST_ITEM_INDEX = 0;
	protected List<Gem> gemList;

	public GemBuilder() {
		this.gemList = new ArrayList<>();
	}

	public abstract void buildGemList(InputStream sourceFile) throws XMLParserException;

	public List<Gem> getGemList() {
		return gemList;
	}

	protected void closeInputStream(InputStream stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			LOGGER.warn("Cannot close input stream");
		}
	}
}
