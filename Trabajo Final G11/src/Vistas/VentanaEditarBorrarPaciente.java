package Vistas;

import Entidades.Conexion;
import Entidades.Paciente;
import Persistencia.PacienteData;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaEditarBorrarPaciente extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo = new NonEditableTableModel();
    PacienteData pacienteData;

    public VentanaEditarBorrarPaciente() {
        initComponents();
        Connection con = Conexion.getConexion();
        pacienteData = new PacienteData(con);
        cargarCabecera();
        actualizarTabla();

        tabPacientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tabPacientes.getSelectedRow();
                    if (fila != -1) {
                        txtId.setText((tabPacientes.getValueAt(fila, 0)).toString());
                        txtName.setText(tabPacientes.getValueAt(fila, 1).toString());
                        txtDni.setText(tabPacientes.getValueAt(fila, 2).toString());
                        txtEdad.setText(tabPacientes.getValueAt(fila, 3).toString());
                        txtTelefono.setText(tabPacientes.getValueAt(fila, 4).toString());
                        txtPesoInicial.setText(tabPacientes.getValueAt(fila, 5).toString());
                        txtPesoBuscado.setText(tabPacientes.getValueAt(fila, 6).toString());
                        txtName.setEditable(true);
                        txtDni.setEditable(true);
                        txtEdad.setEditable(true);
                        txtTelefono.setEditable(true);
                        txtPesoInicial.setEditable(true);
                        txtPesoBuscado.setEditable(true);
                        btnActualizar.setEnabled(true);
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

        grupoSelect = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        radioActualizar = new javax.swing.JRadioButton();
        radioBorrar = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtName = new javax.swing.JTextField();
        txtErrorName = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPacientes = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtEdad = new javax.swing.JTextField();
        txtErrorEdad = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        txtErrorTel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtDni = new javax.swing.JTextField();
        txtErrorDni = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtPesoInicial = new javax.swing.JTextField();
        txtErrorPesoI = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtPesoBuscado = new javax.swing.JTextField();
        txtErrorPesoB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 615));
        setMinimumSize(new java.awt.Dimension(800, 615));
        setPreferredSize(new java.awt.Dimension(800, 615));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Editar");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Paciente");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Imagen acá");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnSelect.setText("Seleccionar");
        btnSelect.setEnabled(false);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        radioActualizar.setBackground(new java.awt.Color(51, 0, 0));
        grupoSelect.add(radioActualizar);
        radioActualizar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioActualizar.setForeground(new java.awt.Color(204, 204, 204));
        radioActualizar.setText("Actualizar Datos");
        radioActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioActualizarActionPerformed(evt);
            }
        });

        radioBorrar.setBackground(new java.awt.Color(51, 0, 0));
        grupoSelect.add(radioBorrar);
        radioBorrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        radioBorrar.setForeground(new java.awt.Color(204, 204, 204));
        radioBorrar.setText("Borrar Datos");
        radioBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBorrarActionPerformed(evt);
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
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(radioActualizar)
                .addGap(18, 18, 18)
                .addComponent(radioBorrar)
                .addGap(18, 18, 18)
                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        jPanel3.setBackground(new java.awt.Color(51, 0, 0));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(51, 0, 0));
        txtId.setForeground(new java.awt.Color(51, 0, 0));
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
        jLabel3.setText("Nombre y Apellido:");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(153, 153, 153));
        txtName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        txtErrorName.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorName.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtErrorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("- Listado de Pacientes: Seleccione el paciente a editar -");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tabPacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tabPacientes.setEnabled(false);
        jScrollPane1.setViewportView(tabPacientes);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Edad:");

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        txtEdad.setEditable(false);
        txtEdad.setBackground(new java.awt.Color(153, 153, 153));
        txtEdad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(0, 0, 0));
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        txtErrorEdad.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorEdad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorEdad.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErrorEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtErrorEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Teléfono:");

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(153, 153, 153));
        txtTelefono.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtErrorTel.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorTel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorTel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtErrorTel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtErrorTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("D.N.I.:");

        jSeparator7.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));

        txtDni.setEditable(false);
        txtDni.setBackground(new java.awt.Color(153, 153, 153));
        txtDni.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtDni.setForeground(new java.awt.Color(0, 0, 0));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        txtErrorDni.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorDni.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorDni.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtErrorDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtErrorDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Peso Inicial:");

        jSeparator8.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));

        txtPesoInicial.setEditable(false);
        txtPesoInicial.setBackground(new java.awt.Color(153, 153, 153));
        txtPesoInicial.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtPesoInicial.setForeground(new java.awt.Color(0, 0, 0));
        txtPesoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoInicialKeyTyped(evt);
            }
        });

        txtErrorPesoI.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorPesoI.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorPesoI.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txtPesoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtErrorPesoI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtErrorPesoI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Peso Buscado:");

        jSeparator10.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator10.setForeground(new java.awt.Color(204, 204, 204));

        txtPesoBuscado.setEditable(false);
        txtPesoBuscado.setBackground(new java.awt.Color(153, 153, 153));
        txtPesoBuscado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtPesoBuscado.setForeground(new java.awt.Color(0, 0, 0));
        txtPesoBuscado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoBuscadoKeyTyped(evt);
            }
        });

        txtErrorPesoB.setBackground(new java.awt.Color(51, 51, 51));
        txtErrorPesoB.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtErrorPesoB.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErrorPesoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtPesoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtErrorPesoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 630, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        tabPacientes.setEnabled(true);
        txtErrorName.setForeground(Color.red);
        txtErrorName.setText("");
        txtErrorDni.setForeground(Color.red);
        txtErrorDni.setText("");
        txtErrorEdad.setForeground(Color.red);
        txtErrorEdad.setText("");
        txtErrorTel.setForeground(Color.red);
        txtErrorTel.setText("");
        txtName.setText("");
        txtDni.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtId.setText("");
        radioActualizar.setEnabled(false);
        radioBorrar.setEnabled(false);
        btnSelect.setEnabled(false);

    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (validarEntradas()) {
            if (txtName.getText().isEmpty()) {
                txtErrorName.setText("*Vacío.");
                txtName.requestFocus();
            } else if (txtDni.getText().isEmpty()) {
                txtErrorDni.setText("*Vacío.");
                txtDni.requestFocus();
            } else if (txtEdad.getText().isEmpty()) {
                txtErrorEdad.setText("*Vacío.");
                txtEdad.requestFocus();
            } else if (txtTelefono.getText().isEmpty()) {
                txtErrorTel.setText("*Vacío.");
                txtTelefono.requestFocus();
            }else if(txtPesoInicial.getText().isEmpty()){
                txtErrorPesoI.setText("*Vacío.");
                txtPesoInicial.requestFocus();
            }else if(txtPesoBuscado.getText().isEmpty()){
                txtErrorPesoB.setText("*Vacío.");
                txtPesoBuscado.requestFocus();
            } else if (radioActualizar.isSelected()) {
                Paciente pacienteEdit = new Paciente(Integer.parseInt(txtId.getText()), txtName.getText(), Integer.parseInt(txtDni.getText()), Integer.parseInt(txtEdad.getText()), txtTelefono.getText(), Double.parseDouble(txtPesoInicial.getText()), Double.parseDouble(txtPesoBuscado.getText()));
                pacienteData.actualizarPacientePorId(pacienteEdit);
                botonActualizarBorrar();
            } else if (radioBorrar.isSelected()) {
                pacienteData.borrarPacientePorId(Integer.parseInt(txtId.getText()));
                botonActualizarBorrar();
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        validarEntradas();
        txtErrorName.setText("");
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        entradaNumerosSinPunto(evt);
        validarEntradas();    
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        entradaNumerosSinPunto(evt);
        validarEntradas();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void radioActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioActualizarActionPerformed
        btnSelect.setEnabled(true);
        btnActualizar.setText("Actualizar");
    }//GEN-LAST:event_radioActualizarActionPerformed

    private void radioBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBorrarActionPerformed
        btnSelect.setEnabled(true);
        btnActualizar.setText("Borrar");
    }//GEN-LAST:event_radioBorrarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        entradaNumerosSinPunto(evt);
        validarEntradas();
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtPesoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoInicialKeyTyped
        entradaNumerosConPunto(evt);
        validarEntradas();
    }//GEN-LAST:event_txtPesoInicialKeyTyped

    private void txtPesoBuscadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoBuscadoKeyTyped
        entradaNumerosConPunto(evt);
        validarEntradas();
    }//GEN-LAST:event_txtPesoBuscadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSelect;
    private javax.swing.ButtonGroup grupoSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JRadioButton radioActualizar;
    private javax.swing.JRadioButton radioBorrar;
    private javax.swing.JTable tabPacientes;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JLabel txtErrorDni;
    private javax.swing.JLabel txtErrorEdad;
    private javax.swing.JLabel txtErrorName;
    private javax.swing.JLabel txtErrorPesoB;
    private javax.swing.JLabel txtErrorPesoI;
    private javax.swing.JLabel txtErrorTel;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPesoBuscado;
    private javax.swing.JTextField txtPesoInicial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

     private boolean validarEntradas() {
        if (!txtEdad.getText().isEmpty() && !txtDni.getText().isEmpty() && !txtName.getText().isEmpty() && !txtTelefono.getText().isEmpty() && !txtPesoInicial.getText().isEmpty() && !txtPesoBuscado.getText().isEmpty()) {
            btnActualizar.setEnabled(true);
        }
        return true;
    }

    private void cargarCabecera() {
        modelo.addColumn("ID Paciente");
        modelo.addColumn("Nombre y Apellido");
        modelo.addColumn("D.N.I.");
        modelo.addColumn("Edad");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Peso Inicial");
        modelo.addColumn("Peso Buscado"); 
        modelo.addColumn("Activo");

        tabPacientes.setModel(modelo);
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        ArrayList<Paciente> listadoPacientes = pacienteData.listarPacientes();
        for (Paciente p : listadoPacientes) {
            modelo.addRow(new Object[]{
                p.getIdPaciente(),
                p.getNombre(),
                p.getDni(),
                p.getEdad(),
                p.getTelefono(),
                p.getPesoActual(),
                p.getPesoBuscado(),
                p.isEstado() ? "SI" : "NO"

            });
        }
    }

    private void botonActualizarBorrar() {
        btnActualizar.setEnabled(false);
        tabPacientes.setEnabled(false);
        txtName.setEditable(false);
        txtDni.setEditable(false);
        txtEdad.setEditable(false);
        txtTelefono.setEditable(false);
        txtPesoInicial.setEditable(false);
        txtPesoBuscado.setEditable(false);
        
        if(radioActualizar.isSelected()) {
        txtErrorName.setForeground(Color.green);
        txtErrorName.setText("*DATOS DEL PACIENTE ACTUALIZADO.");
        
        }else if(radioBorrar.isSelected()) {
        txtErrorName.setForeground(Color.green);
        txtErrorName.setText("*PACIENTE BORRADO.");
        }
        actualizarTabla();
        grupoSelect.clearSelection();
        radioActualizar.setEnabled(true);
        radioBorrar.setEnabled(true);
        
        
        
    }
    
    private void entradaNumerosConPunto (java.awt.event.KeyEvent evt) {
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
            txtErrorDni.setText("*Solo números."); //modificar para que afecte al campo correspondiente
        } else {
            txtErrorDni.setText("");
        }
        
    }
    
    private void entradaNumerosSinPunto (java.awt.event.KeyEvent evt) {
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;

        if (!numero) {
            evt.consume();
            txtErrorDni.setText("*Solo números.");//lo mismo aca
        } else {
            txtErrorDni.setText("");
        }
    }
}
