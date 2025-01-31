package view.Bibliotecário;

import beans.material;
import dao.materialDAO;
import dao.pedidoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TelaAjuda;
import view.TelaPerfil;
import view.TelaPrincipal;
import view.TelaTipoLogin;

public class TelaPrincipalBibliotecario extends javax.swing.JFrame {

    public enum Criterio {
    ID, TITULO, AUTOR, ANO_PUBLICACAO, EDITORA, GENERO, REVISTA, VOLUME, RESUMO, TIPO
}
   
    private void OrdenarTabela(Criterio criteria) {
    materialDAO materialDAO = new materialDAO();
    List<material> listaMaterial = materialDAO.preencherTabelaMaterial();

    if (listaMaterial != null) {
        listaMaterial.sort((m1, m2) -> {
            switch (criteria) {
                case ID:
                    return Integer.compare(m1.getId(), m2.getId());
                case TITULO:
                    return m1.getTítulo().compareToIgnoreCase(m2.getTítulo());
                case AUTOR:
                    return m1.getAutor().compareToIgnoreCase(m2.getAutor());
                case ANO_PUBLICACAO:
                    return m1.getAnoPublicacao().compareToIgnoreCase(m2.getAnoPublicacao());
                case EDITORA:
                    return m1.getEditora().compareToIgnoreCase(m2.getEditora());
                case GENERO:
                    return m1.getGenero().compareToIgnoreCase(m2.getGenero());
                case REVISTA:
                    return m1.getRevista().compareToIgnoreCase(m2.getRevista());
                case VOLUME:
                    return m1.getVolume().compareToIgnoreCase(m2.getVolume());
                case RESUMO:
                    return m1.getResumo().compareToIgnoreCase(m2.getResumo());
                case TIPO:
                    return m1.getTipo().compareToIgnoreCase(m2.getTipo());
                default:
                    return 0;
            }
        });

        DefaultTableModel tabelaMaterial = (DefaultTableModel) tblMateriais.getModel();
        tabelaMaterial.setNumRows(0);

        try {
            for (material m : listaMaterial) {
                Object[] obj = new Object[]{
                    m.getId(),
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
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Nenhum material encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    private void preencheTabela() {
    materialDAO materialDAO = new materialDAO();
    List<material> listaMaterial = materialDAO.preencherTabelaMaterial();

    DefaultTableModel tabelaMaterial = (DefaultTableModel) tblMateriais.getModel();
    tabelaMaterial.setNumRows(0);

    for (material m : listaMaterial) {
        Object[] obj = new Object[]{
            
            m.getId(),
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
                
                m.getId(),
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

        txtPergamum = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBusca = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateriais = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnMenu = new javax.swing.JMenu();
        mnMenuEmpréstimos = new javax.swing.JMenuItem();
        mnMenuGerenciarAcervo = new javax.swing.JMenuItem();
        mnMenuSolicitacoes = new javax.swing.JMenuItem();
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

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar", "ID do material", "Título", "Autor", "Ano de publicação", "Editora", "Gênero", "Revista", "Volume", "Resumo", "Tipo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        tblMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID do material", "Título", "Autor", "Ano de publicação", "Editora", "Gênero", "Revista", "Volume", "Resumo", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMateriais);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\coruja.png")); // NOI18N

        mnMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book.png")); // NOI18N
        mnMenu.setText("Menu");

        mnMenuEmpréstimos.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_addresses.png")); // NOI18N
        mnMenuEmpréstimos.setText("Empréstimos");
        mnMenuEmpréstimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMenuEmpréstimosActionPerformed(evt);
            }
        });
        mnMenu.add(mnMenuEmpréstimos);

        mnMenuGerenciarAcervo.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_open.png")); // NOI18N
        mnMenuGerenciarAcervo.setText("Gerenciar Acervo");
        mnMenuGerenciarAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMenuGerenciarAcervoActionPerformed(evt);
            }
        });
        mnMenu.add(mnMenuGerenciarAcervo);

        mnMenuSolicitacoes.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\book_go.png")); // NOI18N
        mnMenuSolicitacoes.setText("Solicitações");
        mnMenuSolicitacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMenuSolicitacoesActionPerformed(evt);
            }
        });
        mnMenu.add(mnMenuSolicitacoes);

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
                .addGap(400, 400, 400)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtPergamum))
                    .addComponent(jLabel1)))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtPergamum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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

    private void mnMenuSolicitacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMenuSolicitacoesActionPerformed
        
        pedidoDAO pDAO = new pedidoDAO();
        boolean pedido = pDAO.checarPedidosPendentes();
        
        if(pedido == true){
            
            TelaSolicitacao tela = new TelaSolicitacao();
            tela.setVisible(true);
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Não há nenhuma solicitação pendente no momento!");
            
        }
        
    }//GEN-LAST:event_mnMenuSolicitacoesActionPerformed

    private void mnMenuEmpréstimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMenuEmpréstimosActionPerformed
         
        dispose();
        TelaEmprestimoBibliotecario tela = new TelaEmprestimoBibliotecario();
        tela.setVisible(true);
        
    }//GEN-LAST:event_mnMenuEmpréstimosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       
        TelaPerfil perfil = new TelaPerfil();
        perfil.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        int selectedIndex = jComboBox1.getSelectedIndex();
    Criterio criterio = null;
    switch (selectedIndex) {
        case 1:
            criterio = Criterio.ID;
            break;
        case 2:
            criterio = Criterio.TITULO;
            break;
        case 3:
            criterio = Criterio.AUTOR;
            break;
        case 4:
            criterio = Criterio.ANO_PUBLICACAO;
            break;
        case 5:
            criterio = Criterio.EDITORA;
            break;
        case 6:
            criterio = Criterio.GENERO;
            break;
        case 7:
            criterio = Criterio.REVISTA;
            break;
        case 8:
            criterio = Criterio.VOLUME;
            break;
        case 9:
            criterio = Criterio.RESUMO;
            break;
        case 10:
            criterio = Criterio.TIPO;
            break;
        default:
            break;
    }

    if (criterio != null) {
        OrdenarTabela(criterio);
    }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenu mnCadastro;
    private javax.swing.JMenuItem mnCadastroUExterno;
    private javax.swing.JMenuItem mnCadastroUInterno;
    private javax.swing.JMenu mnMenu;
    private javax.swing.JMenuItem mnMenuEmpréstimos;
    private javax.swing.JMenuItem mnMenuGerenciarAcervo;
    private javax.swing.JMenuItem mnMenuSolicitacoes;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenu mnUsuario;
    private javax.swing.JTable tblMateriais;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JLabel txtPergamum;
    // End of variables declaration//GEN-END:variables
}
