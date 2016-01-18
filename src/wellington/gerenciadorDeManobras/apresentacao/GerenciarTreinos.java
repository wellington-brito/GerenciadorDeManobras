/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import wellington.gerenciadorDeManobras.entidade.Categoria;

import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Relatorio;
import wellington.gerenciadorDeManobras.entidade.Treino;
import wellington.gerenciadorDeManobras.entidade.Usuario;
import wellington.gerenciadorDeManobras.excecao.NoSelectionException;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;
import wellington.gerenciadorDeManobras.negocio.RelatorioBO;
import wellington.gerenciadorDeManobras.negocio.TreinoBO;
import wellington.gerenciadorDeManobras.negocio.UsuarioBO;

/**
 *
 * @author Wellington
 */
public class GerenciarTreinos extends javax.swing.JFrame {

    public FormCadastrarEditarTreino formCadastrarTreino;
    public FormCadastrarEditarTreino formEditarTreino;    
    public GerenciarManobrasTelaInicial infoManobras;  
    private List<Treino> treinos;
    private List<Relatorio> listamanobraLoginDia;  
    private List<Manobra> manobras;
    private List<Usuario> usuarios;
    private GerenciarManobrasTelaInicial gerenciarManobrasTelaInicial;
    private int idUsuario;
    /**
     * Creates new form GerenciarTreinos
     */
    public GerenciarTreinos() throws SQLException {        
       this.prepararTela();
    }

    GerenciarTreinos(GerenciarManobrasTelaInicial infoManobras, int idUsuario) throws SQLException {
        this.gerenciarManobrasTelaInicial = infoManobras;
        this.idUsuario = idUsuario;
        this.prepararTela();
    }

//    public GerenciarTreinos(GerenciarManobrasTelaInicial infoManobroas) throws SQLException {
//       this.infoManobras = infoManobroas;
//       this.initComponents();
//       this.carregarTabelaDeTreino(idUsuario);
//      
//    }
    
