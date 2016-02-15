//Código produzido por:
//Felipe Ferreira Campos
//Fernando dos Santos Figueredo
//Raphael Prata
//Paulo Henrique Abreu Neiva
//Anita Pereira
//Marcus Dornas

//Trabalho de Programação Imperativa
//Sudoku v1.10

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#define SO 1 //SO = 1 quer dizer que é Windows, SO = 0 quer dizer que é Linux, tem qua alterar isso pq se não a funcao de limpar da erro

//Prototipo das funções que serão usadas na correção
void limpaTela();
void imprimiGradeJogo();
void imprimiGradeCerta();
void imprimiRegraJogo();
int validaLinha(int, int, int);

// Preenchimento inicial do Sudoku
int grade[9][9] =
  {{ 0, 6, 0, 1, 0, 4, 0, 5,  0},
   { 0, 0, 8, 3, 0, 5, 6, 0, 0},
   { 2, 0, 0, 0, 0, 0, 0, 0, 1},
   { 8, 0, 0, 4, 0, 7, 0, 0, 6},
   { 0, 0, 6, 0, 0, 0, 3, 0, 0},
   { 7, 0, 0, 9, 0, 1, 0, 0, 4},
   { 5, 0, 0, 0, 0, 0, 0, 0, 2},
   { 0, 0, 7, 2, 0, 6, 9, 0, 0},
   { 0, 4, 0, 5, 0, 8, 0, 7, 0}};

int main()
{
    int sair, linha, coluna, valor;

    /*O do fará com que o programa rode pelo menos uma vez
    perguntado no final se o usuario deseja continuar jogando ou não*/
    do
    {
        int num;
        /*entrada de dados no jogo*/
        imprimiGradeJogo();
        printf("\n Digite as coordenadas do campo que deseja preencher");
        printf("\n Digite -1 na Linha para Sair");
        //printf("\n Digite -2 na Linha visualizar o jogo pronto."); É um cheat do jogo.
        printf("\n Digite -999 na linha para ler as regras do jogo");
        printf("\n\n Linha: ");
        scanf("%d", &linha);

        if(linha == -1){
            sair = 1;
        }else if(linha == -2){
            imprimiGradeCerta();
            printf("\n");
            system("pause");
        }else if(linha == -999){
            imprimiRegraJogo();
            printf("\n");
            system("pause");
        }
        else{
            printf(" Coluna: ");
            scanf("%d", &coluna);
            printf("\n Digite o valor a ser inserido na linha %d coluna %d: ", linha, coluna);
            scanf("%d", &valor);

            /*verifica a escolha do usuario*/
            if((valor < 1)||(valor > 9)){
                printf("\n*** Valor invalido, digite um valor entre 1 e 9 ***");
                printf("\n");
                system("pause");
            }
            else
            {
                /*verifica se o número já foi digitado na linha e coluna*/
                if(validaLinha((linha-1), 0, valor) || validaColuna((coluna-1), 0, valor)){
                    printf("\nValor ja foi digitado");
                    printf("\n");
                    system("pause");
                }else{
                    grade[linha-1][coluna-1] = valor;
                }
            }

        }

        printf("\n\n");
    } while(sair!=1);
}
/*usado para se jogar novamente*/
void limpaTela(){
    if(SO)
        system("cls"); // Se SO = 1 Windows
    else
        system("clear"); //Se SO = 0 Linux
}

