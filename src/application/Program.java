package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next()); //.parse transformará a String recebida em Date
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("\nEnter order data:");
		System.out.println("Status: ");
		//.valueOf converte o que for recebido em String para o valor correspondente definido no OrderStatus
		OrderStatus status = OrderStatus.valueOf(sc.next()); 
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this item? ");
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			System.out.println("Enter #" + (i+1) + " item data: ");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem oi = new OrderItem(quantity, productPrice, product);
			
			order.addItem(oi);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
		
	}

}
