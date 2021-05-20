package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}
	
	

}
