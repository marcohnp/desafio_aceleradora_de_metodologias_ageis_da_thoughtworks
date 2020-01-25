package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem (OrderItem item) {
		items.add(item);
	}
	
	public void removeItem (OrderItem item) {
		items.remove(item);
	}

	public double discount (Integer id) {
		double discount = 0;
		for (OrderItem item : items) {
			if(item.getClient().getId() == id) {
				discount = item.subTotalTax() - item.discount(); 
			}
		}	
		return discount;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (OrderItem item : items) {
		sb.append("Cliente: ");
		sb.append(item.getClient().toString() + "\n");
		sb.append("ICMS: R$" + String.format("%.2f", item.getIcms()));
		sb.append("; IPI: R$" + String.format("%.2f", item.getIpi()));
		sb.append("; PIS: R$" + String.format("%.2f", item.getPis()));
		sb.append("; CONFINS: R$" + String.format("%.2f", item.getConfins()));
		sb.append("; TOTAL: R$" + String.format("%.2f", item.subTotalTax()) +"\n\n");
		}
		return sb.toString();
	}

	public String toString2(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%.2f", discount(id)));
		return sb.toString();
	}
	
}	
