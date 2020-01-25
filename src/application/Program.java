package application;

//import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;

public class Program {

	public static void main(String[] args) {
		//Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double totalTax = 0, totalGoods = 0, totalGrand = 0;
		
		System.out.print("Entre com o número de pedidos que deseja fazer: ");
		int request = sc.nextInt();
		
		Order order = new Order();
		
		for (int i = 0; i < request; i++) {
			System.out.print("Cliente: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("ID do Cliente: ");
			int id = sc.nextInt();
			Client client = new Client(name, id);
			
			
			System.out.print("Quantidade de Energéticos Accelerator: ");
			int quantity = sc.nextInt();
			System.out.print("Valor por unidade: R$ ");
			double price = sc.nextDouble();
			
			OrderItem orderItem = new OrderItem(quantity, price, client);
			order.addItem(orderItem);
			
			totalTax += orderItem.totalTax();
			totalGoods += orderItem.subTotal();
			totalGrand += orderItem.subTotalTax();
			
			System.out.println();
						
		}	

		System.out.println(order);

		System.out.println("Total Impostos: R$" + String.format("%.2f", totalTax));
		System.out.println("Total Mercadorias: R$" +String.format("%.2f", totalGoods));
		System.out.println("Total Geral: R$" + String.format("%.2f", totalGrand));
		
		System.out.println();
		System.out.print("Você deseja aplicar desconto aos pedidos?(S/N)");
		char answer = sc.next().charAt(0);
		System.out.println();
		
		if (answer == 'S' | answer == 's') {
			int i = 0, j = 0;
			do {
				while (i == 0) {
				System.out.print("Qual o ID do cliente que deseja aplicar desconto?");
				int idClient = sc.nextInt();	
					for (OrderItem obj : order.getItems()) {
						if (idClient == obj.getClient().getId()) {
							System.out.print("Entre com a porcentagem de desconto: ");
							double percent = sc.nextDouble();
							obj.setPercentage(percent);
							System.out.println();
							System.out.println(obj.getClient().toString());
							System.out.println("Total com desconto: " + order.toString2(idClient));
							i++;
							j = 0;
						}
						else {
							j++;
						}
					}
					if (j > 0 && i == 0) {
						System.out.println("ID não existe!");
						j = 0;
					}
				}
				System.out.println();
				System.out.print("Deseja aplicar desconto em mais algum pedido?(S/N)");
				answer = sc.next().charAt(0);
				i = 0;
				System.out.println();
			} while (answer == 'S' | answer == 's');	
		}		
		
		System.out.println();
		System.out.println("Fim da operação!");
		
		
		sc.close();
	}

}

