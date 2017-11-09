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
/**
 *
 * @author fernando
 */
public class ModelClientes {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql; 
    
    private int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    
    public void SetId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }
    public void SetTelefono(String telefono){
        this.telefono = telefono;
    }
    public void SetEmail(String email){
        this.email = email;
    }
    public void SetDireccion(String direccion){
        this.direccion = direccion;
    }
    public int getId_cliente(){
        return id_cliente;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }
    public String getDireccion(){
        return direccion;
    }
    
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/segundoparcial","root","fernando");
        st = conexion.createStatement();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error 101" + e);
        }    
    }
   public void llenarValores(){
        try{
            SetId_cliente(rs.getInt("id_cliente"));
            SetNombre(rs.getString("nombre"));
            SetTelefono(rs.getString("telefono"));
            SetEmail(rs.getString("email"));
            SetDireccion(rs.getString("direccion"));
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 102" + e);
        }
    }    
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 103" + e);
        }
    }
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 104" + e);
        }
    }
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false)
            rs.next();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 105" + e);
        }
    }
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false)
            rs.previous();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 106" + e);
        }
    }    

    public void seleccionarTodos(){
        try{
            sql="SELECT * FROM clientes;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 107" + e);
        }
    }
    public void insertar(){
        try{
            sql= "INSERT INTO clientes(nombre, telefono, direccion, email) VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, email);
            ps.setString(4, direccion);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            sql="DELETE FROM clientes WHERE id_cliente = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.executeQuery();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 109" + e);
        }
    }
    public void actualizar(){
        try{
            sql= "UPDATE clientes SET nombre=? , telefono=? , email=? , direccion=? WHERE id_cliente=?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, id_cliente);
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, email);
            ps.setString(4, direccion);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
        }
    }
}
