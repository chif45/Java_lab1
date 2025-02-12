package com.mycompany.laba1;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class laba1 extends javax.swing.JFrame {
    int rowIndex = 0;
    int selectedRow = 0;
    public laba1() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        hbordtextfield = new javax.swing.JTextField();
        steptextfield = new javax.swing.JTextField();
        lbordtextfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("нижняя граница");

        jLabel2.setText("           шаг");

        jLabel3.setText("верхняя граница");

        jButton1.setText("Вычислить");
        jButton1.setActionCommand("jButton3");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Удалить");
        jButton2.setActionCommand("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Добавить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Нижняя граница", "Верхняя граница", "Шаг", "Значение"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        hbordtextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hbordtextfieldActionPerformed(evt);
            }
        });

        steptextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steptextfieldActionPerformed(evt);
            }
        });

        lbordtextfield.setName("lbordtextfield"); // NOI18N
        lbordtextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbordtextfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbordtextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(hbordtextfield)
                    .addComponent(steptextfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(lbordtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(hbordtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(steptextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.removeRow(rowIndex - 1);
        rowIndex--;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        
        String lowborder = lbordtextfield.getText();
        
        //model.setValueAt(low, rowIndex, 0); 
        String highborder = hbordtextfield.getText();
        String stepStr = steptextfield.getText();
         
        model.addRow(new Object[]{lowborder,highborder,stepStr, " "});
        rowIndex++;   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    selectedRow = jTable1.getSelectedRow();

    if (selectedRow != -1) { // Проверка, выбрана ли строка
        Object lowBorderObj = model.getValueAt(selectedRow, 0);
        Object highBorderObj = model.getValueAt(selectedRow, 1);
        Object stepObj = model.getValueAt(selectedRow, 2);
        
        // Преобразование значений из строки в double
        double lowBorder = Double.parseDouble(lowBorderObj.toString());
        double highBorder = Double.parseDouble(highBorderObj.toString());
        double step = Double.parseDouble(stepObj.toString());

        double answer = CalculationOfValue(lowBorder, highBorder, step);
        ShowTheAnswer(answer);
    } else {
        JOptionPane.showMessageDialog(this, "Пожалуйста, выберите строку для вычисления.", "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private double CalculationOfValue(Object low,Object high, Object step){
        double dbllow = (Double) low;
        double dblhigh = (Double) high;
        double dblstep = (Double) step;
        double answer = 0;
        
        ArrayList<Double> numbers = new ArrayList<>();
        
        //если шаг равен 0
        if (dblstep == 0){
            return answer;
        }
        
        //подсчет шагов
        for (double currentNumber = dbllow; currentNumber <= dblhigh; currentNumber += dblstep) {
            numbers.add(currentNumber); 
        }
        
        //если шаг равен 1
        if (numbers.isEmpty()){
            answer = (Math.sin(dbllow) + Math.sin(dblhigh)) * (dblstep / 2);
            return answer;
        }
        
        for (int counter = 0; counter < numbers.size() - 1; counter++) {
            double currentElement = numbers.get(counter);
            double nextElement = numbers.get(counter + 1);
            double stepAnswer = (dblstep / 2) * (Math.sin(currentElement) + Math.sin(nextElement));
            answer += stepAnswer;
        }
        
        //если есть промежуток меньше шага между последним элементом и верхней границей       
        if (dblhigh != numbers.get(numbers.size()-1)){
            answer += (dblstep / 2) * (Math.sin(numbers.get(numbers.size()-1)) + Math.sin(dblhigh));
        }

        return answer;
    }
    private void ShowTheAnswer(double answer){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setValueAt(answer, selectedRow, 3); 
    }
    private void steptextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steptextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_steptextfieldActionPerformed

    private void lbordtextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbordtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbordtextfieldActionPerformed

    private void hbordtextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hbordtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hbordtextfieldActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hbordtextfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lbordtextfield;
    private javax.swing.JTextField steptextfield;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new laba1().setVisible(true);
        }
    }
}
