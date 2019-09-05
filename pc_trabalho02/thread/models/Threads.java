package models;

import java.lang.Thread;

import controller.Controller;

public class Threads extends Thread{
  private String name;
  private Controller controller;

  public Threads(String name, Controller controller){ // identificacao da Thread e setar Controller
    this.name = name;
    this.controller = controller;
  }


  @Override
  public void run(){
    while(true){
      switch(name){
        case "pai":
          controller.pai();
          break;
        case "f1":
          controller.filho1();
          break;
        case "f2":
          controller.filho2();
          break;
        case "f3":
          controller.filho3();
          break;
        case "n1":
          controller.neto1();
          break;
        case "n2":
          controller.neto2();
          break;
        case "b1":
          controller.bisneto1();
          break;
        
      }
  
      try {
        sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }


}