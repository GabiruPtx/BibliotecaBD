package view.Bibliotecário;

import beans.material;
import dao.materialDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaAjuda;
import view.TelaPrincipal;
import view.TelaTipoLogin;

public class TelaPrincipalBibliotecario extends javax.swing.JFrame {

   
    private void preencheTabela() {
    materialDAO materialDAO = new materialDAO();
    List<material> listaMaterial = materialDAO.preencherTabelaMaterial();

    DefaultTableModel tabelaMaterial = (DefaultTableModel) tblMateriais.getModel();
    tabelaMaterial.setNumRows(0);

    for (material m : listaMaterial) {
        Object[] obj = new Object[]{
            m.getTítulo(),
            m.getAutor(),
            m.getAnoPublicacao(),
            m.getEditora(),
            m.getGenero(),
            m.getRevista(),
            m.getVolume(),
            m.getResumo(),
            m.getTipo()
                
        };
        tabelaMaterial.addRow(obj);
    }
}
    private void buscaMaterial(String busca){
        
        materialDAO mDAO = new materialDAO();
        
        List<Integer> ids = mDAO.buscarIdsMateriais(busca);
        List<material> buscaMaterial = mDAO.buscarMaterial(ids);
        
        DefaultTableModel tabelaMaterial = (DefaultTableModel) tblMateriais.getModel();
        tabelaMaterial.setNumRows(0);

        for (material m : buscaMaterial) {
            Object[] obj = new Object[]{
                m.getTítulo(),
                m.getAutor(),
                m.getAnoPublicacao(),
                m.getEditora(),
                m.getGenero(),
                m.getRevista(),
                m.getVolume(),
                m.getResumo(),
                m.getTipo()

            };
            tabelaMaterial.addRow(obj);
        }

    }
       
    public TelaPrincipalBibliotecario() {
        initComponents();
        preencheTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        txtPergamum = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateriais = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnMenu = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnMenuGerenciarAcervo = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnCadastro = new javax.swing.JMenu();
        mnCadastroUExterno = new javax.swing.JMenuItem();
        mnCadastroUInterno = new javax.swing.JMenuItem();
        mnUsuario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnAjuda = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtPergamum.setFont(new java.awt.Font("Meditative", 0, 25)); // NOI18N
        txtPergamum.setText("PERGAMUM");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar", "Item 2", "Item 3", "Item 4" }));

        tblMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Título", "Autor", "Ano de publicação", "Editora", "Gênero", "Revista", "Volume", "Resumo", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMateriais);

        mnMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book.png")); // NOI18N
        mnMenu.setText("Menu");

        jMenuItem5.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_addresses.png")); // NOI18N
        jMenuItem5.setText("Empréstimos");
        mnMenu.add(jMenuItem5);

        mnMenuGerenciarAcervo.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_open.png")); // NOI18N
        mnMenuGerenciarAcervo.setText("Gerenciar Acervo");
        mnMenuGerenciarAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMenuGerenciarAcervoActionPerformed(evt);
            }
        });
        mnMenu.add(mnMenuGerenciarAcervo);

        jMenuItem10.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_go.png")); // NOI18N
        jMenuItem10.setText("Solicitações");
        mnMenu.add(jMenuItem10);

        jMenuBar1.add(mnMenu);

        mnCadastro.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\group.png")); // NOI18N
        mnCadastro.setText("Cadastro");

        mnCadastroUExterno.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\user_orange.png")); // NOI18N
        mnCadastroUExterno.setText("Cadastro de Usuário Externo");
        mnCadastroUExterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastroUExternoActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadastroUExterno);

        mnCadastroUInterno.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\user_gray.png")); // NOI18N
        mnCadastroUInterno.setText("Cadastro de Usuário Interno");
        mnCadastroUInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastroUInternoActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadastroUInterno);

        jMenuBar1.add(mnCadastro);

        mnUsuario.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\user.png")); // NOI18N
        mnUsuario.setText("Usuário");

        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\pencil.png")); // NOI18N
        jMenuItem3.setText("Perfil");
        mnUsuario.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\bell.png")); // NOI18N
        jMenuItem4.setText("Notificação");
        mnUsuario.add(jMenuItem4);

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
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPergamum)
                .addGap(475, 475, 475))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBusca)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtPergamum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBusca))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAjudaMouseClicked
        
        dispose();
        TelaAjuda novaTela = new TelaAjuda();
        novaTela.setVisible(true);
        
    }//GEN-LAST:event_mnAjudaMouseClicked

    private void mnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSairMouseClicked
      
        int response = JOptionPane.showConfirmDialog(
                        TelaPrincipalBibliotecario.this,
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

    private void mnCadastroUExternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastroUExternoActionPerformed
        
        TelaCadastroUsuarioExterno tela = new TelaCadastroUsuarioExterno();
        tela.setVisible(true);
        
    }//GEN-LAST:event_mnCadastroUExternoActionPerformed

    private void mnMenuGerenciarAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMenuGerenciarAcervoActionPerformed
        
        dispose();
        TelaGerenciaAcervo tela = new TelaGerenciaAcervo();
        tela.setVisible(true);
        
    }//GEN-LAST:event_mnMenuGerenciarAcervoActionPerformed

    private void mnCadastroUInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastroUInternoActionPerformed
        
        TelaCadastroBibliotecario frame = new TelaCadastroBibliotecario();
        frame.setVisible(true);
        
    }//GEN-LAST:event_mnCadastroUInternoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
        String busca = txtBusca.getText();
        buscaMaterial(busca);
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalBibliotecario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenu mnCadastro;
    private javax.swing.JMenuItem mnCadastroUExterno;
    private javax.swing.JMenuItem mnCadastroUInterno;
    private javax.swing.JMenu mnMenu;
    private javax.swing.JMenuItem mnMenuGerenciarAcervo;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenu mnUsuario;
    private javax.swing.JTable tblMateriais;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JLabel txtPergamum;
    // End of variables declaration//GEN-END:variables
}
