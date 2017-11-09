/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import com.sun.org.apache.xerces.internal.util.FeatureState;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.ViewPeliculas;
import models.ModelRentas;
import views.ViewRentas;
/**
 *
 * @author fernando
 */
public class ControllerRentas {
    private final ModelRentas model_rentas;
    private final ViewRentas view_rentas;
    
    public ControllerRentas(ModelRentas model_rentas, ViewRentas view_rentas){
        this.model_rentas = model_rentas;
        this.view_rentas = view_rentas;
        
        view_rentas.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_rentas.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_rentas.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_rentas.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_rentas.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_rentas.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_rentas.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());
        initView();        
    }
    public void initView(){
        model_rentas.Conectar();
        model_rentas.seleccionarTodos();
        model_rentas.moverPrimero();
            
        view_rentas.jtf_id_renta.setEditable(false);
        
        getValores();        
    }
    public void getValores(){
        view_rentas.jtf_id_renta.setText("" + model_rentas.getId_renta());        
        view_rentas.jtf_id_cliente.setText("" + model_rentas.getId_cliente());
        view_rentas.jtf_id_pelicula.setText("" + model_rentas.getId_pelicula());
        view_rentas.jcb_formato.setSelectedItem(model_rentas.getFormato());
        view_rentas.jtf_costo_dia.setText("" + model_rentas.getCosto_dia());
        view_rentas.jtf_dias.setText("" + model_rentas.getDias());
        view_rentas.jtf_total_renta.setText("" + model_rentas.getTotal_renta());

    }    
    public void setValores(){
        model_rentas.setId_renta(Integer.parseInt(view_rentas.jtf_id_renta.getText()));
        model_rentas.setId_cliente(Integer.parseInt(view_rentas.jtf_id_cliente.getText()));
        model_rentas.setId_pelicula(Integer.parseInt(view_rentas.jtf_id_pelicula.getText()));
        model_rentas.setFormato("" + view_rentas.jcb_formato.getSelectedItem());
        model_rentas.setCosto_dia(Integer.parseInt(view_rentas.jtf_costo_dia.getText()));
        model_rentas.setDias(Integer.parseInt(view_rentas.jtf_dias.getText()));
        model_rentas.setTotal_renta(Integer.parseInt(view_rentas.jtf_total_renta.getText()));
    }    
     public void jbtn_agregar_click(){
        if(view_rentas.jtf_id_cliente.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");

        }else{
        setValores();
        model_rentas.insertar();
        getValores();
        }

    } 
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_rentas.borrar();
        getValores();
    }     
    public void jbtn_nuevo_click(){
        agregar_true();
        
        view_rentas.jtf_id_renta.setText("0");
        view_rentas.jtf_id_cliente.setText("");
        view_rentas.jtf_id_pelicula.setText("");
        view_rentas.jtf_costo_dia.setText("");
        view_rentas.jtf_dias.setText("");
        view_rentas.jtf_total_renta.setText("");        
    }
    public void jbtn_primero_click(){
        model_rentas.moverPrimero();
        getValores();
        agregar_falso();

    }
    public void jbtn_ultimo_click(){
        model_rentas.moverUltimo();
        getValores();
        agregar_falso();

    }
    public void jbtn_anterior_click(){
        model_rentas.moverAnterior();
        getValores();
        agregar_falso();

    }
    public void jbtn_siguiente_click(){
        model_rentas.moverSiguiente();
        getValores();
        agregar_falso();
        
    }    
    public void agregar_falso(){
        view_rentas.jbtn_agregar.setEnabled(false);
        view_rentas.jbtn_eliminar.setEnabled(true);  
    }
    public void agregar_true(){
        view_rentas.jbtn_nuevo.setEnabled(false);        
        view_rentas.jbtn_agregar.setEnabled(true);
        view_rentas.jbtn_eliminar.setEnabled(false);
    }    
}
