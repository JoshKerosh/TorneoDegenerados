/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorTorneo;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Josh
 */
public class PantallaTorneo extends javax.swing.JFrame implements Observer {

    //Singleton
    private boolean local;
    
    private static PantallaTorneo vista;
    public static PantallaTorneo getInstance(){
        if(vista == null){
            vista = new PantallaTorneo();
        }
        return vista;
    } 
    private PantallaTorneo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Generated Code.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlCommandLine = new javax.swing.JPanel();
        ScrollPane_CommandLine = new javax.swing.JScrollPane();
        commandLine = new javax.swing.JTextPane();
        lblInstruccion = new javax.swing.JLabel();
        pnlBatalla = new javax.swing.JPanel();
        pnlEquipo = new javax.swing.JPanel();
        lGuerreroImg5 = new javax.swing.JLabel();
        lGuerreroImg4 = new javax.swing.JLabel();
        lGuerreroImg3 = new javax.swing.JLabel();
        lGuerreroImg2 = new javax.swing.JLabel();
        lGuerreroImg1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lArma1 = new javax.swing.JLabel();
        lArma2 = new javax.swing.JLabel();
        lArma3 = new javax.swing.JLabel();
        lArma4 = new javax.swing.JLabel();
        lArma5 = new javax.swing.JLabel();
        lGuerreroName = new javax.swing.JLabel();
        lGuerreroHP = new javax.swing.JLabel();
        pnlRecibe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lAtaqueRecibidoIgm = new javax.swing.JLabel();
        pnlenvia = new javax.swing.JPanel();
        lGuerreroHP1 = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Torneo Comandos");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        pnlMain.setLayout(null);

        commandLine.setBackground(new java.awt.Color(51, 51, 51));
        commandLine.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        commandLine.setForeground(new java.awt.Color(0, 255, 0));
        commandLine.setCaretColor(new java.awt.Color(0, 255, 0));
        ScrollPane_CommandLine.setViewportView(commandLine);

