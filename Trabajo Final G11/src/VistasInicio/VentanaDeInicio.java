package VistasInicio;

import VistasAlimento.VentanaAltaBajaAlimento;
import VistasAlimento.VentanaEditarBorrarAlimento;
import VistasAlimento.VentanaNuevoAlimento;
import VistasDieta.VentanaAltaBajaLogicaDieta;
import VistasDieta.VentanaNuevaDieta;
import VistasMenuDiario.VentanaNuevoMenuDiario;
import VistasPaciente.VentanaAltaBajaPaciente;
import VistasPaciente.VentanaEditarBorrarPaciente;
import VistasPaciente.VentanaListadoPacientes;
import VistasPaciente.VentanaNuevoPaciente;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import VistasKeyword.VentanaLEBKeyword;
import VistasKeyword.VentanaNuevaKeyword;
import VistasMenuDiario.VentanaLABBMenuDiario;

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
        menuDietas = new javax.swing.JMenu();
        menuCrearDieta = new javax.swing.JMenuItem();
        menuBorrarDieta = new javax.swing.JMenuItem();
        menuListarDietas = new javax.swing.JMenuItem();
        menuAltaBajaDieta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCrearMenuDiario = new javax.swing.JMenuItem();
        menuListarMenuDiario = new javax.swing.JMenuItem();
        menuComidas = new javax.swing.JMenu();
        menuNuevoAlimento = new javax.swing.JMenuItem();
        menuBorrarAlimento = new javax.swing.JMenuItem();
        menuListarComidas = new javax.swing.JMenuItem();
        menuAltaBajaComida = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuCrearKey = new javax.swing.JMenuItem();
        menuHandleKeys = new javax.swing.JMenuItem();
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

        menuListarPacientes.setText("Listar/Buscar Pacientes");
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

        jMenuBar1.add(menuPacientes);

        menuDietas.setText("Dietas");

        menuCrearDieta.setText("Crear Dieta");
        menuCrearDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearDietaActionPerformed(evt);
            }
        });
        menuDietas.add(menuCrearDieta);

        menuBorrarDieta.setText("Editar/Borrar Dieta");
        menuDietas.add(menuBorrarDieta);

        menuListarDietas.setText("Listar/Buscar Dietas");
        menuDietas.add(menuListarDietas);

        menuAltaBajaDieta.setText("Alta/Baja Dieta");
        menuAltaBajaDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaBajaDietaActionPerformed(evt);
            }
        });
        menuDietas.add(menuAltaBajaDieta);

        jMenuBar1.add(menuDietas);

        jMenu2.setText("Menu Diario");

        menuCrearMenuDiario.setText("Crear Menu Diario");
        menuCrearMenuDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearMenuDiarioActionPerformed(evt);
            }
        });
        jMenu2.add(menuCrearMenuDiario);

        menuListarMenuDiario.setText("Listar/Alta/Baja/Borrar Menu");
        menuListarMenuDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarMenuDiarioActionPerformed(evt);
            }
        });
        jMenu2.add(menuListarMenuDiario);

        jMenuBar1.add(jMenu2);

        menuComidas.setText("Alimento");

        menuNuevoAlimento.setText("Nuevo Alimento");
        menuNuevoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoAlimentoActionPerformed(evt);
            }
        });
        menuComidas.add(menuNuevoAlimento);

        menuBorrarAlimento.setText("Editar/Borrar Alimento");
        menuBorrarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBorrarAlimentoActionPerformed(evt);
            }
        });
        menuComidas.add(menuBorrarAlimento);

        menuListarComidas.setText("Listar/Buscar Alimentos");
        menuComidas.add(menuListarComidas);

        menuAltaBajaComida.setText("Alta/Baja Alimento");
        menuAltaBajaComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaBajaComidaActionPerformed(evt);
            }
        });
        menuComidas.add(menuAltaBajaComida);

        jMenuBar1.add(menuComidas);

        jMenu3.setText("Keywords");

        menuCrearKey.setText("Crear Keyword");
        menuCrearKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearKeyActionPerformed(evt);
            }
        });
        jMenu3.add(menuCrearKey);

        menuHandleKeys.setText("Listar/Editar/Borrar Keyword");
        menuHandleKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHandleKeysActionPerformed(evt);
            }
        });
        jMenu3.add(menuHandleKeys);

        jMenuBar1.add(jMenu3);

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

    private void menuNuevoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoAlimentoActionPerformed
        desktop.removeAll();
        VentanaNuevoAlimento nuevoAlimento= new VentanaNuevoAlimento();
        desktop.add(nuevoAlimento);
        nuevoAlimento.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                nuevoAlimento.setLocation((desktop.getWidth() - nuevoAlimento.getWidth()) / 2,
                        (desktop.getHeight() - nuevoAlimento.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(nuevoAlimento);
        nuevoAlimento.setVisible(true);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuNuevoAlimentoActionPerformed

    private void menuBorrarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBorrarAlimentoActionPerformed
        desktop.removeAll();
        VentanaEditarBorrarAlimento editarBorrarAlimento= new VentanaEditarBorrarAlimento();
        desktop.add(editarBorrarAlimento);
        editarBorrarAlimento.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                editarBorrarAlimento.setLocation((desktop.getWidth() - editarBorrarAlimento.getWidth()) / 2,
                        (desktop.getHeight() - editarBorrarAlimento.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(editarBorrarAlimento);
        editarBorrarAlimento.setVisible(true);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuBorrarAlimentoActionPerformed

    private void menuAltaBajaComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaBajaComidaActionPerformed
        desktop.removeAll();
        VentanaAltaBajaAlimento altaBajaAlimento= new VentanaAltaBajaAlimento();
        desktop.add(altaBajaAlimento);
        altaBajaAlimento.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                altaBajaAlimento.setLocation((desktop.getWidth() - altaBajaAlimento.getWidth()) / 2,
                        (desktop.getHeight() - altaBajaAlimento.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(altaBajaAlimento);
        altaBajaAlimento.setVisible(true);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuAltaBajaComidaActionPerformed

    private void menuCrearMenuDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearMenuDiarioActionPerformed
       desktop.removeAll();
        VentanaNuevoMenuDiario nuevoMenuDiario= new VentanaNuevoMenuDiario();
        desktop.add(nuevoMenuDiario);
        nuevoMenuDiario.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                nuevoMenuDiario.setLocation((desktop.getWidth() - nuevoMenuDiario.getWidth()) / 2,
                        (desktop.getHeight() - nuevoMenuDiario.getHeight()) / 2
                );
            }
        });
        desktop.moveToFront(nuevoMenuDiario);
        nuevoMenuDiario.setVisible(true);
        desktop.revalidate();
        desktop.repaint();
    }//GEN-LAST:event_menuCrearMenuDiarioActionPerformed

    private void menuHandleKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHandleKeysActionPerformed
       desktop.removeAll();
       VentanaLEBKeyword LEBKeyword = new VentanaLEBKeyword();
       desktop.add(LEBKeyword);
       LEBKeyword.addComponentListener(new ComponentAdapter(){
           
           @Override
           public void componentShown(ComponentEvent e){
               LEBKeyword.setLocation((desktop.getWidth() - LEBKeyword.getWidth())/ 2,
                       (desktop.getHeight() - LEBKeyword.getHeight()) / 2
               );
           }
       });
       desktop.moveToFront(LEBKeyword);
       LEBKeyword.setVisible(true);
       desktop.revalidate();
       desktop.repaint();
    }//GEN-LAST:event_menuHandleKeysActionPerformed

    private void menuCrearKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearKeyActionPerformed
       desktop.removeAll();
       VentanaNuevaKeyword NuevaKeyword = new  VentanaNuevaKeyword();
       desktop.add(NuevaKeyword);
       NuevaKeyword.addComponentListener(new ComponentAdapter(){
           
           @Override
           public void componentShown(ComponentEvent e){
               NuevaKeyword.setLocation((desktop.getWidth() - NuevaKeyword.getWidth())/ 2,
                       (desktop.getHeight() - NuevaKeyword.getHeight()) / 2
               );
           }
       });
       desktop.moveToFront(NuevaKeyword);
       NuevaKeyword.setVisible(true);
       desktop.revalidate();
       desktop.repaint();
    }//GEN-LAST:event_menuCrearKeyActionPerformed

    private void menuCrearDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearDietaActionPerformed
       desktop.removeAll();
       VentanaNuevaDieta nuevaDieta = new VentanaNuevaDieta();
       desktop.add(nuevaDieta);
       nuevaDieta.addComponentListener(new ComponentAdapter(){
           
           @Override
           public void componentShown(ComponentEvent e){
               nuevaDieta.setLocation((desktop.getWidth() - nuevaDieta.getWidth())/ 2,
                       (desktop.getHeight() - nuevaDieta.getHeight()) / 2
               );
           }
       });
       desktop.moveToFront(nuevaDieta);
       nuevaDieta.setVisible(true);
       desktop.revalidate();
       desktop.repaint();
       
    }//GEN-LAST:event_menuCrearDietaActionPerformed

    private void menuListarMenuDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarMenuDiarioActionPerformed
        desktop.removeAll();
       VentanaLABBMenuDiario nuevoLABBMenu = new VentanaLABBMenuDiario();
       desktop.add(nuevoLABBMenu );
       nuevoLABBMenu.addComponentListener(new ComponentAdapter(){
           
           @Override
           public void componentShown(ComponentEvent e){
              nuevoLABBMenu.setLocation((desktop.getWidth() - nuevoLABBMenu .getWidth())/ 2,
                       (desktop.getHeight() - nuevoLABBMenu .getHeight()) / 2
               );
           }
       });
       desktop.moveToFront(nuevoLABBMenu );
       nuevoLABBMenu .setVisible(true);
       desktop.revalidate();
       desktop.repaint();
    }//GEN-LAST:event_menuListarMenuDiarioActionPerformed

    private void menuAltaBajaDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaBajaDietaActionPerformed
      desktop.removeAll();
       VentanaAltaBajaLogicaDieta altaBajaDieta = new VentanaAltaBajaLogicaDieta();
       desktop.add(altaBajaDieta );
       altaBajaDieta .addComponentListener(new ComponentAdapter(){
           
           @Override
           public void componentShown(ComponentEvent e){
              altaBajaDieta.setLocation((desktop.getWidth() - altaBajaDieta .getWidth())/ 2,
                       (desktop.getHeight() - altaBajaDieta .getHeight()) / 2
               );
           }
       });
       desktop.moveToFront(altaBajaDieta );
       altaBajaDieta.setVisible(true);
       desktop.revalidate();
       desktop.repaint();
    }//GEN-LAST:event_menuAltaBajaDietaActionPerformed

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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAltaBajaComida;
    private javax.swing.JMenuItem menuAltaBajaDieta;
    private javax.swing.JMenuItem menuAltaBajaPaciente;
    private javax.swing.JMenuItem menuBorrarAlimento;
    private javax.swing.JMenuItem menuBorrarDieta;
    private javax.swing.JMenu menuComidas;
    private javax.swing.JMenuItem menuCrearDieta;
    private javax.swing.JMenuItem menuCrearKey;
    private javax.swing.JMenuItem menuCrearMenuDiario;
    private javax.swing.JMenu menuDietas;
    private javax.swing.JMenuItem menuEditarPaciente;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuHandleKeys;
    private javax.swing.JMenuItem menuListarComidas;
    private javax.swing.JMenuItem menuListarDietas;
    private javax.swing.JMenuItem menuListarMenuDiario;
    private javax.swing.JMenuItem menuListarPacientes;
    private javax.swing.JMenuItem menuNuevoAlimento;
    private javax.swing.JMenuItem menuNuevoPaciente;
    private javax.swing.JMenu menuPacientes;
    // End of variables declaration//GEN-END:variables

}
