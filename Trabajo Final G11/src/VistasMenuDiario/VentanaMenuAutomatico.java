package VistasMenuDiario;

import Entidades.Alimento;
import Entidades.Keywords;
import Entidades.MenuDiario;
import Persistencia.AlimentoData;
import Persistencia.Alimento_KeywordData;
import Persistencia.Handlers.MenuDiario_Alimento_Handler_DATA;
import Persistencia.KeywordData;
import Persistencia.MenuDiarioData;
import Utilities.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaMenuAutomatico extends javax.swing.JInternalFrame {

    private final DefaultListModel<String> modelListaKeys = new NonEditableListModel();
    private final DefaultListModel<String> modelListaKeysIn = new NonEditableListModel();
    private final DefaultListModel<String> modelListaKeysNotIn = new NonEditableListModel();
    private final DefaultTableModel modelTablaFiltered = new NonEditableTableModel();
    private final DefaultTableModel modelTablaMenu = new NonEditableTableModel();
    KeywordData keywordData;
    AlimentoData alimentoData;
    Alimento_KeywordData alimento_KeywordData;
    MenuDiarioData menuDiarioData;
    MenuDiario_Alimento_Handler_DATA menuDiario_Alimento_Handler_DATA;

    public VentanaMenuAutomatico() {
        initComponents();
        txtMenuName.requestFocus();
        Connection con = Conexion.getConexion();
        keywordData = new KeywordData(con);
        alimentoData = new AlimentoData(con);
        alimento_KeywordData = new Alimento_KeywordData(con);
        menuDiarioData = new MenuDiarioData(con);
        menuDiario_Alimento_Handler_DATA = new MenuDiario_Alimento_Handler_DATA(con);
        listIncluye.setModel(modelListaKeysIn);
        listNoIncluye.setModel(modelListaKeysNotIn);
        cargarListaKeys();
        cargarCabecerasGenerico((NonEditableTableModel) modelTablaFiltered, tabListadoFiltered);
        cargarCabecerasGenerico((NonEditableTableModel) modelTablaMenu, tabMenuDiario);
        cargarAlimentosAll();
        txtError.setForeground(Color.red);

    }

    private class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private class NonEditableListModel extends DefaultListModel<String> {

        @Override
        public void setElementAt(String element, int index) {
            // No permitir la edición del elemento
            throw new UnsupportedOperationException("No se puede editar el elemento.");
        }

        @Override
        public void removeElementAt(int index) {
            // Permitir eliminar elementos
            super.removeElementAt(index);
        }

        @Override
        public void addElement(String element) {
            super.addElement(element);
        }
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
        btnGenerate = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnComenzar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMenuName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        panelRadios = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtLimite = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtError = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listIncluye = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listKeywords = new javax.swing.JList<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listNoIncluye = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btnAddIn = new javax.swing.JButton();
        btnRemoveIn = new javax.swing.JButton();
        btnAddNot = new javax.swing.JButton();
        btnRemoveNot = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabListadoFiltered = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabMenuDiario = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCalTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Menu");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Automatico");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Imagen acá");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnGenerate.setText("Generar");
        btnGenerate.setEnabled(false);
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        btnGuardar.setText("Guardar Menu");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnComenzar.setText("Comenzar");
        btnComenzar.setEnabled(false);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnComenzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(0, 102, 102));
        txtId.setForeground(new java.awt.Color(0, 102, 102));
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
        jLabel11.setText("Nombre del Menu:");

        txtMenuName.setBackground(new java.awt.Color(0, 255, 204));
        txtMenuName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtMenuName.setForeground(new java.awt.Color(0, 0, 0));
        txtMenuName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMenuName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMenuNameKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMenuName, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMenuName)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 640, 50));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRadios.setBackground(new java.awt.Color(51, 51, 51));
        panelRadios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Limite de calorias:");

        txtLimite.setBackground(new java.awt.Color(153, 153, 153));
        txtLimite.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtLimite.setForeground(new java.awt.Color(0, 0, 0));
        txtLimite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLimiteKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Calorías");

        txtError.setEditable(false);
        txtError.setBackground(new java.awt.Color(51, 51, 51));
        txtError.setForeground(new java.awt.Color(51, 51, 51));
        txtError.setBorder(null);

        javax.swing.GroupLayout panelRadiosLayout = new javax.swing.GroupLayout(panelRadios);
        panelRadios.setLayout(panelRadiosLayout);
        panelRadiosLayout.setHorizontalGroup(
            panelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtError, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRadiosLayout.setVerticalGroup(
            panelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.add(panelRadios, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 618, -1));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        listIncluye.setBackground(new java.awt.Color(102, 102, 102));
        listIncluye.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 3, true));
        listIncluye.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        listIncluye.setForeground(new java.awt.Color(204, 204, 204));
        listIncluye.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listIncluye);

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Que Contenga");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 3, true));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 49, -1, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        listKeywords.setBackground(new java.awt.Color(102, 102, 102));
        listKeywords.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        listKeywords.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listKeywords);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 170, 203));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        listNoIncluye.setBackground(new java.awt.Color(102, 102, 102));
        listNoIncluye.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        listNoIncluye.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        listNoIncluye.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(listNoIncluye);

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Que NO Contenga");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 49, -1, 203));

        btnAddIn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAddIn.setText("<");
        btnAddIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 121, 40, -1));

        btnRemoveIn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRemoveIn.setText(">");
        btnRemoveIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveInActionPerformed(evt);
            }
        });
        jPanel4.add(btnRemoveIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 162, 40, -1));

        btnAddNot.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAddNot.setText(">");
        btnAddNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNotActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddNot, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 121, 40, -1));

        btnRemoveNot.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRemoveNot.setText("<");
        btnRemoveNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveNotActionPerformed(evt);
            }
        });
        jPanel4.add(btnRemoveNot, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 162, 40, -1));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane6.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane6.setForeground(new java.awt.Color(204, 204, 204));
        jScrollPane6.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tabListadoFiltered.setBackground(new java.awt.Color(0, 0, 0));
        tabListadoFiltered.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabListadoFiltered.setForeground(new java.awt.Color(204, 204, 204));
        tabListadoFiltered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabListadoFiltered.setEnabled(false);
        tabListadoFiltered.setGridColor(new java.awt.Color(153, 153, 153));
        tabListadoFiltered.setSelectionBackground(new java.awt.Color(0, 153, 204));
        tabListadoFiltered.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jScrollPane6.setViewportView(tabListadoFiltered);

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Seleccione el alimento a agregar al -- MENU DIARIO --");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 618, -1));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("-- MENU DIARIO --");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jScrollPane7.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane7.setForeground(new java.awt.Color(204, 204, 204));
        jScrollPane7.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tabMenuDiario.setBackground(new java.awt.Color(0, 0, 0));
        tabMenuDiario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabMenuDiario.setForeground(new java.awt.Color(204, 204, 204));
        tabMenuDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabMenuDiario.setEnabled(false);
        tabMenuDiario.setGridColor(new java.awt.Color(153, 153, 153));
        jScrollPane7.setViewportView(tabMenuDiario);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, 150));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("TOTAL CALORIAS:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, 40));

        txtCalTotal.setEditable(false);
        txtCalTotal.setBackground(new java.awt.Color(51, 51, 51));
        txtCalTotal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtCalTotal.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.add(txtCalTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 90, 40));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("cal");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 600, 60));

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

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        ArrayList<Alimento> desayunos = alimentoData.buscarAlimentosPorTipoComida("Desayuno");
        ArrayList<Alimento> almuerzos = alimentoData.buscarAlimentosPorTipoComida("Almuerzo");
        ArrayList<Alimento> meriendas = alimentoData.buscarAlimentosPorTipoComida("Merienda");
        ArrayList<Alimento> snacks = alimentoData.buscarAlimentosPorTipoComida("Snack");
        ArrayList<Alimento> cenas = alimentoData.buscarAlimentosPorTipoComida("Cena");
        modelTablaMenu.setRowCount(0);
        int intentos = 0;
        if (!txtLimite.getText().isEmpty() && Integer.parseInt(txtLimite.getText()) <= 10000 && Integer.parseInt(txtLimite.getText()) >= 1000 ) {
            txtError.setText("");
            int limiteCalorias = Integer.parseInt(txtLimite.getText());
            
            while (tabMenuDiario.getRowCount() < 5 ) {
                if(intentos != 100){
                    int randomIndexDesayuno = (int) (Math.random() * desayunos.size());
                    int randomIndexAlmuerzo = (int) (Math.random() * almuerzos.size());
                    int randomIndexMerienda = (int) (Math.random() * meriendas.size());
                    int randomIndexSnack = (int) (Math.random() * snacks.size());
                    int randomIndexCena = (int) (Math.random() * cenas.size());
                    Alimento desayuno = desayunos.get(randomIndexDesayuno);
                    Alimento almuerzo = almuerzos.get(randomIndexAlmuerzo);
                    Alimento merienda = meriendas.get(randomIndexMerienda);
                    Alimento snack = snacks.get(randomIndexSnack);
                    Alimento cena = cenas.get(randomIndexCena);

                    boolean desayunoValido = verificarEnTabla(desayuno.getIdAlimento());
                    boolean almuerzoValido = verificarEnTabla(almuerzo.getIdAlimento());
                    boolean meriendaValido = verificarEnTabla(merienda.getIdAlimento());
                    boolean snackValido = verificarEnTabla(snack.getIdAlimento());
                    boolean cenaValido = verificarEnTabla(cena.getIdAlimento());

                    int sumaCalorias = desayuno.getCaloriasPor100g() + almuerzo.getCaloriasPor100g() + merienda.getCaloriasPor100g() + snack.getCaloriasPor100g() + cena.getCaloriasPor100g();
                    intentos+= 1;
                    if (sumaCalorias <= limiteCalorias && desayunoValido && almuerzoValido && meriendaValido && snackValido && cenaValido) {
                        txtCalTotal.setText(String.valueOf(sumaCalorias));
                        modelTablaMenu.addRow(new Object[]{
                            desayuno.getIdAlimento(), desayuno.getTipoComida(), desayuno.getNombre(), desayuno.getCaloriasPor100g()
                        });
                        modelTablaMenu.addRow(new Object[]{
                            almuerzo.getIdAlimento(), almuerzo.getTipoComida(), almuerzo.getNombre(), almuerzo.getCaloriasPor100g()
                        });
                        modelTablaMenu.addRow(new Object[]{
                            merienda.getIdAlimento(), merienda.getTipoComida(), merienda.getNombre(), merienda.getCaloriasPor100g()
                        });
                        modelTablaMenu.addRow(new Object[]{
                            snack.getIdAlimento(), snack.getTipoComida(), snack.getNombre(), snack.getCaloriasPor100g()
                        });
                        modelTablaMenu.addRow(new Object[]{
                            cena.getIdAlimento(), cena.getTipoComida(), cena.getNombre(), cena.getCaloriasPor100g()
                        });
                        btnGuardar.setEnabled(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "No se encontraron resultados");
                    cargarListaKeys();
                    modelListaKeysIn.clear();
                    modelListaKeysNotIn.clear();
                    cargarAlimentosAll();
                    modelTablaMenu.setRowCount(0);
                    break;
                }
                
            }
        }else if(txtLimite.getText().isEmpty() ){
            txtLimite.requestFocus();
            txtError.setText("Debe ingresar un limite de calorías."); 
        }else{
            txtLimite.setText("");
            txtError.setText("Establezca un límite entre 1000 y 10.000 cal");
        }
        

    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        btnComenzar.setEnabled(false);
        String nombreMenu = txtMenuName.getText();

        int caloriasDelMenu = Integer.parseInt(txtCalTotal.getText());

        MenuDiario menuDiario = new MenuDiario(nombreMenu, caloriasDelMenu);

        menuDiarioData.crearMenuDiario(menuDiario);
        MenuDiario menuEnviado = menuDiarioData.buscarMenuPorNombre(nombreMenu);

        for (int i = 0; i < tabMenuDiario.getRowCount(); i++) {
            int idAlimentoMenu = (int) tabMenuDiario.getValueAt(i, 0);
            System.out.println("ID ALIMENTO ENVIADO " + idAlimentoMenu);
            System.out.println("ID MENU ENVIADO " + menuEnviado.getIdMenuDiario());
            menuDiario_Alimento_Handler_DATA.createHandler_MenuDiario_Alimento(menuEnviado, alimentoData.buscarAlimentoPorID(idAlimentoMenu));
        }

        txtMenuName.setText("");
        modelTablaMenu.setRowCount(0);
        txtCalTotal.setText("");

        listIncluye.removeAll();
        listNoIncluye.removeAll();
        cargarListaKeys();
        cargarAlimentosAll();
        btnGuardar.setEnabled(false);
        txtMenuName.setEditable(true);
        txtMenuName.requestFocus();
        btnComenzar.setEnabled(false);
        txtError.setForeground(Color.green);
        txtError.setText("Menu agregado con exito"); 

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        if (txtMenuName.getText().isEmpty()) {
            txtMenuName.requestFocus();
            txtError.setText("*Nombre no puede quedar vacío");
        } else {
            txtError.setText(""); 
            btnGenerate.setEnabled(true);
            txtMenuName.setEditable(false);
            btnComenzar.setEnabled(false);
        }
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void txtMenuNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenuNameKeyTyped
        if (!txtMenuName.getText().isEmpty()) {
            btnComenzar.setEnabled(true);
            txtError.setText("");
            txtError.setForeground(Color.red);
        }
    }//GEN-LAST:event_txtMenuNameKeyTyped

    private void btnAddInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInActionPerformed
        moverElementoEntreListas(listKeywords, listIncluye, modelListaKeys, modelListaKeysIn);
        filtroKeywords();
        
    }//GEN-LAST:event_btnAddInActionPerformed

    private void btnRemoveInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveInActionPerformed
        moverElementoEntreListas(listIncluye, listKeywords, modelListaKeysIn, modelListaKeys);
        filtroKeywords();
        
    }//GEN-LAST:event_btnRemoveInActionPerformed

    private void btnAddNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNotActionPerformed
        moverElementoEntreListas(listKeywords, listNoIncluye, modelListaKeys, modelListaKeysNotIn);
        filtroKeywords();
        
    }//GEN-LAST:event_btnAddNotActionPerformed

    private void btnRemoveNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveNotActionPerformed
        moverElementoEntreListas(listNoIncluye, listKeywords, modelListaKeysNotIn, modelListaKeys);
        filtroKeywords();
        
    }//GEN-LAST:event_btnRemoveNotActionPerformed

    private void txtLimiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLimiteKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;

        if (!numero) {
            evt.consume();
            txtError.setText("*Solo números.");
        } else {
            txtError.setText("");
        }
    }//GEN-LAST:event_txtLimiteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddIn;
    private javax.swing.JButton btnAddNot;
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRemoveIn;
    private javax.swing.JButton btnRemoveNot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JList<String> listIncluye;
    private javax.swing.JList<String> listKeywords;
    private javax.swing.JList<String> listNoIncluye;
    private javax.swing.JPanel panelRadios;
    private javax.swing.JTable tabListadoFiltered;
    private javax.swing.JTable tabMenuDiario;
    private javax.swing.JTextField txtCalTotal;
    private javax.swing.JTextField txtError;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLimite;
    private javax.swing.JTextField txtMenuName;
    // End of variables declaration//GEN-END:variables
