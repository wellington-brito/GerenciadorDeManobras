/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellington.gerenciadorDeManobras.apresentacao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wellington.gerenciadorDeManobras.entidade.Dica;
import wellington.gerenciadorDeManobras.entidade.Manobra;
import wellington.gerenciadorDeManobras.excecao.CampoObrigatorioException;
import wellington.gerenciadorDeManobras.negocio.DicaBO;

/**
 *
 * @author Wellington
 */
public class FormAdicionarDicaManobra extends javax.swing.JFrame {

    private int verificaEditarOuSalvar;
    private Dica dicaEmEdicao;
    private DicaBO dicaBO;
    private int idManobra = 0;
    private int idUsuario;
    private FormCadastrarEditarTreino formCadastrarEditarTreino;
    private GerenciarDicas gerenciarDicas;

    /**
     * Creates new form FormAdicionarDicaManobra
     */
    public FormAdicionarDicaManobra() {
        initComponents();
    }

    FormAdicionarDicaManobra(FormCadastrarEditarTreino formCadastrarEditarTreino, int id, int idUsuario) {
        this.idUsuario = idUsuario;
        this.formCadastrarEditarTreino = formCadastrarEditarTreino;
        this.idManobra = id;
        initComponents();
    }

    FormAdicionarDicaManobra(GerenciarDicas gerenciarDicas, Dica dicaSelecionado) {
        this.gerenciarDicas = gerenciarDicas;
        this.dicaEmEdicao = dicaSelecionado;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDicaManobra = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnSalvarDica = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblinfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Dica");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione uma dica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtDicaManobra.setColumns(20);
        txtDicaManobra.setRows(5);
        jScrollPane2.setViewportView(txtDicaManobra);

        jLabel1.setText("Caso você fique possa relembrar como executa-la corretamente.");

        btnSalvarDica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save23.png"))); // NOI18N
        btnSalvarDica.setText("Salvar");
        btnSalvarDica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDicaActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back57.png"))); // NOI18N
        btnFechar.setText("Voltar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblinfo.setText("info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblinfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarDica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvarDica, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblinfo, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(566, 367));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarDicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDicaActionPerformed
      
        if (this.verificaEditarOuSalvar == 1) {
            try {
                this.verificaEditarOuSalvar = 0;
                this.atualizarDica();
            } catch (CampoObrigatorioException ex) {
                Logger.getLogger(FormCadastroManobra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FormAdicionarDicaManobra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FormAdicionarDicaManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.inserirDica();
            } catch (SQLException ex) {
                Logger.getLogger(FormAdicionarDicaManobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarDicaActionPerformed

    public void inserirDica() throws SQLException {
        this.veririficarCampoDica();
        this.recuperarDica();
        this.dicaEmEdicao.setIdManobra(idManobra);
        DicaBO dicaBO = new DicaBO();
        dicaBO.incluirNovaDica(dicaEmEdicao);
        JOptionPane.showMessageDialog(this, "Dica cadastrada com sucesso", "Nova dica", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvarDica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JTextArea txtDicaManobra;
    // End of variables declaration//GEN-END:variables

    private void recuperarDica() {
        this.dicaEmEdicao = new Dica();
        this.dicaEmEdicao.setDescricao(txtDicaManobra.getText());
        this.dicaEmEdicao.setIdUsuario(idUsuario);

    }

    private void veririficarCampoDica() {
        if (txtDicaManobra.getText().trim().isEmpty()) {
           String msg = "Infome sua dica para a manobra q acaba de concluir o treino!";
            throw new CampoObrigatorioException(msg);
        }
    }

    public int getVerificaEditarOuSalvar() {
        return verificaEditarOuSalvar;
    }

    public void setVerificaEditarOuSalvar(int verificaEditarOuSalvar) {
        this.verificaEditarOuSalvar = verificaEditarOuSalvar;

    }

    private void atualizarDica() throws ParseException, SQLException {
       recuperarCamposTela();
       this.dicaBO = new DicaBO();
       this.dicaBO.atualizarDica(dicaEmEdicao);
       this.gerenciarDicas.carregarTabelaDeDicas(idUsuario);
       JOptionPane.showMessageDialog(this, "Dica atualizada com sucesso", "Edição de dica", JOptionPane.INFORMATION_MESSAGE);
       this.gerenciarDicas.carregarTabelaDeDicas(idUsuario);
       this.dispose();
       
    }

    
    private void recuperarCamposTela() throws ParseException {
        dicaEmEdicao.setDescricao(txtDicaManobra.getText());        
        dicaEmEdicao.setIdUsuario(idUsuario);
    }
}
