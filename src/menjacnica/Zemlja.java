package menjacnica;


public class Zemlja {

	String alpha3;
	 String currencyId;
	 String currencyName;
	String currencySymbol;
	 String id;
	 String name;
	public String getAlpha3() {
		return alpha3;
	}
	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Zemlja [alpha3=" + alpha3 + ", currencyId=" + currencyId + ", currencyName=" + currencyName
				+ ", currencySymbol=" + currencySymbol + ", id=" + id + ", name=" + name + "]";
	}
	 
}
