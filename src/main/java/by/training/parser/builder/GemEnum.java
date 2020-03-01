package by.training.parser.builder;

public enum GemEnum {

	GEMS("gems"), GEM("gem"), ID("id"), NAME("name"), PRECIOUSNESS("preciousness"), ORIGIN("origin"), VALUE("value"),
	VISUALPARAMETERS("visualParameters"), COLOR("color"), TRANSPARENCY("transparency"), FACETS("facets"),
	PRODUCTIONDATE("productionDate");

	private GemEnum(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}
}
