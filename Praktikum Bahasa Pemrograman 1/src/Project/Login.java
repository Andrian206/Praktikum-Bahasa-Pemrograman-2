/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Suci Indah Lestari
 */
public class Login extends javax.swing.JFrame {
    
    Statement st;
    ResultSet rs;
    Koneksi Koneksi;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        Koneksi = new Koneksi();
    }
    
    private void LoginUser() {
        String User = jTextField1.getText();
        String Pass = jTextField2.getText();
        boolean userExists = false;
        boolean loginSuccess = false;

         try {
             st = Koneksi.con.createStatement();
             rs = st.executeQuery("SELECT username, password FROM user");

             while (rs.next()) {
                 String Username = rs.getString("Username");
                 String Password = rs.getString("Password");
                 
                 if (User.equals(Username)) {
                    userExists = true; // Username ditemukan
                    if (Pass.equals(Password)) {   
                        loginSuccess = true; // Username dan password cocok
                    }
                    break;
                 }
             }
         }catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }

        // Validasi 
        if (User.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (loginSuccess) {
            JOptionPane.showMessageDialog(null, "Login Sukses Sebagai " + User, "Login", JOptionPane.INFORMATION_MESSAGE);
            new NavigasiUser().setVisible(true);
            this.dispose();
        } else if (userExists) {
            JOptionPane.showMessageDialog(null, "Password salah", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Username tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void LoginAdmin() {
        String User = jTextField1.getText();
        String Pass = jTextField2.getText();
        boolean userExists = false;
        boolean loginSuccess = false;

        try {
            st = 
                    
                    Koneksi.con.createStatement();
            rs = st.executeQuery("SELECT username, password FROM admin");

            while (rs.next()) {
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");

                if (User.equals(Username)) {
                    userExists = true; // Username ditemukan
                    if (Pass.equals(Password)) {
                        loginSuccess = true; // Username dan password cocok
                    }
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        // Validasi 
        if (User.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (loginSuccess) {
            JOptionPane.showMessageDialog(null, "Login Sukses Sebagai " + User, "Login", JOptionPane.INFORMATION_MESSAGE);
            new NavigasiAdmin().setVisible(true);
            this.dispose();
        } else if (userExists) {
            JOptionPane.showMessageDialog(null, "Password salah", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Username tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
 private void Registrasi() {
    try {
        st = Koneksi.con.createStatement();

        // Validasi input
        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi ComboBox
        String level = (String) jComboBox1.getSelectedItem();
        String sql = "";

        if (level.equals("User")) {
            sql = "INSERT INTO user (Username, Password) VALUES ('" 
                + jTextField1.getText() + "', '" + jTextField2.getText() + "')";
        } else if (level.equals("Admin")) {
            sql = "INSERT INTO admin (Username, Password) VALUES ('" 
                + jTextField1.getText() + "', '" + jTextField2.getText() + "')";
        } else {
            JOptionPane.showMessageDialog(this, "Level tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Konfirmasi Simpan Data
        int Opsi = JOptionPane.showConfirmDialog(this, "Apakah Anda Akan Menyimpan Data?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION);

        if (Opsi == JOptionPane.YES_OPTION) {
            st.execute(sql);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
            Clear(); // Bersihkan inputan setelah data disimpan
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak disimpan.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    
    public void Clear(){
        jTextField1.setText("");
        jTextField2.setText("");
    }

    private void Login() {
        String level = (String) jComboBox1.getSelectedItem();
        if (level.equals("Admin")) {
            LoginAdmin();
        } else {
            LoginUser();
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
        Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.gray);

        Login.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Login.setText("Register");
        Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Register");

        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        jTextField2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Level");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, 364, Short.MAX_VALUE)
                            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMouseClicked
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_LoginMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