        javax.swing.GroupLayout pnlCommandLineLayout = new javax.swing.GroupLayout(pnlCommandLine);
        pnlCommandLine.setLayout(pnlCommandLineLayout);
        pnlCommandLineLayout.setHorizontalGroup(
            pnlCommandLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCommandLineLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ScrollPane_CommandLine, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCommandLineLayout.setVerticalGroup(
            pnlCommandLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCommandLineLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ScrollPane_CommandLine, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlCommandLine);
        pnlCommandLine.setBounds(0, 420, 800, 200);

        lblInstruccion.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        lblInstruccion.setForeground(new java.awt.Color(204, 204, 204));
        lblInstruccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInstruccion.setText("Torneo");
        lblInstruccion.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pnlMain.add(lblInstruccion);
        lblInstruccion.setBounds(20, 400, 300, 20);

        pnlBatalla.setOpaque(false);

        pnlEquipo.setOpaque(false);

        lGuerreroImg5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lGuerreroImg5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lGuerreroImg4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lGuerreroImg4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lGuerreroImg3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lGuerreroImg3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lGuerreroImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lGuerreroImg2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lGuerreroImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lGuerreroImg1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lArma1.setForeground(new java.awt.Color(102, 204, 255));
        lArma1.setText("arma1");

        lArma2.setForeground(new java.awt.Color(102, 204, 255));
        lArma2.setText("arma2");

        lArma3.setForeground(new java.awt.Color(102, 204, 255));
        lArma3.setText("arma3");

        lArma4.setForeground(new java.awt.Color(102, 204, 255));
        lArma4.setText("arma4");

        lArma5.setForeground(new java.awt.Color(102, 204, 255));
        lArma5.setText("arma5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lArma1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lArma2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lArma3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lArma4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lArma5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lArma1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lArma2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lArma3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lArma4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lArma5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lGuerreroName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lGuerreroName.setForeground(new java.awt.Color(51, 51, 255));
        lGuerreroName.setText("Guerrero");

        lGuerreroHP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lGuerreroHP.setForeground(new java.awt.Color(51, 51, 255));
        lGuerreroHP.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lGuerreroHP.setText("0");

        pnlRecibe.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Ultimo ataque recibido:");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(102, 204, 255));
        jTextArea1.setRows(5);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        lAtaqueRecibidoIgm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAtaqueRecibidoIgm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlenvia.setOpaque(false);

        javax.swing.GroupLayout pnlenviaLayout = new javax.swing.GroupLayout(pnlenvia);
        pnlenvia.setLayout(pnlenviaLayout);
        pnlenviaLayout.setHorizontalGroup(
            pnlenviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlenviaLayout.setVerticalGroup(
            pnlenviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlRecibeLayout = new javax.swing.GroupLayout(pnlRecibe);
        pnlRecibe.setLayout(pnlRecibeLayout);
        pnlRecibeLayout.setHorizontalGroup(
            pnlRecibeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecibeLayout.createSequentialGroup()
                .addComponent(lAtaqueRecibidoIgm, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRecibeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
            .addComponent(pnlenvia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlRecibeLayout.setVerticalGroup(
            pnlRecibeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecibeLayout.createSequentialGroup()
                .addGroup(pnlRecibeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lAtaqueRecibidoIgm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRecibeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlenvia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lGuerreroHP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lGuerreroHP1.setForeground(new java.awt.Color(51, 51, 255));
        lGuerreroHP1.setText("%");

        javax.swing.GroupLayout pnlEquipoLayout = new javax.swing.GroupLayout(pnlEquipo);
        pnlEquipo.setLayout(pnlEquipoLayout);
        pnlEquipoLayout.setHorizontalGroup(
            pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEquipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEquipoLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(lGuerreroImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lGuerreroImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lGuerreroImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lGuerreroImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lGuerreroImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(pnlEquipoLayout.createSequentialGroup()
                        .addGroup(pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lGuerreroName, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlEquipoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lGuerreroHP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lGuerreroHP1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlEquipoLayout.setVerticalGroup(
            pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEquipoLayout.createSequentialGroup()
                .addGroup(pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEquipoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lGuerreroImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lGuerreroImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lGuerreroImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lGuerreroImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lGuerreroImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEquipoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addGroup(pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEquipoLayout.createSequentialGroup()
                        .addComponent(lGuerreroName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lGuerreroHP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lGuerreroHP1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBatallaLayout = new javax.swing.GroupLayout(pnlBatalla);
        pnlBatalla.setLayout(pnlBatallaLayout);
        pnlBatallaLayout.setHorizontalGroup(
            pnlBatallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBatallaLayout.setVerticalGroup(
            pnlBatallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBatallaLayout.createSequentialGroup()
                .addComponent(pnlEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMain.add(pnlBatalla);
        pnlBatalla.setBounds(0, 0, 800, 400);

        imgFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgFondo.setToolTipText("");
        imgFondo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlMain.add(imgFondo);
        imgFondo.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane_CommandLine;
    public javax.swing.JTextPane commandLine;
    public javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel lArma1;
    public javax.swing.JLabel lArma2;
    public javax.swing.JLabel lArma3;
    public javax.swing.JLabel lArma4;
    public javax.swing.JLabel lArma5;
    public javax.swing.JLabel lAtaqueRecibidoIgm;
    public javax.swing.JLabel lGuerreroHP;
    private javax.swing.JLabel lGuerreroHP1;
    public javax.swing.JLabel lGuerreroImg1;
    public javax.swing.JLabel lGuerreroImg2;
    public javax.swing.JLabel lGuerreroImg3;
    public javax.swing.JLabel lGuerreroImg4;
    public javax.swing.JLabel lGuerreroImg5;
    public javax.swing.JLabel lGuerreroName;
    public javax.swing.JLabel lblInstruccion;
    public javax.swing.JPanel pnlBatalla;
    private javax.swing.JPanel pnlCommandLine;
    private javax.swing.JPanel pnlEquipo;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRecibe;
    private javax.swing.JPanel pnlenvia;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        String mensajeFull = (String) arg;
        String mensaje = getCommand(mensajeFull);
        
        switch(mensaje){
            case ">IniTurno":
                this.lblInstruccion.setText("Tu turno");
                this.commandLine.setEnabled(true);
                this.commandLine.requestFocus();
                break;
                
            
            case ">FinTurno":
                this.lblInstruccion.setText("Turno del oponente");
                this.commandLine.setEnabled(false);
                break;
                
            case ">IniciarBatalla":
                this.lblInstruccion.setText("Iniciando Batalla");
                this.commandLine.setEnabled(false);
                break;
                
            case ">Rendicion":
                this.lblInstruccion.setText("Torneo");
                this.commandLine.setEnabled(true);
                this.commandLine.requestFocus();
                volverCharSelect();
                write("Has ganado por rendicion");
                addCommandReceiver();
                break;
        }
    }
    public void write(String text){
        int line = vista.commandLine.getDocument().getLength();
        Style style = vista.commandLine.getStyle("commandLineStyle");
        try {
            StyleConstants.setForeground(style, Color.white);
            vista.commandLine.getStyledDocument().insertString(line , text + "\n" , style);  
        } catch (BadLocationException ex) {
            Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addCommandReceiver() {
        Style style = commandLine.getStyle("commandLineStyle");
        StyleConstants.setForeground(style, Color.green);
        try {
            int currentLine = commandLine.getDocument().getLength();
            commandLine.getStyledDocument().insertString(currentLine , "> ", style);
            commandLine.setCaretPosition(commandLine.getDocument().getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void volverCharSelect(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/recursos/charSelect.png"));
        this.imgFondo.setIcon(icon);
        this.pnlBatalla.setVisible(false);
    }

    private String getCommand(String mensajeFull) {
        try{
            return mensajeFull.substring(0, mensajeFull.indexOf(" "));
        } catch(Exception e){
            return mensajeFull;
        }
         
    }
}
