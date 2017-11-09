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
public class ModelRentas {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql; 
    
    private int id_renta;
    private int id_cliente;
    private int id_pelicula;
    private String formato;
    private int costo_dia;
    private int dias;
    private int total_renta;

    public int getId_renta() {
        return id_renta;
    }
    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_pelicula() {
        return id_pelicula;
    }
    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public int getCosto_dia() {
        return costo_dia;
    }
    public void setCosto_dia(int costo_dia) {
        this.costo_dia = costo_dia;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public int getTotal_renta() {
        return total_renta;
    }
    public void setTotal_renta(int total_renta) {
        this.total_renta = total_renta;
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
            setId_renta(rs.getInt("id_renta"));
            setId_cliente(rs.getInt("id_cliente"));
            setId_pelicula(rs.getInt("id_pelicula"));
            setFormato(rs.getString("formato"));
            setCosto_dia(rs.getInt("costo_dia"));
            setDias(rs.getInt("dias"));
            setTotal_renta(rs.getInt("total_renta"));
            
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
            sql="SELECT * FROM rentas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 107" + e);
        }
    }   
    public void insertar(){
        try{
            sql= "INSERT INTO rentas(id_cliente, id_pelicula, formato, costo_dia, dias, total_renta) VALUES (?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.setInt(2, id_pelicula);
            ps.setString(3, formato);
            ps.setInt(4, costo_dia);
            ps.setInt(5,dias);
            ps.setInt(6, total_renta);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            sql="DELETE FROM rentas WHERE id_renta = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_renta);
            ps.executeQuery();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 109" + e);
        }
    }    
    
}
