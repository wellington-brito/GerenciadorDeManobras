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
import javax.swing.table.AbstractTableModel;
import wellington.gerenciadorDeManobras.entidade.Categoria;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Treino;
import wellington.gerenciadorDeManobras.excecao.NoSelectionException;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;

/**
 *
 * @author Wellington
 */
public class GerenciarTreinos extends javax.swing.JFrame {

    public FormCadastrarEditarTreino formCadastrarTreino;
    public FormCadastrarEditarTreino formEditarTreino;
    public InfoManobras infoManobras;
  
    private List<Treino> treinos;
    private List<Manobra> manobras;
    /**
     * Creates new form GerenciarTreinos
     */
    public GerenciarTreinos() {
        initComponents();
    }

    public GerenciarTreinos(InfoManobras infoManobroas) {
       this.infoManobras = infoManobroas;
       this.initComponents();
      
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
        tabelaTreinos = new javax.swing.JTable();
        btnNovoTreino = new javax.swing.JButton();
        btnAlterarTreino = new javax.swing.JButton();
        btnExcluirTreino = new javax.swing.JButton();
        btnFecharTela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Treinos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tabelaTreinos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaTreinos);

        btnNovoTreino.setText("Novo");
        btnNovoTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTreinoActionPerformed(evt);
            }
        });

        btnAlterarTreino.setText("Editar");
        btnAlterarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTreinoActionPerformed(evt);
            }
        });

        btnExcluirTreino.setText("Excluir");
        btnExcluirTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTreinoActionPerformed(evt);
            }
        });

        btnFecharTela.setText("Voltar");
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovoTreino)
                .addGap(18, 18, 18)
                .addComponent(btnAlterarTreino)
                .addGap(18, 18, 18)
                .addComponent(btnExcluirTreino)
                .addGap(11, 11, 11)
                .addComponent(btnFecharTela)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTreinoActionPerformed
        try {
            this.carregarFormCadastroEditarTreino();
        } catch (SQLException ex) {
            Logger.getLogger(InfoManobras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNovoTreinoActionPerformed

    private void btnAlterarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTreinoActionPerformed
//        try {
//            this.editarCategoria();
//            this.editarCategoriaForm.setVerificaEditarOuSalvar(1);
//        } catch (ParseException | SQLException ex) {
//            Logger.getLogger(GerenciarCategorias.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnAlterarTreinoActionPerformed

    private void btnExcluirTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTreinoActionPerformed
       // this.excluirCategoria();
    }//GEN-LAST:event_btnExcluirTreinoActionPerformed

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    public void carregarFormCadastroEditarTreino() throws SQLException {
        if (formCadastrarTreino == null) {
            formCadastrarTreino = new FormCadastrarEditarTreino(this);
        }
        formCadastrarTreino.setVisible(true);
        formCadastrarTreino.toFront();
    }

    private void editarCategoria() throws SQLException, ParseException {
        int linhaSelecionada = tabelaTreinos.getSelectedRow();
        if (linhaSelecionada != -1) {
            Treino treinoSelecionado = treinos.get(linhaSelecionada);
            if (formEditarTreino != null) {
                formEditarTreino.dispose();
            }
            formEditarTreino = new FormCadastrarEditarTreino(this, treinoSelecionado);
            formEditarTreino.setVisible(true);
        } else {
            throw new NoSelectionException();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarTreino;
    private javax.swing.JButton btnExcluirTreino;
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JButton btnNovoTreino;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaTreinos;
    // End of variables declaration//GEN-END:variables

     //classe interna
    private class ModeloTabelaTreinos extends AbstractTableModel {

        @Override
        public String getColumnName(int coluna) {
            if(coluna == 0){
                return "Manobras";
            } else if (coluna == 1){
                return "Progresso";
            } else{
                return "Dias treinando";
            }
        }
        
        @Override
        public int getRowCount() {
            return treinos.size();
        }
        
        @Override
        public int getColumnCount() {
            return 3;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Treino t = treinos.get(rowIndex);
            ManobraBO manobraBO = new ManobraBO();
            try {
                manobras = manobraBO.buscarTodasManobras();
            } catch (SQLException ex) {
                Logger.getLogger(GerenciarTreinos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (columnIndex == 0){
                for (Manobra m : manobras) {
                    if(m.getId() == t.getId()){
                        return m.getNome();
                    }
                    else{return t.getId();
                    }
                }
                return t.getIdManobra();
            }else if(columnIndex == 1){
                return t.getProgresso();
            }else{
                return t.getQntddias();
            }
        }

    }
}
