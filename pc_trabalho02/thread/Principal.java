/***********************************************************
 * Autor....: Vitor de Almeida Reis
 * Matricula: 201710793
 * Inicio...: 29 de agosto de 2019
 * Alteracao: 01 de setembro de 2019
 * Nome.....: Principal.java
 * Funcao...: Exemplo de criacao de Threads em java
 * 
***********************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.Controller;

public class Principal extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent principalfxml = FXMLLoader.load(getClass().getResource("/views/tela_principal.fxml"));
    Scene scenePrincipal = new Scene(principalfxml);
    primaryStage.setScene(scenePrincipal);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  
}