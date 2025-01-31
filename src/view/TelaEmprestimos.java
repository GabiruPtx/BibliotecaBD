package view;

import beans.emprestimo;
import beans.pedido;
import dao.emprestimoDAO;
import dao.pedidoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaAjuda;
import view.TelaPerfil;
import view.TelaPrincipal;
import view.TelaTipoLogin;

public class TelaEmprestimos extends javax.swing.JFrame {
    
    String usuario = System.getProperty("nomeCompleto");
    
    private void preencheSolicitacaoUsuario(String usuario) {
    pedidoDAO pDAO = new pedidoDAO();
    List<pedido> listaPedido = pDAO.preencherTabelaPedidoUsuario(usuario);

    DefaultTableModel tabelaPedido = (DefaultTableModel) tblSolicitacoes.getModel();
    tabelaPedido.setNumRows(0);

    for (pedido p : listaPedido) {
        Object[] obj = new Object[]{
            p.getId(),
            p.getTitulo(),
            p.getTipoPedido(),
            p.getStatus()
                
        };
        tabelaPedido.addRow(obj);
    }
}
    
    private void preencheEmprestimoUsuario(String usuario) {
        
    emprestimoDAO eDAO = new emprestimoDAO();
    List<emprestimo> listaEmprestimo = eDAO.preencherTabelaEmprestimoUsuario(usuario);

    DefaultTableModel tabelaEmprestimo = (DefaultTableModel) tblEmprestimos.getModel();
    tabelaEmprestimo.setNumRows(0);

    for (emprestimo e : listaEmprestimo) {
        Object[] obj = new Object[]{
            e.getId(),
            e.getTitulo(),
            e.getDataEmprestimo(),
            e.getDataDevolucao(),
            e.getStatus(),
            e.getChancesDePrazo()  
                
        };
        tabelaEmprestimo.addRow(obj);
    }
}
    
    
    public TelaEmprestimos() {
        
        initComponents();
        preencheSolicitacaoUsuario(usuario);
        preencheEmprestimoUsuario(usuario);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmprestimos = new javax.swing.JTable();
        bntSolicitarEmprestimos = new javax.swing.JButton();
        btnEstenderPrazo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSolicitacoes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnMenu = new javax.swing.JMenu();
        mnUsuario = new javax.swing.JMenu();
        mnUsuarioPerfil = new javax.swing.JMenuItem();
        mnAjuda = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pergamum");
        setMinimumSize(new java.awt.Dimension(770, 503));
        setResizable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Empréstimos");

        tblEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Data de Empréstimo", "Data de Devolução", "Status", "Renovar Prazo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmprestimos);

        bntSolicitarEmprestimos.setText("Solicitar Empréstimos");
        bntSolicitarEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSolicitarEmprestimosActionPerformed(evt);
            }
        });

        btnEstenderPrazo.setText("Estender prazo");
        btnEstenderPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstenderPrazoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Meditative", 0, 24)); // NOI18N
        jLabel1.setText("PERGAMUM");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\coruja.png")); // NOI18N

        tblSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Tipo do pedido", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSolicitacoes);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Empréstimos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Solicitações");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(bntSolicitarEmprestimos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEstenderPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7))
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEstenderPrazo)
                    .addComponent(bntSolicitarEmprestimos))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        mnMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book.png")); // NOI18N
        mnMenu.setText("Menu Principal");
        mnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnMenu);

        mnUsuario.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\status_online.png")); // NOI18N
        mnUsuario.setText("Usuário");

        mnUsuarioPerfil.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\pencil.png")); // NOI18N
        mnUsuarioPerfil.setText("Perfil");
        mnUsuarioPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsuarioPerfilActionPerformed(evt);
            }
        });
        mnUsuario.add(mnUsuarioPerfil);

        jMenuBar1.add(mnUsuario);

        mnAjuda.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\help.png")); // NOI18N
        mnAjuda.setText("Ajuda");
        mnAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnAjudaMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnAjuda);

        mnSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\stop.png")); // NOI18N
        mnSair.setText("Sair");
        mnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnUsuarioPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUsuarioPerfilActionPerformed

        dispose();
        TelaPerfil novaTela = new TelaPerfil();
        novaTela.setVisible(true);

    }//GEN-LAST:event_mnUsuarioPerfilActionPerformed

    private void mnAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAjudaMouseClicked

        dispose();
        TelaAjuda novaTela = new TelaAjuda();
        novaTela.setVisible(true);

    }//GEN-LAST:event_mnAjudaMouseClicked

    private void mnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSairMouseClicked

        int response = JOptionPane.showConfirmDialog(
            TelaEmprestimos.this,
            "Tem certeza que quer sair?",
            "Confirmação de Saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION) {

            System.clearProperty("nomeCompleto");
            System.clearProperty("matricula");
            System.clearProperty("email");
            System.clearProperty("cpf");
            System.clearProperty("celular");
            System.clearProperty("celularreserva");
            System.clearProperty("endereco");
            System.clearProperty("complemento");
            System.clearProperty("cep");
            System.clearProperty("senha");
            System.clearProperty("tipo");

            System.out.println("Logout realizado com sucesso!");

            dispose();
            TelaTipoLogin novaTela = new TelaTipoLogin();
            novaTela.setVisible(true);

        }

    }//GEN-LAST:event_mnSairMouseClicked

    private void bntSolicitarEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSolicitarEmprestimosActionPerformed
       
    TelaSolicitacaoEmprestimo tela = new TelaSolicitacaoEmprestimo();
    tela.addWindowListener(new java.awt.event.WindowAdapter() {
            
        @Override
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                
            preencheSolicitacaoUsuario(usuario);
                
        }
    });
    tela.setVisible(true);
        
    }//GEN-LAST:event_bntSolicitarEmprestimosActionPerformed

    private void btnEstenderPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstenderPrazoActionPerformed

    
    TelaEstenderPrazo tela = new TelaEstenderPrazo();
    tela.addWindowListener(new java.awt.event.WindowAdapter() {
        
        @Override
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            
            preencheSolicitacaoUsuario(usuario);
            
        }
    });
    tela.setVisible(true);
        
    }//GEN-LAST:event_btnEstenderPrazoActionPerformed

    private void mnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnMenuMouseClicked
        
        dispose();
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        
    }//GEN-LAST:event_mnMenuMouseClicked

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
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSolicitarEmprestimos;
    private javax.swing.JButton btnEstenderPrazo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenu mnMenu;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenu mnUsuario;
    private javax.swing.JMenuItem mnUsuarioPerfil;
    private javax.swing.JTable tblEmprestimos;
    private javax.swing.JTable tblSolicitacoes;
    // End of variables declaration//GEN-END:variables
}
