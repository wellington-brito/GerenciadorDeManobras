/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.entidade.Requisito;
import wellington.gerenciadorDeManobras.negocio.ManobraBO;
import wellington.gerenciadorDeManobras.negocio.RequisitoBO;

/**
 *
 * @author Wellington
 */
public class FormAdicionarRequisito extends javax.swing.JFrame {

    private Manobra manobraEmEdicao;
    private Requisito requisitoEmEdicao;
    private List<Manobra> manobras;
    public int verificaEditarOuSalvarRequisitos;
    String item = "";
    private int idUsuario;

    /**
     * Creates new form FormAdicionarRequisito
     */
    public FormAdicionarRequisito(GerenciarRequisitos gerenciarRequisitos, Requisito requisitoSelecionado) throws SQLException {
       // this(gerenciarRequisitos);
        this.requisitoEmEdicao = requisitoSelecionado;
        this.prepararTelaEditar();
        //this.manobraEmEdicao = new Manobra();
        // this.prepararTela();
    }

    public FormAdicionarRequisito(GerenciarRequisitos gerenciarRequisitos) throws SQLException {
        this.manobraEmEdicao = new Manobra();
        this.prepararTela();
        // this.requisitoEmEdicao = requisitoSelecionado;
        // this.prepararTela();
    }

    public FormAdicionarRequisito(Manobra manobra, int idUsuario) throws SQLException {
       this.idUsuario = idUsuario;
        this.manobraEmEdicao = manobra;
        this.prepararTela();
    }

    public void prepararTela() throws SQLException {
        try {
            this.initComponents();
            this.inicializaCampoNomeManobra();
            this.carregarComboManobras();
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Tela Requisito de manobras", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    public void prepararTelaEditar() throws SQLException {
        try {
            this.initComponents();
           // this.inicializaCampoNomeManobraEditar();
            this.carregarComboManobras();
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Tela Requisito de manobras", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    public void inicializaCampoNomeManobra() {
        txtManobraRecente.setText(manobraEmEdicao.getNome());
    }

//    public void inicializaCampoNomeManobraEditar() {
//        try {
//            ManobraBO manobraBO = new ManobraBO();
//            manobras = manobraBO.buscarTodasManobras();
//            for (Manobra m : manobras) {
//
//                if (this.requisitoEmEdicao.getIdManobra() == m.getId()) {
//                    int x = requisitoEmEdicao.getIdManobra();
//                    txtManobraRecente.setText("teste");
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FormAdicionarRequisito.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public void setVisible(boolean exibir) {
        super.setVisible(exibir);
        if (exibir == true) {
            try {
                this.inicializaCampoNomeManobra();
                this.carregarComboManobras();
            } catch (SQLException ex) {
                Logger.getLogger(FormCadastroManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void carregarComboManobras() throws SQLException {
        ManobraBO manobraBO = new ManobraBO();
        manobras = manobraBO.buscarTodasManobras(idUsuario);
        cbxManobrasRequisitos.removeAllItems();
       this.cbxManobrasRequisitos.addItem("");
        for (Manobra m : manobras) {
            cbxManobrasRequisitos.addItem(m.getNome());
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
        lblManobraRecente = new javax.swing.JLabel();
        txtManobraRecente = new javax.swing.JTextField();
        cbxManobrasRequisitos = new javax.swing.JComboBox<>();
        lblEscolherManobra = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        lblDicaAdicionarRequisito = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicinar Reqisito de manobra");
        setExtendedState(6);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Requisito de manobra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        lblManobraRecente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblManobraRecente.setText("Manobra");

        cbxManobrasRequisitos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEscolherManobra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEscolherManobra.setText("Manobra requisito");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save23.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblDicaAdicionarRequisito.setText("Caso não seja necessário aprender uma outra manobra antes desta clique em \"Fechar\".");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back57.png"))); // NOI18N
        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblDicaAdicionarRequisito, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblManobraRecente)
                        .addGap(83, 83, 83)
                        .addComponent(txtManobraRecente, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEscolherManobra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxManobrasRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManobraRecente)
                    .addComponent(txtManobraRecente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscolherManobra)
                    .addComponent(cbxManobrasRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(lblDicaAdicionarRequisito)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnSalvar)))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(881, 506));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (verificaEditarOuSalvarRequisitos == 1) {
                this.atualizarRequisito();
            } else {
                this.incluiRequisito();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormAdicionarRequisito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void incluiRequisito() throws SQLException {
        this.getItemComboManobras(cbxManobrasRequisitos.getSelectedItem().toString());
        this.recuperarCamposTela();
        RequisitoBO requisitoBO = new RequisitoBO();
        requisitoBO.inlcuirRequisito(requisitoEmEdicao);
        JOptionPane.showMessageDialog(this, "Requisito para a manobra " + cbxManobrasRequisitos.getSelectedItem() + "Foi salvo com sucesso", "Adicionar requisito de Manobra", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarRequisito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void recuperarCamposTela() {
        requisitoEmEdicao = new Requisito();
        for (Manobra m : manobras) {
            if (m.getNome().equals(txtManobraRecente.getText())) {
                requisitoEmEdicao.setIdManobra(m.getId());// null pointer exception bem aqui
            }
        }
        for (Manobra m : manobras) {
            if (m.getNome().equals(item)) {
                requisitoEmEdicao.setIdManobraRequisito(m.getId());
            }
        }
    }

    public void getItemComboManobras(String manobraSlecionado) {
        this.item = manobraSlecionado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxManobrasRequisitos;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDicaAdicionarRequisito;
    private javax.swing.JLabel lblEscolherManobra;
    private javax.swing.JLabel lblManobraRecente;
    private javax.swing.JTextField txtManobraRecente;
    // End of variables declaration//GEN-END:variables

    public int getFormRequisitos() {
        return verificaEditarOuSalvarRequisitos;
    }

    public void setFormRequisitos(int formRequisitos) {
        this.verificaEditarOuSalvarRequisitos = formRequisitos;
    }

}
