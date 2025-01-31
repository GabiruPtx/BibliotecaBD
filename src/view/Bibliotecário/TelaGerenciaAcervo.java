package view.Bibliotecário;

import beans.exemplar;
import dao.exemplarDAO;
import dao.pedidoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaAjuda;
import view.TelaPerfil;
import view.Bibliotecário.TelaEmprestimoBibliotecario;
import view.TelaTipoLogin;

public class TelaGerenciaAcervo extends javax.swing.JFrame {

    private void preencheTabela() {
    exemplarDAO exemplarDAO = new exemplarDAO();
    List<exemplar> listaExemplar = exemplarDAO.preencherTabelaExemplar();

    DefaultTableModel tabelaExemplar = (DefaultTableModel) tblExemplares.getModel();
    tabelaExemplar.setNumRows(0);

    for (exemplar e : listaExemplar) {
        Object[] obj = new Object[]{
            e.getId(),
            e.getTitulo(),
            e.getStatus(),
            e.getAndar(),
            e.getCorredor(),
            e.getEstante(),
            e.getPrateleira()
                
        };
        tabelaExemplar.addRow(obj);
    }
}
    
    public TelaGerenciaAcervo() {
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

        txtPergamum = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarMaterial = new javax.swing.JButton();
        btnRemoverMaterial = new javax.swing.JButton();
        btnAdicionarExemplares = new javax.swing.JButton();
        btnRemoverExemplares = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblExemplares = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnMenu = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnMenuSolicitações = new javax.swing.JMenuItem();
        mnCadastro = new javax.swing.JMenu();
        mnCadastroUExterno = new javax.swing.JMenuItem();
        mnCadastroUInterno = new javax.swing.JMenuItem();
        mnUsuario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnAjuda = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtPergamum.setFont(new java.awt.Font("Meditative", 0, 25)); // NOI18N
        txtPergamum.setText("PERGAMUM");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("ACERVO");

        btnAdicionarMaterial.setText("Adicionar material ao acervo");
        btnAdicionarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarMaterialActionPerformed(evt);
            }
        });

        btnRemoverMaterial.setText("Remover material do acervo");
        btnRemoverMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverMaterialActionPerformed(evt);
            }
        });

        btnAdicionarExemplares.setText("Adicionar exemplares");
        btnAdicionarExemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarExemplaresActionPerformed(evt);
            }
        });

        btnRemoverExemplares.setText("Remover exemplares");
        btnRemoverExemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverExemplaresActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        tblExemplares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Exemplar", "Título", "Status", "Andar", "Corredor", "Estante", "Prateleira"
            }
        ));
        jScrollPane2.setViewportView(tblExemplares);

        mnMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book.png")); // NOI18N
        mnMenu.setText("Menu");

        jMenuItem5.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_addresses.png")); // NOI18N
        jMenuItem5.setText("Empréstimos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnMenu.add(jMenuItem5);

        mnMenuSolicitações.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_go.png")); // NOI18N
        mnMenuSolicitações.setText("Solicitações");
        mnMenuSolicitações.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMenuSolicitaçõesActionPerformed(evt);
            }
        });
        mnMenu.add(mnMenuSolicitações);

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
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnUsuario.add(jMenuItem3);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnAdicionarMaterial)
                .addGap(67, 67, 67)
                .addComponent(btnRemoverMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(btnAdicionarExemplares)
                .addGap(96, 96, 96)
                .addComponent(btnRemoverExemplares)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(531, 531, 531)
                        .addComponent(txtPergamum))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(572, 572, 572)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPergamum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarMaterial)
                    .addComponent(btnRemoverMaterial)
                    .addComponent(btnAdicionarExemplares)
                    .addComponent(btnRemoverExemplares))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarMaterialActionPerformed
      
        
        TelaCadastroObra novaTela = new TelaCadastroObra();
        novaTela.addWindowListener(new java.awt.event.WindowAdapter() {
        
        @Override
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            
            preencheTabela();
            
        }
    });
        novaTela.setVisible(true);
        
    }//GEN-LAST:event_btnAdicionarMaterialActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        
        dispose();
        TelaPrincipalBibliotecario novaTela = new TelaPrincipalBibliotecario();
        novaTela.setVisible(true);
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnRemoverMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverMaterialActionPerformed
        
        TelaRemoveObra novaTela = new TelaRemoveObra();
        novaTela.addWindowListener(new java.awt.event.WindowAdapter() {
        
        @Override
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            
            preencheTabela();
            
        }
    });
        novaTela.setVisible(true);
        
    }//GEN-LAST:event_btnRemoverMaterialActionPerformed

    private void mnCadastroUExternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastroUExternoActionPerformed

        TelaCadastroUsuarioExterno tela = new TelaCadastroUsuarioExterno();
        tela.setVisible(true);

    }//GEN-LAST:event_mnCadastroUExternoActionPerformed

    private void mnCadastroUInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastroUInternoActionPerformed

        TelaCadastroBibliotecario frame = new TelaCadastroBibliotecario();
        frame.setVisible(true);

    }//GEN-LAST:event_mnCadastroUInternoActionPerformed

    private void mnAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAjudaMouseClicked

        dispose();
        TelaAjuda novaTela = new TelaAjuda();
        novaTela.setVisible(true);

    }//GEN-LAST:event_mnAjudaMouseClicked

    private void mnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSairMouseClicked

        int response = JOptionPane.showConfirmDialog(
            TelaGerenciaAcervo.this,
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

    private void btnAdicionarExemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarExemplaresActionPerformed
        
        exemplarDAO e = new exemplarDAO();
        exemplar exemplarEncontrado = e.buscarExemplarComCamposDefault();
        System.out.println(exemplarEncontrado);
        
        if (exemplarEncontrado != null){
            
            
            TelaAdicionarExemplar frame = new TelaAdicionarExemplar();
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
        
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            
            preencheTabela();
            
        }
    });
            frame.setVisible(true);
            
            
        }else {
            
            TelaAdicionarExemplarV2 frame = new TelaAdicionarExemplarV2();
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
        
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            
            preencheTabela();
            
        }
    });
            frame.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btnAdicionarExemplaresActionPerformed

    private void btnRemoverExemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverExemplaresActionPerformed
       
        TelaRemoverExemplar tela = new TelaRemoverExemplar();
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
        
        @Override
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            
            preencheTabela();
            
        }
    });
        tela.setVisible(true);
        
    }//GEN-LAST:event_btnRemoverExemplaresActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        TelaPerfil perfil = new TelaPerfil();
        perfil.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        TelaEmprestimoBibliotecario tela = new TelaEmprestimoBibliotecario();
        tela.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void mnMenuSolicitaçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMenuSolicitaçõesActionPerformed
         
        pedidoDAO pDAO = new pedidoDAO();
        boolean pedido = pDAO.checarPedidosPendentes();
        
        if(pedido == true){
            
            TelaSolicitacao tela = new TelaSolicitacao();
            tela.setVisible(true);
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Não há nenhuma solicitação pendente no momento!");
            
        }
        
    }//GEN-LAST:event_mnMenuSolicitaçõesActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerenciaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciaAcervo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarExemplares;
    private javax.swing.JButton btnAdicionarMaterial;
    private javax.swing.JButton btnRemoverExemplares;
    private javax.swing.JButton btnRemoverMaterial;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenu mnCadastro;
    private javax.swing.JMenuItem mnCadastroUExterno;
    private javax.swing.JMenuItem mnCadastroUInterno;
    private javax.swing.JMenu mnMenu;
    private javax.swing.JMenuItem mnMenuSolicitações;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenu mnUsuario;
    private javax.swing.JTable tblExemplares;
    private javax.swing.JLabel txtPergamum;
    // End of variables declaration//GEN-END:variables
}
