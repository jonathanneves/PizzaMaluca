package game;

//PILHA
public class Carta {

	public String cartas;
	public Carta proximo;
	
	public Carta(String c) {
		this.cartas = c;
		this.proximo = null;
	}
}
