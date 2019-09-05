/****************************************************
 * Classe: Controller
 * Funcao: Classe reponsavel por controlar todas as
 *         acoes da view tela_principal.fxml
 ***************************************************/

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.Threads;

public class Controller implements Initializable {

  @FXML
  private AnchorPane root, animacao, animacao1;

  @FXML
  private Text textAnimacao, tempo;

  @FXML
  private ImageView imagePai, imageFilho1, imageFilho2, imageFilho3, imageNeto1, imageNeto2, imageBisneto1, icon;

  @FXML
  private AnchorPane paneIniciar;

  private Threads pai, f1, f2, f3, n1, n2, b1;

  // Ano de nascimento F1, F2, F3, N1, N2, B1
  private int nascF1 = 22, nascF2 = 25, nascF3 = 32, nascN1 = 38, nascN2 = 45, nascB1 = 68;


  private int temp = 0; // variavel responsavel pelo tempo

  public Controller() {
  }

  public void initialize(URL url, ResourceBundle rb) {

  }


  /************************************************************
   * Metodo: ocultarPaneIniciar
   * Funcao: Este metodo esconde a tela inicial
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  @FXML
  public void ocultarPanelIniciar() {
    paneIniciar.setVisible(false);

    pai = new Threads("pai", this);
    pai.start(); // nasceu o pai

    animacaoNascimento("pai"); // animacao para o nascimento

  }


  /************************************************************
   * Metodo: pai
   * Funcao: Este metodo eh responsavel pelo ciclo de vida da
   *         Thread pai, onde dah vida as Threads filhas
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  public void pai() {
    temp++; // incrimenta variavel tempo
    tempo.setText("Time: " + temp); // controla o tempo
    
    if(temp == 3){ // ao chegar terceiro ano de vida, no caso 3 segundos, a animacao de nascimento desaparece
      imagePai.setImage(new Image("images/bardock1.png"));
      animacao.setVisible(false);
      animacao1.setVisible(false);
    }

    if(temp == 15){// 15 anos. Trocar imagem por uma mais velha
      imagePai.setImage(new Image("images/bardock2.png"));
    }


    if (temp == nascF1) { // Nascimento do filho1
      f1 = new Threads("f1", this); // instancia filho1
      f1.start(); // start filho1
      animacaoNascimento("f1"); // animacao de nascimento

    }

    if(temp == (nascF1 + 3)){ // ao chegar terceiro ano de vida, no caso 3 segundos, a animacao de nascimento desaparece
      imageFilho1.setImage(new Image("images/goku1.png"));
      animacao.setVisible(false);
      animacao1.setVisible(false);
    }

    if (temp == nascF2) { // Nascimento do filho2
      f2 = new Threads("f2", this); // filho dois
      f2.start();
      animacaoNascimento("f2"); // animacao de nascimento
    }

    if(temp == (nascF2 + 3)){ // ao chegar terceiro ano de vida, no caso 3 segundos, a animacao de nascimento desaparece
      imageFilho2.setImage(new Image("images/raditz1.png"));
      animacao.setVisible(false);
      animacao1.setVisible(false);
    }

    if (temp == nascF3) { // Nascimento do filho3
      f3 = new Threads("f3", this);
      f3.start();
      animacaoNascimento("f3"); // animacao de nascimento
    }

    if(temp == (nascF3 + 3)){ // ao chegar terceiro ano de vida, no caso 3 segundos, a animacao de nascimento desaparece
      imageFilho3.setImage(new Image("images/vegeta1.png"));
      animacao.setVisible(false);
      animacao1.setVisible(false);
    }

    if(temp == 90){ // idade do pai
      // morre o pai
      animacaoMorte("pai"); // animacao de morte
      Thread.currentThread().stop(); // mata a Thread
    }
  }


  /************************************************************
   * Metodo: filho1
   * Funcao: Este metodo eh responsavel pelo ciclo de vida da
   *         Thread filho1, onde dah vida as Threads filhas
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  public void filho1(){
    if(temp == nascN1){ // Nascimento do primeiro neto
      n1 = new Threads("n1", this);
      n1.start();
      animacaoNascimento("n1"); // animacao de nascimento
    }

    if((temp - nascF1) == 15){ // troca imagem por uma mais velha
      imageFilho1.setImage(new Image("images/goku2.png"));
    }

    if(temp == (nascN1 + 3)){ // ao chegar terceiro ano de vida, no caso 3 segundos, a animacao de nascimento desaparece
      imageNeto1.setImage(new Image("images/gohan1.png"));
      animacao.setVisible(false);
      animacao1.setVisible(false);
    }

    if((temp - nascF1) == 61){ // idade do primeiro filho
      animacaoMorte("f1"); // animacao de morte
      Thread.currentThread().stop(); // mata a Thread
    }

  }

  /************************************************************
   * Metodo: filho2
   * Funcao: Este metodo eh responsavel pelo ciclo de vida da
   *         Thread filho2, onde dah vida as Threads filhas
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  public void filho2(){
    if(temp == nascN2){
      n2 = new Threads("n2", this);
      n2.start();
      animacaoNascimento("n2"); // animacao de nascimento
    }

    if((temp - nascF2) == 15){ // troca imagem por uma mais velha
      imageFilho2.setImage(new Image("images/raditz2.png"));
    }

    if(temp == (nascN2 + 3)){ // ao chegar terceiro ano de vida, no caso 3 segundos, a animacao de nascimento desaparece
      imageNeto2.setImage(new Image("images/bulla1.png"));
      animacao.setVisible(false);
      animacao1.setVisible(false);
    }

    if((temp - nascF2) == 55){ // idade do segundo filho
      animacaoMorte("f2"); // animacao de morte
      Thread.currentThread().stop(); // mata a Thread
    }
  }


  /************************************************************
   * Metodo: filho3
   * Funcao: Este metodo eh responsavel pelo ciclo de vida da
   *         Thread filho3
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  public void filho3() {

    if((temp - nascF3) == 15){ // troca imagem por uma mais velha
      imageFilho3.setImage(new Image("images/vegeta2.png"));
    }


    if((temp - nascF3) == 55){ // idade do terceiro filho
      animacaoMorte("f3"); // animacao de morte
      Thread.currentThread().stop(); //  mata a Thread
    }
  }

  /************************************************************
   * Metodo: neto1
   * Funcao: Este metodo eh responsavel pelo ciclo de vida da
   *         Thread neto1, onde dah vida as Threads filhas
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  public void neto1() {
    if(temp == nascB1){ // nasce o primero bisneto
      b1 = new Threads("b1", this);
      b1.start();
      animacaoNascimento("b1"); // animacao de nascimento
    }

    if((temp - nascN1) == 15){ // troca imagem por uma mais velha
      imageNeto1.setImage(new Image("images/gohan2.png"));
    }

    if(temp == (nascB1 + 3)){ // ao chegar terceiro ano de vida, no caso 3 segundos, a animacao de nascimento desaparece
      imageBisneto1.setImage(new Image("images/pan1.png"));
      animacao.setVisible(false);
      animacao1.setVisible(false);
    }

    if((temp - nascN1) == 35){ // idade do primeiro neto = 35
      animacaoMorte("n1"); // animacao de morte
      Thread.currentThread().stop(); // mata a Thread
    }
  }

  /************************************************************
   * Metodo: neto2
   * Funcao: Este metodo eh responsavel pelo ciclo de vida da
   *         Thread neto2
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  public void neto2(){

    if((temp - nascN2) == 15){ // troca imagem por uma mais velha
      imageNeto2.setImage(new Image("images/bulla2.png"));
    }

    if((temp - nascN2) == 33){ // idade do segundo neto = 33
      animacaoMorte("n2"); // animacao de morte
      Thread.currentThread().stop(); // mata a Thread
    }

  }

  /************************************************************
   * Metodo: bisneto
   * Funcao: Este metodo eh responsavel pelo ciclo de vida da
   *         Thread bisneto
   * Parametros: nenhum
   * Retorno: void
   ***********************************************************/
  public void bisneto1(){

    if((temp - nascB1) == 10){ // troca imagem por uma mais velha
      imageBisneto1.setImage(new Image("images/pan2.png"));
    }

    if((temp - nascB1) == 12){ // idade do Bisneto = 12
      animacaoMorte("b1"); // animacao de morte
      Thread.currentThread().stop(); // mata a Thread
    }
  }

