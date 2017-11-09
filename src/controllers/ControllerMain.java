/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.*;
import models.*;
/**
 *
 * @author fernando
 */
public class ControllerMain {
    ViewPrincipal view_principal;
    ViewClientes view_clientes;
    ViewPeliculas view_peliculas;
    ViewRentas view_rentas;
    
    ModelMain model_main;
    ModelClientes model_clientes;
    ModelPeliculas model_peliculas;
    ModelRentas model_rentas;
    
    public ControllerMain(ViewPrincipal view_principal, ViewClientes view_clientes, ViewPeliculas view_peliculas, ViewRentas view_rentas, ModelMain model_main){
        this.view_principal = view_principal;
        this.view_clientes = view_clientes;
        this.view_peliculas = view_peliculas;
        this.view_rentas = view_rentas;
        this.model_main = model_main;
        this.view_principal.jmi_clientes.addActionListener(e-> jmi_clientesActionPerformed());
        this.view_principal.jmi_peliculas.addActionListener(e-> jmi_peliculasActionPerformed());
        this.view_principal.jmi_rentas.addActionListener(e-> jmi_rentasActionPerformed());        
        this.view_principal.jmi_salir.addActionListener(e-> jmi_salirActionPerformed());

        view_principal.setVisible(true);
        view_principal.setResizable(false); //tamaño
        view_principal.setLocationRelativeTo(null);
        view_principal.setTitle("Bienvenidos");
        
    }
    public void jmi_clientesActionPerformed(){
        this.view_principal.setContentPane(view_clientes);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
    public void jmi_peliculasActionPerformed(){
        this.view_principal.setContentPane(view_peliculas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
    public void jmi_rentasActionPerformed(){
        this.view_principal.setContentPane(view_rentas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
    public void jmi_salirActionPerformed(){
        System.exit(0);
    }
}
