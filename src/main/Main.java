/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.*;
import controllers.*;
import models.*;
/**
 *
 * @author fernando
 */
public class Main {
    private static ViewPrincipal view_principal;
    private static ModelMain model_main;
    private static ControllerMain controller_main;
    
    private static ViewClientes view_clientes;
    private static ModelClientes model_clientes;
    private static ControllerClientes controller_clientes;
    
    private static ViewPeliculas view_peliculas;
    private static ModelPeliculas model_peliculas;
    private static ControllerPeliculas controller_peliculas;

    private static ViewRentas view_rentas;
    private static ModelRentas model_rentas;
    private static ControllerRentas controller_rentas;    
    
    public static void main (String ferk[]){
       view_rentas = new ViewRentas(); 
       model_rentas = new ModelRentas();
       controller_rentas = new ControllerRentas(model_rentas, view_rentas);
        
       view_clientes = new ViewClientes();
       model_clientes = new ModelClientes();
       controller_clientes = new ControllerClientes(model_clientes, view_clientes);
       
       view_peliculas = new ViewPeliculas();
       model_peliculas = new ModelPeliculas();
       controller_peliculas = new ControllerPeliculas(model_peliculas, view_peliculas);
       
       view_principal = new ViewPrincipal();
       model_main = new ModelMain();
       controller_main = new ControllerMain(view_principal, view_clientes, view_peliculas, view_rentas, model_main);
    }
}
