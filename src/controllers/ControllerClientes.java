/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import javax.swing.JOptionPane;
import views.ViewClientes;
import models.ModelClientes;
/**
 *
 * @author fernando
 */
public class ControllerClientes {
    private final ModelClientes model_clientes;
    private final ViewClientes view_clientes;
    
    public ControllerClientes(ModelClientes model_clientes, ViewClientes view_clientes){
        this.model_clientes = model_clientes;
        this.view_clientes = view_clientes;
        
        view_clientes.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_clientes.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_clientes.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_clientes.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_clientes.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_clientes.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_clientes.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_clientes.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());
        initView();
        }
    public void initView(){
        model_clientes.Conectar();
        model_clientes.seleccionarTodos();
        model_clientes.moverPrimero();
            
        view_clientes.jbtn_agregar.setEnabled(false);
        view_clientes.jtf_id_cliente.setEditable(false);
        
        getValores();
    }
    public void getValores(){
        view_clientes.jtf_id_cliente.setText("" + model_clientes.getId_cliente());
        view_clientes.jtf_nombre.setText(model_clientes.getNombre());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
        view_clientes.jtf_email.setText(model_clientes.getEmail());
    }
    public void setValores(){
        model_clientes.SetId_cliente(Integer.parseInt(view_clientes.jtf_id_cliente.getText()));
        model_clientes.SetNombre(view_clientes.jtf_nombre.getText());
        model_clientes.SetTelefono(view_clientes.jtf_telefono.getText());
        model_clientes.SetDireccion(view_clientes.jtf_direccion.getText());
        model_clientes.SetEmail(view_clientes.jtf_email.getText());
    }
    public void jbtn_nuevo_click(){
        agregar_true();
        view_clientes.jtf_id_cliente.setText("0");
        view_clientes.jtf_nombre.setText("");
        view_clientes.jtf_telefono.setText("");
        view_clientes.jtf_direccion.setText("");
        view_clientes.jtf_email.setText("");
    }
     public void jbtn_agregar_click(){
        
        if(view_clientes.jtf_nombre.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setValores();
        model_clientes.insertar();
        getValores();
        agregar_falso();
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_clientes.actualizar();
        getValores();
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_clientes.borrar();
        getValores();
    }
    public void jbtn_primero_click(){
        model_clientes.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_click(){
        model_clientes.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_click(){
        model_clientes.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_click(){
        model_clientes.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    public void agregar_falso(){
        view_clientes.jbtn_agregar.setEnabled(false);
        view_clientes.jbtn_editar.setEnabled(true);
        view_clientes.jbtn_eliminar.setEnabled(true);          
    }
    public void agregar_true(){
        view_clientes.jbtn_agregar.setEnabled(true);
        view_clientes.jbtn_eliminar.setEnabled(false);
        view_clientes.jbtn_editar.setEnabled(false);        
    }
}
