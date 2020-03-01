package by.training.parser.factory;

import by.training.parser.builder.DOMGemBuilder;
import by.training.parser.builder.SAXGemBuilder;
import by.training.parser.builder.StAXGemBuilder;

public class GemBuilderFactory {

	private final DOMGemBuilder domGemBuilder = new DOMGemBuilder();
	private final SAXGemBuilder saxGemBuilder = new SAXGemBuilder();
	private final StAXGemBuilder stAXGemBuilder = new StAXGemBuilder();

	private GemBuilderFactory() {
	}

	private static class GemBuilderFactoryInstance {
		private static final GemBuilderFactory INSTANCE = new GemBuilderFactory();
	}

	public static GemBuilderFactory getInstance() {
		return GemBuilderFactoryInstance.INSTANCE;
	}

	public DOMGemBuilder getDomGemBuilder() {
		return domGemBuilder;
	}

	public SAXGemBuilder getSaxGemBuilder() {
		return saxGemBuilder;
	}

	public StAXGemBuilder getStAXGemBuilder() {
		return stAXGemBuilder;
	}
}
