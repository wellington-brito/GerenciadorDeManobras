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
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Requisito;
import wellington.gerenciadorDeManobras.entidade.Treino;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;
import wellington.gerenciadorDeManobras.negocio.TreinoBO;

/**
 *
 * @author Wellington
 */
public class FormCadastrarEditarTreino extends javax.swing.JFrame {

    private List<Manobra> manobras;
    private List<Requisito> listaRquisitos;
    private GerenciarTreinos gerenciarTreinos;
    private Treino treinoEmEdicao;
    private TreinoBO treinoBO;
    String item = "";

    /**
     * Creates new form FormCadastrarEditarTreino
     */
    FormCadastrarEditarTreino(GerenciarTreinos gerenciarTreinos, Treino treinoSelecionado) throws SQLException {
        this(gerenciarTreinos);
        this.treinoEmEdicao = treinoSelecionado;
        this.inicializaCampostela();
    }

    public FormCadastrarEditarTreino(GerenciarTreinos gerenciarTreinos) throws SQLException {
        this.gerenciarTreinos = gerenciarTreinos;
        this.treinoEmEdicao = new Treino();
        this.initComponents();
        this.carregarComboManobras();
    }

    @Override
    public void setVisible(boolean exibir) {
        super.setVisible(exibir);
        if (exibir == true) {
            try {
                this.carregarComboManobras();
                this.inicializaCampostela();
            } catch (SQLException ex) {
                Logger.getLogger(FormCadastroManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void carregarComboManobras() throws SQLException {
        ManobraBO manobraBO = new ManobraBO();
        manobras = manobraBO.buscarTodasManobras();
        cbxManobras.removeAllItems();
        for (Manobra m : manobras) {
            cbxManobras.addItem(m.getNome());
        }
    }

    public void getItemComboManobras(String itemCombo) {
        this.item = itemCombo;
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
        lblManobra = new javax.swing.JLabel();
        cbxManobras = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnFecharTela = new javax.swing.JButton();
        txtProgressoTreino = new javax.swing.JFormattedTextField();
        txtQntddiaTreinando = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo Treino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        lblManobra.setText("Manobra");

        jLabel1.setText("Progresso do treino");

        jLabel2.setText("%");

        jLabel3.setText("Quantidade de dias treinando");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFecharTela.setText("Voltar");
        btnFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTelaActionPerformed(evt);
            }
        });

        txtProgressoTreino.setColumns(3);
        txtProgressoTreino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        txtQntddiaTreinando.setColumns(3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblManobra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxManobras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProgressoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQntddiaTreinando, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnFecharTela)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFecharTela, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblManobra)
                        .addComponent(cbxManobras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(txtProgressoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQntddiaTreinando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(830, 232));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificaEditarOuSalvar == 1) {
            try {
                this.atualizar();
            } catch (CampoObrigatorioException | ParseException | SQLException ex) {
                Logger.getLogger(FormCadastroManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.incluirTreino();
            } catch (SQLException ex) {
                Logger.getLogger(FormCadastrarEditarTreino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTelaActionPerformed
        this.gerenciarTreinos.toFront();
        this.dispose();
    }//GEN-LAST:event_btnFecharTelaActionPerformed

    private void incluirTreino() throws SQLException {
        this.treinoBO = new TreinoBO();
        this.recuperarCamposTela();
        treinoBO.validarCamposObrigatoriosIdManobra(treinoEmEdicao);
        treinoBO.inserir(treinoEmEdicao);
        JOptionPane.showMessageDialog(this, "Treino cadastrado com sucesso!", "Novo Treino", JOptionPane.INFORMATION_MESSAGE);
        this.limparCamposTela();
        this.gerenciarTreinos.carregarTabelaDeTreino();
    }

    private void atualizar() throws CampoObrigatorioException, ParseException, SQLException {
        this.treinoBO = new TreinoBO();
        this.recuperarCamposTela();
        //treinoBO.validarCamposObrigatoriosAtualizar(treinoEmEdicao);
        if (treinoEmEdicao.getIdManobra() == 0 || treinoEmEdicao.getProgresso() == 0 || treinoEmEdicao.getQntddias() == 0) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Editar Treino", JOptionPane.INFORMATION_MESSAGE);
            throw new CampoObrigatorioException();
        }
        treinoBO.atualizar(treinoEmEdicao);
        this.limparCamposTela();
        this.gerenciarTreinos.carregarTabelaDeTreino();
        JOptionPane.showMessageDialog(this, "Dados do treino alterado com sucesso", "Ediçao de treino", JOptionPane.INFORMATION_MESSAGE);
        this.atualizaStatus(treinoEmEdicao.getIdManobra(), 100);
        this.sugerirNovoTreino();
       
        

    }

    private void sugerirNovoTreino() throws SQLException {
        this.treinoBO = new TreinoBO();
        listaRquisitos = treinoBO.verificaProgresso(treinoEmEdicao);

        String mensagem = "";
        for (Requisito requisitos : listaRquisitos) {
            if (requisitos.getIdManobraRequisito() == treinoEmEdicao.getIdManobra()) {
                int idManobraSugerida = requisitos.getIdManobraRecente();
                for (Manobra m : manobras) {
                    if (m.getId() == idManobraSugerida) {
                        mensagem = mensagem + "-"+m.getNome()+"\n";
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(this, "PARABÉNS!! Agora é possivel treinar: \n" + mensagem, "Sugestão de Manobra", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void atualizaStatus(int id,int status) throws SQLException{
        ManobraBO manobraBO = new ManobraBO();
        manobraBO.atualizaStatus(id,status);
    
    }

    private void recuperarCamposTela() {
        this.getItemComboManobras(cbxManobras.getSelectedItem().toString());                                            //recuperar valor selecionado no combobox de categoria, para poder resgatar o id do banco de dados e não do indice do combobox
        int posicaoSelecionada = 0;
        for (Manobra m : manobras) {
            if (m.getNome().equals(item)) {
                posicaoSelecionada = m.getId();
                treinoEmEdicao.setIdManobra(posicaoSelecionada);
            }
        }
        treinoEmEdicao.setProgresso(Integer.parseInt(txtProgressoTreino.getText()));
        treinoEmEdicao.setQntddias(Integer.parseInt(txtQntddiaTreinando.getText()));
    }

    private void inicializaCampostela() {
        for (Manobra m : manobras) {
            if (treinoEmEdicao.getIdManobra() == m.getId()) {
                cbxManobras.setSelectedItem(m.getNome());
            }
        }
        String progresso = Integer.toString(treinoEmEdicao.getProgresso());
        txtProgressoTreino.setText(progresso);
        String qntddias = Integer.toString(treinoEmEdicao.getQntddias());
        txtQntddiaTreinando.setText(qntddias);
    }

    private void limparCamposTela() {
        this.txtProgressoTreino.setText("");
        this.txtQntddiaTreinando.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharTela;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxManobras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblManobra;
    private javax.swing.JFormattedTextField txtProgressoTreino;
    private javax.swing.JFormattedTextField txtQntddiaTreinando;
    // End of variables declaration//GEN-END:variables

    int verificaEditarOuSalvar;

    public int getVerificaEditarOuSalvar() {
        return verificaEditarOuSalvar;
    }

    public void setVerificaEditarOuSalvar(int verificaEditarOuSalvar) {
        this.verificaEditarOuSalvar = verificaEditarOuSalvar;

    }

}
