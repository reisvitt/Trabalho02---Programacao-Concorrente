/********************************************************
 * Autor....: Vitor de Almeida Reis
 * Matricula: 201710793
 * Inicio...: 27 de agosto 2019
 * Alteracao: 31 de agosto de 2019
 * Nome.....: Principal.cpp
 * Funcao...: Exemplo do uso do comando fork em C++
*********************************************************/

#include <iostream>
#include <unistd.h>

using namespace std;

static pid_t pai, primeiroFilho, segundoFilho, terceiroFilho, primeiroNeto, segundoNeto, primeiroBisneto;
int nascF1 = 22; // == nascimento Primeiro Filho
int nascF2 = 25, nascF3 = 32, nascN1 = 38, nascN2 = 45, nascB1 = 68;
int ano = 0;

//Funcao que gerencia a arvore genealogica da familia
void arvoreGenealogica(){

  while(true){
    if(getpid() == pai){ // printa o ano corrente
      cout << "Ano - " << ano << endl; 
    }

    if(ano == 22 && getpid() == pai){
      cout << "Nasce o primeiro filho" << endl;
      primeiroFilho = fork(); //nasce o primeiro filho
      
      if(primeiroFilho == 0){// apenas o filho possui acesso
        primeiroFilho = getpid();
      }
    }

    if(ano == 25 && getpid() == pai){
      cout << "Nasce o segundo filho" << endl;
      segundoFilho = fork(); //nasce o segundo filho
      

      if(segundoFilho == 0){ // apenas o filho possui acesso
        segundoFilho = getpid();
      }
    }


    if(ano == 32 && getpid() == pai){
      cout << "Nasce o terceiro filho" << endl;
      terceiroFilho = fork(); // nasce o terceiro filho
      
      if(terceiroFilho == 0){ // apenas o filho possui acesso
        terceiroFilho = getpid();
      }
    }

    if(primeiroFilho == getpid() && ano == 38){
      cout << "Pai eh avo" << endl;
      primeiroNeto = fork(); // nasce o primeiro neto

      if(primeiroNeto == 0){ // apenas o primeiro neto possui acesso
        primeiroNeto = getpid();
      }
    }

    if(segundoFilho == getpid() && ano == 45){
      cout << "Nasce o segundo neto" << endl;
      segundoNeto = fork(); // nasce o segundo neto

      if(segundoNeto == 0){
        segundoNeto = getpid();
      }
    }

    if((ano - nascF1) == 61 && primeiroFilho == getpid()){ // idade do primeiro filho == 61
      cout << "Morre o primeiro filho :(" << endl;
      _exit(0);
    }

    if(primeiroNeto == getpid() && ano == 68){
      cout << "Nasce o primeiro bisneto" << endl;
      primeiroBisneto = fork();

      if(primeiroBisneto == 0){ // apenas o primeiro bisneto possui acesso
        primeiroBisneto = getpid();
      }
    }

    if((ano - nascF2) == 55 && segundoFilho == getpid()){// filho morre aos 55 anos
      cout << "Morre o segundo filho :(" << endl;
      _exit(0);
    }

    if((ano - nascF2) == 55 && terceiroFilho == getpid()){ // filho morre aos 55 anos
      cout << "Morre o terceiro filho :(" << endl;
      _exit(0);
    }

    if((ano - nascN1) == 35 && getpid() == primeiroNeto){ // neto morre aos 35 anos
      cout << "Morre o primeiro neto :(" << endl;
      _exit(0);
    }

    if((ano - nascN2) == 33 && getpid() == segundoNeto){ // neto morre aos 33 anos
      cout << "Morre o segundo neto :(" << endl;
      _exit(0);
    }

    if((ano - nascB1) == 12 && getpid() == primeiroBisneto){ // bisneto morre aos 12 anos
      cout << "Morre o unico bisneto" << endl;
      _exit(0);
    }

    
    if(ano  == 90 && pai == getpid()){// pai sai do laço e da funcao responsavel pela arvore
      break;
    }
    sleep(1);
    ano++;
  }// fim while

}//fim funcao


int main(){
  pai = getpid();
  cout << "Nasce o pai" << endl;
  arvoreGenealogica();

  cout << "Morre o pai :(" << endl;
  return 0;
}