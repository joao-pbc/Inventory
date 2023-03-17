package inventory;

import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		executeMenu(scan);
		
		scan.close();
		
		System.out.println("\n Programa encerrado!");
		
		return;
		
	}
	
	public static void executeMenu(Scanner scan) {
		Boolean i=false;
		int x = 0;
		int emptyArray = -1;
		
		Product produtos[] = {};
		Product[] newArray = {};
		
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
					
					return;
					
				case 1:
					try {
							emptyArray = getEmptyArray(produtos, newArray);
							
							switch(emptyArray)  {
							case 1:
								throw new Exception();
								
							case 2:
								displayInventory(produtos);
								
								break;
								
							case 3: 
								displayInventory(newArray);
								
								break;
							}
			
						i = true;
						
					} catch(Exception e) {
						System.out.println("ainda não foram adicionados produtos!");
						
					}
					break;
					
				case 2:
					
					int numToAdd= getNumProducts(scan);
					
					emptyArray = getEmptyArray(produtos, newArray);
						
					switch(emptyArray)  {
					case 1:
						produtos = new Product[numToAdd];
						
						addToInventory(produtos, scan, numToAdd);
						
						break;
						
					case 2:
						newArray = new Product[numToAdd + produtos.length];
						
						x = newArray.length - 1;
						for(Product p : produtos) {
							newArray[x] = p;
							p = null;
							x--;
						}
						addToInventory(newArray, scan, numToAdd);
						
						break;
						
					case 3: 
						produtos = new Product[numToAdd + newArray.length];
						
						x = produtos.length - 1;
						
						for(Product p : newArray) {
							produtos[x] = p;
							
							p = null;
							
							x--;
							
						}
						addToInventory(produtos, scan, numToAdd);
						
						break;
						
					}
					i = true;
					
					break;
					
				
				case 3:
					for(Boolean l = false;l==false;) {
						try {
							emptyArray = getEmptyArray(produtos, newArray);
							
							switch(emptyArray) {
							case 1:
								throw new Exception("ainda não foram adicionados produtos!");
								
							case 2: 
								System.out.println("\nEscolha um desses produtos:\n");
								
								for (Product p : produtos) {
									System.out.println(p.getNumero() + " " + p.getName());
									
									int numeroProdutoChange = getProductNumber(produtos, scan);
									if (numeroProdutoChange == -1) {
										break;
									}

									System.out.println("Escreva a quantidade a ser inserida");

									int qty = scan.nextInt();

									produtos[numeroProdutoChange-1].changeToQuantity(qty);
									
									l = true;
									break;
								}
							case 3:
								System.out.println("\nEscolha um desses produtos:\n");
								
								for (Product p : newArray) {
									System.out.println(p.getNumero() + " " + p.getName());
								}
								int numeroProdutoChange = getProductNumber(newArray, scan);
								if (numeroProdutoChange == -1) {
									break;
								}

								System.out.println("Escreva a quantidade a ser inserida");

								int qty = scan.nextInt();

								newArray[numeroProdutoChange-1].changeToQuantity(qty);
								
								l = true;
								break;
							}
						} catch (Exception e) {
							System.out.println("Digite novamente");
							scan.nextLine();
						}
						
					}
					
					
					break;
					
				case 4:
					for(Boolean l = false;l==false;) {
						try {
							int nextStatus = 0;
							int numeroProdutoStatus;
							emptyArray = getEmptyArray(produtos, newArray);
							switch (emptyArray) {
							case 1:
								throw new Exception("ainda não foram adicionados produtos!");
								
							case 2:
								System.out.println("\nEscolha um desses produtos:\n");

								for (Product p : produtos) {
									System.out.println(p.getNumero() + " " + p.getName());

								}
								numeroProdutoStatus = getProductNumber(produtos, scan);

								System.out.println("\n Escolha o status: \n" + "1 - Ativo \n" + "2 - Desativado \n");
								nextStatus = scan.nextInt();
								
								if ((nextStatus < 1) || (nextStatus > 2)) {
									throw new Exception();
									
								} else {
									switch (nextStatus) {
									case 1:
										produtos[numeroProdutoStatus - 1].setAtivo(true);
										
										l = true;
										
										break;
										
									case 2:
										produtos[numeroProdutoStatus - 1].setAtivo(false);
										
										l = true;
										
										break;
										
									}
								}
							case 3:
								
								
								System.out.println("\nEscolha um destes produtos:\n");
								
								for(Product p : newArray) {
									System.out.println(p.getNumero() + " " + p.getName());
									
								}
								
								numeroProdutoStatus = getProductNumber(newArray, scan);
								
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
										newArray[numeroProdutoStatus-1].setAtivo(true);
										l = true;
										
										break;
										
									case 2:
										newArray[numeroProdutoStatus-1].setAtivo(false);
										l = true;
										
										break;
										
									}
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
	}
	
	public static void displayInventory(Product[] produtos) {
		// Displays the products

		for (Product p : produtos) {
			System.out.println(p.toString());

		}
	}
	
	public static void addToInventory(Product[] array, Scanner scan, int numToAdd) {
		// Catches missInputs and reads the values of the products
		int tempQty, tempClassification, tempAlbmMusicNmbr, type = 0;
		double temPrice, tempDuration;
		String tempName, tempStudio, tempArtist, tempSeal;
		
		
		for (Boolean n = false; n == false;) {
			try {
				System.out.println("\nSelecione um: \n" + "1. CD\n" + "2. DVD\n");

				type = scan.nextInt();

				if ((type > 2) && (type < 1)) {
					throw new Exception();

				} else {

					n = true;

				}
				
			}catch(Exception e) {
				System.out.println("Digite um valor dentro das opcoes");
				scan.nextLine();
			}
			
		}
		
		for (int k = 0; k  < (numToAdd); k++) {
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
							
							if(type == 1) {
								System.out.println("  digite a classificacao do produto");
								tempClassification = scan.nextInt();
								
								System.out.println("  digite a duracao do produto");
								tempDuration = scan.nextDouble();

								System.out.println("  digite o Estudio do produto");
								tempStudio = scan.next();
								

								j = true;
								i = true;
								
								array[k] = new Cd(tempName, tempQty, temPrice, tempDuration, tempClassification, tempStudio);
								array[k].numero = Product.getTotalOfProducts()+1;
								Product.setTotalOfProducts(Product.getTotalOfProducts()+1);;
								
							} else {
								System.out.println("  digite o numero da musica no album do produto");
								tempAlbmMusicNmbr = scan.nextInt();
								
								System.out.println("  digite o artista do produto");
								tempArtist = scan.next();

								System.out.println("  digite o selo do produto");
								tempSeal = scan.next();
								
								System.out.println("  digite o preco do produto");
								temPrice = scan.nextDouble();
								
								j = true;
								i = true;
								
								array[k] = new Dvd(tempName, tempQty, temPrice, tempArtist, tempSeal, tempAlbmMusicNmbr);
								array[k].numero = Product.getTotalOfProducts()+1;
								Product.setTotalOfProducts(Product.getTotalOfProducts()+1);;
							}
							
							
						

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

	public static int getProductNumber(Product[] array, Scanner scan) {

		int option = -1;
		for(Boolean i = false;i==false;) {
			try {
				option = scan.nextInt();
				
				if((option > array.length)||(option < 0)) {
					throw new Exception();
					
				}else if(array[option-1].ativo==false){
					System.out.println("\nlinha descontinuada!\n");
					return -1;
				}
				i = true;
				
			} catch(Exception e) {
				System.out.println("Valor inválido");
				scan.nextLine();
			}
		}
		return array[option-1].numero;
	}
	public static int getEmptyArray(Product[] produtos, Product[] newArray){
		
		if(produtos.length == 0) {
			return 1;
			
		} else if(newArray.length <  produtos.length){
			return 2;
			
		}  else {
			return 3;
		}
			
		
	}
}
