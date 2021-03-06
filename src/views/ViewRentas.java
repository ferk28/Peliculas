/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author fernando
 */
public class ViewRentas extends javax.swing.JPanel {

    /**
     * Creates new form ViewRentas
     */
    public ViewRentas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_id_renta = new javax.swing.JLabel();
        jl_id_cliente = new javax.swing.JLabel();
        jl_id_pelicula = new javax.swing.JLabel();
        jl_formato = new javax.swing.JLabel();
        jl_costo_dia = new javax.swing.JLabel();
        jl_dias = new javax.swing.JLabel();
        jl_total_renta = new javax.swing.JLabel();
        jtf_id_renta = new javax.swing.JTextField();
        jtf_id_cliente = new javax.swing.JTextField();
        jtf_id_pelicula = new javax.swing.JTextField();
        jcb_formato = new javax.swing.JComboBox<>();
        jtf_costo_dia = new javax.swing.JTextField();
        jtf_dias = new javax.swing.JTextField();
        jtf_total_renta = new javax.swing.JTextField();
        jbtn_agregar = new javax.swing.JButton();
        jbtn_eliminar = new javax.swing.JButton();
        jbtn_anterior = new javax.swing.JButton();
        jbtn_siguiente = new javax.swing.JButton();
        jbtn_primero = new javax.swing.JButton();
        jbtn_ultimo = new javax.swing.JButton();
        jbtn_nuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        jl_id_renta.setForeground(new java.awt.Color(255, 255, 255));
        jl_id_renta.setText("ID Renta");

        jl_id_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jl_id_cliente.setText("ID Cliente");

        jl_id_pelicula.setForeground(new java.awt.Color(255, 255, 255));
        jl_id_pelicula.setText("ID Película");

        jl_formato.setForeground(new java.awt.Color(255, 255, 255));
        jl_formato.setText("Formato");

        jl_costo_dia.setForeground(new java.awt.Color(255, 255, 255));
        jl_costo_dia.setText("Costo Día");

        jl_dias.setForeground(new java.awt.Color(255, 255, 255));
        jl_dias.setText("Días");

        jl_total_renta.setForeground(new java.awt.Color(255, 255, 255));
        jl_total_renta.setText("Total Renta");

        jcb_formato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DVD", "Blue-Ray", " " }));

        jbtn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-circular-de-suma.png"))); // NOI18N

        jbtn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-de-cancelacion.png"))); // NOI18N

        jbtn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jbtn_anterior.png"))); // NOI18N

        jbtn_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jbtn_siguiente.png"))); // NOI18N

        jbtn_primero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jbtn_primero.png"))); // NOI18N

        jbtn_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jbtn_ultimo.png"))); // NOI18N

        jbtn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/documento-nuevo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_total_renta)
                    .addComponent(jl_dias)
                    .addComponent(jl_costo_dia)
                    .addComponent(jl_formato)
                    .addComponent(jl_id_pelicula)
                    .addComponent(jl_id_cliente)
                    .addComponent(jl_id_renta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtf_costo_dia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_formato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_dias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jbtn_anterior)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_siguiente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtn_nuevo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbtn_agregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbtn_eliminar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtf_total_renta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jbtn_primero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_ultimo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtf_id_pelicula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(jtf_id_cliente, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtf_id_renta, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_id_renta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtn_nuevo))
                        .addGap(16, 16, 16)
                        .addComponent(jtf_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jtf_id_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcb_formato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_costo_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtn_eliminar)
                                    .addComponent(jbtn_agregar))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtn_anterior)
                                    .addComponent(jbtn_siguiente))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_total_renta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_id_renta)
                        .addGap(28, 28, 28)
                        .addComponent(jl_id_cliente)
                        .addGap(27, 27, 27)
                        .addComponent(jl_id_pelicula)
                        .addGap(27, 27, 27)
                        .addComponent(jl_formato)
                        .addGap(26, 26, 26)
                        .addComponent(jl_costo_dia)
                        .addGap(28, 28, 28)
                        .addComponent(jl_dias)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtn_primero)
                            .addComponent(jbtn_ultimo)
                            .addComponent(jl_total_renta))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jbtn_agregar;
    public javax.swing.JButton jbtn_anterior;
    public javax.swing.JButton jbtn_eliminar;
    public javax.swing.JButton jbtn_nuevo;
    public javax.swing.JButton jbtn_primero;
    public javax.swing.JButton jbtn_siguiente;
    public javax.swing.JButton jbtn_ultimo;
    public javax.swing.JComboBox<String> jcb_formato;
    public javax.swing.JLabel jl_costo_dia;
    public javax.swing.JLabel jl_dias;
    public javax.swing.JLabel jl_formato;
    public javax.swing.JLabel jl_id_cliente;
    public javax.swing.JLabel jl_id_pelicula;
    public javax.swing.JLabel jl_id_renta;
    public javax.swing.JLabel jl_total_renta;
    public javax.swing.JTextField jtf_costo_dia;
    public javax.swing.JTextField jtf_dias;
    public javax.swing.JTextField jtf_id_cliente;
    public javax.swing.JTextField jtf_id_pelicula;
    public javax.swing.JTextField jtf_id_renta;
    public javax.swing.JTextField jtf_total_renta;
    // End of variables declaration//GEN-END:variables
}
