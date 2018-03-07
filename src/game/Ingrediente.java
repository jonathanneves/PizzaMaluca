package game;

//LISTA SIMPLES
public class Ingrediente {
	
	public String nome;
	public Ingrediente proximo;
	
	public Ingrediente(String nome) {
		this.nome = nome;
		this.proximo = null;
	}

}
