# DESAFIO: Pizza Maluca
Jogo de Tabuleiro utilizando Estrutura de Dados.

## Objetivo do jogo
Reunir os ingredientes necessários para montar uma pizza de um determinado sabor.
**Nro de jogadores:** de 2 a 5
**Como funciona o jogo:** O tabuleiro é formado por um círculo subdividido em diversas partes. Cada parte é nomeada com um dos ingredientes da pizza, alguma punição ou algum prêmio ao jogador. Veja uma apresentação do jogo em https://www.youtube.com/watch?v=IKp5-C26h5M
**Regras:** http://www.ilhadotabuleiro.com.br/jogos/pizzaria-maluca/imagem/20374
https://www.youtube.com/watch?v=ibuUytE75xI
https://www.youtube.com/watch?v=_JIhMWOPFbA


###### Elementos do jogo: 
Elemento tipo pizza (para o jogador escolher qual vai montar):  Montar 5 pizzas com 5 ingredientes cada. 
Elemento tipo ingrediente: (a cada rodada o jogador pode conquistar mais um ingrediente para a sua pizza. Verificar no tabuleiro os ingredientes disponíveis.
Elemento tipo sorte ou azar: caso o jogador pare o seu peão na parte indicando sorte ou azar, o mesmo vira uma ficha a qual contém um prêmio ou uma punição.
Funcionamento do jogo: todos os jogadores iniciam em uma posição do tabuleiro com um peão. A cada rodada, os jogadores jogam o dado e seguem adiante n casas no tabuleiro, de acordo com o número indicado pelo dado e recebe o ingrediente, a punição ou o prêmio (retirando a ficha sorte ou azar).

###### Como implementar o jogo utilizando-se de TADs:
Obs.: Todos os elementos devem utilizar-se de alocação dinâmica de memória.
O dado deve ser um número entre 1 e 6 sorteado aleatoriamente, utilizando-se de função randômica. 
Tabuleiro: implementar uma lista circular duplamente encadeada contendo sequencialmente todas as posições do tabuleiro. Todos os jogadores iniciam no início da lista. Obs.: a lista deve ter um ponteiro para cada jogador (para marcar a posição atual do jogador). Abaixo seguem todas as posições do tabuleiro, iniciando do primeiro elemento da primeira fila, seguindo-se no sentido horizontal até o último elemento da fila (1-perde tudo, 2- cebola..., 35- sorte ou azar)
INÍCIO ->
PERDE TUDO	CEBOLA	SORTE OU AZAR	CALABREZA	QUEIJO	SORTE OU AZAR	SORTE OU AZAR
TOMATE	OVOS	AZEITONA	SORTE OU AZAR	SORTE OU AZAR	MILHO	AZEITONA
SORTE OU AZAR	PREZUNTO	TOMATE	MILHO	SORTE OU AZAR	SORTE OU AZAR	BROCOLIS
SORTE OU AZAR	OVOS	CEBOLA	SORTE OU AZAR	CALABREZA	SORTE OU AZAR	PREZUNTO
SORTE OU AZAR	QUEIJO	AZEITONA	SORTE OU AZAR	BROCOLIS	AZEITONA	SORTE OU AZAR
-> FIM
Obs.: o elemento pizzaiolo foi substituído pelo elemento sorte ou azar. 
**Escolha da pizza a ser montada:** As pizzas devem ser implementadas numa lista simplesmente encadeada, contendo 5 ingredientes. A cada ingrediente conquistado, o mesmo é retirado da lista. GANHA O JOGO o jogador que esvaziar primeiro a sua lista.
**Fichas sorte ou azar (prêmio ou punição):** Implementar uma pilha contendo diversos prêmios ou punições para os participantes. Os prêmios e punições devem conter 20 fichas de cada ação empilhadas aleatoriamente, que são as seguintes: perder um ingrediente, ganhar dois ingredientes, retirar um ingrediente de um outro jogador, queimar a pizza(perder todos os ingredientes). Quando no tabuleiro o jogador for para a posição sorte ou azar, um elemento da pilha é retirado, revelado ao jogador e executada a ação descrita na ficha. Caso pilha se esvazie, empilhar novamente os elementos de forma aleatória.


