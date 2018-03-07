package game;

import java.util.Arrays;

public class Receita {

	private Ingrediente primeiro, ultimo, atual;
	public int tamanho;
	public String removido = "";
	public String removido2 = "";
	
	public Receita() {
		primeiro = null;
		ultimo = null;
		atual = null;
		tamanho = 0;
	}

	public boolean estaVazio(){
		return tamanho<=0;  
	}

	public int tamanho() {
		return tamanho;
	}

	public void InserirPrimeiro(String nome){
		if(!nome.equals("")){
			Ingrediente novo = new Ingrediente(nome);
			if(estaVazio()){
				primeiro = novo;
				ultimo = novo;
				atual = novo;
			}else{
				novo.proximo = primeiro;
				primeiro = novo;
			}
			tamanho++;
		}
	}
	
	public void removePrimeiro(){
		if(!estaVazio()){
				if(removido.length()==0)
					removido = primeiro.nome;
				else
					removido2 = primeiro.nome;
			primeiro = primeiro.proximo;
			tamanho--;
		}
	}
	
	public void MoveParaPos(int pos){
		atual = primeiro;
		for(int i=0; i<pos; i++){
			atual=atual.proximo;		
		}	
	}

	//remove ingrediente especifico
	public void removeIngrediente(String ing){
		if(!estaVazio()){
			Ingrediente temp;
			int pos = buscarIngrediente(ing);
			if(pos == 0){
					if(removido.length()==0)
						removido = ing;
					else
						removido2 = ing;
				primeiro = primeiro.proximo;
				tamanho--;
			}else if(pos>-1){
				temp = atual.proximo;
				if(removido.length()>0)
					removido2 = ing;
				else
					removido = ing;
				MoveParaPos(pos-1);
				atual.proximo = temp;
				tamanho--;
			}else{
				System.out.println("Não existe o ingrediente "+ing+" na receita atual!");
			}
		}
	}

	
	public void todosIngredientes(){
		atual = primeiro;
		System.out.print("Ingredientes: ");
		for(int i=0; i<tamanho; i++){
			System.out.print(atual.nome+" | ");
			atual=atual.proximo;
		}	
		System.out.println("");
	}
	
	public void ingredienteRestante(){
		atual = primeiro;
		System.out.print("Ingredientes Restantes: ");
		for(int i=0; i<tamanho; i++){
			System.out.print(atual.nome+" | ");
			atual=atual.proximo;
		}	
		System.out.println("");
	}

	public int buscarIngrediente(String etapa){
		int cont = 0;
		atual=primeiro;
		
		while(atual!=null && !atual.nome.equals(etapa)){
			atual=atual.proximo;
			cont++;
		}
		
		if(atual!=null)
			return cont;
		return -1;
	}
	 
}
