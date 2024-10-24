package VistasAlimento;

import Entidades.Alimento;
import Entidades.Keywords;
import Persistencia.AlimentoData;
import Persistencia.Handlers.Alimento_Keyword_Handler_DATA;
import Persistencia.KeywordData;
import Utilities.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaNuevoAlimento extends javax.swing.JInternalFrame {

    AlimentoData alimentoData;
    KeywordData keywordData;
    Alimento_Keyword_Handler_DATA alimento_Keyword_Handler_DATA;
    private final DefaultTableModel modelListKeys = new NonEditableTableModel();
    private final DefaultTableModel modelAddedKeys = new NonEditableTableModel();

    public VentanaNuevoAlimento() {
        initComponents();
        Connection con = Conexion.getConexion();
        alimentoData = new AlimentoData(con);
        keywordData = new KeywordData(con);
        alimento_Keyword_Handler_DATA = new Alimento_Keyword_Handler_DATA(con);
        txtErrorDesc.setForeground(Color.green);
        cargarCabecerasGenerico((NonEditableTableModel) modelListKeys, tabKeys);
        cargarCabecerasGenerico((NonEditableTableModel) modelAddedKeys, tabAddedKeys);
        cargarTablaKeys();

    }

    private class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpComidas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnNw = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtNameAli = new javax.swing.JTextField();
        txtErrorNameAli = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtErrorTipoComida = new javax.swing.JLabel();
        rbtBreak = new javax.swing.JRadioButton();
        rbtLunch = new javax.swing.JRadioButton();
        rbtDinner = new javax.swing.JRadioButton();
        rbtSnack = new javax.swing.JRadioButton();
        rbtTea = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtErrorDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtCalorias = new javax.swing.JTextField();
        txtErrorCal = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        btnRemoveKey = new javax.swing.JButton();
        btnAddKey = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdNuevoAlimento = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabAddedKeys = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabKeys = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Nuevo");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Alimento");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Imagen acá");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnNw.setText("Nuevo");
        btnNw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNwActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(btnNw, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(btnNw, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));

        jPanel3.setBackground(new java.awt.Color(0, 51, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 630, 50));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Nombre del Alimento:");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        txtNameAli.setEditable(false);
        txtNameAli.setBackground(new java.awt.Color(153, 153, 153));
        txtNameAli.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtNameAli.setForeground(new java.awt.Color(0, 0, 0));
        txtNameAli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameAliKeyTyped(evt);
            }
        });

        txtErrorNameAli.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorNameAli.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorNameAli.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtErrorNameAli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNameAli, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtErrorNameAli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNameAli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Tipo:");

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        txtErrorTipoComida.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorTipoComida.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorTipoComida.setForeground(new java.awt.Color(255, 0, 0));

        grpComidas.add(rbtBreak);
        rbtBreak.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rbtBreak.setText("Desayuno");
        rbtBreak.setEnabled(false);
        rbtBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBreakActionPerformed(evt);
            }
        });

        grpComidas.add(rbtLunch);
        rbtLunch.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rbtLunch.setText("Almuerzo");
        rbtLunch.setEnabled(false);
        rbtLunch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtLunchActionPerformed(evt);
            }
        });

        grpComidas.add(rbtDinner);
        rbtDinner.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rbtDinner.setText("Cena");
        rbtDinner.setEnabled(false);
        rbtDinner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDinnerActionPerformed(evt);
            }
        });

        grpComidas.add(rbtSnack);
        rbtSnack.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rbtSnack.setText("Snack");
        rbtSnack.setEnabled(false);
        rbtSnack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSnackActionPerformed(evt);
            }
        });

        grpComidas.add(rbtTea);
        rbtTea.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rbtTea.setText("Merienda");
        rbtTea.setEnabled(false);
        rbtTea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTeaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErrorTipoComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(rbtBreak)
                        .addGap(18, 18, 18)
                        .addComponent(rbtLunch)
                        .addGap(18, 18, 18)
                        .addComponent(rbtTea)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSnack)
                        .addGap(18, 18, 18)
                        .addComponent(rbtDinner)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtErrorTipoComida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtBreak)
                    .addComponent(rbtLunch)
                    .addComponent(rbtDinner)
                    .addComponent(rbtSnack)
                    .addComponent(rbtTea))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Descripción:");

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        txtErrorDesc.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorDesc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorDesc.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorDesc.setText("*El minimo de caracteres en la descripción es 20.-");

        txtDescription.setEditable(false);
        txtDescription.setBackground(new java.awt.Color(153, 153, 153));
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(0, 0, 0));
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Calorias del plato");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        txtCalorias.setEditable(false);
        txtCalorias.setBackground(new java.awt.Color(153, 153, 153));
        txtCalorias.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        txtCalorias.setForeground(new java.awt.Color(0, 0, 0));
        txtCalorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCaloriasKeyTyped(evt);
            }
        });

        txtErrorCal.setEditable(false);
        txtErrorCal.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorCal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorCal.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorCal.setBorder(null);

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Keys añadidas");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnRemoveKey.setText("<");
        btnRemoveKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveKeyActionPerformed(evt);
            }
        });

        btnAddKey.setText(">");
        btnAddKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKeyActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Seleccione al menos 1 key");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtIdNuevoAlimento.setEditable(false);
        txtIdNuevoAlimento.setBackground(new java.awt.Color(51, 51, 51));
        txtIdNuevoAlimento.setForeground(new java.awt.Color(51, 51, 51));
        txtIdNuevoAlimento.setBorder(null);

        btnFinalizar.setText("Añadir y Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        tabAddedKeys.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane4.setViewportView(tabAddedKeys);

        tabKeys.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabKeys.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane5.setViewportView(tabKeys);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtErrorDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(txtErrorCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(txtIdNuevoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddKey, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveKey, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtErrorDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtErrorCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(txtCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtIdNuevoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnAddKey)
                        .addGap(27, 27, 27)
                        .addComponent(btnRemoveKey)
                        .addGap(42, 42, 42)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 630, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNwActionPerformed
        btnNw.setEnabled(false);
        txtErrorNameAli.setForeground(Color.red);
        txtErrorNameAli.setText("");
        txtNameAli.setText("");
        txtNameAli.setEditable(true);
        txtNameAli.requestFocus();
        txtErrorTipoComida.setForeground(Color.red);
        txtErrorTipoComida.setText("");
        grpComidas.clearSelection();
        rbtBreak.setEnabled(true);
        rbtDinner.setEnabled(true);
        rbtLunch.setEnabled(true);
        rbtSnack.setEnabled(true);
        rbtTea.setEnabled(true);
        txtDescription.setText("");
        txtDescription.setEditable(true);
        txtErrorCal.setForeground(Color.red);
        txtErrorCal.setText("");
        txtCalorias.setText("");
        txtCalorias.setEditable(true);


    }//GEN-LAST:event_btnNwActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (validarEntradas()) {
            if (txtNameAli.getText().isEmpty()) {
                txtErrorNameAli.setText("*Ingrese un Nombre.");
                txtNameAli.requestFocus();
            } else if (!(rbtBreak.isSelected() || rbtDinner.isSelected() || rbtLunch.isSelected() || rbtSnack.isSelected() || rbtTea.isSelected())) {
                txtErrorTipoComida.setText("Debe seleccionar un tipo de comida.");
            } else if (txtDescription.getText().isEmpty()) {
                txtErrorDesc.setText("*Debe Ingresar una descripcion de al menos 20 caracteres.");
                txtDescription.requestFocus();
            } else if (txtCalorias.getText().isEmpty()) {
                txtErrorCal.setText("*Ingrese un valor.");
                txtCalorias.requestFocus();
            } else {
                String nombre = txtNameAli.getText();
                String tipo = "";
                if (rbtBreak.isSelected()) {
                    tipo = "Desayuno";
                } else if (rbtLunch.isSelected()) {
                    tipo = "Almuerzo";
                } else if (rbtTea.isSelected()) {
                    tipo = "Merienda";
                } else if (rbtSnack.isSelected()) {
                    tipo = "Snack";
                } else if (rbtDinner.isSelected()) {
                    tipo = "Cena";
                }

                int cal = Integer.parseInt(txtCalorias.getText());
                String desc = txtDescription.getText();

                Alimento alimento = new Alimento(nombre, tipo, cal, desc);

                alimentoData.crearAlimento(alimento);
                txtNameAli.setEditable(false);
                txtDescription.setEditable(false);
                txtCalorias.setEditable(false);
                btnSave.setEnabled(false);
                btnNw.setEnabled(true);
                txtErrorNameAli.setForeground(Color.green);
                txtErrorNameAli.setText("*Nuevo alimento agregado con éxito.");
                Alimento completo = alimentoData.buscarAlimentoPorNombre(nombre);
                txtIdNuevoAlimento.setText(String.valueOf(completo.getIdAlimento())); 

            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtNameAliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameAliKeyTyped
        validarEntradas();
        txtErrorNameAli.setText("");
    }//GEN-LAST:event_txtNameAliKeyTyped

    private void rbtBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBreakActionPerformed
        validarEntradas();
        cerrarRadios();
    }//GEN-LAST:event_rbtBreakActionPerformed

    private void rbtLunchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtLunchActionPerformed
        validarEntradas();
        cerrarRadios();
    }//GEN-LAST:event_rbtLunchActionPerformed

    private void rbtTeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTeaActionPerformed
        validarEntradas();
        cerrarRadios();
    }//GEN-LAST:event_rbtTeaActionPerformed

    private void rbtSnackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSnackActionPerformed
        validarEntradas();
        cerrarRadios();
    }//GEN-LAST:event_rbtSnackActionPerformed

    private void rbtDinnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDinnerActionPerformed
        validarEntradas();
        cerrarRadios();
    }//GEN-LAST:event_rbtDinnerActionPerformed

    private void txtCaloriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaloriasKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
            txtErrorCal.setText("*Solo números.");
        } else {
            txtErrorCal.setText("");
        }
        validarEntradas();
    }//GEN-LAST:event_txtCaloriasKeyTyped

    private void txtDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyTyped
        txtErrorDesc.setText("");
        if (txtDescription.getText().toString().length() >= 20) {
            validarEntradas();
        }
    }//GEN-LAST:event_txtDescriptionKeyTyped

    private void btnAddKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKeyActionPerformed
        if (tabKeys.getSelectedRow() != -1) {
            int fila = tabKeys.getSelectedRow();
            int colId = 0;
            int colKey = 1;
            modelAddedKeys.addRow(new Object[]{
                tabKeys.getValueAt(fila, colId),
                tabKeys.getValueAt(fila, colKey)
            });
            modelListKeys.removeRow(fila);
        } else {
            System.out.println("Seleccione una fila");
        }
        
        ordenarTablaAlfabeticamente(tabAddedKeys);
    }//GEN-LAST:event_btnAddKeyActionPerformed

    private void btnRemoveKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveKeyActionPerformed
        if (tabAddedKeys.getSelectedRow() != -1) {
            int fila = tabAddedKeys.getSelectedRow();
            int colId = 0;
            int colKey = 1;
            modelListKeys.addRow(new Object[]{
                tabAddedKeys.getValueAt(fila, colId),
                tabAddedKeys.getValueAt(fila, colKey)
            });
            modelAddedKeys.removeRow(fila);
        } else {
            System.out.println("Seleccione una fila");
        }
        ordenarTablaAlfabeticamente(tabKeys);
        

    }//GEN-LAST:event_btnRemoveKeyActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        DefaultTableModel modelo = (NonEditableTableModel) tabAddedKeys.getModel();

        ArrayList<Integer> listaKeysAdded = new ArrayList<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            int idKey = (int) modelo.getValueAt(i, 0);
            
            listaKeysAdded.add(idKey);
        }
        
        for(int i = 0; i< listaKeysAdded.size(); i++) {
            alimento_Keyword_Handler_DATA.createAlimento_Keyword_Handler(listaKeysAdded.get(i), Integer.parseInt(txtIdNuevoAlimento.getText()));
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKey;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnNw;
    private javax.swing.JButton btnRemoveKey;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup grpComidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JRadioButton rbtBreak;
    private javax.swing.JRadioButton rbtDinner;
    private javax.swing.JRadioButton rbtLunch;
    private javax.swing.JRadioButton rbtSnack;
    private javax.swing.JRadioButton rbtTea;
    private javax.swing.JTable tabAddedKeys;
    private javax.swing.JTable tabKeys;
    private javax.swing.JTextField txtCalorias;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtErrorCal;
    private javax.swing.JLabel txtErrorDesc;
    private javax.swing.JLabel txtErrorNameAli;
    private javax.swing.JLabel txtErrorTipoComida;
    private javax.swing.JTextField txtIdNuevoAlimento;
    private javax.swing.JTextField txtNameAli;
    // End of variables declaration//GEN-END:variables

    private boolean validarEntradas() {
        if (!txtNameAli.getText().isEmpty() && !txtDescription.getText().isEmpty() && !txtCalorias.getText().isEmpty() && (rbtBreak.isSelected() || rbtDinner.isSelected() || rbtLunch.isSelected() || rbtSnack.isSelected() || rbtTea.isSelected())) {
            btnSave.setEnabled(true);
        }
        return true;
    }

    private void cerrarRadios() {
        rbtBreak.setEnabled(false);
        rbtDinner.setEnabled(false);
        rbtLunch.setEnabled(false);
        rbtSnack.setEnabled(false);
        rbtTea.setEnabled(false);
    }

    private void cargarCabecerasGenerico(NonEditableTableModel modelo, JTable table) {
        modelo.addColumn("ID Key");
        modelo.addColumn("key");

        table.setModel(modelo);

    }

    private void cargarTablaKeys() {
        modelListKeys.setRowCount(0);
        ArrayList<Keywords> keyList = keywordData.listarKeywords();
        for (Keywords k : keyList) {
            modelListKeys.addRow(new Object[]{
                k.getIdKeyword(),
                k.getKeyword()
            });
        }

    }

    private void ordenarTablaAlfabeticamente(JTable tabla) {
        DefaultTableModel modelo = (NonEditableTableModel) tabla.getModel();

        ArrayList<Object[]> filas = new ArrayList<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            int valorColumna0 = (int) modelo.getValueAt(i, 0);
            String valorColumna1 = modelo.getValueAt(i, 1).toString();
            filas.add(new Object[]{valorColumna0, valorColumna1});
        }
        
         Collections.sort(filas, (a, b) -> ((String) a[1]).compareTo((String) b[1]));

        modelo.setRowCount(0);

        for (Object[] fila : filas) {
            modelo.addRow(fila);
        }
    }

}