private void cargarListaKeys() {
        modelListaKeys.removeAllElements();
        ArrayList<Keywords> keysList = keywordData.listarKeywords();
        listKeywords.setModel(modelListaKeys);

        for (Keywords k : keysList) {
            modelListaKeys.addElement(k.getKeyword());

        }
        ordenarListaAlfabeticamente(listKeywords);
        ordenarListaAlfabeticamente(listIncluye);
    }

    private void moverElementoEntreListas(JList<String> listaOrigen, JList<String> listaDestino, DefaultListModel<String> modeloOrigen, DefaultListModel<String> modeloDestino) {
        String selectedKey = listaOrigen.getSelectedValue();

        if (selectedKey != null) {
            
            if(modeloDestino.getSize() < 5){
                modeloOrigen.removeElement(selectedKey);

                modeloDestino.addElement(selectedKey);

                ordenarListaAlfabeticamente(listaOrigen);

                ordenarListaAlfabeticamente(listaDestino);
            }else{
                txtError.setText("Maximo 5 keys.");
            }
               
        }
        
    }

    private void ordenarListaAlfabeticamente(JList<String> lista) {
        DefaultListModel<String> modelo = (DefaultListModel<String>) lista.getModel();

        ArrayList<String> elementos = new ArrayList<>();

        for (int i = 0; i < modelo.size(); i++) {
            elementos.add(modelo.getElementAt(i));
        }

        Collections.sort(elementos);

        modelo.clear();

        for (String elemento : elementos) {
            modelo.addElement(elemento);
        }
    }   

    private void cargarCabecerasGenerico(NonEditableTableModel modelo, JTable table) {
        modelo.addColumn("ID Alimento");
        modelo.addColumn("Tipo");
        modelo.addColumn("Alimento");
        modelo.addColumn("Calorias");

        table.setModel(modelo);

    }

    private void cargarAlimentosAll() {
        modelTablaFiltered.setRowCount(0);
        ArrayList<Alimento> alimentosAll = alimentoData.listarAlimentosActivos();
        for (Alimento a : alimentosAll) {
            modelTablaFiltered.addRow(new Object[]{
                a.getIdAlimento(),
                a.getTipoComida(),
                a.getNombre(),
                a.getCaloriasPor100g()

            });

        }

    }

    private void filtroKeywords() {
        modelTablaFiltered.setRowCount(0);
        ArrayList<String> keysIn = new ArrayList<>();
        ArrayList<String> keysOut = new ArrayList<>();
        if (!keysIn.isEmpty()) {
            keysIn.removeAll(keysIn);
        }
        if (!keysOut.isEmpty()) {
            keysOut.removeAll(keysOut);
        }

        DefaultListModel<String> modeloIn = (DefaultListModel<String>) listIncluye.getModel();

        for (int i = 0; i < modeloIn.getSize(); i++) {
            String keyIn = modeloIn.getElementAt(i);
            keysIn.add(keyIn);
            System.out.println("Keys IN: " + keysIn.toString());
        }

        DefaultListModel<String> modeloOut = (DefaultListModel<String>) listNoIncluye.getModel();

        for (int i = 0; i < modeloOut.getSize(); i++) {
            String keyOut = modeloOut.getElementAt(i);
            keysOut.add(keyOut);
            System.out.println("Keys OUT: " + keysOut.toString());
        }

        ArrayList<Alimento> listadoFiltrado = alimento_KeywordData.obtenerAlimentosPorKeywordsYaEspecificadas(keysIn, keysOut);
        if (listadoFiltrado != null && !listadoFiltrado.isEmpty()) {
            for (Alimento a : listadoFiltrado) {
                modelTablaFiltered.addRow(new Object[]{
                    a.getIdAlimento(),
                    a.getTipoComida(),
                    a.getNombre(),
                    a.getCaloriasPor100g()

                });
            }
        }
        if (keysIn.isEmpty() && keysOut.isEmpty()) {
            cargarAlimentosAll();
        }
    }

    private boolean verificarEnTabla(int idAlimento) {
        for (int i = 0; i < tabListadoFiltered.getRowCount(); i++) {
            int idEnTabla = (int) tabListadoFiltered.getValueAt(i, 0);
            if (idAlimento == idEnTabla) {
                return true;
            }
        }
        return false;
    }

   

}
