package entities;

public class OrderItem {
	
	private final double icms = 0.18;
	private final double ipi = 0.04;
	private final double pis = 0.0186;
	private final double confins = 0.0854;
	private int quantity;
	private double price;
	private double percentage;
	
	private Client client;
	
	
	
	public OrderItem(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItem(int quantity, double price, Client client) {
		this.quantity = quantity;
		this.price = price;
		this.client = client;
	}
	
	
	public OrderItem(double percentage) {
		this.percentage = percentage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Double subTotal() {
		return quantity * price;
	}
	
	
	
	public double getIcms() {
		return subTotal() * icms;
	}
	
	public double getIpi() {
		return subTotal() * ipi;
	}
	
	public double getPis() {
		return subTotal() * pis;
	}
	
	public double getConfins() {
		return subTotal() * confins;
	}
	
	public double subTotalTax() {
		return subTotal() + getIcms() + getIpi() + getPis() + getConfins();
	}
	
		
	public double totalTax() {
		return getIcms() + getIpi() + getPis() + getConfins();
	}
	
	public double discount () {
		return subTotalTax() * percentage / 100; 
	}



}
