package VistasDieta;

import Entidades.Dieta;
import Entidades.Handlers.Dieta_MenuDiario_Handler;
import Entidades.MenuDiario;
import Entidades.Paciente;
import Persistencia.DietaData;
import Persistencia.Handlers.Dieta_MenuDiario_Handler_DATA;
import Persistencia.MenuDiarioData;
import Persistencia.PacienteData;
import Utilities.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VentanaEditEraseDieta extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new NonEditableTableModel();
    private final DefaultTableModel modelo1 = new NonEditableTableModel();
    private final DefaultTableModel modelo2 = new NonEditableTableModel();
    DietaData dietaData;
    Dieta_MenuDiario_Handler_DATA dietaMenuHand;
    MenuDiarioData menuDiarioData;
    PacienteData pacienteData;

    public VentanaEditEraseDieta() {
        initComponents();
        Connection con = Conexion.getConexion();
        dietaData = new DietaData(con);
        dietaMenuHand = new Dieta_MenuDiario_Handler_DATA(con);
        menuDiarioData = new MenuDiarioData(con);
        pacienteData = new PacienteData(con);
        txtMsg.setForeground(Color.yellow);
        txtMsg.setText("**Elija un modo de operar.**");
        cargarCabeceraDietas();
        cargarCabeceraMenues((NonEditableTableModel) modelo1, tabMenuSelect);
        cargarCabeceraMenues((NonEditableTableModel) modelo2, tabMenuAdd);
        actualizarTabla();

        //Actualiza los datos que se muestran en la tabla, entonces, no creo que aca funque mucho
        //el sistema de edicion. Tal vez si, pero por ahora no.
        tabListDietas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tabListDietas.getSelectedRow();
                    if (fila != -1) {
                        txtId.setText((tabListDietas.getValueAt(fila, 0)).toString());
                        txtMsg.setText(tabListDietas.getValueAt(fila, 1).toString());
                        LocalDate inicioDiet = LocalDate.parse(tabListDietas.getValueAt(fila, 2).toString());
                        LocalDate finalDiet = LocalDate.parse(tabListDietas.getValueAt(fila, 3).toString());
                        fechaInicio.setDate(Date.from(inicioDiet.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                        fechaFinal.setDate(Date.from(finalDiet.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                        if (radioEditar.isSelected()) {
                            txtMsg.setText("Esta por editar " + " a " + tabListDietas.getValueAt(fila, 1).toString());
                            txtMsg.setForeground(Color.yellow);
                            //btnFinEdit.setEnabled(true);
                        } else {
                            txtMsg.setText("se dara de " + btnUpdate.getText() + " a " + tabListDietas.getValueAt(fila, 1).toString());
                            txtMsg.setForeground(Color.yellow);
                        }
                        btnUpdate.setEnabled(true);
                    }
                }
            }
        });

        //LISTENERS DE LAS TABLAS DE LOS MENUS:
        tabMenuSelect.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tabMenuSelect.getSelectedRow();
                    if (fila != -1) {

                    }
                }
            }
        });

        // TABLA DE AGREGAR MENUS
        tabMenuAdd.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tabMenuAdd.getSelectedRow();
                    if (fila != -1) {

                    }
                }
            }
        });
    }

    //HACE QUE LAS CELDAS DE LA TABLA NO SEA EDITABLE
    private class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        radioAlta = new javax.swing.JRadioButton();
        radioBaja = new javax.swing.JRadioButton();
        radioBorrar = new javax.swing.JRadioButton();
        btnUpdate = new javax.swing.JButton();
        txtErrorName = new javax.swing.JLabel();
        radioEditar = new javax.swing.JRadioButton();
        btnFinEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtMsg = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        fechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtDieta = new javax.swing.JTextField();
        cmbDieta = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        btnRemoveMenu = new javax.swing.JButton();
        btnAddMenu = new javax.swing.JButton();
        txtCalTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMenuSelect = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabListDietas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabMenuAdd = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("L.E.B.A.B");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dieta");

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        radioAlta.setBackground(new java.awt.Color(102, 0, 102));
        btnGroup.add(radioAlta);
        radioAlta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioAlta.setForeground(new java.awt.Color(204, 204, 204));
        radioAlta.setText("Alta Dieta");
        radioAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAltaActionPerformed(evt);
            }
        });

        radioBaja.setBackground(new java.awt.Color(102, 0, 102));
        btnGroup.add(radioBaja);
        radioBaja.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioBaja.setForeground(new java.awt.Color(204, 204, 204));
        radioBaja.setText("Baja Dieta");
        radioBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBajaActionPerformed(evt);
            }
        });

        radioBorrar.setBackground(new java.awt.Color(102, 0, 102));
        btnGroup.add(radioBorrar);
        radioBorrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioBorrar.setForeground(new java.awt.Color(204, 204, 204));
        radioBorrar.setText("Borrar Dieta");
        radioBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBorrarActionPerformed(evt);
            }
        });

        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtErrorName.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorName.setForeground(new java.awt.Color(255, 0, 0));

        radioEditar.setBackground(new java.awt.Color(102, 0, 102));
        btnGroup.add(radioEditar);
        radioEditar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioEditar.setForeground(new java.awt.Color(204, 204, 204));
        radioEditar.setText("Editar dieta");
        radioEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditarActionPerformed(evt);
            }
        });

        btnFinEdit.setText("Aceptar");
        btnFinEdit.setEnabled(false);
        btnFinEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinEditActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioBaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioAlta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioEditar)
                            .addComponent(radioBorrar))
                        .addGap(0, 28, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addComponent(txtErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(radioBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioEditar)
                .addGap(13, 13, 13)
                .addComponent(radioAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioBaja)
                .addGap(38, 38, 38)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));

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

        txtMsg.setEditable(false);
        txtMsg.setBackground(new java.awt.Color(102, 0, 102));
        txtMsg.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtMsg.setForeground(new java.awt.Color(255, 255, 102));
        txtMsg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMsg.setBorder(null);
        txtMsg.setCaretColor(new java.awt.Color(51, 0, 0));
        txtMsg.setFocusable(false);
        txtMsg.setRequestFocusEnabled(false);
        txtMsg.setSelectedTextColor(new java.awt.Color(51, 0, 0));
        txtMsg.setSelectionColor(new java.awt.Color(51, 0, 0));
        txtMsg.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 750, 50));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jSeparator10.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator10.setForeground(new java.awt.Color(204, 204, 204));

        fechaInicio.setDateFormatString("yyyy-MM-dd");
        fechaInicio.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Fecha Inicio:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, -1));

        jPanel11.setBackground(new java.awt.Color(102, 102, 102));

        jSeparator11.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator11.setForeground(new java.awt.Color(204, 204, 204));

        fechaFinal.setDateFormatString("yyyy-MM-dd");
        fechaFinal.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Fecha Fin:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator11)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 20, 140, -1));

        txtDieta.setBackground(new java.awt.Color(204, 204, 204));
        txtDieta.setForeground(new java.awt.Color(0, 0, 0));
        txtDieta.setEnabled(false);
        txtDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDietaActionPerformed(evt);
            }
        });
        jPanel5.add(txtDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 262, 30));

        cmbDieta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbDieta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Nombre", "Peso Inicial", "Peso Final" }));
        cmbDieta.setEnabled(false);
        jPanel5.add(cmbDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 70, 160, 30));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        btnRemoveMenu.setText("Quitar Menu");
        btnRemoveMenu.setEnabled(false);
        btnRemoveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMenuActionPerformed(evt);
            }
        });

        btnAddMenu.setText("Agregar Menu");
        btnAddMenu.setEnabled(false);
        btnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMenuActionPerformed(evt);
            }
        });

        txtCalTotal.setEditable(false);
        txtCalTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtCalTotal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCalTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtCalTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CALORIAS:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRemoveMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemoveMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(txtCalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(btnAddMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 6, 440, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("- Listado de Dietas -");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tabMenuSelect.setModel(new javax.swing.table.DefaultTableModel(
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
        tabMenuSelect.setEnabled(false);
        jScrollPane2.setViewportView(tabMenuSelect);

        tabListDietas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabListDietas.setEnabled(false);
        jScrollPane1.setViewportView(tabListDietas);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("- Cambiar Menu -");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tabMenuAdd.setModel(new javax.swing.table.DefaultTableModel(
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
        tabMenuAdd.setEnabled(false);
        jScrollPane3.setViewportView(tabMenuAdd);

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("- Menus de la Dieta -");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(269, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 740, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void radioAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAltaActionPerformed
        //btnSelect.setEnabled(true);
        btnUpdate.setText("Alta");
        //txtMsg.setText("Presione seleccionar para continuar");
        tabListDietas.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtMsg.setForeground(Color.yellow);
       // txtMsg.setText("**Elija una Dieta para operar");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
        radioEditar.setEnabled(false);
       // btnSelect.setEnabled(false);
    }//GEN-LAST:event_radioAltaActionPerformed

    private void radioBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBajaActionPerformed
        //btnSelect.setEnabled(true);
        btnUpdate.setText("Baja");
        //txtMsg.setText("Presione seleccionar para continuar");
        tabListDietas.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtMsg.setForeground(Color.yellow);
       // txtMsg.setText("**Elija una Dieta para operar");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
        radioEditar.setEnabled(false);
        //btnSelect.setEnabled(false);
    }//GEN-LAST:event_radioBajaActionPerformed

    private void radioBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBorrarActionPerformed
       // btnSelect.setEnabled(true);
        btnUpdate.setText("Borrar");
        //txtMsg.setText("Presione seleccionar para continuar");
        tabListDietas.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtMsg.setForeground(Color.yellow);
       // txtMsg.setText("**Elija una Dieta para operar");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
        radioEditar.setEnabled(false);
        //btnSelect.setEnabled(false);
    }//GEN-LAST:event_radioBorrarActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        btnUpdate.setEnabled(false);
        
        if (radioAlta.isSelected()) {
            dietaData.altaLogicaDieta(Integer.parseInt(txtId.getText()));
            botonUpdate();
        } else if (radioBaja.isSelected()) {
            dietaData.bajaLogicaDieta(Integer.parseInt(txtId.getText()));
            botonUpdate();
        } else if (radioBorrar.isSelected()) { //TERMINAR ESTO
            dietaData.borrarDietaPorId(Integer.parseInt(txtId.getText()));
            dietaMenuHand.borrarDieta_MenuDiario_HandlerPorIds(Integer.parseInt(txtId.getText()), SOMEBITS);
            botonUpdate();
        } else if (radioEditar.isSelected()) {
            btnFinEdit.setEnabled(true);
            fechaInicio.setEnabled(true);
            fechaFinal.setEnabled(true);
            cmbDieta.setEnabled(true);
            txtDieta.setEnabled(true);
            tabMenuSelect.setEnabled(true);
            tabMenuAdd.setEnabled(true);
            cargarTablaMenu(Integer.parseInt(txtId.getText()));
            cargarTablaMenu2(Integer.parseInt(txtId.getText()));
            sumarCalorias();
            btnAddMenu.setEnabled(true);
            btnRemoveMenu.setEnabled(true);
            tabListDietas.setEnabled(false);

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void radioEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditarActionPerformed
        //btnSelect.setEnabled(true);
        btnUpdate.setText("Editar");
        //txtMsg.setText("Presione seleccionar para continuar");
        tabListDietas.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtMsg.setForeground(Color.yellow);
       // txtMsg.setText("**Elija una Dieta para operar");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
        radioEditar.setEnabled(false);
        //btnSelect.setEnabled(false);
    }//GEN-LAST:event_radioEditarActionPerformed

    private void btnFinEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinEditActionPerformed
        LocalDate nuevaFechaInicio = fechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nuevaFechaFinal = fechaFinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        int largoFilas = tabMenuSelect.getRowCount();
        long diferencia = ChronoUnit.DAYS.between(nuevaFechaInicio, nuevaFechaFinal);
        System.out.println("diferencia = "+diferencia);
        long diferenciaReal = diferencia +1;       
        if(diferencia >= 0) {
        if (largoFilas == diferenciaReal) {
            int fila = tabListDietas.getSelectedRow();
            if (fila != -1) {
                int idDieta = (int) tabListDietas.getValueAt(fila, 0);
                String nombre = tabListDietas.getValueAt(fila, 1).toString();
                double pesoStart = Double.parseDouble(tabListDietas.getValueAt(fila, 4).toString());
                double pesoEnd = Double.parseDouble(tabListDietas.getValueAt(fila, 5).toString());
                int totalCalorias = Integer.parseInt(txtCalTotal.getText());
                //boolean estado = parseBoolean(tabDieta.getValueAt(fila, 5).toString());
                Dieta dietaNueva = new Dieta(idDieta, nombre, idDieta, nuevaFechaInicio, nuevaFechaFinal, pesoStart, pesoEnd, totalCalorias, true);
                dietaNueva.setIdDieta(idDieta);
                dietaNueva.setFechaInicio(nuevaFechaInicio);
                dietaNueva.setFechaFinal(nuevaFechaFinal);

                //Condicionan la seleccion del comboBox:
                String seleccion = (String) cmbDieta.getSelectedItem();
                String nuevoValor = txtDieta.getText();

                //Controladores que segun la opcion, van a modificar el valor de la dieta.
                if (seleccion.equalsIgnoreCase("Nombre")) {
                    dietaNueva.setNombre(nuevoValor);
                } else if (seleccion.equalsIgnoreCase("peso inicial")) {
                    dietaNueva.setPesoInicial(Double.valueOf(nuevoValor));
                } else if (seleccion.equalsIgnoreCase("peso final")) {
                    dietaNueva.setPesoFinal(Double.valueOf(nuevoValor));
                }
                txtMsg.setText("");
                dietaData.actualizarDietaPorId(dietaNueva);
                botonUpdate();
            }
        }else{
            txtMsg.setForeground(Color.red);
            txtMsg.setText("El numero de menus incluidos, debe ser igual a "+diferenciaReal); 
        }
        }else{
            JOptionPane.showMessageDialog(this, "La fecha final no puede ser anterior a la inicial");
        }
    }//GEN-LAST:event_btnFinEditActionPerformed

    private void txtDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDietaActionPerformed

    }//GEN-LAST:event_txtDietaActionPerformed

    private void btnRemoveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMenuActionPerformed
        int fila = tabMenuSelect.getSelectedRow();
        if (fila != -1) {

            int idMenu = (int) tabMenuSelect.getValueAt(fila, 0);
            int idDieta = idDietaCaja();

            dietaMenuHand.borrarDieta_MenuDiario_HandlerPorIds(idDieta, idMenu);

            cargarTablaMenu(Integer.parseInt(txtId.getText()));
            cargarTablaMenu2(Integer.parseInt(txtId.getText()));
        }
        sumarCalorias();

    }//GEN-LAST:event_btnRemoveMenuActionPerformed

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
        int largoFilas = tabMenuSelect.getRowCount();
        int fila = tabMenuAdd.getSelectedRow();
        LocalDate dateFinal = fechaFinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateInicial = fechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long diferencia = ChronoUnit.DAYS.between(dateInicial, dateFinal);
        //ArrayList<Dieta_MenuDiario_Handler> handlerFechas = dietaMenuHand.obtenerFechaYMenuPorIdDieta(idDietaCaja());
        ArrayList<LocalDate> fechasIncluidas = new ArrayList();
        for (int i = 0; i < largoFilas; i++) {
            fechasIncluidas.add((LocalDate) tabMenuSelect.getValueAt(i, 1));
        }
        if (fila != -1 && largoFilas <= diferencia) {

            System.out.println("LA COMPARATIVA DE FECHAS DA: " + diferencia);

            int idMenu = (int) tabMenuAdd.getValueAt(fila, 0);
            int idDieta = idDietaCaja();
            LocalDate fechaAsignada = null;

            for (LocalDate fecha = dateInicial; !fecha.isAfter(dateFinal); fecha = fecha.plusDays(1)) {
                if (!fechasIncluidas.contains(fecha)) {
                    fechaAsignada = fecha;
                    fechasIncluidas.add(fecha);
                    break;
                }
            }

            if (fechaAsignada != null) {
                dietaMenuHand.createDieta_MenuDiario_Handler(idDieta, idMenu, fechaAsignada);
                System.out.println("Fecha asignada para el menú: " + fechaAsignada);
            } else {
                System.out.println("No hay fechas disponibles en el rango especificado.");
            }

            cargarTablaMenu(Integer.parseInt(txtId.getText()));
            cargarTablaMenu2(Integer.parseInt(txtId.getText()));
            sumarCalorias();
        } else {
            System.out.println("Número de filas excede la diferencia de días.");
        }


    }//GEN-LAST:event_btnAddMenuActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        actualizarTabla();
        btnGroup.clearSelection();
        radioAlta.setEnabled(true);
        radioBaja.setEnabled(true);
        radioBorrar.setEnabled(true);
        radioEditar.setEnabled(true);
        modelo1.setRowCount(0);
        modelo2.setRowCount(0);
        fechaInicio.setEnabled(false);
        fechaFinal.setEnabled(false);
        cmbDieta.setSelectedIndex(0);
        cmbDieta.setEnabled(false);
        fechaFinal.setDate(null);
        fechaInicio.setDate(null);
        btnRemoveMenu.setEnabled(false);
        btnAddMenu.setEnabled(false);
        btnUpdate.setText("");
        btnFinEdit.setEnabled(false);
        txtCalTotal.setText("");
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMenu;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFinEdit;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnRemoveMenu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbDieta;
    private com.toedter.calendar.JDateChooser fechaFinal;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JRadioButton radioAlta;
    private javax.swing.JRadioButton radioBaja;
    private javax.swing.JRadioButton radioBorrar;
    private javax.swing.JRadioButton radioEditar;
    private javax.swing.JTable tabListDietas;
    private javax.swing.JTable tabMenuAdd;
    private javax.swing.JTable tabMenuSelect;
    private javax.swing.JTextField txtCalTotal;
    private javax.swing.JTextField txtDieta;
    private javax.swing.JLabel txtErrorName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables

    private int idDietaCaja() {
        int fila = tabListDietas.getSelectedRow();

        if (fila != -1) {
            return (int) tabListDietas.getValueAt(fila, 0);
        }
        return (int) tabListDietas.getValueAt(fila, 0);
    }

    private void cargarCabeceraDietas() {
        modelo.addColumn("ID Dieta");
        modelo.addColumn("Nombre");

        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
        modelo.addColumn("Peso Inicial");
        modelo.addColumn("Peso Final");
        modelo.addColumn("Calorias Totales");
        modelo.addColumn("Estado");
        modelo.addColumn("Paciente");

        tabListDietas.setModel(modelo);
    }

    private void cargarCabeceraMenues(NonEditableTableModel model, JTable table) {
        model.addColumn("ID Menu");
        model.addColumn("Fecha del menu");
        model.addColumn("Nombre Menu");
        model.addColumn("Calorías del Menu");

        table.setModel(model);
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        ArrayList<Dieta> listadoDietas = dietaData.listarDietas();
        Collections.sort(listadoDietas, (d1, d2) -> d1.getNombre().compareToIgnoreCase(d2.getNombre()));
        for (Dieta d : listadoDietas) {
            Paciente pacienteDieta = pacienteData.buscarPacientePorID(d.getIdPaciente());
            modelo.addRow(new Object[]{
                d.getIdDieta(),
                d.getNombre(),
                d.getFechaInicio(),
                d.getFechaFinal(),
                d.getPesoInicial(),
                d.getPesoFinal(),
                d.getTotalCalorias(),
                d.isEstadoDieta() ? "Activo" : "Inactivo",
                pacienteDieta.getNombre()

            });
        }
    }

    // Carga los menus en la tabla tabMenuAdd y filtra los menus, sacando los asociados con una dieta
    private void cargarTablaMenu2(int idDieta) {
        modelo2.setRowCount(0);
        ArrayList<MenuDiario> listaIdMenu = menuDiarioData.listarMenusActivos();

        //Con este ArrayList capturo los menus asociados
        ArrayList<Integer> listaMenuConDieta = dietaMenuHand.listarMenuDiario_DietaID(idDieta);

        ArrayList<MenuDiario> menuSinDieta = new ArrayList();
        for (MenuDiario menu : listaIdMenu) {
            //Si el ArrayList con los menus asociados no contiene los menus
            // sin dieta, entonces que solo se agreguen los menus sin dieta
            if (!listaMenuConDieta.contains(menu.getIdMenuDiario())) {
                menuSinDieta.add(menu);
            }

        }
        for (MenuDiario menu : menuSinDieta) {
            modelo2.addRow(new Object[]{
                menu.getIdMenuDiario(),
                menu.getNombreMenu(),
                menu.getCaloriasDelMenu()
            });
        }
    }

    private void cargarTablaMenu(int idDieta) {
        modelo1.setRowCount(0);
        ArrayList<Integer> listaIdMenuDieta = dietaMenuHand.listarMenuDiario_DietaID(idDieta);
        List<SimpleEntry<MenuDiario, LocalDate>> menusConFechas = new ArrayList();
        ArrayList<MenuDiario> menuDietas = new ArrayList();
        for (Integer i : listaIdMenuDieta) {
            menuDietas.add(menuDiarioData.buscarMenuPorID(i));

        }

        for (MenuDiario menu : menuDietas) {
            LocalDate fechaMenu = LocalDate.parse(dietaMenuHand.obtenerFechaPorMenuYDieta(idDieta, menu.getIdMenuDiario()));
            menusConFechas.add(new AbstractMap.SimpleEntry<>(menu, fechaMenu));
            menusConFechas.sort(Comparator.comparing(Map.Entry::getValue));

        }
        int longMapa = menusConFechas.size();
        for (int i = 0; i < longMapa; i++) {
            modelo1.addRow(new Object[]{
                menusConFechas.get(i).getKey().getIdMenuDiario(),
                menusConFechas.get(i).getValue(),
                menusConFechas.get(i).getKey().getNombreMenu(),
                menusConFechas.get(i).getKey().getCaloriasDelMenu()
            });
        }
    }

    private void botonUpdate() {
        btnUpdate.setEnabled(false);
        tabListDietas.setEnabled(false);
        btnFinEdit.setEnabled(false);
        txtDieta.setText("");
        txtDieta.setEnabled(false);
        cmbDieta.setSelectedIndex(0);

        if (radioAlta.isSelected()) {
            txtErrorName.setForeground(Color.green);
            txtErrorName.setText("DIETA DADA DE ALTA.");
        } else if (radioBaja.isSelected()) {
            txtErrorName.setForeground(Color.green);
            txtErrorName.setText("DIETA DADA DE BAJA.");
        } else if (radioBorrar.isSelected()) {
            txtErrorName.setForeground(Color.green);
            txtErrorName.setText("DIETA BORRADA.");
        } else if (radioEditar.isSelected()) {
            txtErrorName.setForeground(Color.green);
            txtErrorName.setText("DIETA ACTUALIZADA.");
        }
        actualizarTabla();
        btnGroup.clearSelection();
        radioAlta.setEnabled(true);
        radioBaja.setEnabled(true);
        radioBorrar.setEnabled(true);
        radioEditar.setEnabled(true);
        modelo1.setRowCount(0);
        modelo2.setRowCount(0);
        fechaInicio.setEnabled(false);
        fechaFinal.setEnabled(false);
        cmbDieta.setSelectedIndex(0);
        cmbDieta.setEnabled(false);
        fechaFinal.setDate(null);
        fechaInicio.setDate(null);
        btnRemoveMenu.setEnabled(false);
        btnAddMenu.setEnabled(false);
    }

    private void sumarCalorias() {
        int caloriasTotales = 0;
        int filas = tabMenuSelect.getRowCount();
        for (int i = 0; i < filas; i++) {
            int caloriasMenu = Integer.parseInt(tabMenuSelect.getValueAt(i, 3).toString());
            caloriasTotales += caloriasMenu;
            txtCalTotal.setText(String.valueOf(caloriasTotales));

        }

    }

}
