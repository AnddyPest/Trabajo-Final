package VistasDieta;

import Entidades.Alimento;
import Entidades.Dieta;
import Entidades.MenuDiario;
import Entidades.Paciente;
import Persistencia.AlimentoData;
import Persistencia.DietaData;
import Persistencia.Handlers.Dieta_MenuDiario_Handler_DATA;
import Persistencia.Handlers.MenuDiario_Alimento_Handler_DATA;
import Persistencia.MenuDiarioData;
import Persistencia.PacienteData;
import Utilities.Conexion;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Utilities.ExportarPDF;

public class VentanaExportarDieta extends javax.swing.JInternalFrame {

    DietaData dietaData;
    PacienteData pacienteData;
    Dieta_MenuDiario_Handler_DATA dieta_MenuDiario_Handler_DATA;
    MenuDiarioData menuDiarioData;
    AlimentoData alimentoData;
    MenuDiario_Alimento_Handler_DATA menuDiario_Alimento_Handler_DATA;
    

    public VentanaExportarDieta() {
        initComponents();
        Connection con = Conexion.getConexion();
        dietaData = new DietaData(con);
        pacienteData = new PacienteData(con);
        menuDiarioData = new MenuDiarioData(con);
        alimentoData = new AlimentoData(con);
        dieta_MenuDiario_Handler_DATA = new Dieta_MenuDiario_Handler_DATA(con);
        menuDiario_Alimento_Handler_DATA = new MenuDiario_Alimento_Handler_DATA(con);
        cargarComboDietas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        btnExportar = new javax.swing.JButton();
        btnVerDieta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbDietas = new javax.swing.JComboBox<>();
        btnSelectDieta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtPacienteName = new javax.swing.JTextField();
        txtIdPac = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaDieta = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Mostrar");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dieta");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Imagen acá");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        btnExportar.setText("Export PDF");
        btnExportar.setEnabled(false);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnVerDieta.setText("Ver Dieta");
        btnVerDieta.setEnabled(false);
        btnVerDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDietaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVerDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(btnVerDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        jPanel3.setBackground(new java.awt.Color(102, 0, 102));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(102, 0, 102));
        txtId.setForeground(new java.awt.Color(102, 0, 102));
        txtId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtId.setBorder(null);
        txtId.setCaretColor(new java.awt.Color(51, 0, 0));
        txtId.setFocusable(false);
        txtId.setRequestFocusEnabled(false);
        txtId.setSelectedTextColor(new java.awt.Color(51, 0, 0));
        txtId.setSelectionColor(new java.awt.Color(51, 0, 0));
        txtId.setVerifyInputWhenFocusTarget(false);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Dieta:");

