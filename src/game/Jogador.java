package game;

public class Jogador {

	private int ponteiro = 0;
	private String color;
	private String Pizza;
	public Receita receita = new Receita();
	public boolean remocao;
	
	public boolean getRemocao(){
		return remocao;
	}
	
	public void setRemocao(boolean remocao){
		this.remocao = remocao;
	}
	
	public String getPizza() {
		return Pizza;
	}
	public void setPizza(String pizza) {
		this.Pizza = pizza;
	}
	
	public String getColor() {
		return color;
	}
	
	//Definir a cor de cada jogador
	public void setColor(int color) {
		if(color == 1)
			this.color = "1 (Azul)";
		if(color == 2)
			this.color = "2 (Vermelho)";
		if(color == 3)
			this.color = "3 (Verde)";
		if(color == 4)
			this.color = "4 (Amarelho)";
		if(color == 5)
			this.color = "5 (Roxo)";
	}
	
	public int getPosicao() {
		return ponteiro;
	}
	
	//Posição ou Ponteiro de cada Jogador
	public void setPosicao(int posicao) {
		if(posicao <= 36)
			this.ponteiro = posicao;
		else
			this.ponteiro = posicao-36;
	}
	
	//Definir a receita do Jogador adicionando na Lista
	public void escolhaPizza(int escolhaPizza){
		switch(escolhaPizza){
		case 1:
			receita.InserirPrimeiro("OVOS");
			receita.InserirPrimeiro("CALABREZA");
			receita.InserirPrimeiro("QUEIJO");
			receita.InserirPrimeiro("PRESUNTO");
			receita.InserirPrimeiro("CEBOLA");
			setPizza("Portuguesa");
			break;
		case 2:
			receita.InserirPrimeiro("BROCOLIS");
			receita.InserirPrimeiro("AZEITONA");
			receita.InserirPrimeiro("QUEIJO");
			receita.InserirPrimeiro("MILHO");
			receita.InserirPrimeiro("CEBOLA");
			setPizza("Vegetariana");
			break;
		case 3:
			receita.InserirPrimeiro("TOMATE");
			receita.InserirPrimeiro("AZEITONA");
			receita.InserirPrimeiro("QUEIJO");
			receita.InserirPrimeiro("CALABREZA");
			receita.InserirPrimeiro("CEBOLA");
			setPizza("Calabreza");
			break;
		case 4:
			receita.InserirPrimeiro("TOMATE");
			receita.InserirPrimeiro("FRANGO");
			receita.InserirPrimeiro("QUEIJO");
			receita.InserirPrimeiro("CATUPIRY");
			receita.InserirPrimeiro("CEBOLA");
			setPizza("Frango");
			break;
		case 5:
			receita.InserirPrimeiro("TOMATE");
			receita.InserirPrimeiro("PRESUNTO");
			receita.InserirPrimeiro("QUEIJO");
			receita.InserirPrimeiro("CATUPIRY");
			receita.InserirPrimeiro("CEBOLA");
			setPizza("Presunto");
			break;
		}
	}	
	
	//Remove toda lista e atualiza a receita novamente;
	public void PerdeTudo(){
		String pizza = getPizza();
		for(int i=0; i<5; i++)
			receita.removePrimeiro();
		receita.removido="";
		receita.removido2="";
		if(pizza.equals("Portuguesa"))
			escolhaPizza(1);
		if(pizza.equals("Vegetariana"))
			escolhaPizza(2);
		if(pizza.equals("Calabreza"))
			escolhaPizza(3);
		if(pizza.equals("Frango"))
			escolhaPizza(4);
		if(pizza.equals("Presunto"))
			escolhaPizza(5);
	}
}


