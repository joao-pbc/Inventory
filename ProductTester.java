package inventory;

import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		Product produtos[] = {};
		Boolean i=false;
		Scanner scan = new Scanner(System.in);
	
		
		for(Boolean m = false; m==false;) {
			
			do {
				i = false;
				System.out.println(
						"1. Exibir Inventário\r\n"
						+ "2. Adicionar Estoque\r\n"
						+ "3. Modificar quantidade de produto \r\n"
						+ "4. Mudar Status do Produto\r\n"
						+ "0. Sair\r\n"
						+ "Insira uma opção de menu:"); 
				switch(getMenuOption(scan)){
				case 0:
					System.out.println("Encerrando programa");
					m = true;
					break;
				case 1:
					try {
						if(produtos.length == 0) {
							throw new Exception();
						}
						displayInventory(produtos);
						i = true;
					} catch(Exception e) {
						System.out.println("ainda não foram adicionados produtos!");
					}
					break;
				case 2:
					produtos = new Product[getNumProducts(scan)];
					addToInventory(produtos, scan);
					i = true;
					break;
				case 3:
					for(Boolean l = false;l==false;) {
						try {
							if (produtos.length == 0) {
								throw new Exception("ainda não foram adicionados produtos!");
							}
							System.out.println("\nEscolha um desses produtos:\n");
							for (Product p : produtos) {
								System.out.println(p.getNumero() + " " + p.getName());
							}

							int numeroProdutoChange = getProductNumber(produtos, scan);

							System.out.println("Escreva a quantidade a ser inserida");

							int qty = scan.nextInt();

							produtos[numeroProdutoChange-1].changeToQuantity(qty);
							
							l = true;
							break;
						} catch (Exception e) {
							System.out.println("Digite novamente");
							scan.nextLine();
						}
						
					}
					
					
					break;
					
				case 4:
					System.out.println("\nEscolha um desses produtos:\n");
					
					for(Product p : produtos) {
						System.out.println(p.getNumero() + " " + p.getName());
						
						
					}
					for(Boolean l = false;l==false;) {
						try {
							if (produtos.length == 0) {
								l = true;
								throw new Exception("ainda não foram adicionados produtos!");
								
							}
							int nextStatus = 0;
							int numeroProdutoStatus = getProductNumber(produtos, scan);
							
							System.out.println(
									"\n Escolha o status: \n"
									+"1 - Ativo \n"
									+"2 - Desativado \n");
							nextStatus = scan.nextInt();
							if((nextStatus < 1)||(nextStatus>2)) {
								throw new Exception();
							} else {
								switch(nextStatus) {
								case 1:
									produtos[numeroProdutoStatus-1].setAtivo(true);
									l = true;
									break;
								case 2:
									produtos[numeroProdutoStatus-1].setAtivo(false);
									l = true;
									break;
								}
							}
							
						} catch(Exception e){
							System.out.println("Digite novamente");
							scan.nextLine();
							
						}
					}
					
				}
			}while(i == false);
		}
		
		
		scan.close();
		return;
		
	}
	
	
	public static void displayInventory(Product[] produtos) {
		// Displays the products

		for (Product p : produtos) {
			System.out.println(p.toString());

		}
	}
	
	public static void addToInventory(Product[] produtos, Scanner scan) {
		// Catches missInputs and reads the values of the products
		
		int tempQty;
		double temPrice;
		String tempName;
		
		for (int k = 0; k  < (produtos.length); k++) {
			System.out.println("PRODUTO " + (k+1) + "\n");

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

							System.out.println("  digite o preco do produto");
							temPrice = scan.nextDouble();
							
							j = true;
							i = true;
							
							produtos[k] = new Product(tempName, tempQty, temPrice);
							produtos[k].numero = k+1;

						} catch (Exception f) {
							System.out.println("\n \n \n Insira um número válido \n");
							scan.nextLine();

						}
					}
				}
			}
		} 
	}

	public static int getNumProducts(Scanner scan) {
		// Catches missInputs and reads the number of products to be added
		
		int maxSize = -1;
		
		for (Boolean i = false; i == false;) {
			try {
				System.out.println("Insira o número de produtos que gostaria de adicionar\r\n"
						+ " Insira 0 (zero) se não quiser adicionar produtos:");

				maxSize = scan.nextInt();

				if (maxSize < 0) {
					throw new Exception("Valor incorreto inserido");

				} else if (maxSize == 0) {
					System.out.println("Não há produtos a serem inseridos");
					return 0;

				} else {
					i = true;
				}

			} catch (Exception e) {
				System.out.println("valor inválido! tente novamente");

				scan.nextLine();

			}
		}
		return maxSize;
	}

	public static int getMenuOption(Scanner scan) {
		int option = -1;
		for(Boolean i = false; i==false;) {
			try {
				option = scan.nextInt();
				if ((option < 0) || (option > 4)) {
					throw new Exception("\nNenhuma opção selecionada");
				} else {
					i = true ;
				}
			} catch (Exception e) {
				System.out.println("\nDigite um valor válido");
				scan.nextLine();
			}
		}
		return option;
	}

	public static int getProductNumber(Product[] produtos, Scanner scan) {
		int option = -1;
		for(Boolean i = false;i==false;) {
			try {
				option = scan.nextInt();
				if((option > produtos.length)||(option < 0)) {
					throw new Exception();
				}
				i = true;
			} catch(Exception e) {
				System.out.println("Valor inválido!");
				scan.nextLine();
			}
		}
		return produtos[option-1].numero;
	}

}
