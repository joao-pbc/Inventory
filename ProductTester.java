package inventory;

import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		int tempNumber, tempQty, maxSize = -1;
		double temPrice;
		String tempName;
		Scanner scan = new Scanner(System.in);

		// Catches missInputs and reads the number of products to be added
		for (Boolean i = false; i == false;) {
			try {
				System.out.println("Insira o número de produtos que gostaria de adicionar\r\n"
						+ " Insira 0 (zero) se não quiser adicionar produtos:");

				maxSize = scan.nextInt();

				if (maxSize < 0) {
					scan.nextLine();

					throw new Exception("Valor incorreto inserido");

				} else if (maxSize == 0) {
					System.out.println("Não há produtos a serem inseridos");

					return;

				} else {
					i = true;
				}

			} catch (Exception e) {
				System.out.println("valor inválido! tente novamente");

				scan.nextLine();

			}
		}

		// Catches missInputs and reads the values of the products
		Product produtos[] = new Product[maxSize];

		for (int k = 0; k < (maxSize); k++) {
			System.out.println("PRODUTO " + (k + 1) + "\n");

			System.out.println("  digite o nome do produto");

			for (Boolean i = false; i == false;) {
				tempName = scan.next();

				try {
					Double.parseDouble(tempName);
					
					System.out.println("  digite um nome válido");

				} catch (Exception e) {
					for (Boolean j = false; j == false;) {

						try {
							System.out.println("  digite a quantidade do produto");
							tempQty = scan.nextInt();

							System.out.println("  digite o numero do produto");
							tempNumber = scan.nextInt();

							System.out.println("  digite o preco do produto");
							temPrice = scan.nextDouble();
							
							j = true;
							
							produtos[k] = new Product(tempName, tempQty, tempNumber, temPrice);

						} catch (Exception f) {
							System.out.println("\n \n \n Insira um número válido \n");
							scan.nextLine();

						}
					}
				}
				i = true;
			}
		}
		scan.close();

		// Displays the products
		for (Product p : produtos) {
			System.out.println(p.toString());
		}
	}
}
