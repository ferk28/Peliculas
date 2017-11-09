/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import javax.swing.JOptionPane;
import views.ViewPeliculas;
import models.ModelPeliculas;
/**
 *
 * @author fernando
 */
public class ControllerPeliculas {
    private final ModelPeliculas model_peliculas;
    private final ViewPeliculas view_peliculas;
    
    public ControllerPeliculas(ModelPeliculas model_peliculas, ViewPeliculas view_peliculas){
        this.model_peliculas = model_peliculas;
        this.view_peliculas = view_peliculas;
        
        view_peliculas.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_peliculas.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_peliculas.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_peliculas.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_peliculas.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_peliculas.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_peliculas.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_peliculas.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());
        initView();
    }
    public void initView(){
        model_peliculas.Conectar();
        model_peliculas.seleccionarTodos();
        model_peliculas.moverPrimero();
        
        view_peliculas.jbtn_agregar.setEnabled(false);
        view_peliculas.jtf_id_pelicula.setEditable(false);
        
        getValores();
    }
    public void getValores(){
        view_peliculas.jtf_id_pelicula.setText("" + model_peliculas.getId_pelicula());
        view_peliculas.jtf_nombre.setText(model_peliculas.getNombre());
        view_peliculas.jcb_formato.setSelectedItem(model_peliculas.getFormato());
        view_peliculas.jtf_duracion.setText(model_peliculas.getDuracion());
        view_peliculas.jta_descripcion.setText(model_peliculas.getDescripcion());
    }
    public void setValores(){
        model_peliculas.setId_pelicula(Integer.parseInt(view_peliculas.jtf_id_pelicula.getText()));
        model_peliculas.setNombre(view_peliculas.jtf_nombre.getText());
        model_peliculas.setFormato("" + view_peliculas.jcb_formato.getSelectedItem());
        model_peliculas.setDuracion(view_peliculas.jtf_duracion.getText());
        model_peliculas.setDescripcion(view_peliculas.jta_descripcion.getText());
    }
        public void jbtn_nuevo_click(){
        agregar_true();
        view_peliculas.jtf_id_pelicula.setText("0");
        view_peliculas.jtf_nombre.setText("");
        view_peliculas.jtf_duracion.setText("");
        view_peliculas.jta_descripcion.setText("");
    }
     public void jbtn_agregar_click(){
        
        if(view_peliculas.jtf_nombre.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto! >:(");
        }else{
        setValores();
        model_peliculas.insertar();
        getValores();
        agregar_falso();
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_peliculas.actualizar();
        getValores();
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_peliculas.borrar();
        getValores();
    }
    public void jbtn_primero_click(){
        model_peliculas.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_click(){
        model_peliculas.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_click(){
        model_peliculas.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_click(){
        model_peliculas.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    public void agregar_falso(){
        view_peliculas.jbtn_agregar.setEnabled(false);
        view_peliculas.jbtn_editar.setEnabled(true);
        view_peliculas.jbtn_eliminar.setEnabled(true);          
    }
    public void agregar_true(){
        view_peliculas.jbtn_agregar.setEnabled(true);
        view_peliculas.jbtn_eliminar.setEnabled(false);
        view_peliculas.jbtn_editar.setEnabled(false);        
    }
}
