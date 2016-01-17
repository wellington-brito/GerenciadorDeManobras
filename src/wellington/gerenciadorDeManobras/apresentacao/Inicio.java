/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import wellington.gerenciadorDeManobras.entidade.Dica;

import wellington.gerenciadorDeManobras.entidade.Relatorio;
import wellington.gerenciadorDeManobras.negocio.DicaBO;
import wellington.gerenciadorDeManobras.negocio.RelatorioBO;

/**
 *
 * @author Wellington
 */
public class Inicio extends javax.swing.JFrame {

    private Inicio inicio;
    private Login abrirFormLogin;

    /**
     * Creates new form Inicio
     */
    public Inicio() throws SQLException {
        initComponents();
        this.dicasAleatorias();
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
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblManobraAleatorioa1 = new javax.swing.JLabel();
        lblDicaAleatoria = new javax.swing.JLabel();
        lblManobraAleatoria2 = new javax.swing.JLabel();
        btnRelatorioTotalManobras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Manobras Bmx");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.lightGray));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/robber1.png"))); // NOI18N
        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/direction237.png"))); // NOI18N
        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblManobraAleatorioa1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblManobraAleatorioa1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDicaAleatoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDicaAleatoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblManobraAleatoria2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblManobraAleatoria2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRelatorioTotalManobras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/certification.png"))); // NOI18N
        btnRelatorioTotalManobras.setText("Manobras com treinos 100%");
        btnRelatorioTotalManobras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioTotalManobrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(btnRelatorioTotalManobras, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblManobraAleatoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblManobraAleatorioa1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblDicaAleatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(190, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addComponent(btnRelatorioTotalManobras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(lblManobraAleatorioa1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblManobraAleatoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(lblDicaAleatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(250, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.abrirTelaLoguin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRelatorioTotalManobrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioTotalManobrasActionPerformed
        try {
            this.gerarRelatorioTotalDeManobras();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarManobrasTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRelatorioTotalManobrasActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inicio().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRelatorioTotalManobras;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDicaAleatoria;
    private javax.swing.JLabel lblManobraAleatoria2;
    private javax.swing.JLabel lblManobraAleatorioa1;
    // End of variables declaration//GEN-END:variables

    private void abrirTelaLoguin() {
        if (this.abrirFormLogin == null) {
            this.abrirFormLogin = new Login(this);
        }
        abrirFormLogin.setVisible(true);
        abrirFormLogin.toFront();
        this.dispose();
    }

    private void gerarRelatorioTotalDeManobras() throws SQLException {
        RelatorioBO manobraLoginDiaBO = new RelatorioBO();
        List<Relatorio> listaTotalManobras = manobraLoginDiaBO.recuperaTotalManobra();
        try {
            String arquivoRelatorio = System.getProperty("user.dir")
                    + "/relatorios/TotaDeManobraPorUsuario.jasper";

            Map<String, Object> parametros = new HashMap<String, Object>();

            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(listaTotalManobras);

            JasperPrint relatorioGerado = JasperFillManager.fillReport(arquivoRelatorio, parametros, fonteDados);

            JasperViewer telaExibicaoRelatorio = new JasperViewer(relatorioGerado, false);
            telaExibicaoRelatorio.setTitle("Relatorio Quantidade de dias treinando cada manobra");
            telaExibicaoRelatorio.setVisible(true);
        } catch (JRException ex) {
            //JOptionPane.showMessageDialog(this, "Erro ao exibir relatório.","Erro",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void dicasAleatorias() throws SQLException {
        DicaBO dicaBO = new DicaBO();
        List<Dica> dicaAleatoria = dicaBO.buscarDicasAleatorias();

        for (Dica d : dicaAleatoria) {
            this.lblDicaAleatoria.setText(d.getDescricao());
        }

        for (Dica d : dicaAleatoria) {
            if (this.lblDicaAleatoria.getText().equals(d.getDescricao())) {

            } else {
                this.lblManobraAleatorioa1.setText(d.getDescricao());
            }

        }

        for (Dica d : dicaAleatoria) {            
            if (this.lblManobraAleatorioa1.getText().equals(d.getDescricao()) || this.lblDicaAleatoria.getText().equals(d.getDescricao())) {

            } else {
               this.lblManobraAleatoria2.setText(d.getDescricao());
            }
            
        }

    }

}
