/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.awt.event.ItemListener;
import java.util.List;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import wellington.gerenciadorDeManobras.entidade.Categoria;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.excecao.GerenciadorException;
import wellington.gerenciadorDeManobras.negocio.CategoriaBO;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;

/**
 *
 * @author were
 */
public class FormCadastroManobra extends javax.swing.JFrame {

    private Manobra manobraEmEdicao;
    private List<Categoria> categorias;
    private List<Manobra> manobras;
    private GerenciarManobrasTelaInicial infoManobra;
    private FormAdicionarRequisito formAddRequisito;
    public int verificaEditarOuSalvar;
    private Categoria categoria;
    private ManobraBO manobraBO;
    String item = " ";
    private int idUsuario;

    /**
     * Creates metodos construtuores FormCadastroManobra
     */
    public FormCadastroManobra(GerenciarManobrasTelaInicial infoManobras, Manobra manobraSelecionada) throws ParseException, SQLException {
       // this(infoManobras);
        this.manobraEmEdicao = manobraSelecionada;
        this.inicializaCampoNomeManobra();
    }

    public FormCadastroManobra(GerenciarManobrasTelaInicial infoManobras, int idUsuario) throws ParseException, SQLException {
        this.idUsuario = idUsuario;
        this.infoManobra = infoManobras;
        this.manobraEmEdicao = new Manobra();
        this.initComponents();
        this.carregarComboCategorias();
        this.carregarComboDificuldade();
        //this.carregarComboStatus();
        this.recuperarCamposTela();

    }

    /**
     * @setVisible sobreescrita do set visible para toda vz que a tela de
     * cadastro de manobras estiver 'VISIBLE' o combobox das categorias
     * atualizar
     */
    @Override
    public void setVisible(boolean exibir) {
        super.setVisible(exibir);
        if (exibir == true) {
            try {
                this.carregarComboCategorias();
            } catch (SQLException ex) {
                Logger.getLogger(FormCadastroManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void carregarComboCategorias() throws SQLException {
        CategoriaBO categoriaBO = new CategoriaBO();
        categorias = categoriaBO.buscarTodasCategorias();
        cbxCategoriaManobras.removeAllItems();
        for (Categoria categoria : categorias) {
            cbxCategoriaManobras.addItem(categoria.getNome());
        }
    }

    /**
     * @getItemComboCategorias verifica item selecionado na combobox Categoria
     */
    public void getItemComboCategorias(String itemCombo) {
        this.item = itemCombo;
    }

    public void carregarComboDificuldade() {
        cbxGrauDificuldade.removeAllItems();
        for (int x = 0; x <= 4; x++) {
            if (x == 0) {
                cbxGrauDificuldade.addItem("simples");
            } else if (x == 1) {
                cbxGrauDificuldade.addItem("facil");
            } else if (x == 2) {
                cbxGrauDificuldade.addItem("mediana");
            } else if (x == 3) {
                cbxGrauDificuldade.addItem("difícil");
            } else {
                cbxGrauDificuldade.addItem("Dificuldade inexistente");
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
        txtNomeManobra = new javax.swing.JTextField();
        lblNomeManobra = new javax.swing.JLabel();
        lblDificuldade = new javax.swing.JLabel();
        cbxGrauDificuldade = new javax.swing.JComboBox();
        lblDificuldade3 = new javax.swing.JLabel();
        cbxCategoriaManobras = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblinfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Manobra");
        setExtendedState(6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Manobra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtNomeManobra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeManobraActionPerformed(evt);
            }
        });

        lblNomeManobra.setText("Nome");

        lblDificuldade.setText("Grau Dificulade");

        cbxGrauDificuldade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGrauDificuldadeActionPerformed(evt);
            }
        });

        lblDificuldade3.setText("Categoria");

        cbxCategoriaManobras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaManobrasActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Voltar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblinfo.setText("info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeManobra)
                            .addComponent(txtNomeManobra, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDificuldade3)
                            .addComponent(cbxCategoriaManobras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDificuldade)
                            .addComponent(cbxGrauDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btnCancelar)
                        .addGap(35, 35, 35)
                        .addComponent(btnSalvar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblinfo)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeManobra)
                            .addComponent(lblDificuldade3)
                            .addComponent(lblDificuldade))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeManobra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCategoriaManobras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxGrauDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                .addComponent(lblinfo)
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

        setSize(new java.awt.Dimension(721, 211));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeManobraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeManobraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeManobraActionPerformed

    private void cbxGrauDificuldadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGrauDificuldadeActionPerformed

    }//GEN-LAST:event_cbxGrauDificuldadeActionPerformed