    public void prepararTela() throws SQLException {
        try {
            this.initComponents();
            this.carregarTabelaDeTreino(idUsuario);
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
                this.carregarTabelaDeTreino(idUsuario);
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
        tabelaTreinos = new javax.swing.JTable();
        btnNovoTreino = new javax.swing.JButton();
        btnAlterarTreino = new javax.swing.JButton();
        btnExcluirTreino = new javax.swing.JButton();
        btnFecharTela = new javax.swing.JButton();
        lblTeste = new javax.swing.JLabel();
        btnRelatorioQntdDiasTreinos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setResizable(false);

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

        btnNovoTreino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add182.png"))); // NOI18N
        btnNovoTreino.setText("Novo");
        btnNovoTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTreinoActionPerformed(evt);
            }
        });

        btnAlterarTreino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pencil43.png"))); // NOI18N
        btnAlterarTreino.setText("Editar");
        btnAlterarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTreinoActionPerformed(evt);
            }
        });

        btnExcluirTreino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete81.png"))); // NOI18N
        btnExcluirTreino.setText("Excluir");
        btnExcluirTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTreinoActionPerformed(evt);
            }
        });

        btnFecharTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back57.png"))); // NOI18N
        btnFecharTela.setText("Voltar");
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });

        lblTeste.setText("Info.");

        btnRelatorioQntdDiasTreinos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/certification.png"))); // NOI18N
        btnRelatorioQntdDiasTreinos.setText("Dias treinando");
        btnRelatorioQntdDiasTreinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioQntdDiasTreinosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTeste)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRelatorioQntdDiasTreinos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovoTreino)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarTreino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluirTreino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(btnFecharTela, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190)
                .addComponent(lblTeste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRelatorioQntdDiasTreinos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlterarTreino)
                        .addComponent(btnExcluirTreino)
                        .addComponent(btnFecharTela))
                    .addComponent(btnNovoTreino)))
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

        setSize(new java.awt.Dimension(885, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTreinoActionPerformed
        try {
            this.novoTreino();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarManobrasTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNovoTreinoActionPerformed

    private void btnAlterarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTreinoActionPerformed
        try {
            this.editarTreino();
            this.formEditarTreino.setVerificaEditarOuSalvar(1);
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GerenciarTreinos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarTreinoActionPerformed

    private void btnExcluirTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTreinoActionPerformed
        this.excluirCategoria();
    }//GEN-LAST:event_btnExcluirTreinoActionPerformed

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
      
        try {
            this.gerenciarManobrasTelaInicial.carregarTabelaDeManobras(idUsuario);
            this.dispose();            
            // this.carregarTelaInfoManobra();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarTreinos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    private void btnRelatorioQntdDiasTreinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioQntdDiasTreinosActionPerformed
        try {
            this.gerarRelatorioQntdDiasTrinandoCadaManobras();
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarTreinos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRelatorioQntdDiasTreinosActionPerformed

   
    public void novoTreino() throws SQLException {                       
            if (formCadastrarTreino == null) {
                formCadastrarTreino = new FormCadastrarEditarTreino(this,idUsuario);         
            }            
            formCadastrarTreino.setVisible(true);       
            formCadastrarTreino.toFront();       
     }
    
     private void editarTreino() throws SQLException, ParseException {
        int linhaSelecionada = tabelaTreinos.getSelectedRow();
        if (linhaSelecionada != -1) {
            Treino treinoSelecionado = treinos.get(linhaSelecionada);
            if (formEditarTreino != null) {
                formEditarTreino.dispose();
            }
            formEditarTreino = new FormCadastrarEditarTreino(this, treinoSelecionado, idUsuario);
            formEditarTreino.setVisible(true);
            
        } else {
            this.lblTeste.setText("Selecione Um treinos antes!");
            throw new NoSelectionException();
        }
    }
     public void excluirCategoria(){
       try {
            int linhaSelecionada = tabelaTreinos.getSelectedRow();
            if (linhaSelecionada != -1) {
                Treino treinoSelecionado = treinos.get(linhaSelecionada);

                int resposta;
                String mensagem = "Desseja realmente excluir treino selecionado?";
                String titulo = "Exclusão de treino";
                resposta = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_NO_OPTION) {
                    TreinoBO treinoBO = new TreinoBO();
                    treinoBO.removerTreino(treinoSelecionado.getId());
                    mensagem = "Treino " + treinoSelecionado.getId() + " Id manobra: " + treinoSelecionado.getId() + " excluída com sucesso!";
                    JOptionPane.showMessageDialog(this, mensagem, "Exclusão de treino", JOptionPane.INFORMATION_MESSAGE);
                    this.carregarTabelaDeTreino(idUsuario);
                }
            } else {
                String mensagem = "Selecione uma categoria antes!";
                JOptionPane.showMessageDialog(this, mensagem, "Exclusão de categoria", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Exclusão de categoria ", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
     }
     
   
     public void carregarTabelaDeTreino(int idUsuario) throws SQLException {
        TreinoBO treinoBO = new TreinoBO();
        this.treinos = treinoBO.buscarTodosTreinos(idUsuario);
        ModeloTabelaTreinos modelo = new ModeloTabelaTreinos();
        tabelaTreinos.setModel(modelo);
     }
   
//    public void carregarTelaInfoManobra() throws SQLException{
//       if (this.infoManobras == null) {
//          //  int idUsuario = u.getId();
//            this.infoManobras = new GerenciarManobrasTelaInicial(idUsuario);
//       }
//       this.infoManobras.setVisible(true);
//       this.infoManobras.toFront();
//     }
    
   
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarTreino;
    private javax.swing.JButton btnExcluirTreino;
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JButton btnNovoTreino;
    private javax.swing.JButton btnRelatorioQntdDiasTreinos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTeste;
    private javax.swing.JTable tabelaTreinos;
    // End of variables declaration//GEN-END:variables

     //classe interna
    private class ModeloTabelaTreinos extends AbstractTableModel {

        @Override
        public String getColumnName(int coluna) {
            if(coluna == 0){
                return "Manobras";
            } else {
                return "Progresso %";
            } 
        }
        
        @Override
        public int getRowCount() {
            return treinos.size();
        }
        
        @Override
        public int getColumnCount() {
            return 2;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Treino t = treinos.get(rowIndex);                   
            if (columnIndex == 0){
                try {
                    ManobraBO manobraBO = new ManobraBO();
                    manobras = manobraBO.buscarTodasManobras(idUsuario);
                    for (Manobra m : manobras) {
                        if(m.getId() == t.getIdManobra()){
                            return m.getNome();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GerenciarTreinos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(columnIndex == 1){
                return t.getProgresso();
            }else{
                return t.getQntddias();
            }
            return null;
        }

    }
    
    
   
    
    private void gerarRelatorioQntdDiasTrinandoCadaManobras() throws SQLException {
        RelatorioBO manobraLoginDiaBO = new RelatorioBO();
        this.listamanobraLoginDia = manobraLoginDiaBO.recuperaManobraLoginDia(idUsuario);
        
        try{
            String arquivoRelatorio = System.getProperty("user.dir")+
                    "/relatorios/RelatorioDiasGatosTreinandoManobras.jasper";
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(this.listamanobraLoginDia);
            
            JasperPrint  relatorioGerado = JasperFillManager.fillReport(arquivoRelatorio, parametros, fonteDados);
            
            JasperViewer telaExibicaoRelatorio = new JasperViewer(relatorioGerado,false);
            telaExibicaoRelatorio.setTitle("Relatorio Quantidade de dias treinando cada manobra");
            telaExibicaoRelatorio.setVisible(true);
        }catch(JRException ex){
            JOptionPane.showMessageDialog(this, "Erro ao exibir relatório.","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
    }

}
