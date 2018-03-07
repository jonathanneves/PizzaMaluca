package game;

//LISTA CIRCULAR
public class Casa {

	public String casa;
	public Casa anterior, proximo;
	
	public Casa(String casa) {
		this.casa = casa;
		this.anterior = null;
		this.proximo = null;
	}	
}