  /*****************************************************************
   * Metodo: animacaoNascimento
   * Funcao: Este metodo eh responsavel pela animacao de nascimento
   *         de algum filho/Thread
   * Parametros: name - Nome da thread que irah ser criada
   * Retorno: void
   ****************************************************************/
  public void animacaoNascimento(String name){
    animacao.setVisible(true);
    animacao1.setVisible(true);

    switch(name){
      case "pai":
        textAnimacao.setText("Nasceu o pai");
        icon.setImage(new Image("images/bardock1.png"));
        break;
      case "f1":
        textAnimacao.setText("Nasceu o primeiro filho");
        icon.setImage(new Image("images/goku1.png"));
        break;
      case "f2":
        textAnimacao.setText("Nasceu o segundo filho");
        icon.setImage(new Image("images/raditz1.png"));
        break;
      case "f3":
        textAnimacao.setText("Nasceu o terceiro filho");
        icon.setImage(new Image("images/vegeta1.png"));
        break;
      case "n1":
        textAnimacao.setText("Nasceu o primeiro neto");
        icon.setImage(new Image("images/gohan1.png"));
        break;
      case "n2":
        textAnimacao.setText("Nasceu o segundo neto");
        icon.setImage(new Image("images/bulla1.png"));
        break;
      case "b1":
        textAnimacao.setText("Nasceu o primeiro bisneto");
        icon.setImage(new Image("images/pan1.png"));
        break;
      
    }//fim switch
  }//fim metodo

