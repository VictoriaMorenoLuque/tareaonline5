package interfazMain;

import clases.Continente;
import clases.Pais;
import utilidades.ConexionBD;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;

/**
 *
 * @author javier
 */
public class Operaciones extends javax.swing.JDialog {

    ArrayList<Continente> arrayContinentes;
    ArrayList<Pais> arrayPaises;
    ConexionBD cbd;
    ResultSet rs;
    String queryContinentes;
    String queryPaises;

    /**
     * Creates new form jdOperaciones
     */
    public Operaciones(java.awt.Frame parent, boolean modal, ConexionBD cbdParam) {
        super(parent, modal);
        initComponents();
        this.setTitle("FabraCarrascoDavid_AD_TO2 - Consultas");
        arrayContinentes = new ArrayList<>();
        arrayPaises = new ArrayList<>();
        queryContinentes = "SELECT * FROM `continentes`";
        queryPaises = "SELECT * FROM `paises`";
        rs = null;
        cbd = cbdParam;
        selectContinentes();
        selectPaises();
    }

    private Operaciones(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbContinentes2 = new javax.swing.JComboBox<>();
        jlNumHab = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaPaisesyHabitantes = new javax.swing.JTextArea();
        bCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));

        jcbContinentes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbContinentes2ActionPerformed(evt);
            }
        });

        jlNumHab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNumHab.setBorder(javax.swing.BorderFactory.createTitledBorder("N??mero de Habitantes"));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paises y Habitantes"));

        jtaPaisesyHabitantes.setEditable(false);
        jtaPaisesyHabitantes.setColumns(20);
        jtaPaisesyHabitantes.setRows(5);
        jtaPaisesyHabitantes.setOpaque(false);
        jScrollPane1.setViewportView(jtaPaisesyHabitantes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbContinentes2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlNumHab, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNumHab, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcbContinentes2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        bCerrar.setText("Cerrar");
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

    private void jcbContinentes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbContinentes2ActionPerformed
        calcularNumeroHabitantes();
        configurarJTextFieldPaises();
    }//GEN-LAST:event_jcbContinentes2ActionPerformed

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
            java.util.logging.Logger.getLogger(Operaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Operaciones dialog = new Operaciones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbContinentes2;
    private javax.swing.JLabel jlNumHab;
    private javax.swing.JTextArea jtaPaisesyHabitantes;
    // End of variables declaration//GEN-END:variables

    void selectContinentes() {
        int idContinente;
        String nombreContinente;
        Continente continenteIntroducir;
        try {
            arrayContinentes.clear();
        } catch (Error e) {
        }
        rs = cbd.ejecutarConsultaSelect(queryContinentes);
        if (rs != null) {
            try {
                while (rs.next()) {
                    idContinente = rs.getInt("idContinente");
                    nombreContinente = rs.getString("nombreContinente");
                    continenteIntroducir = new Continente(idContinente, nombreContinente);
                    arrayContinentes.add(continenteIntroducir);
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        configurarComboContinentes();
    }

    private void configurarComboContinentes() {
        jcbContinentes2.removeAllItems();
        if (arrayContinentes.size() > 0) {
            for (Continente c : arrayContinentes) {
                jcbContinentes2.addItem(c.getNombreContinente());
            }
        } else {
            jcbContinentes2.addItem("No existen continentes.");
        }
        calcularNumeroHabitantes();
    }

    void selectPaises() {
        int idPais;
        int idContinente;
        String nombrePais;
        BigInteger numHabitantes;
        Pais paisIntroducir;
        arrayPaises.clear();
        rs = cbd.ejecutarConsultaSelect(queryPaises);
        if (rs != null) {
            try {
                while (rs.next()) {
                    idPais = rs.getInt("idPais");
                    idContinente = rs.getInt("idContinente");
                    nombrePais = rs.getString("nombrePais");
                    numHabitantes = new BigInteger(rs.getString("numHabitantes"));
                    paisIntroducir = new Pais(idPais, idContinente, nombrePais, numHabitantes);
                    arrayPaises.add(paisIntroducir);
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        configurarJTextFieldPaises();
    }

    private void configurarJTextFieldPaises() {
        ArrayList<Pais> arrayPaisesOrdenado;
        String continenteActual;
        String query;
        String texto = "";
        int idContinente = 0;
        arrayPaisesOrdenado = new ArrayList<>();
        continenteActual = jcbContinentes2.getSelectedItem().toString();
        query = "SELECT `idContinente` FROM continentes WHERE `nombreContinente` = '" + continenteActual + "'";
        rs = cbd.ejecutarConsultaSelect(query);
        if (rs != null) {
            try {
                while (rs.next()) {
                    idContinente = rs.getInt("idContinente");
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        query = "SELECT * FROM `paises` WHERE idContinente = " + idContinente;
        rs = cbd.ejecutarConsultaSelect(query);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Pais p = new Pais(rs.getInt("idContinente"), rs.getString("nombrePais"), new BigInteger(rs.getString("numHabitantes")));
                    arrayPaisesOrdenado.add(p);
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        Collections.sort(arrayPaisesOrdenado, Pais.comparadorNombre);
        for (Pais ps : arrayPaisesOrdenado) {
            texto += ps.getNombrePais() + " | " + ps.getNumHabitantes() + "\n";
        }
        jtaPaisesyHabitantes.setText(texto);
    }

    private void calcularNumeroHabitantes() {
        BigInteger cantidadTotalHabitantes = new BigInteger("0");
        BigInteger cantIntro;
        String idContinente = null;
        String query;
        query = "SELECT `idContinente` FROM continentes WHERE `nombreContinente` = '" + jcbContinentes2.getSelectedItem() + "'";
        rs = cbd.ejecutarConsultaSelect(query);
        if (rs != null) {
            try {
                while (rs.next()) {
                    idContinente = rs.getString("idContinente");
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        query = "SELECT SUM(numHabitantes) AS total FROM paises WHERE idContinente = " + idContinente;
        rs = cbd.ejecutarConsultaSelect(query);
        if (rs != null) {
            try {
                while (rs.next()) {
                    try {
                        String totalIntroducir = rs.getString("total");
                        if (totalIntroducir != null) {
                            cantIntro = new BigInteger(totalIntroducir);
                            cantidadTotalHabitantes = cantidadTotalHabitantes.add(cantIntro);
                        }
                    } catch (NumberFormatException error) {
                    }
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        jlNumHab.setText(cantidadTotalHabitantes.toString());
    }

}
