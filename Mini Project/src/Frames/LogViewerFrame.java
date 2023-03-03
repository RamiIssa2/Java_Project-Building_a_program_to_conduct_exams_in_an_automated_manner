/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;


import Classes.*;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class LogViewerFrame extends javax.swing.JFrame {

    private DefaultTableModel model;
    ArrayList<Log> logs = new ArrayList<>();
    ArrayList<Log> FilterdLogs = new ArrayList<>();
    
    public LogViewerFrame() {
        initComponents();
        model = (DefaultTableModel) Logs_Table.getModel();
        initList();
        FilterList();
        initTable();
    }

    private void initList(){
        File logsFile = new File("Files\\Logs.txt");
        int offset = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(logsFile));
            String Line = br.readLine();
            while (Line != null){
                if (!Line.equals("")){
                    if (Line.startsWith("[INFO")){
                        offset = 4;
                    }else if (Line.startsWith("[ERROR")){
                        offset = 5;
                    }
                    Log tmp = new Log();
                    tmp.setLogLevel(Line.substring(1, 1+offset));
                    tmp.setDate(Line.substring(3+offset, 13+offset));
                    tmp.setTime(Line.substring(14+offset, 22+offset));
                    tmp.setMessage(Line.substring(25+offset));
                    logs.add(tmp);
                }
                Line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void FilterList(){
        String Filter = (String) LogLevelFilter_ComboBox.getSelectedItem();
        FilterdLogs.clear();
        switch (Filter){
            case "ALL":
                logs.forEach((L) -> {
                    FilterdLogs.add(L);
                });
                break;
            default:
                logs.stream().filter((L) -> (L.getLogLevel().equals(Filter))).forEachOrdered((L) -> {
                    FilterdLogs.add(L);
                });
                break;
        }
    }
    
    private void initTable(){
        model.setRowCount(0);
        FilterdLogs.forEach((L) -> {
            model.insertRow(model.getRowCount(), new Object[]{L.getLogLevel(), L.getDate(), L.getTime(), L.getMessage()});
        });
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Logs_Table = new javax.swing.JTable();
        LogLevelFilter_ComboBox = new javax.swing.JComboBox<>();
        Filter_Label = new javax.swing.JLabel();
        Search_Label = new javax.swing.JLabel();
        Search_TextField = new javax.swing.JTextField();
        Search_BT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log Viewer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Logs_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Log Level", "Date", "Time", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Logs_Table);
        if (Logs_Table.getColumnModel().getColumnCount() > 0) {
            Logs_Table.getColumnModel().getColumn(0).setPreferredWidth(125);
            Logs_Table.getColumnModel().getColumn(1).setPreferredWidth(70);
            Logs_Table.getColumnModel().getColumn(2).setPreferredWidth(50);
            Logs_Table.getColumnModel().getColumn(3).setPreferredWidth(410);
        }

        LogLevelFilter_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "INFO", "ERROR" }));
        LogLevelFilter_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogLevelFilter_ComboBoxActionPerformed(evt);
            }
        });

        Filter_Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Filter_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filter_Label.setText("Log Level Filter:");

        Search_Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Search_Label.setText("Search for student:");

        Search_BT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Search_BT.setText("Search");
        Search_BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_BTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Search_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search_BT, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Filter_Label)
                        .addGap(18, 18, 18)
                        .addComponent(LogLevelFilter_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogLevelFilter_ComboBox)
                    .addComponent(Filter_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Search_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Search_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Search_BT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        TeacherFrame teacher = new TeacherFrame();
        teacher.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void Search_BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_BTActionPerformed
        LogLevelFilter_ComboBox.setSelectedIndex(1);
        FilterList();
        ArrayList<Log> tmp = new ArrayList<>();
        for (Log L : FilterdLogs){
            if ((L.getMessage().contains("(" + Search_TextField.getText() + ")")) && (L.getMessage().startsWith("An Exam"))){
                tmp.add(L);
            }
        }
        FilterdLogs.clear();
        FilterdLogs = tmp;
        initTable();
    }//GEN-LAST:event_Search_BTActionPerformed

    private void LogLevelFilter_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogLevelFilter_ComboBoxActionPerformed
        FilterList();
        initTable();
    }//GEN-LAST:event_LogLevelFilter_ComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(LogViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogViewerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogViewerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Filter_Label;
    private javax.swing.JComboBox<String> LogLevelFilter_ComboBox;
    private javax.swing.JTable Logs_Table;
    private javax.swing.JButton Search_BT;
    private javax.swing.JLabel Search_Label;
    private javax.swing.JTextField Search_TextField;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
