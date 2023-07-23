package ECommerceAPITest;

import java.util.List;

public class CreateOrder_Payload {

	private List<Orders> orders;

	public CreateOrder_Payload() {

	}

	public CreateOrder_Payload(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
