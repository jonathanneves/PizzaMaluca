package game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	static ArrayList<Jogador> jogadores = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// 	                   _              
//	                  (_)             
//	             _ __  _ __________ _ 
//	            | '_ \| |_  /_  / _` |
//	            | |_) | |/ / / / (_| |
//	            | .__/|_/___/___\__,_|
//	            | |                   
//	            |_|    
		
//			By: Jonathan Neves e Adriano Karas		
		
		
		//Inserir Casas e Empilhar Caras(Lista Circular - Pilha)
		Tabuleiro tabuleiro = new Tabuleiro();
				
		int numjogadores = 0;
		int escolhaPizza = 0;
		
		
		//Criando Numero de Jogadores;
		do{
			try{
				numjogadores = Integer.parseInt(JOptionPane.showInputDialog("Quantos jogadores? 2-5"));				
			}catch(Exception e){
				System.out.println("Número Inválido. Deve ser um número entre 2 e 5.");	
			}
		} while (numjogadores < 2 || numjogadores > 5);
		
		
		//Setando a receita de cada jogador;
		do{			
			try{
				for(int i=1; i<numjogadores+1; i++){
				escolhaPizza = Integer.parseInt(JOptionPane.showInputDialog("Escolha sua pizza jogador: "+i+"\n1)Portuguesa\n2)Vegetariana\n3)Calabresa\n4)Frango\n5)Presunto"));
				if(escolhaPizza < 1 || escolhaPizza > 5)
					throw new Exception();
				Jogador j = new Jogador();
				j.setColor(i);
				j.escolhaPizza(escolhaPizza);
				System.out.println("Jogador "+j.getColor()+" Escolheu a pizza de "+j.getPizza());
				jogadores.add(j);
				jogadores.get(i-1).receita.todosIngredientes();		//Imprimi os ingredientes que Faltam
				}
			}catch(Exception e){
				System.out.println("Escolha inválida. Deve ser um número entre 1 e 5");
			}
		} while (escolhaPizza < 1 || escolhaPizza > 5);
		
		System.out.println("");

		//Processando a rodada do Game
		int rodada = 1;
		int i;
		int random = -1;

				for(i=0; i<=numjogadores; i++){
					if(tabuleiro.cards.estaVazia())				//embaralhar 20 carta SorteAzar
						tabuleiro.cards.embaralharCarta();
					if(i>numjogadores-1){						//Contador de rodada
						rodada++;
						i=0;
					}
					int dado = (int)(Math.random()*6+1);
					jogadores.get(i).setPosicao(jogadores.get(i).getPosicao()+dado);
						System.out.println("Rodada: "+rodada);
						System.out.println("Turno do jogador "+jogadores.get(i).getColor());
						jogadores.get(i).receita.ingredienteRestante();		//Imprimi os ingredientes que Faltam
						System.out.println("Jogou o dado e caiu: "+dado);
						System.out.println("Avançar para a posição: "+(jogadores.get(i).getPosicao())+" - Casa: "+tabuleiro.buscarCasa(jogadores.get(i).getPosicao()));
					tabuleiro.VerificarCasa(jogadores.get(i));
					jogadores.get(i).receita.ingredienteRestante();		//Imprimi os ingredientes que Faltam
						
					//Condição para retirar ingrediente do proximo jogador		
					if(jogadores.get(i).getRemocao()){											
						jogadores.get(i).setRemocao(false);
							do{
								random = (int)(Math.random()*numjogadores);	
							}while(random==i);
								if(jogadores.get(random).receita.tamanho != 5){
									if(jogadores.get(random).receita.removido.length()!=0){
										jogadores.get(random).receita.InserirPrimeiro(jogadores.get(random).receita.removido);	
										System.out.println("*Jogador "+jogadores.get(random).getColor()+" perdeu um ingrediente ("+jogadores.get(random).receita.removido+")");
										jogadores.get(random).receita.removido="";	
									}else if(jogadores.get(random).receita.removido.length()!=0){
										jogadores.get(random).receita.InserirPrimeiro(jogadores.get(random).receita.removido2);	
										System.out.println("*Jogador "+jogadores.get(random).getColor()+" perdeu um ingrediente  ("+jogadores.get(random).receita.removido2+")");
										jogadores.get(random).receita.removido2="";	
									}else{
										System.out.println("*Jogador "+jogadores.get(random).getColor()+", não possui nenhum ingrediente para ser retirado.");
									}
								}else{
									System.out.println("*Jogador "+jogadores.get(random).getColor()+", não possui nenhum ingrediente para ser retirado.");
								}
					}
					
					System.out.println("");
					
					//Vitoria se lista esta Vazio
					if(jogadores.get(i).receita.estaVazio()){
						System.out.println("JOGADOR "+jogadores.get(i).getColor()+ " VENCEU!!!");
						System.out.println("Completou sua pizza de "+jogadores.get(i).getPizza()+". Bon Appétit!!");
						JOptionPane.showMessageDialog(null, "JOGADOR "+jogadores.get(i).getColor()+ " VENCEU!!!\n"+"Completou sua pizza "+jogadores.get(i).getPizza()+". Bon Appétit!!");		
						break;
					}
				}	
	}
}
	

