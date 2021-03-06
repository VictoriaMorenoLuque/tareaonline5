package interfazMain;

import clases.Continente;
import clases.Pais;
import utilidades.ComprobarCaracteres;
import utilidades.ConexionBD;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class Paises extends javax.swing.JDialog {

    ArrayList<Continente> arrayContinentes;
    ArrayList<Pais> arrayPaises;
    ConexionBD cbd;
    ResultSet rs;
    String queryContinentes;
    String queryPaises;
    ComprobarCaracteres comprobarCaracteres;

    /**
     * Creates new form jdPaises
     */
    public Paises(java.awt.Frame parent, boolean modal, ConexionBD cbdParam) {
        super(parent, modal);
        initComponents();
        this.setTitle("FabraCarrascoDavid_AD_TO2 - Operaciones Países");
        arrayContinentes = new ArrayList<>();
        arrayPaises = new ArrayList<>();
        cbd = cbdParam;
        rs = null;
        comprobarCaracteres = new ComprobarCaracteres();
        queryContinentes = "SELECT * FROM `continentes`";
        queryPaises = "SELECT * FROM `paises`";
        selectContinentes();
        selectPaises();
    }

    private Paises(JFrame jFrame, boolean b) {
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
        jcbContinentes1 = new javax.swing.JComboBox<>();
        jtfHabitantes = new javax.swing.JTextField();
        jtfPais = new javax.swing.JTextField();
        bAddPais = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcbPais = new javax.swing.JComboBox<>();
        bEliminarPais = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Añadir País"));

        bAddPais.setText("Añadir País");
        bAddPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddPaisActionPerformed(evt);
            }
        });

        jLabel1.setText("Nº Habitantes");

        jLabel2.setText("Nombre País");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbContinentes1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jtfHabitantes, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(bAddPais, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAddPais, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbContinentes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHabitantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar País"));

        bEliminarPais.setText("Eliminar País");
        bEliminarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bEliminarPais)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEliminarPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEliminarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarPaisActionPerformed
        int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar '" + jcbPais.getSelectedItem() + "'?", "¡Atención!", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == confirmacion) {
            eliminarPais();
            selectPaises();
        }
    }//GEN-LAST:event_bEliminarPaisActionPerformed

    private void bAddPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddPaisActionPerformed
        if (comprobarCaracteres.comprobarInt(jtfHabitantes.getText()) && comprobarCaracteres.comprobarLetras(jtfPais.getText())) {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere agregar '" + jtfPais.getText() + "' como País con " + jtfHabitantes.getText() + " Habitantes de " + jcbContinentes1.getSelectedItem() + "?", "¡Atención!", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == confirmacion) {
                insertarPais(jcbContinentes1.getSelectedItem().toString(), comprobarCaracteres.devolverCadenaSinEspacios(jtfPais.getText()), comprobarCaracteres.devolverCadenaSinEspacios(jtfHabitantes.getText()));
                selectPaises();
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Los datos introducidos no son válidos!", "¡Error!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bAddPaisActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_bCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(Paises.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paises.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paises.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paises.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Paises dialog = new Paises(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bAddPais;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bEliminarPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcbContinentes1;
    private javax.swing.JComboBox<String> jcbPais;
    private javax.swing.JTextField jtfHabitantes;
    private javax.swing.JTextField jtfPais;
    // End of variables declaration//GEN-END:variables

    void selectContinentes() {
        int idContinente;
        String nombreContinente;
        Continente continenteIntroducir;
        arrayContinentes.clear();
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
        configurarComboPaises();
    }

    private void configurarComboContinentes() {
        jcbContinentes1.removeAllItems();
        if (arrayContinentes.size()>0) {
            for (Continente c : arrayContinentes) {
                jcbContinentes1.addItem(c.getNombreContinente());
            }
            bAddPais.setEnabled(true);
        } else {
            jcbContinentes1.addItem("No existen Continentes");
            bAddPais.setEnabled(false);
        }
    }

    private void configurarComboPaises() {
        jcbPais.removeAllItems();
        if (arrayPaises.size() < 1) {
            jcbPais.addItem("No existen paises.");
            bEliminarPais.setEnabled(false);
        } else {
            bEliminarPais.setEnabled(true);
            for (Pais p : arrayPaises) {
                jcbPais.addItem(p.getNombrePais());
            }
        }
    }

    private void eliminarPais() {
        String query = "SELECT * FROM `paises` WHERE `nombrePais`='" + jcbPais.getSelectedItem() + "'";
        int idPais = 0;
        int idContinente = 0;
        rs = cbd.ejecutarConsultaSelect(query);
        if (rs != null) {
            try {
                while (rs.next()) {
                    idContinente = rs.getInt("idContinente");
                    idPais = rs.getInt("idPais");
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        query = "DELETE FROM `paises` WHERE `idPais` = " + idPais;
        cbd.ejecutarConsultaSinReturn(query);
        query = "SELECT * FROM `paises` WHERE `idContinente`= " + idContinente;
        rs = cbd.ejecutarConsultaSelect(query);
        if (rs != null) {
            try {
                int contador;
                contador = 0;
                while (rs.next()) {
                    contador++;
                }
                if (contador == 0) {
                    query = "DELETE FROM `continentes` WHERE `idContinente` = " + idContinente;
                    cbd.ejecutarConsultaSinReturn(query);
                    selectContinentes();
                    selectPaises();
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
    }

    private void insertarPais(String cont, String nomPais, String numHabPais) {
        String query;
        int idCont = 0;
        query = "SELECT * FROM `continentes` WHERE `nombreContinente` = '" + cont + "'";
        rs = cbd.ejecutarConsultaSelect(query);
        if (rs != null) {
            try {
                while (rs.next()) {
                    idCont = rs.getInt("idContinente");
                }
                rs.close();
            } catch (SQLException sqlEx) {
            }
            rs = null;
        }
        query = "INSERT INTO `paises` (`idPais`, `idContinente`, `nombrePais`, `numHabitantes`) VALUES (NULL, '" + idCont + "', '" + nomPais + "', '" + numHabPais + "')";
        cbd.ejecutarConsultaSinReturn(query);
        jtfPais.setText("");
        jtfHabitantes.setText("");
        JOptionPane.showMessageDialog(null, "Operación Realizada Correctamente");
    }

}
