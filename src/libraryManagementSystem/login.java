/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryManagementSystem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import CONFIG.DBCONNECTOR;
import CONFIG.Session;
import CONFIG.passwordHash;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.DriverManager;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class login extends javax.swing.JFrame {

private Connection con;
    /**
     * Creates new form login
     */
  static String status; 
    public login() {
        initComponents();
        login.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"login" );
        login.getActionMap().put("login", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            loginActionPerformed(e);
        }
    });
    }
     public boolean validatelogin(){
    String name = UN.getText();
    String pwd = PD.getText();
    
    if (name.equals("")){
    JOptionPane.showMessageDialog(this, "PLEASE ENTER USERNAME");
   return false;
    }
    if (pwd.equals("")){
    JOptionPane.showMessageDialog(this, "PLEASE ENTER USERNAME");
   return false;
    }
    return true;
    }
   
     
      public static boolean loginAcc(String username, String password){
        DBCONNECTOR connector = new DBCONNECTOR();
        try{
            String query = "SELECT * FROM user  WHERE username = '" + username + "'";
            ResultSet resultSet = connector.getData(query);

                if(resultSet.next()){ 
                    String hashedPass = resultSet.getString("password");
                    String rehashedPass = passwordHash.hashPassword(password);
                    
                   
                    if(hashedPass.equals(rehashedPass)){
                status= resultSet.getString("status");            
                Session sess = Session.getInstance();
                sess.setUid(resultSet.getInt("user_id"));
                sess.setUN(resultSet.getString("username"));
                sess.setEMAIL(resultSet.getString("email"));
                sess.setCONTACT(resultSet.getString("contact"));
                sess.setStatus(resultSet.getString("status"));
                        System.out.println(""+sess.getUid());
                return true;
            }else{
                return false;
            }
                   }else{
                return false;
            }
        }catch (SQLException | NoSuchAlgorithmException ex) {
            System.out.println(""+ex);
            return false;
        }

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        UN = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        login = new necesario.RSMaterialButtonCircle();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        PD = new rojerusan.RSPasswordTextPlaceHolder();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cb = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 58, 140));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 495));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/signup-library-icon.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, -10, 630, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 225));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("x");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, 20));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WELCOME");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 240, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Please login to you account");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        UN.setBackground(new java.awt.Color(102, 102, 225));
        UN.setBorder(null);
        UN.setForeground(new java.awt.Color(255, 255, 255));
        UN.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        UN.setOpaque(false);
        UN.setPlaceholder("ENTER USERNAME");
        UN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UNMouseEntered(evt);
            }
        });
        UN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNActionPerformed(evt);
            }
        });
        jPanel2.add(UN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("USERNAME:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PASSWORD:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 90, 30));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setForeground(new java.awt.Color(0, 0, 0));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel2.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, 40));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("_______________________________");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 220, 30));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("_______________________________");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 220, 30));

        PD.setBackground(new java.awt.Color(102, 102, 225));
        PD.setBorder(null);
        PD.setForeground(new java.awt.Color(255, 255, 255));
        PD.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        PD.setOpaque(false);
        PD.setPhColor(new java.awt.Color(0, 0, 0));
        PD.setPlaceholder("ENTER PASSWORD");
        jPanel2.add(PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Please click here to register");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 180, 2));

        cb.setForeground(new java.awt.Color(255, 255, 255));
        cb.setText("Show Password");
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        jPanel2.add(cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 120, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 375, 495));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void PDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PDActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
              if(loginAcc(UN.getText(),PD.getText())){
                  if(!status.equals("Active")){
                      JOptionPane.showMessageDialog(null, "In-active account");
                  }else{
                      JOptionPane.showMessageDialog(null, "Login Success");
                      DASHBOARD ds = new DASHBOARD();
                      ds.setVisible(true);
                      this.dispose();
                  }
                  }else{
                         JOptionPane.showMessageDialog(null, "invalid username or password ");
                          
        }
    }//GEN-LAST:event_loginActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
            signup UP= new signup();
                   UP.setVisible(true);
                   this. dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
        if(cb.isSelected()){
            PD.setEchoChar((char)0);
            
        }else{
            PD.setEchoChar('*');
        }
    }//GEN-LAST:event_cbActionPerformed

    private void UNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UNMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void UNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UNActionPerformed

    private void UNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UNMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_UNMouseEntered

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSPasswordTextPlaceHolder PD;
    private app.bolivia.swing.JCTextField UN;
    private javax.swing.JCheckBox cb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private necesario.RSMaterialButtonCircle login;
    // End of variables declaration//GEN-END:variables
}
