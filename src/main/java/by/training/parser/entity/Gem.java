package by.training.parser.entity;

import java.util.Date;

public class Gem {

	private String name;
	private PreciousnessType preciousnessType;
	private String origin;
	private final VisualParameter visualParameter;
	private double value;
	private Date productionDate;
	private String id;

	public Gem() {
		visualParameter = new VisualParameter();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PreciousnessType getPreciousnessType() {
		return preciousnessType;
	}

	public void setPreciousnessType(PreciousnessType preciousnessType) {
		this.preciousnessType = preciousnessType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VisualParameter getVisualParameter() {
		return visualParameter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((preciousnessType == null) ? 0 : preciousnessType.hashCode());
		result = prime * result + ((productionDate == null) ? 0 : productionDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((visualParameter == null) ? 0 : visualParameter.hashCode());
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
		Gem other = (Gem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (preciousnessType != other.preciousnessType)
			return false;
		if (productionDate == null) {
			if (other.productionDate != null)
				return false;
		} else if (!productionDate.equals(other.productionDate))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		if (visualParameter == null) {
			if (other.visualParameter != null)
				return false;
		} else if (!visualParameter.equals(other.visualParameter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gem [name=" + name + ", preciousnessType=" + preciousnessType + ", origin=" + origin
				+ ", visualParameter=" + visualParameter + ", value=" + value + ", productionDate=" + productionDate
				+ ", id=" + id + "]";
	}

}
