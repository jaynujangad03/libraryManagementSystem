/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;
import CONFIG.DBCONNECTOR;
import com.sun.javafx.collections.IntegerArraySyncer;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;
public class returnbook extends javax.swing.JInternalFrame {
private Connection connection;
    /**
     * Creates new form dashabord
     */
    public returnbook() {
        initComponents();
        

          this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
    }
 public void issuedbookdetails(){
  
 int bookid = Integer.parseInt(ISBN.getText());
 int sid= Integer.parseInt(STUDid.getText());
 
    try {
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ba", "root", "");
         String sql = "SELECT * FROM issued_bookdet where ISBN = ? and ID = ? and STATUS =?";
        PreparedStatement pst = connection.prepareStatement(sql);
        
        pst.setInt(1, bookid);
        pst.setInt(2, sid);
        pst.setString(3, "PENDING");
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            
        ISSUEDID.setText(rs.getString("ISSUED_ID"));
        TITLE.setText(rs.getString("ISBN"));
        STUDNAME.setText(rs.getString("ID"));
        ISSUEDDATE.setText(rs.getString("ISSUED"));
        DUEDATE.setText(rs.getString("DUE"));
        ERROR.setText("");
        }else{   
        ERROR.setText("NO RECORD FOUND");
          ISSUEDID.setText(" ");
        TITLE.setText(" ");
        STUDNAME.setText(" ");
        ISSUEDDATE.setText(" ");
        DUEDATE.setText("  ");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public boolean returnbook(){
boolean isreturnbook = false;
 int bookid = Integer.parseInt(ISBN.getText());
 int sid= Integer.parseInt(STUDid.getText());
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ba", "root", "");
         String sql = "update issued_bookdet set STATUS = ? where ID = ? and ISBN = ? and STATUS = ?";
         PreparedStatement pst = connection.prepareStatement(sql);
         pst.setString(1, "RETURNED");
        pst.setInt(2, sid);
        pst.setInt(3, bookid);
        pst.setString(4, "PENDING");
        
        int rowcount = pst.executeUpdate();
        if(rowcount>0){
            isreturnbook = true;
        }else{
            isreturnbook = false;
        
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isreturnbook;
}
public void updatebookquant(){
 int bookid= Integer.parseInt(ISBN.getText());
     try {
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ba", "root", "");
          String sql = "update book_details set QUANTITY = QUANTITY + 1 where ISBN =?";
          PreparedStatement pst = connection.prepareStatement(sql);
          pst.setInt(1, bookid);
          
        int rowcount = pst.executeUpdate();
          
          if(rowcount>0){
          JOptionPane.showMessageDialog(this, "BOOK QUANTITY UPDATED");
        
          }else{
          JOptionPane.showMessageDialog(this, "BOOK QUANTITY FAILED TO UPDATED");
          }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
  public boolean validation(){
String isb = ISBN.getText();
String studenti = STUDid.getText();
 if (isb.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER ISBN");
 return false;
 }
 if(studenti.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER STUDENT ID");
 return false;
 }     
   return true;  
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
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ISSUEDID = new javax.swing.JLabel();
        TITLE = new javax.swing.JLabel();
        STUDNAME = new javax.swing.JLabel();
        ISSUEDDATE = new javax.swing.JLabel();
        DUEDATE = new javax.swing.JLabel();
        ERROR = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ISBN = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        STUDid = new app.bolivia.swing.JCTextField();
        FINDET = new necesario.RSMaterialButtonCircle();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        RETURNBOOK = new necesario.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(158, 165, 241));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ISSUED ID:");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 90, 32));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TITTLE:");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 32));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("NAME:");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 32));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ISSUED DATE:");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, 32));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DUE DATE:");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 100, 32));

        ISSUEDID.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        ISSUEDID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(ISSUEDID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, 30));

        TITLE.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        TITLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(TITLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 150, 30));

        STUDNAME.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        STUDNAME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(STUDNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 160, 30));

        ISSUEDDATE.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        ISSUEDDATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(ISSUEDDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 160, 30));

        DUEDATE.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        DUEDATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(DUEDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 150, 30));

        ERROR.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        ERROR.setForeground(new java.awt.Color(51, 255, 204));
        ERROR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(ERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 330, 30));

        jLabel13.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book (8).png"))); // NOI18N
        jLabel13.setText("ISSUE BOOK DETAILS");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 300, 80));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 540));

        ISBN.setBorder(null);
        ISBN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ISBN.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        ISBN.setOpaque(false);
        ISBN.setPlaceholder("ENTER ISBN");
        ISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ISBNKeyPressed(evt);
            }
        });
        jPanel1.add(ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, -1));

        jLabel14.setBackground(new java.awt.Color(0, 190, 82));
        jLabel14.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 225));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ISBN:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 90, 30));

        jLabel15.setBackground(new java.awt.Color(0, 190, 82));
        jLabel15.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 225));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("STUDENT ID:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 110, 40));

        STUDid.setBorder(null);
        STUDid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        STUDid.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        STUDid.setOpaque(false);
        STUDid.setPlaceholder("ENTER STUDENT ID");
        STUDid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STUDidActionPerformed(evt);
            }
        });
        STUDid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                STUDidKeyPressed(evt);
            }
        });
        jPanel1.add(STUDid, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        FINDET.setBackground(new java.awt.Color(158, 165, 241));
        FINDET.setText("FIND DETAILS");
        FINDET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINDETActionPerformed(evt);
            }
        });
        jPanel1.add(FINDET, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 270, 60));

        jLabel19.setForeground(new java.awt.Color(25, 20, 20));
        jLabel19.setText("_______________________________");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 210, 40));

        jLabel20.setForeground(new java.awt.Color(25, 20, 20));
        jLabel20.setText("_______________________________");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 210, 40));

        RETURNBOOK.setBackground(new java.awt.Color(158, 165, 241));
        RETURNBOOK.setText("RETURN BOOK");
        RETURNBOOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RETURNBOOKActionPerformed(evt);
            }
        });
        jPanel1.add(RETURNBOOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 270, 60));

        jLabel16.setBackground(new java.awt.Color(0, 190, 82));
        jLabel16.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 225));
        jLabel16.setText("RETURN BOOK");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 190, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FINDETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINDETActionPerformed
    
        if(validation()== true){ 
            issuedbookdetails();
        }     
    }//GEN-LAST:event_FINDETActionPerformed

    private void RETURNBOOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RETURNBOOKActionPerformed
      if(validation()== true){
        if(returnbook()== true){
       JOptionPane.showMessageDialog(this, "BOOK RETURNED SUCCESSFULLY");
       updatebookquant();   
       }else{
       JOptionPane.showMessageDialog(this, "BOOK RETURNED FAILED ");
       }
      }
    }//GEN-LAST:event_RETURNBOOKActionPerformed

    private void STUDidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STUDidActionPerformed

    private void ISBNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ISBNKeyPressed
           char c =evt.getKeyChar();
        if(Character.isLetter(c)){
        ISBN.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        ISBN.setEditable(true);
        }
    }//GEN-LAST:event_ISBNKeyPressed

    private void STUDidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_STUDidKeyPressed
               char c =evt.getKeyChar();
        if(Character.isLetter(c)){
        STUDid.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        STUDid.setEditable(true);
        }
    }//GEN-LAST:event_STUDidKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DUEDATE;
    private javax.swing.JLabel ERROR;
    private necesario.RSMaterialButtonCircle FINDET;
    private app.bolivia.swing.JCTextField ISBN;
    private javax.swing.JLabel ISSUEDDATE;
    private javax.swing.JLabel ISSUEDID;
    private necesario.RSMaterialButtonCircle RETURNBOOK;
    private javax.swing.JLabel STUDNAME;
    private app.bolivia.swing.JCTextField STUDid;
    private javax.swing.JLabel TITLE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    // End of variables declaration//GEN-END:variables
}
