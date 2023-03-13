package inventory;

public class Product {
	//declaring variables
	String name;
	int quantidade, numero;
	double valor;
	boolean  ativo = true;
	
	//empty constructor
	public Product() {

	}
	
	//constructor with parameters
	public Product(String name, int quantidade, int numero, double valor) {
		this.name = name;
		this.quantidade = quantidade;
		this.valor = valor;
		this.numero = numero;
	}

	//Setter and Getter for variable name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//Setter and Getter for variable quantidade
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	//Setter and Getter for variable numero
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	//Setter and Getter for variable valor

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	//Setter and Getter for variable ativo
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	//toString to display info about each object
	public String toString() {
		String status = (ativo == true)? "Ativo" : "Desativado";
		return "Nome do item: " + name + "\n" + "quantidade: " +  quantidade + "\n" + "numero do item: " + numero + "\n" + "valor do item: " + valor + "\n"
				+ "Status: " + status + "\n" + "valor total: " + price() + "\n";
	}

	//This method returns the total value (quantity * price)
	public double price() {
		return (double)quantidade*valor;
	}
}
