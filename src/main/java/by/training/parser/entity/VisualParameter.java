package by.training.parser.entity;

public class VisualParameter {

	private GemColor gemColor;
	private int transparencyValue;
	private int facetCount;

	public GemColor getGemColor() {
		return gemColor;
	}

	public void setGemColor(GemColor gemColor) {
		this.gemColor = gemColor;
	}

	public int getTransparencyValue() {
		return transparencyValue;
	}

	public void setTransparencyValue(int transparencyValue) {
		this.transparencyValue = transparencyValue;
	}

	public int getFacetCount() {
		return facetCount;
	}

	public void setFacetCount(int facetCount) {
		this.facetCount = facetCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facetCount;
		result = prime * result + ((gemColor == null) ? 0 : gemColor.hashCode());
		result = prime * result + transparencyValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisualParameter other = (VisualParameter) obj;
		if (facetCount != other.facetCount)
			return false;
		if (gemColor != other.gemColor)
			return false;
		if (transparencyValue != other.transparencyValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisualParameter [gemColor=" + gemColor + ", transparencyValue=" + transparencyValue + ", facetCount="
				+ facetCount + "]";
	}
}
