package game;

public class SorteAzar {

	private Carta topo = null;	
	
	public SorteAzar(){
		embaralharCarta();
	}
	
	public boolean estaVazia(){
		return topo == null;
	}
	
	public void empilha(String c){
		Carta novo = new Carta(c);
		if(estaVazia()){
			topo = novo;
		}else{
			novo.proximo = topo; //proximo é o anterior
			topo = novo;
		}
	}
	
	public String desempilha(){
		if(!estaVazia()){
			String temp = topo.cartas;
			topo = topo.proximo;
			return temp;
		}
		return null;
	}
	
	//embaralha aleatoriamente no total 20 cartas
	public void embaralharCarta(){
		int cont[] = new int[6];
		for(int i=0; i<20; i++){
			int num = (int)(Math.random()*4+1);
			switch(num){
				case 1:
					if(cont[0] < 6){
						empilha("Ganhe dois ingrediente de sua pizza (Sorte)");
						cont[0]++;
					}else{
						i--;
					}
					break;
				case 2:
					if(cont[1] < 6){
						empilha("Perca um ingrediente de sua pizza (Azar)");
						cont[1]++;
					}else{
						i--;
					}
					break;
				case 3:
					if(cont[2] < 6){
						empilha("Retire um ingrediente de um jogador aleatório (Sorte)");
						cont[2]++;
					}else{
						i--;
					}
					break;
				case 4:
					if(cont[3] < 6){
						empilha("Sua pizza queimou, perca todos os ingredientes (Azar)");
						cont[3]++;
					}else{
						i--;
					}
						break;
				}
			}
		}	

	//recebe o nome da carta e entrega o efeito
	public void efeitoCarta(Jogador j){
		String carta = desempilha();
		System.out.println("Sorte ou Azar: "+carta);
		if(carta.equals("Retire um ingrediente de um jogador aleatório (Sorte)")){
			j.setRemocao(true);
		}
		if(carta.equals("Perca um ingrediente de sua pizza (Azar)")){
			if(j.receita.tamanho != 5){
				if(j.receita.removido.length()!=0){
					j.receita.InserirPrimeiro(j.receita.removido);
					System.out.println("*Perdeu o ingrediente "+j.receita.removido+" de sua pizza");
					j.receita.removido = "";
				} else if(j.receita.removido2.length()!=0){
					j.receita.InserirPrimeiro(j.receita.removido2);
					System.out.println("*Perdeu o ingrediente "+j.receita.removido2+" de sua pizza");
					j.receita.removido2 = "";
				}
			}
		}
		if(carta.equals("Ganhe dois ingrediente de sua pizza (Sorte)")){
			j.receita.removePrimeiro();
			j.receita.removePrimeiro();
		}
		if(carta.equals("Sua pizza queimou, perca todos os ingredientes (Azar)")){
			j.PerdeTudo();
		}
	}
}