void imprimiGradeJogo(){
    int i,j;
    limpaTela();
    system("color 4e"); //desativar essa linha caso for rodar no linux
    FILE *arq;
    char Linha[100];
    char *result;
    int l;
    // Abre um arquivo TEXTO para LEITURA
    arq = fopen("logo.txt", "r");
    if (arq == NULL)  // Se houve erro na abertura
    {
        printf("Problemas na abertura do arquivo\n");
        return;
    }
    l = 1;
    while (!feof(arq))
  {
	// Lê uma linha (inclusive com o '\n')
    result = fgets(Linha, 100, arq);  // o 'fgets' lê até 99 caracteres ou até o '\n'
    if (result)  // Se foi possível ler
	printf(Linha);
    l++;
  }
    fclose(arq);

    printf("\n\nCreditos: Fernando, Raphael, Felipe, Anita, Paulo, Marcus\n\n\n");
    printf("    1  2  3   4  5  6   7  8  9  \n");//Desenho inicial do sudoku
    printf("  +---------+---------+---------+\n");
    for (i = 0; i < 9; i++)
    {
        printf("%d |", i+1); //Barra lateral esquerda

        for (j = 0; j < 9; j++)
        {
            if (grade[i][j] != 0) //Mostra os campos existentes
                printf(" %d ", grade[i][j]);
            else
                printf("   ");

            if (j % 3 == 2)// Após 3 alementos na coluna printa uma barra
                printf("|");
        }

        if (i % 3 == 2)// Após 3 elementos na linha print a divisoria
        printf("\n  +---------+---------+---------+");
        printf("\n");
    }
}

void imprimiGradeCerta(){

    limpaTela();
    system("color 1f");
    FILE *arq;
    char Linha[100];
    char *result;
    int i;
    // Abre um arquivo TEXTO para LEITURA
    arq = fopen("sudoku.txt", "r");
    if (arq == NULL)  // Se houve erro na abertura
    {
        printf("Problemas na abertura do arquivo\n");
        return;
    }
    i = 1;
    while (!feof(arq))
  {
	// Lê uma linha (inclusive com o '\n')
    result = fgets(Linha, 100, arq);  // o 'fgets' lê até 99 caracteres ou até o '\n'
    if (result)  // Se foi possível ler
	printf(Linha);
    i++;
  }
    fclose(arq);
  }

void imprimiRegraJogo(){

    limpaTela();
    system("color 2f");
    FILE *arq;
    char Linha[100];
    char *result;
    int i;
    // Abre um arquivo TEXTO para LEITURA
    arq = fopen("regra.txt", "r");
    if (arq == NULL)  // Se houve erro na abertura
    {
        printf("Problemas na abertura do arquivo\n");
        return;
    }
    i = 1;
    while (!feof(arq))
  {
	// Lê uma linha (inclusive com o '\n')
    result = fgets(Linha, 100, arq);  // o 'fgets' lê até 99 caracteres ou até o '\n'
    if (result)  // Se foi possível ler
	printf(Linha);
    i++;
  }
    fclose(arq);
  }

int validaLinha(int linhaDigita, int colunaTestar, int valor){
    int i;
	/*
Como estou valiando a linha, entao percorrerei as colunas da linha
que sao no maximo 9 (de 0 a 8)*/
    if(colunaTestar < 9)//Testo se o valor digitado se encontra na linha, ou seja, nas colunas da linha{
        if(valor != grade[linhaDigita][colunaTestar]){
            if(!validaLinha(linhaDigita, colunaTestar+1, valor)){
					/*Este return so eh utilizado quando a recursividade chegou ao fim
se chegou na ultima coluna da linha, e nao identificou numero repetido,
entao ele voltara recursivamente dando return zero*/
                return 0;
            }else{
            	/*Este return so eh utilizado quando a recursividade encontra um numero
repetido, dai ele sai retornando verdadeiro*/
                return 1;
            }
        }else{
        	/*Este return nao faz exatamente a recursividade, mas pode estar dentro dela,
exemplo: a recursividade executou 3 vezes e entrou neste return,
entao ela ira se desfazendo e dando returns verdadeiros*/
            return 1;
        }
    else{
    	/*Este return so eh utilizado caso passe por todas colunas da linha
e nao encontrar nenhum valor repetido*/
        return 0;
    }
}

/*Essa recursão faz a mesma coisa da recursão acima, mas para a coluna*/
int validaColuna(int colunaDigita, int linhaTestar, int valor){
    int i;
    if(linhaTestar < 9){
        if(valor != grade[linhaTestar][colunaDigita]){
            if(!validaColuna(colunaDigita, linhaTestar+1, valor)){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }else{
        return 0;
    }
}