        cmbDietas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbDietas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        btnSelectDieta.setText("Seleccionar");
        btnSelectDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectDietaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelectDieta, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectDieta))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 640, 50));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Paciente:");

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        txtPacienteName.setEditable(false);
        txtPacienteName.setBackground(new java.awt.Color(255, 153, 255));
        txtPacienteName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPacienteName.setForeground(new java.awt.Color(0, 0, 0));
        txtPacienteName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPacienteName.setBorder(null);

        txtIdPac.setEditable(false);
        txtIdPac.setBackground(new java.awt.Color(102, 102, 102));
        txtIdPac.setForeground(new java.awt.Color(102, 102, 102));
        txtIdPac.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPacienteName, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jSeparator4))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtIdPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPacienteName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        txtAreaDieta.setEditable(false);
        txtAreaDieta.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaDieta.setColumns(20);
        txtAreaDieta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAreaDieta.setForeground(new java.awt.Color(204, 204, 204));
        txtAreaDieta.setRows(5);
        jScrollPane3.setViewportView(txtAreaDieta);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 640, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSelectDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectDietaActionPerformed
        cmbDietas.setEnabled(false);
        Dieta selectedDiet = dietaData.buscarDietasPorNombre(cmbDietas.getSelectedItem().toString());

        txtId.setText(String.valueOf(selectedDiet.getIdDieta()));
        System.out.println(txtId.getText());
        txtIdPac.setText(String.valueOf(selectedDiet.getIdPaciente()));
        System.out.println(txtIdPac.getText());
        Paciente pacienteDieta = pacienteData.buscarPacientePorID(Integer.parseInt(txtIdPac.getText()));
        txtPacienteName.setText(pacienteDieta.getNombre());
        btnSelectDieta.setEnabled(false);
        btnVerDieta.setEnabled(true);
    }//GEN-LAST:event_btnSelectDietaActionPerformed

    private void btnVerDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDietaActionPerformed
      
    Dieta selectedDiet = dietaData.buscarDietasPorNombre(cmbDietas.getSelectedItem().toString());

    // Arraylist con los Id de Menu que estan relacionados con el Id de la Dieta
    ArrayList<Integer> handlerDietaMenu = dieta_MenuDiario_Handler_DATA.listarMenuDiario_DietaID(selectedDiet.getIdDieta());

    // Arraylist con los Menus que se encuentran en la Dieta
    ArrayList<MenuDiario> menusEnDieta = new ArrayList<>();

    for (Integer idMenu : handlerDietaMenu) {
        MenuDiario menu = menuDiarioData.buscarMenuPorID(idMenu);
        if (menu != null) {
            menusEnDieta.add(menu);
            System.out.println("ID DE MENU ENVIADO: " + idMenu);
        } else {
            System.out.println("No se encontró el menú con ID: " + idMenu);
        }
    }

    txtAreaDieta.setText("");
    txtAreaDieta.append("Dieta: " + selectedDiet.getNombre() + "\n");
    txtAreaDieta.append("Paciente: " + txtPacienteName.getText() + "\n");
    txtAreaDieta.append("Fecha inicio dieta: " + selectedDiet.getFechaInicio() + " Peso inicial: " + selectedDiet.getPesoInicial() + "Kg\n");
    txtAreaDieta.append("Fecha final dieta: " + selectedDiet.getFechaFinal() + " Peso final: " + selectedDiet.getPesoFinal() + "Kg\n");
    txtAreaDieta.append("-----------------------------------------------------------\n");

    // Orden de las comidas
    String[] ordenComidas = {"Desayuno", "Almuerzo", "Merienda", "Snack", "Cena"};

    for (MenuDiario menu : menusEnDieta) {
        txtAreaDieta.append("Menu dia " + menu.getDia() + " Necesitamos agregar fecha en el handler " + menu.getNombreMenu() + "\n");
        txtAreaDieta.append("-----------------------------------------------------------\n");

        // Obtener alimentos del menú diario usando menudiario_alimento_handler
        ArrayList<Integer> alimentosIdEnMenuActual = menuDiario_Alimento_Handler_DATA.listarAlimentosPorMenuDiarioID(menu.getIdMenuDiario());
        ArrayList<Alimento> alimentosEnMenuActual = new ArrayList<>();
        for (Integer idAli : alimentosIdEnMenuActual) {
            alimentosEnMenuActual.add(alimentoData.buscarAlimentoPorID(idAli));
        }

        // Agrupar alimentos por tipo de comida
        Map<String, List<Alimento>> alimentosPorTipo = alimentosEnMenuActual.stream()
                .collect(Collectors.groupingBy(Alimento::getTipoComida));

        // Iterar sobre los tipos de comida en el orden deseado
        for (String tipoComida : ordenComidas) {
            List<Alimento> alimentos = alimentosPorTipo.get(tipoComida);
            if (alimentos != null) {
                txtAreaDieta.append(tipoComida + "\n");
                for (Alimento alimento : alimentos) {
                    txtAreaDieta.append("Nombre del alimento: " + alimento.getNombre() + "\n");
                    txtAreaDieta.append("Descripción del alimento: " + alimento.getDetalle() + "\n");
                    txtAreaDieta.append("Calorías: " + alimento.getCaloriasPor100g() + "\n");
                    txtAreaDieta.append("-----------------------\n");
                }
            }
        }
        txtAreaDieta.append("Total de calorias del Día: " +menu.getCaloriasDelMenu() +"\n");
        txtAreaDieta.append("-----------------------------------------------------------\n");
        txtAreaDieta.append("-----------------------------------------------------------\n");
    }

    
    txtAreaDieta.append("Calorías totales de la dieta: " + selectedDiet.getTotalCalorias() + "\n");

    btnExportar.setEnabled(true);
    }//GEN-LAST:event_btnVerDietaActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        ExportarPDF.exportarJTextAreaAPdf(txtAreaDieta);
    }//GEN-LAST:event_btnExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnSelectDieta;
    private javax.swing.JButton btnVerDieta;
    private javax.swing.JComboBox<String> cmbDietas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextArea txtAreaDieta;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdPac;
    private javax.swing.JTextField txtPacienteName;
    // End of variables declaration//GEN-END:variables

    private void cargarComboDietas() {
        ArrayList<Dieta> listDietas = dietaData.listarDietas();
        for (Dieta d : listDietas) {
            cmbDietas.addItem(d.getNombre());
        }
    }

}
