package view;

import view.Bibliotecário.TelaLoginBibliotecario;
import javax.swing.JOptionPane;

//Tela para seleção do tipo de login: Aluno/Professor ou Bibliotecário.

public class TelaTipoLogin extends javax.swing.JFrame {

    
    public TelaTipoLogin() {
        initComponents();
    }

    /**
     * Método chamado no construtor para inicializar os componentes da tela.
     * WARNING: Não modifique este código. O conteúdo deste método é sempre
     * gerado pelo Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Título = new javax.swing.JLabel();
        Faixa = new javax.swing.JSeparator();
        BotãoAlunoProfessor = new javax.swing.JButton();
        BotãoBibliotecário = new javax.swing.JButton();
        icoCoruja = new javax.swing.JLabel();
        txtPergamum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pergamum");
        setIconImages(null);
        setResizable(false);

        Título.setText("Acessar como:");

        Faixa.setForeground(new java.awt.Color(153, 153, 153));

        BotãoAlunoProfessor.setText("Aluno/Professor");
        BotãoAlunoProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotãoAlunoProfessorActionPerformed(evt);
            }
        });

        BotãoBibliotecário.setText("Bibliotecário");
        BotãoBibliotecário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotãoBibliotecárioActionPerformed(evt);
            }
        });

        icoCoruja.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\NetBeansProjects\\InterfaceJava\\src\\images\\coruja.png")); // NOI18N

        txtPergamum.setFont(new java.awt.Font("Meditative", 0, 24)); // NOI18N
        txtPergamum.setText("PERGAMUM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(BotãoAlunoProfessor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(BotãoBibliotecário)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Faixa)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Título)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(icoCoruja))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(txtPergamum)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(icoCoruja, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPergamum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Título)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Faixa, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotãoAlunoProfessor)
                    .addComponent(BotãoBibliotecário))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   //Método chamado quando o botão "Aluno/Professor" é clicado.
    
    private void BotãoAlunoProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotãoAlunoProfessorActionPerformed
        dispose();
        try {
            
            TelaLogin novoFrame = new TelaLogin();
            novoFrame.setVisible(true);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, "Erro ao abrir a tela de login de Aluno/Professor", "Erro", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_BotãoAlunoProfessorActionPerformed

    //Método chamado quando o botão "Bibliotecário" é clicado.
    
    private void BotãoBibliotecárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotãoBibliotecárioActionPerformed
        dispose();
        try {
            
            TelaLoginBibliotecario novoFrame = new TelaLoginBibliotecario();
            novoFrame.setVisible(true);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, "Erro ao abrir a tela de login de Bibliotecário", "Erro", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_BotãoBibliotecárioActionPerformed

    
    //Método principal para executar a aplicação.
    
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
            java.util.logging.Logger.getLogger(TelaTipoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTipoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTipoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTipoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         /* Cria e exibe a tela */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaTipoLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotãoAlunoProfessor;
    private javax.swing.JButton BotãoBibliotecário;
    private javax.swing.JSeparator Faixa;
    private javax.swing.JLabel Título;
    private javax.swing.JLabel icoCoruja;
    private javax.swing.JLabel txtPergamum;
    // End of variables declaration//GEN-END:variables

}
