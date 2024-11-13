package VistasMenuDiario;

import Entidades.Alimento;
import Entidades.MenuDiario;
import Persistencia.AlimentoData;
import Persistencia.Handlers.MenuDiario_Alimento_Handler_DATA;
import Persistencia.MenuDiarioData;
import Utilities.Conexion;
import java.sql.Connection;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VentanaLABBMenuDiario extends javax.swing.JInternalFrame {

    private final DefaultTableModel modeloMenu = new NonEditableTableModel();
    private final DefaultTableModel modeloAlim = new NonEditableTableModel();
    private final DefaultTableModel modeloTipo = new NonEditableTableModel();
    MenuDiarioData menuDiarioData;
    MenuDiario_Alimento_Handler_DATA menuAlimentoHandlerData;
    AlimentoData alimentoData;

    public VentanaLABBMenuDiario() {
        initComponents();
        Connection con = Conexion.getConexion();
        menuDiarioData = new MenuDiarioData(con);
        menuAlimentoHandlerData = new MenuDiario_Alimento_Handler_DATA(con);
        alimentoData = new AlimentoData(con);
        cargarCabecera();
        actualizarTabla();
        cargarCabeceraAlimentos((NonEditableTableModel) modeloAlim, tabAlimentosMenu);
        cargarCabeceraAlimentos((NonEditableTableModel) modeloTipo, tabAlimentosTipo);

        tabMenu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    int fila = tabMenu.getSelectedRow();
                    if (fila != -1) {
                        if (!radioEditar.isSelected()) {
                            txtId.setText((tabMenu.getValueAt(fila, 0)).toString());
                            txtName.setText("Se dara de " + btnUpdate.getText() + " a " + tabMenu.getValueAt(fila, 1).toString());
                            btnUpdate.setEnabled(true);
                        } else {
                            txtId.setText((tabMenu.getValueAt(fila, 0)).toString());
                            txtName.setText("Se procederá a " + btnUpdate.getText() + " a " + tabMenu.getValueAt(fila, 1).toString());
                            btnUpdate.setEnabled(true);
                        }
                    }
                }

            }
        });

        tabAlimentosMenu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tabAlimentosMenu.getSelectedRow();
                    if (fila != -1) {
                        txtIdAlimento.setText((tabAlimentosMenu.getValueAt(fila, 0)).toString());
                        txtTipoAlim.setText(tabAlimentosMenu.getValueAt(fila, 2).toString());

                    }
                }
            }
        });
        
         tabAlimentosTipo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tabAlimentosTipo.getSelectedRow();
                    if (fila != -1) {
                        txtIdAlimentoAdd.setText((tabAlimentosTipo.getValueAt(fila, 0)).toString());
                        btnAgregarAlimento.setEnabled(true);

                    }
                }
            }
        });
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

        groupSelect = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        radioAlta = new javax.swing.JRadioButton();
        radioBaja = new javax.swing.JRadioButton();
        radioBorrar = new javax.swing.JRadioButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        radioEditar = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtName = new javax.swing.JTextField();
        txtErrorName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabAlimentosMenu = new javax.swing.JTable();
        btnAgregarAlimento = new javax.swing.JButton();
        btnQuitarAlimento = new javax.swing.JButton();
        txtIdAlimento = new javax.swing.JTextField();
        txtTipoAlim = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMenu = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabAlimentosTipo = new javax.swing.JTable();
        txtIdAlimentoAdd = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Edicion");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Menu Diario");

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        radioAlta.setBackground(new java.awt.Color(0, 102, 102));
        groupSelect.add(radioAlta);
        radioAlta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioAlta.setForeground(new java.awt.Color(204, 204, 204));
        radioAlta.setText("Alta Menu diario");
        radioAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAltaActionPerformed(evt);
            }
        });

        radioBaja.setBackground(new java.awt.Color(0, 102, 102));
        groupSelect.add(radioBaja);
        radioBaja.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioBaja.setForeground(new java.awt.Color(204, 204, 204));
        radioBaja.setText("Baja Menu diario");
        radioBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBajaActionPerformed(evt);
            }
        });

        radioBorrar.setBackground(new java.awt.Color(0, 102, 102));
        groupSelect.add(radioBorrar);
        radioBorrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioBorrar.setForeground(new java.awt.Color(204, 204, 204));
        radioBorrar.setText("Borrar Menu");
        radioBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBorrarActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        radioEditar.setBackground(new java.awt.Color(0, 102, 102));
        groupSelect.add(radioEditar);
        radioEditar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioEditar.setForeground(new java.awt.Color(204, 204, 204));
        radioEditar.setText("Editar Menu");
        radioEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBorrar)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioEditar))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(129, 129, 129)
                .addComponent(radioBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioEditar)
                .addGap(27, 27, 27)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(548, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 630, 50));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Informacion:");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(153, 153, 153));
        txtName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));

        txtErrorName.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorName.setForeground(new java.awt.Color(255, 0, 0));

        tabAlimentosMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tabAlimentosMenu.setEnabled(false);
        jScrollPane2.setViewportView(tabAlimentosMenu);

        btnAgregarAlimento.setText("Agregar Alimento");
        btnAgregarAlimento.setEnabled(false);
        btnAgregarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlimentoActionPerformed(evt);
            }
        });

        btnQuitarAlimento.setText("Quitar Alimento");
        btnQuitarAlimento.setEnabled(false);
        btnQuitarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAlimentoActionPerformed(evt);
            }
        });

        txtIdAlimento.setEditable(false);
        txtIdAlimento.setBackground(new java.awt.Color(51, 51, 51));
        txtIdAlimento.setForeground(new java.awt.Color(51, 51, 51));
        txtIdAlimento.setBorder(null);

        txtTipoAlim.setEditable(false);
        txtTipoAlim.setBackground(new java.awt.Color(51, 51, 51));
        txtTipoAlim.setForeground(new java.awt.Color(51, 51, 51));
        txtTipoAlim.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(txtTipoAlim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnQuitarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(txtIdAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtErrorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoAlim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("- Listado de Menus Seleccione el menu a dar de Alta-Baja -");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tabMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tabMenu.setEnabled(false);
        jScrollPane1.setViewportView(tabMenu);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        tabAlimentosTipo.setModel(new javax.swing.table.DefaultTableModel(
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
        tabAlimentosTipo.setEnabled(false);
        jScrollPane3.setViewportView(tabAlimentosTipo);

        txtIdAlimentoAdd.setEditable(false);
        txtIdAlimentoAdd.setBackground(new java.awt.Color(51, 51, 51));
        txtIdAlimentoAdd.setForeground(new java.awt.Color(51, 51, 51));
        txtIdAlimentoAdd.setBorder(null);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtIdAlimentoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdAlimentoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 630, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
        tabMenu.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtName.setText("");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
        // btnSelect.setEnabled(false);
    }//GEN-LAST:event_radioAltaActionPerformed

    private void radioBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBajaActionPerformed
        //btnSelect.setEnabled(true);
        btnUpdate.setText("Baja");
        tabMenu.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtName.setText("");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
        radioEditar.setEnabled(false);
        // btnSelect.setEnabled(false);
    }//GEN-LAST:event_radioBajaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (radioAlta.isSelected()) {
            menuDiarioData.altaLogicaMenuDiario(Integer.parseInt(txtId.getText()));
            botonUpdate();
        } else if (radioBaja.isSelected()) {
            menuDiarioData.bajaLogicaMenuDiario(Integer.parseInt(txtId.getText()));
            botonUpdate();
        } else if (radioBorrar.isSelected()) {
            menuDiarioData.borrarMenuDiarioPorId(Integer.parseInt(txtId.getText()));
            botonUpdate();
        }
        if (radioEditar.isSelected()) {
            tabMenu.setEnabled(false); 
            actualizarTablaAlimentos();
            btnQuitarAlimento.setEnabled(true);
            tabAlimentosMenu.setEnabled(true);
            btnUpdate.setEnabled(false);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void radioBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBorrarActionPerformed
        //btnSelect.setEnabled(true);
        btnUpdate.setText("Borrar");
        tabMenu.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtName.setText("");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
        radioEditar.setEnabled(false);
        //btnSelect.setEnabled(false);
    }//GEN-LAST:event_radioBorrarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        btnUpdate.setText("");
        btnUpdate.setEnabled(false);
        actualizarTabla();
        groupSelect.clearSelection();
        radioAlta.setEnabled(true);
        radioBaja.setEnabled(true);
        radioBorrar.setEnabled(true);
        radioEditar.setEnabled(false);
        txtName.setText("");
        radioEditar.setEnabled(true);
        modeloAlim.setRowCount(0);
        modeloTipo.setRowCount(0);
        btnQuitarAlimento.setEnabled(false);
        btnAgregarAlimento.setEnabled(false);
        txtId.setText("");
        txtIdAlimento.setText("");
        txtIdAlimentoAdd.setText("");
        txtTipoAlim.setText("");
        tabMenu.setEnabled(false);
        txtErrorName.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void radioEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEditarActionPerformed
        btnUpdate.setText("Editar");
        radioEditar.setEnabled(false);
        tabMenu.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtName.setText("");
        txtId.setText("");
        radioAlta.setEnabled(false);
        radioBaja.setEnabled(false);
        radioBorrar.setEnabled(false);
    }//GEN-LAST:event_radioEditarActionPerformed

    private void btnQuitarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAlimentoActionPerformed
        ArrayList<Alimento> alimentoTipo = alimentoData.buscarAlimentosPorTipoComida(txtTipoAlim.getText());
        modeloTipo.setRowCount(0);
        for (Alimento a : alimentoTipo) {

            modeloTipo.addRow(new Object[]{
                a.getIdAlimento(),
                a.getNombre(),
                a.getTipoComida(),
                a.getCaloriasPor100g()
            });
        }
        if(tabAlimentosMenu.getSelectedRow() != -1) {
        menuAlimentoHandlerData.borrarHandler_MenuDiario_AlimentoPorIds(Integer.parseInt(txtId.getText()), Integer.parseInt(txtIdAlimento.getText()));
        actualizarTablaAlimentos();
        tabAlimentosTipo.setEnabled(true); 
        btnQuitarAlimento.setEnabled(false);
        btnExit.setEnabled(false);
        btnReset.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Alimento borrado con éxito, seleccione un alimento para reemplazarlo.");
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alimento para borrar.");
        }
    }//GEN-LAST:event_btnQuitarAlimentoActionPerformed

    private void btnAgregarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlimentoActionPerformed
        menuAlimentoHandlerData.createHandler_MenuDiario_AlimentoPorId(Integer.parseInt(txtId.getText()), Integer.parseInt(txtIdAlimentoAdd.getText()));
        actualizarTablaAlimentos();
        btnAgregarAlimento.setEnabled(false);
        
        btnQuitarAlimento.setEnabled(true);
        modeloTipo.setRowCount(0);
        btnExit.setEnabled(true);
        btnReset.setEnabled(true);
    }//GEN-LAST:event_btnAgregarAlimentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAlimento;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnQuitarAlimento;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup groupSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton radioAlta;
    private javax.swing.JRadioButton radioBaja;
    private javax.swing.JRadioButton radioBorrar;
    private javax.swing.JRadioButton radioEditar;
    private javax.swing.JTable tabAlimentosMenu;
    private javax.swing.JTable tabAlimentosTipo;
    private javax.swing.JTable tabMenu;
    private javax.swing.JLabel txtErrorName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdAlimento;
    private javax.swing.JTextField txtIdAlimentoAdd;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTipoAlim;
    // End of variables declaration//GEN-END:variables

    //Los metodos :3
    private void cargarCabecera() {
        modeloMenu.addColumn("ID Menu Diario");
        modeloMenu.addColumn("Nombre Menu");

        modeloMenu.addColumn("Calorias Del Menu");
        modeloMenu.addColumn("Estado");

        tabMenu.setModel(modeloMenu);
    }

    private void actualizarTabla() {
        modeloMenu.setRowCount(0);
        ArrayList<MenuDiario> listadoMenus = menuDiarioData.listarMenus();
        Collections.sort(listadoMenus, (m1, m2) -> m1.getNombreMenu().compareToIgnoreCase(m2.getNombreMenu()));
        for (MenuDiario m : listadoMenus) {
            modeloMenu.addRow(new Object[]{
                m.getIdMenuDiario(),
                m.getNombreMenu(),
                //m.getDia(),
                m.getCaloriasDelMenu(),
                m.isEstado() ? "Activo" : "Inactivo"

            });
        }
    }

    private void actualizarTablaAlimentos() {
        modeloAlim.setRowCount(0);
        ArrayList<Integer> idsAlimentos = menuAlimentoHandlerData.listarAlimentosPorMenuDiarioID(Integer.parseInt(txtId.getText()));
        ArrayList<Alimento> alimentosMenuDesordenado = new ArrayList();
        for (Integer i : idsAlimentos) {
            alimentosMenuDesordenado.add(alimentoData.buscarAlimentoPorID(i));
        }
        
        if (alimentosMenuDesordenado.size() == 5) {
            String[] ordenComidas = {"Desayuno", "Almuerzo", "Merienda", "Snack", "Cena"};
            Map<String, List<Alimento>> alimentosPorTipo = alimentosMenuDesordenado.stream()
                    .collect(Collectors.groupingBy(Alimento::getTipoComida));

            for (String tipoComida : ordenComidas) {
                List<Alimento> alimentosOrdenados = alimentosPorTipo.get(tipoComida);

                for (Alimento a : alimentosOrdenados) {
                    modeloAlim.addRow(new Object[]{
                        a.getIdAlimento(),
                        a.getNombre(),
                        a.getTipoComida(),
                        a.getCaloriasPor100g()
                    });
                }
            }
        }else{
            for(Alimento a : alimentosMenuDesordenado){
                modeloAlim.addRow(new Object[]{
                    a.getIdAlimento(),
                    a.getNombre(),
                    a.getTipoComida(),
                    a.getCaloriasPor100g()
                });
            }
        }
    }

    private void botonUpdate() {
        btnUpdate.setEnabled(false);
        tabMenu.setEnabled(false);

        if (radioAlta.isSelected()) {
            txtErrorName.setForeground(Color.green);
            txtErrorName.setText("MENU DADO DE ALTA.");
        } else if (radioBaja.isSelected()) {
            txtErrorName.setForeground(Color.green);
            txtErrorName.setText("MENU DADO DE BAJA.");
        } else if (radioBorrar.isSelected()) {
            txtErrorName.setForeground(Color.green);
            txtErrorName.setText("MENU BORRADO.");
        }
        actualizarTabla();
        groupSelect.clearSelection();
        radioAlta.setEnabled(true);
        radioBaja.setEnabled(true);
        radioBorrar.setEnabled(true);
    }

    private void cargarCabeceraAlimentos(NonEditableTableModel modelo, JTable table) {
        modelo.addColumn("ID Alimento");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Calorias");

        table.setModel(modelo);
    }

}