  /*****************************************************************
   * Metodo: animacaoMorte
   * Funcao: Este metodo eh responsavel pela animacao de morte
   *         de algum filho/Thread
   * Parametros: name - Nome da thread que irah morrer
   * Retorno: void
   ****************************************************************/
  public void animacaoMorte(String name){
    
      try {
        switch(name){
          case "pai":
            imagePai.setImage(new Image("images/taNaHora.gif")); // chegando a hora
            Thread.sleep(2000);
            imagePai.setImage(new Image("images/dead.gif"));
            break;
          case "f1":
            imageFilho1.setImage(new Image("images/taNaHora.gif")); // chegando a hora
            Thread.sleep(2000);
            imageFilho1.setImage(new Image("images/dead.gif"));
            break;
          case "f2":
            imageFilho2.setImage(new Image("images/taNaHora.gif")); // chegando a hora
            Thread.sleep(2000);
            imageFilho2.setImage(new Image("images/dead.gif"));
            break;
          case "f3":
            imageFilho3.setImage(new Image("images/taNaHora.gif")); // chegando a hora
            Thread.sleep(2000);
            imageFilho3.setImage(new Image("images/dead.gif"));
            break;
          case "n1":
            imageNeto1.setImage(new Image("images/taNaHora.gif")); // chegando a hora
            Thread.sleep(2000);
            imageNeto1.setImage(new Image("images/dead.gif"));
            break;
          case "n2":
            imageNeto2.setImage(new Image("images/taNaHora.gif")); // chegando a hora
            Thread.sleep(2000);
            imageNeto2.setImage(new Image("images/dead.gif"));
            break;
          case "b1":
            imageBisneto1.setImage(new Image("images/taNaHora.gif")); // chegando a hora
            Thread.sleep(2000);
            imageBisneto1.setImage(new Image("images/dead.gif"));
            break;
      
        }//fim switch
      } catch (Exception e) {
        e.printStackTrace();
      }//fim try-catch
  }//fim metodo
}