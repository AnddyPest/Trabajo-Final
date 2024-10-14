package Vistas;


public class VentanaDeInicio extends javax.swing.JFrame {

    
    public VentanaDeInicio() {
        initComponents();
        setExtendedState(VentanaDeInicio.MAXIMIZED_BOTH);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        btnExit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuPacientes = new javax.swing.JMenu();
        menuNuevoPaciente = new javax.swing.JMenuItem();
        menuEditarPaciente = new javax.swing.JMenuItem();
        menuBorrarPaciente = new javax.swing.JMenuItem();
        menuListarPacientes = new javax.swing.JMenuItem();
        menuAsignarDieta = new javax.swing.JMenuItem();
        menuDietas = new javax.swing.JMenu();
        menuNuevaDieta = new javax.swing.JMenuItem();
        menuBorrarDieta = new javax.swing.JMenuItem();
        menuListarDietas = new javax.swing.JMenuItem();
        menuEditarDieta = new javax.swing.JMenuItem();
        menuComidas = new javax.swing.JMenu();
        menuNuevaComida = new javax.swing.JMenuItem();
        menuBorrarComida = new javax.swing.JMenuItem();
        menuEditarComida = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nutricionista G11");
        setName("Nutricionista"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        desktop.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnExit.setText("SALIR");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        desktop.setLayer(btnExit, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addContainerGap(900, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addContainerGap(592, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        menuPacientes.setText("Pacientes");

        menuNuevoPaciente.setText("Nuevo Paciente");
        menuPacientes.add(menuNuevoPaciente);

        menuEditarPaciente.setText("Editar Paciente");
        menuPacientes.add(menuEditarPaciente);

        menuBorrarPaciente.setText("Borrar Paciente");
        menuPacientes.add(menuBorrarPaciente);

        menuListarPacientes.setText("Listar Pacientes");
        menuPacientes.add(menuListarPacientes);

        menuAsignarDieta.setText("Asignar Dieta");
        menuPacientes.add(menuAsignarDieta);

        jMenuBar1.add(menuPacientes);

        menuDietas.setText("Dietas");

        menuNuevaDieta.setText("Nueva Dieta");
        menuDietas.add(menuNuevaDieta);

        menuBorrarDieta.setText("Borrar Dieta");
        menuDietas.add(menuBorrarDieta);

        menuListarDietas.setText("Listar Dietas");
        menuDietas.add(menuListarDietas);

        menuEditarDieta.setText("Editar Dieta");
        menuDietas.add(menuEditarDieta);

        jMenuBar1.add(menuDietas);

        menuComidas.setText("Comidas");

        menuNuevaComida.setText("Nueva Comida");
        menuComidas.add(menuNuevaComida);

        menuBorrarComida.setText("Borrar Comida");
        menuComidas.add(menuBorrarComida);

        menuEditarComida.setText("Editar Comida");
        menuComidas.add(menuEditarComida);

        jMenuBar1.add(menuComidas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDeInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAsignarDieta;
    private javax.swing.JMenuItem menuBorrarComida;
    private javax.swing.JMenuItem menuBorrarDieta;
    private javax.swing.JMenuItem menuBorrarPaciente;
    private javax.swing.JMenu menuComidas;
    private javax.swing.JMenu menuDietas;
    private javax.swing.JMenuItem menuEditarComida;
    private javax.swing.JMenuItem menuEditarDieta;
    private javax.swing.JMenuItem menuEditarPaciente;
    private javax.swing.JMenuItem menuListarDietas;
    private javax.swing.JMenuItem menuListarPacientes;
    private javax.swing.JMenuItem menuNuevaComida;
    private javax.swing.JMenuItem menuNuevaDieta;
    private javax.swing.JMenuItem menuNuevoPaciente;
    private javax.swing.JMenu menuPacientes;
    // End of variables declaration//GEN-END:variables
}