    private void cbxCategoriaManobrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaManobrasActionPerformed
        // TODO add your handling code here:  
    }//GEN-LAST:event_cbxCategoriaManobrasActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (this.verificaEditarOuSalvar == 1) {
            try {
                this.verificaEditarOuSalvar = 0;
                this.atualizar();
            } catch (CampoObrigatorioException | ParseException | SQLException ex) {
                Logger.getLogger(FormCadastroManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            this.incluirManobra();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.infoManobra.toFront();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void incluirManobra() {
        try {
            this.getItemComboCategorias(cbxCategoriaManobras.getSelectedItem().toString());
            this.recuperarCamposTela();
            this.manobraBO = new ManobraBO();
            this.validarCamposObrigatorios();
            this.verificarManobra(manobraEmEdicao);
            this.manobraBO.inserir(manobraEmEdicao);
            JOptionPane.showMessageDialog(this, "Manobra cadastrada com sucesso!", "Nova manobra", JOptionPane.INFORMATION_MESSAGE);
            this.carregaTelaAddRequisito();
            this.limparCamposTela();
            this.infoManobra.carregarTabelaDeManobras(idUsuario);

        } catch (GerenciadorException g) {
            String mensagem = "Erro ao realizar operação:\n" + g.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Nova manobra", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            String mensagem = "Erro ao realizar operação:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Nova manobra", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizar() throws CampoObrigatorioException, ParseException, SQLException {
        this.getItemComboCategorias(cbxCategoriaManobras.getSelectedItem().toString());                 //recuperar valor selecionado no combobox de categoria, para poder resgatar o id do banco de dados e não do indice do combobox
        this.recuperarCamposTela();
        this.manobraBO = new ManobraBO();
        this.validarCamposObrigatorios();
        manobraBO.atualizar(manobraEmEdicao);
        JOptionPane.showMessageDialog(this, "Dados da manobra alterado com sucesso", "Ediçao de manobra", JOptionPane.INFORMATION_MESSAGE);
        this.limparCamposTela();
        this.infoManobra.carregarTabelaDeManobras(idUsuario);
    }

    public void validarCamposObrigatorios() throws CampoObrigatorioException {
        if (txtNomeManobra.getText().trim().isEmpty()) {
            this.lblinfo.setText("Campo nome manobra deve ser preenchido!");
            this.lblinfo.setText("Info");
            throw new CampoObrigatorioException();
        }

    }

    public void inicializaCampoNomeManobra() {
        txtNomeManobra.setText(manobraEmEdicao.getNome());
    }

    private void recuperarCamposTela() throws ParseException {
        manobraEmEdicao.setNome(txtNomeManobra.getText());
        manobraEmEdicao.setIdUsuario(idUsuario);
        int posicaoSelecionada1 = cbxGrauDificuldade.getSelectedIndex();
        manobraEmEdicao.setDificuldade(posicaoSelecionada1);

        int posicaoSelecionada3 = 0;
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equals(item)) {
                posicaoSelecionada3 = categoria.getId();
                manobraEmEdicao.setCategoria(posicaoSelecionada3);
            }
        }
        
        
    }

    public void verificarManobra(Manobra manobra) throws SQLException {
        this.manobraBO = new ManobraBO();
        this.manobras = manobraBO.buscarTodasManobras(idUsuario);
        for (Manobra m : manobras) {
            if (manobraEmEdicao.getNome().equals(m.getNome())) {
                JOptionPane.showMessageDialog(this, "Uma manobra com o mesmo nome ja existe no sistema!", "Adicionar  manobra", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }

    private void limparCamposTela() {
        this.txtNomeManobra.setText("");
    }

    public void carregaTelaAddRequisito() throws SQLException {
        if (formAddRequisito == null) {
            formAddRequisito = new FormAdicionarRequisito(manobraEmEdicao, idUsuario);
        }
        formAddRequisito.setVisible(true);
        formAddRequisito.toFront();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    public static javax.swing.JComboBox cbxCategoriaManobras;
    private javax.swing.JComboBox cbxGrauDificuldade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDificuldade;
    private javax.swing.JLabel lblDificuldade3;
    private javax.swing.JLabel lblNomeManobra;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JTextField txtNomeManobra;
    // End of variables declaration//GEN-END:variables

    // setando variavel para poder diferenciar quando o usuario quer editar ou atualizar uma manobra ou se está 
    // querendo salvar uma nova manobra
    public int getVerificaEditarOuSalvar() {
        return verificaEditarOuSalvar;
    }

    public void setVerificaEditarOuSalvar(int verificaEditarOuSalvar) {
        this.verificaEditarOuSalvar = verificaEditarOuSalvar;

    }
}
