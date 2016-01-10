/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Requisito;
import wellington.gerenciadorDeManobras.excecao.NoSelectionException;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;
import wellington.gerenciadorDeManobras.negocio.RequisitoBO;

/**
 *
 * @author Wellington
 */
public class GerenciarRequisitos extends javax.swing.JFrame {

    private List<Requisito> requisitos;
    private List<Manobra> manobras;
   // private FormAdicionarRequisito forVerificaEditarOuSalvarRequisito;
    private FormAdicionarRequisito formEditarRequisito;

    /**
     * Creates new form GerenciarRequisitos
     */
    public GerenciarRequisitos() throws SQLException {
        this.prepararTela();
    }

    public void prepararTela() throws SQLException {
        try {
            this.initComponents();
            this.carregarTabelaDeRequisitos();
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Manobras cadastrados", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }
        
    @Override
    public void setVisible(boolean exibir) {
        super.setVisible(exibir);
        if (exibir == true) {
            try {
                this.carregarTabelaDeRequisitos();
            } catch (SQLException ex) {
                Logger.getLogger(FormCadastroManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRequisitos = new javax.swing.JTable();
        btnAlterarRequisito = new javax.swing.JButton();
        btnExcluirRequisito = new javax.swing.JButton();
        btnFecharTela = new javax.swing.JButton();
        lblDica = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Requisitos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Requisitos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tabelaRequisitos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaRequisitos);

        btnAlterarRequisito.setText("Editar");
        btnAlterarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarRequisitoActionPerformed(evt);
            }
        });

        btnExcluirRequisito.setText("Excluir");
        btnExcluirRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirRequisitoActionPerformed(evt);
            }
        });

        btnFecharTela.setText("Voltar");
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });

        lblDica.setText("Info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDica))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(626, 626, 626)
                        .addComponent(btnAlterarRequisito)
                        .addGap(27, 27, 27)
                        .addComponent(btnExcluirRequisito)
                        .addGap(11, 11, 11)
                        .addComponent(btnFecharTela)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFecharTela, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        setSize(new java.awt.Dimension(907, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void btnExcluirRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirRequisitoActionPerformed
        this.excluirRequisito();
    }//GEN-LAST:event_btnExcluirRequisitoActionPerformed

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    private void btnAlterarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarRequisitoActionPerformed
        try {
            this.editarRequisito();
            this.formEditarRequisito.setFormRequisitos(1);
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarRequisitos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarRequisitoActionPerformed

     public void carregarTabelaDeRequisitos() throws SQLException {
        RequisitoBO requisitoBO = new RequisitoBO();
        this.requisitos = requisitoBO.buscarTodosRequisitosEspecificos();
        ModeloTabelaRequisitos modelo = new ModeloTabelaRequisitos();
        tabelaRequisitos.setModel(modelo);
    }
     
    public void editarRequisito() throws SQLException {
        int linhaSelecionada = tabelaRequisitos.getSelectedRow();
        if (linhaSelecionada != -1) {
            Requisito requisitoSelecionado = requisitos.get(linhaSelecionada);
            if (formEditarRequisito != null) {
                formEditarRequisito.dispose();
            }
            formEditarRequisito = new FormAdicionarRequisito(this, requisitoSelecionado);
            formEditarRequisito.setVisible(true);
        } else {
            this.lblDica.setText("Selecione um requisito antes!");
            throw new NoSelectionException();
        }
    }
    
    public void excluirRequisito() {
        try {
            int linhaSelecionada = tabelaRequisitos.getSelectedRow();
            if (linhaSelecionada != -1) {
                Requisito requisitoSelecionado = requisitos.get(linhaSelecionada);
                int resposta;
                String mensagem = "Deseja realmente excluir requisito selecionado?";
                String titulo = "Exclusão de requisito";
                resposta = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_NO_OPTION) {
                    RequisitoBO requisitoBO = new RequisitoBO();
                    requisitoBO.removerRequisito(requisitoSelecionado.getId());
                    mensagem = "Excluído com sucesso!Id requisito: " + requisitoSelecionado.getId();
                    JOptionPane.showMessageDialog(this, mensagem, "Exclusão de requisito", JOptionPane.INFORMATION_MESSAGE);
                    this.carregarTabelaDeRequisitos();
                }
            } else {
                String mensagem = "Selecione uma categoria antes!";
                JOptionPane.showMessageDialog(this, mensagem, "Exclusão de categoria", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Exclusão de requisito", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarRequisito;
    private javax.swing.JButton btnExcluirRequisito;
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDica;
    private javax.swing.JTable tabelaRequisitos;
    // End of variables declaration//GEN-END:variables

    //classe interna
    private class ModeloTabelaRequisitos extends AbstractTableModel {

        @Override
        public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "Manobra";
            } else {
                return "Manobra que você precisa aprender antes";
            }
        }

        @Override
        public int getRowCount() {
            return requisitos.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try {
                ManobraBO manobraBO = new ManobraBO();
                manobras = manobraBO.buscarTodasManobras();
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarRequisitos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Requisito r = requisitos.get(rowIndex);

            if (columnIndex == 0){
                for (Manobra m : manobras) {
                    if (r.getIdManobraRecente() == m.getId()) {
                        return m.getNome();
                    }
                }
                return "Problemas para exibir o nome da manobra";
            } else {
                for (Manobra m : manobras) {
                    if (r.getIdManobraRequisito() == m.getId()) {
                        return m.getNome();
                    }
                }
                return " ";
            }
        }
    }

}
