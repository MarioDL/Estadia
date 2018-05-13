/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ConexionBD;
import Controlador.ControladorUsuario;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mingo
 */
public class FrmPrincipal extends javax.swing.JFrame {
    PnlPrincipal pnlPrincipal;
    PnlRecepcionCuero pnlRecepcionCuero;
    PnlInsXproc pnlInsXproc;
    ConexionBD conexionBD;
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        inicializar();
    }
    
    private void inicializar()
    {
        conexionBD = new ConexionBD();
        //Colocar icono de la aplicación
        Image ico=new ImageIcon(getClass().getResource("/imagenes/esmar.png")).getImage();
        setIconImage(ico);        
        //Titulo de la aplicación
        this.setTitle("Sistema de producción V.1.0");
        
        //Inicializamos las propiedades del dialogo:
        dlgLogin.setSize(560, 322);
        dlgLogin.setPreferredSize(dlgLogin.getSize());
        dlgLogin.setLocationRelativeTo(null);
        dlgLogin.setAlwaysOnTop(true);
        dlgLogin.setVisible(true);
    }
    
    
    private void validarUsuario()
    {
        ControladorUsuario controladorUsuario = new ControladorUsuario(conexionBD);
        Usuario u = new Usuario();
        u.setUserName(txtUsuario.getText());
        u.setPassword(new String(ptxtContrasenia.getPassword()));
        
        try
        {
            if (controladorUsuario.validarUsuario(u))
            {
                dlgLogin.setVisible(false);
                this.setVisible(true);
                pnlPrincipal=new PnlPrincipal();
                pnlPrincipalx.removeAll();        
                pnlPrincipalx.add(pnlPrincipal, BorderLayout.CENTER);
                pnlPrincipalx.paintAll(pnlPrincipal.getGraphics());
                ImageIcon ico=new ImageIcon(".\\src\\imagenes\\house.png");
                lblVentana.setIcon(ico);
//                DateLabel();
                lblNombreUsuario.setText(u.getNombre());
//                lblIdUsuario.setText(u.getIdUsuario());
                lblTipoUsuario.setText(u.getTipo());
//                lblTipoUsuario.setVisible(false);
                
                if (lblTipoUsuario.getText().equals("produccion"))
                {
//                    btnRecepcionSemiterminado.setVisible(false);
//                    btnProductoProceso.setVisible(false);
                }
            }
            else
                JOptionPane.showMessageDialog(dlgLogin, "Datos incorrectos", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(dlgLogin, "Error de conexion de datos", "Error de conexion", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgLogin = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        ptxtContrasenia = new javax.swing.JPasswordField();
        lblLogo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        lblMenui = new javax.swing.JLabel();
        btnRecepcionCuero = new javax.swing.JButton();
        btnInsXproc = new javax.swing.JButton();
        btnPartidas = new javax.swing.JButton();
        btnCross = new javax.swing.JButton();
        btnSemiterminado = new javax.swing.JButton();
        btnTerminado = new javax.swing.JButton();
        btnProdEnProc = new javax.swing.JButton();
        pnlPrincipalx = new javax.swing.JPanel();
        pnlFooter = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblVentana = new javax.swing.JLabel();
        lblLogoEsmar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmpArchivo = new javax.swing.JMenu();
        jmSalir = new javax.swing.JMenuItem();
        jmpCatalogos = new javax.swing.JMenu();
        jmProveedores = new javax.swing.JMenuItem();
        jmSubProcesos = new javax.swing.JMenuItem();
        jmpConfiguraciones = new javax.swing.JMenu();
        jmpAcercaDe = new javax.swing.JMenu();

        dlgLogin.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgLogin.setTitle("Login");
        dlgLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sistema de Producción");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Contraseña:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.setText("Mario");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Usuario:");

        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/door.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        ptxtContrasenia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ptxtContrasenia.setText("MarioDL96");
        ptxtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptxtContraseniaActionPerformed(evt);
            }
        });

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoEsmar.png"))); // NOI18N

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/status_online.png"))); // NOI18N

        lblContrasenia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnEntrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir))
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(ptxtContrasenia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addComponent(lblContrasenia)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblLogo)))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContrasenia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(ptxtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addComponent(btnEntrar))
                .addContainerGap())
        );

        dlgLogin.getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/house.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        lblMenui.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMenui.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenui.setText("Menu");

        btnRecepcionCuero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRecepcionCuero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lorry.png"))); // NOI18N
        btnRecepcionCuero.setText("Recepción de cuero ");
        btnRecepcionCuero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRecepcionCuero.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRecepcionCuero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecepcionCueroActionPerformed(evt);
            }
        });

        btnInsXproc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInsXproc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flask.png"))); // NOI18N
        btnInsXproc.setText("Insumos por proceso");
        btnInsXproc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInsXproc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInsXproc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsXprocActionPerformed(evt);
            }
        });

        btnPartidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPartidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cueroProceso.png"))); // NOI18N
        btnPartidas.setText("Partidas");
        btnPartidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPartidas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidasActionPerformed(evt);
            }
        });

        btnCross.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuero.png"))); // NOI18N
        btnCross.setText("Cross");
        btnCross.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCross.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrossActionPerformed(evt);
            }
        });

        btnSemiterminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSemiterminado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuero.png"))); // NOI18N
        btnSemiterminado.setText("Semiterminado");
        btnSemiterminado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSemiterminado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSemiterminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemiterminadoActionPerformed(evt);
            }
        });

        btnTerminado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTerminado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuero.png"))); // NOI18N
        btnTerminado.setText("Terminado");
        btnTerminado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTerminado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTerminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminadoActionPerformed(evt);
            }
        });

        btnProdEnProc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProdEnProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cog.png"))); // NOI18N
        btnProdEnProc.setText("Producción en proceso");
        btnProdEnProc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProdEnProc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProdEnProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdEnProcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTerminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCross, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPartidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsXproc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecepcionCuero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSemiterminado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProdEnProc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMenui, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecepcionCuero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsXproc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPartidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProdEnProc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCross)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSemiterminado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTerminado)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        pnlPrincipalx.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipalx.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlPrincipalx.setLayout(new java.awt.BorderLayout());

        lblNombreUsuario.setText("Nombre usuario");

        lblTipoUsuario.setText("Tipo Usuario");

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreUsuario)
                .addGap(18, 18, 18))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblVentana.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVentana.setText("Inicio");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVentana, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        lblLogoEsmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoEsmar_CH.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlPrincipalx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLogoEsmar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoEsmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlPrincipalx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jmpArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/page.png"))); // NOI18N
        jmpArchivo.setText("Archivo");

        jmSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross.png"))); // NOI18N
        jmSalir.setText("Salir");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        jmpArchivo.add(jmSalir);

        jMenuBar1.add(jmpArchivo);

        jmpCatalogos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/book.png"))); // NOI18N
        jmpCatalogos.setText("Catálogos");
        jmpCatalogos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmpCatalogosMouseClicked(evt);
            }
        });

        jmProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/group.png"))); // NOI18N
        jmProveedores.setText("Proveedores");
        jmpCatalogos.add(jmProveedores);

        jmSubProcesos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cueroProceso.png"))); // NOI18N
        jmSubProcesos.setText("SubProcesos");
        jmpCatalogos.add(jmSubProcesos);

        jMenuBar1.add(jmpCatalogos);

        jmpConfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cog.png"))); // NOI18N
        jmpConfiguraciones.setText("Configuraciones");
        jmpConfiguraciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmpConfiguracionesMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmpConfiguraciones);

        jmpAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/information.png"))); // NOI18N
        jmpAcercaDe.setText("Acerca de");
        jmpAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmpAcercaDeMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmpAcercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_jmSalirActionPerformed

    private void jmpCatalogosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmpCatalogosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jmpCatalogosMouseClicked

    private void jmpAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmpAcercaDeMouseClicked
        JOptionPane.showMessageDialog(null, "'Sistema de Producción ESMAR V.1.0' \n"
            + "Julio 2018\n\nDesarrollado por: \nIng. César Domingo Luna Gutiérrez \n\n"
            + "Dudas, comentarios o reportes de errores: \n"
            + "mingo.utl@gmail.com", "Acerca de...",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmpAcercaDeMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        validarUsuario();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        validarUsuario();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ptxtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptxtContraseniaActionPerformed
        validarUsuario();
    }//GEN-LAST:event_ptxtContraseniaActionPerformed

    private void btnProdEnProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdEnProcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProdEnProcActionPerformed

    private void btnTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTerminadoActionPerformed

    private void btnSemiterminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemiterminadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSemiterminadoActionPerformed

    private void btnCrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrossActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrossActionPerformed

    private void btnPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPartidasActionPerformed

    private void btnInsXprocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsXprocActionPerformed
        try {
            pnlInsXproc = new PnlInsXproc();
            pnlPrincipalx.removeAll();
            pnlPrincipalx.add(pnlInsXproc, BorderLayout.CENTER);
            pnlPrincipalx.paintAll(pnlInsXproc.getGraphics());
            
            lblVentana.setText("Insumos Por Proceso");
            ImageIcon ico=new ImageIcon(".\\src\\imagenes\\flask.png");
            lblVentana.setIcon(ico);
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInsXprocActionPerformed

    private void btnRecepcionCueroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecepcionCueroActionPerformed
        try {
            pnlRecepcionCuero = new PnlRecepcionCuero();
            pnlPrincipalx.removeAll();
            pnlPrincipalx.add(pnlRecepcionCuero, BorderLayout.CENTER);
            pnlPrincipalx.paintAll(pnlRecepcionCuero.getGraphics());
            
            lblVentana.setText("Recepción de Cuero");
            ImageIcon ico=new ImageIcon(".\\src\\imagenes\\lorry.png");
            lblVentana.setIcon(ico);
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRecepcionCueroActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        pnlPrincipal=new PnlPrincipal();
        pnlPrincipalx.removeAll();
        pnlPrincipalx.add(pnlPrincipal, BorderLayout.CENTER);
        pnlPrincipalx.paintAll(pnlPrincipal.getGraphics());

        lblVentana.setText("Inicio");
        ImageIcon ico=new ImageIcon(".\\src\\imagenes\\house.png");
        lblVentana.setIcon(ico);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void jmpConfiguracionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmpConfiguracionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jmpConfiguracionesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new FrmPrincipal().setVisible(true);
                try {
                    new FrmPrincipal().setLocationRelativeTo(null);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCross;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnInsXproc;
    private javax.swing.JButton btnPartidas;
    private javax.swing.JButton btnProdEnProc;
    private javax.swing.JButton btnRecepcionCuero;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSemiterminado;
    private javax.swing.JButton btnTerminado;
    private javax.swing.JDialog dlgLogin;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JMenuItem jmProveedores;
    private javax.swing.JMenuItem jmSalir;
    private javax.swing.JMenuItem jmSubProcesos;
    private javax.swing.JMenu jmpAcercaDe;
    private javax.swing.JMenu jmpArchivo;
    private javax.swing.JMenu jmpCatalogos;
    private javax.swing.JMenu jmpConfiguraciones;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoEsmar;
    private javax.swing.JLabel lblMenui;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVentana;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPrincipalx;
    private javax.swing.JPasswordField ptxtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
