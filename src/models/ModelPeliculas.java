/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Time;
/**
 *
 * @author fernando
 */
public class ModelPeliculas {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql; 

    private int id_pelicula;
    private String nombre;
    private String formato;
    private String duracion;
    private String descripcion;
    
    public void setId_pelicula(int id_pelicula){
        this.id_pelicula = id_pelicula;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setFormato(String formato){
        this.formato = formato;
    }
    public void setDuracion(String duracion){
        this.duracion = duracion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public int getId_pelicula(){
        return id_pelicula;
    }
    public String getNombre(){
        return nombre;
    }
    public String getFormato(){
        return formato;
    }
    public String getDuracion(){
        return duracion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/segundoparcial","root","fernando");
        st = conexion.createStatement();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error 201" + e);
        }    
    }
    public void llenarValores(){
        try{
            setId_pelicula(rs.getInt("id_pelicula"));
            setNombre(rs.getString("nombre"));
            setFormato(rs.getString("formato"));
            setDuracion(rs.getString("duracion"));
            setDescripcion(rs.getString("descripcion"));
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 202" + e);
        }
    }    
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 203" + e);
        }
    }
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 204" + e);
        }
    }
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false)
            rs.next();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 205" + e);
        }
    }
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false)
            rs.previous();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 206" + e);
        }
    }    

    public void seleccionarTodos(){
        try{
            sql="SELECT * FROM peliculas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 207" + e);
        }
    }
    public void insertar(){
        try{
            sql= "INSERT INTO peliculas(nombre, formato, duracion, descripcion) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, formato);
            ps.setTime(3, Time.valueOf(duracion));
            ps.setString(4, descripcion);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 208" + e);
        }
    }
    public void borrar(){
        try{
            sql="DELETE FROM peliculas WHERE id_pelicula = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_pelicula);
            ps.executeQuery();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 209" + e);
        }
    }
    public void actualizar(){
        try{
            sql= "UPDATE peliculas SET nombre=? , formato=? , duracion=? , descripcion=? WHERE id_pelicula=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, id_pelicula);
            ps.setString(1, nombre);
            ps.setString(2, formato);
            ps.setTime(3, Time.valueOf(duracion));
            ps.setString(4, descripcion);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 210" + e);
        }
    }    
}
