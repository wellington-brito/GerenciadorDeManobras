/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.text.ParseException;
import javax.swing.JOptionPane;
import wellington.gerenciadorDeManobras.entidade.Categoria;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.negocio.CategoriaBO;

/**
 *
 * @author were
 */
public class AdicionarCategoriaForm extends javax.swing.JFrame {

    private Categoria categoriaEmEdicao;

    /**
     * Creates new form AdicionarCategoriaForm
     */
    public AdicionarCategoriaForm() {
        initComponents();
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
        btnSalvar = new javax.swing.JButton();
        txtDescricaoCategoria = new javax.swing.JTextField();
        lblNomeCategoria1 = new javax.swing.JLabel();
        txtNomeCategoria = new javax.swing.JTextField();
        lblNomeCategoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nova Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        btnSalvar.setText("Salva!");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtDescricaoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoCategoriaActionPerformed(evt);
            }
        });

        lblNomeCategoria1.setText("Descrição");

        txtNomeCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCategoriaActionPerformed(evt);
            }
        });

        lblNomeCategoria.setText("Nome Categoria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeCategoria1)
                            .addComponent(lblNomeCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                            .addComponent(txtDescricaoCategoria))))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCategoria))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricaoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCategoria1))
                .addGap(28, 28, 28)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoCategoriaActionPerformed

    private void txtNomeCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCategoriaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        this.salvar();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void salvar() {
        try {

            this.validarCamposObrigatorios();
            this.recuperarCamposTela();
            CategoriaBO categoriaBO = new CategoriaBO();
            categoriaBO.inserir(categoriaEmEdicao);

            JOptionPane.showMessageDialog(this, "Categoria cadastrada com sucesso!", "Cadastro de nova Catagoria", JOptionPane.INFORMATION_MESSAGE);
            this.limparCamposTela();

        } catch (Exception e) {
            String mensagem = "Erro ao realizar operação:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Cadastro de nova Catagoria", JOptionPane.ERROR_MESSAGE);

        }
    }

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
            java.util.logging.Logger.getLogger(AdicionarCategoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarCategoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarCategoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarCategoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarCategoriaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNomeCategoria;
    private javax.swing.JLabel lblNomeCategoria1;
    private javax.swing.JTextField txtDescricaoCategoria;
    private javax.swing.JTextField txtNomeCategoria;
    // End of variables declaration//GEN-END:variables

    private void validarCamposObrigatorios() throws CampoObrigatorioException {
        if (txtDescricaoCategoria.getText().trim().isEmpty() && txtDescricaoCategoria.getText().trim().isEmpty()) {
            throw new CampoObrigatorioException();
        }
    }

    private void recuperarCamposTela() {
        categoriaEmEdicao = new Categoria();
        categoriaEmEdicao.setNome(txtNomeCategoria.getText());
        categoriaEmEdicao.setDescricao(txtDescricaoCategoria.getText());

    }

    private void limparCamposTela() {
         this.txtNomeCategoria.setText("");
          this.txtDescricaoCategoria.setText("");
    }

}
