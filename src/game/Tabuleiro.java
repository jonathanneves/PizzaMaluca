package game;

public class Tabuleiro {

	private Casa primeiro, ultimo, atual;
	public SorteAzar cards = new SorteAzar(); 
	int tamanho = 0;
	
	public Tabuleiro() {
		primeiro = null;
		ultimo = null;
		atual = null;
		montarTabuleiro();
	}
	
	public boolean estaVazio(){
		return primeiro == null;	//tamanho == 0
	}
	
	public void InserirPrimeiro(String casa){
		Casa novo = new Casa(casa);
		if(estaVazio()){
			novo.proximo = novo;			//circular
			novo.anterior = novo;			//circular
			primeiro = novo;
			ultimo = novo;
			atual = novo;	
		}else{
			novo.proximo = primeiro;   
			novo.anterior = ultimo;
			primeiro.anterior = novo;
			primeiro = novo;
			ultimo.proximo = primeiro;	//Circular
		}
		tamanho++;
	}
	
	public void InserirUltimo(String casa){
		Casa novo = new Casa(casa);
		if(estaVazio()){
			novo.proximo = novo;
			novo.anterior = novo;
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		}else{
			ultimo.proximo = novo;
			novo.anterior = ultimo;
			novo.proximo = primeiro;
			primeiro.anterior = novo;
			ultimo = novo;
		}	
		tamanho++;
	}
	
	//Procura a casa e retorna-a
	public String buscarCasa(int pos){
		atual = primeiro;
		for(int i=1; i<pos; i++){
			atual=atual.proximo;	
		}
		return atual.casa;
	}
	
	//Insere todas as casas
	public void montarTabuleiro(){
	
		InserirUltimo("Perde Tudo");
		InserirUltimo("Cebola");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Calabreza");
		InserirUltimo("Queijo");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Catupiry");
		InserirUltimo("Tomate");
		InserirUltimo("Ovos");
		InserirUltimo("Azeitona");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Presunto");
		InserirUltimo("Milho");
		InserirUltimo("Azeitona");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Catupiry");
		InserirUltimo("Tomate");
		InserirUltimo("Milho");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Brocolis");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Ovos");
		InserirUltimo("Cebola");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Calabreza");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Presunto");
		InserirUltimo("Sorte ou Azar");	
		InserirUltimo("Queijo");
		InserirUltimo("Azeitona");
		InserirUltimo("Sorte ou Azar");
		InserirUltimo("Brocolis");
		InserirUltimo("Azeitona");
		InserirUltimo("Sorte ou Azar");
	}
	

	
	//Pega a posição do jogador e verifica casa que ele se encontra
	public void VerificarCasa(Jogador j){
		String casa = buscarCasa(j.getPosicao());
			if(casa == "Perde Tudo")
				j.PerdeTudo();
			if(casa == "Sorte ou Azar")	
				cards.efeitoCarta(j);
			if(casa == "Cebola")
				j.receita.removeIngrediente("CEBOLA");
			if(casa == "Calabreza")
				j.receita.removeIngrediente("CALABREZA");
			if(casa == "Queijo")
				j.receita.removeIngrediente("QUEIJO");
			if(casa == "Catupiry")
				j.receita.removeIngrediente("CATUPIRY");
			if(casa == "Tomate")
				j.receita.removeIngrediente("TOMATE");
			if(casa == "Ovos")
				j.receita.removeIngrediente("OVOS");
			if(casa == "Azeitona")
				j.receita.removeIngrediente("AZEITONA");
			if(casa == "Presunto")
				j.receita.removeIngrediente("PRESUNTO");
			if(casa == "Milho")
				j.receita.removeIngrediente("MILHO");
			if(casa == "Brocolis")
				j.receita.removeIngrediente("BROCOLIS");
		}
	}
	
//conferido
