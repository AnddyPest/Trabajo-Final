package Vistas;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class VentanaDeInicio extends javax.swing.JFrame {

    public VentanaDeInicio() {
        initComponents();
        setExtendedState(VentanaDeInicio.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuPacientes = new javax.swing.JMenu();
        menuNuevoPaciente = new javax.swing.JMenuItem();
        menuEditarPaciente = new javax.swing.JMenuItem();
        menuListarPacientes = new javax.swing.JMenuItem();
        menuAltaBajaPaciente = new javax.swing.JMenuItem();
        menuAsignarDieta = new javax.swing.JMenuItem();
        menuDietas = new javax.swing.JMenu();
        menuCrearDieta = new javax.swing.JMenuItem();
        menuBorrarDieta = new javax.swing.JMenuItem();
        menuListarDietas = new javax.swing.JMenuItem();
        menuAltaBajaDieta = new javax.swing.JMenuItem();
        menuComidas = new javax.swing.JMenu();
        menuNuevaComida = new javax.swing.JMenuItem();
        menuBorrarComida = new javax.swing.JMenuItem();
        menuListarComidas = new javax.swing.JMenuItem();
        menuAltaBajaComida = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nutricionista G11");
        setName("Nutricionista"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        desktop.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(2, 2, 2, 2));

        menuPacientes.setText("Pacientes");

        menuNuevoPaciente.setText("Nuevo Paciente");
        menuNuevoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoPacienteActionPerformed(evt);
            }
        });
        menuPacientes.add(menuNuevoPaciente);

        menuEditarPaciente.setText("Editar/Borrar Paciente");
        menuEditarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarPacienteActionPerformed(evt);
            }
        });
        menuPacientes.add(menuEditarPaciente);

        menuListarPacientes.setText("Listar Pacientes");
        menuListarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarPacientesActionPerformed(evt);
            }
        });
        menuPacientes.add(menuListarPacientes);

        menuAltaBajaPaciente.setText("Alta/Baja Paciente");
        menuAltaBajaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaBajaPacienteActionPerformed(evt);
            }
        });
        menuPacientes.add(menuAltaBajaPaciente);

        menuAsignarDieta.setText("Asignar Dieta");
        menuPacientes.add(menuAsignarDieta);

        jMenuBar1.add(menuPacientes);

        menuDietas.setText("Dietas");

        menuCrearDieta.setText("Crear Dieta");
        menuDietas.add(menuCrearDieta);

        menuBorrarDieta.setText("Editar/Borrar Dieta");
        menuDietas.add(menuBorrarDieta);

        menuListarDietas.setText("Listar Dietas");
        menuDietas.add(menuListarDietas);

        menuAltaBajaDieta.setText("Alta/Baja Dieta");
        menuDietas.add(menuAltaBajaDieta);

        jMenuBar1.add(menuDietas);

        menuComidas.setText("Comidas");

        menuNuevaComida.setText("Nueva Comida");
        menuComidas.add(menuNuevaComida);

        menuBorrarComida.setText("Editar/Borrar Comida");
        menuComidas.add(menuBorrarComida);

        menuListarComidas.setText("Listar Comidas");
        menuComidas.add(menuListarComidas);

        menuAltaBajaComida.setText("Alta/Baja Comida");
        menuComidas.add(menuAltaBajaComida);

        jMenuBar1.add(menuComidas);

        jMenu1.setText("Salir");

        menuExit.setText("Salir");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNuevoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoPacienteActionPerformed
        desktop.removeAll();
        VentanaNuevoPaciente nuevoPaciente = new VentanaNuevoPaciente();
        desktop.add(nuevoPaciente);

        nuevoPaciente.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                nuevoPaciente.setLocation(
                        (desktop.getWidth() - nuevoPaciente.getWidth()) / 2,
                        (desktop.getHeight() - nuevoPaciente.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(nuevoPaciente);
        nuevoPaciente.setVisible(true);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuNuevoPacienteActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        dispose();
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuEditarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarPacienteActionPerformed
        desktop.removeAll();
        VentanaEditarBorrarPaciente editarPaciente = new VentanaEditarBorrarPaciente();
        desktop.add(editarPaciente);

        editarPaciente.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                editarPaciente.setLocation((desktop.getWidth() - editarPaciente.getWidth()) / 2,
                        (desktop.getHeight() - editarPaciente.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(editarPaciente);
        editarPaciente.setVisible(true);
        desktop.revalidate();
        desktop.repaint();


    }//GEN-LAST:event_menuEditarPacienteActionPerformed

    private void menuAltaBajaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaBajaPacienteActionPerformed
        desktop.removeAll();
        VentanaAltaBajaPaciente altaBaja = new VentanaAltaBajaPaciente();
        desktop.add(altaBaja);
        altaBaja.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                altaBaja.setLocation((desktop.getWidth() - altaBaja.getWidth()) / 2,
                        (desktop.getHeight() - altaBaja.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(altaBaja);
        altaBaja.setVisible(true);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuAltaBajaPacienteActionPerformed

    private void menuListarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarPacientesActionPerformed
        desktop.removeAll();
        VentanaListadoPacientes listaPacientes = new VentanaListadoPacientes();
        desktop.add(listaPacientes);
        listaPacientes.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                listaPacientes.setLocation((desktop.getWidth() - listaPacientes.getWidth()) / 2,
                        (desktop.getHeight() - listaPacientes.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(listaPacientes);
        listaPacientes.setVisible(true);
        desktop.revalidate();
        desktop.repaint();


    }//GEN-LAST:event_menuListarPacientesActionPerformed

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
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAltaBajaComida;
    private javax.swing.JMenuItem menuAltaBajaDieta;
    private javax.swing.JMenuItem menuAltaBajaPaciente;
    private javax.swing.JMenuItem menuAsignarDieta;
    private javax.swing.JMenuItem menuBorrarComida;
    private javax.swing.JMenuItem menuBorrarDieta;
    private javax.swing.JMenu menuComidas;
    private javax.swing.JMenuItem menuCrearDieta;
    private javax.swing.JMenu menuDietas;
    private javax.swing.JMenuItem menuEditarPaciente;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuListarComidas;
    private javax.swing.JMenuItem menuListarDietas;
    private javax.swing.JMenuItem menuListarPacientes;
    private javax.swing.JMenuItem menuNuevaComida;
    private javax.swing.JMenuItem menuNuevoPaciente;
    private javax.swing.JMenu menuPacientes;
    // End of variables declaration//GEN-END:variables

}
