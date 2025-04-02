package com.mycompany.laba1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

class IntegralTask implements Runnable {
    private double lowBorder;
    private double highBorder;
    private double step;
    private int threadIndex;
    private int totalThreads;
    private double[] results;

    public IntegralTask(double lowBorder, double highBorder,
            double step, int threadIndex, int totalThreads, double[] results) {
        this.lowBorder = lowBorder;
        this.highBorder = highBorder;
        this.step = step;
        this.threadIndex = threadIndex;
        this.totalThreads = totalThreads;
        this.results = results;
    }

    @Override
    public void run() {
        // Расчёт границ для текущего потока
        double rangePerThread = (highBorder - lowBorder) / totalThreads;
        double start = lowBorder + threadIndex * rangePerThread;
        double end = (threadIndex == totalThreads - 1) ? highBorder : start + rangePerThread;

        // Вычисление интеграла в пределах границ start и end
        double localResult = 0;
        for (double currentNumber = start; currentNumber <= end; currentNumber += step) {
            if (currentNumber + step <= end) {
                localResult += (step / 2) * (Math.sin(currentNumber) + Math.sin(currentNumber + step));
            } else {
                localResult += (step / 2) * (Math.sin(currentNumber) + Math.sin(end));
            }
        }

        // Сохранение результата в массив
        results[threadIndex] = localResult;
    }
}


class InvalidRecIntegralValueException extends Exception {
    public InvalidRecIntegralValueException(String message) {
        super(message);
    }
}

class RecIntegral implements Serializable {
    private double lowborder;
    private double highborder;
    private double step;
    private double answer;

    RecIntegral(double inputLowBorder, double inputHighBorder, double inputStep, double inputAnswer) throws InvalidRecIntegralValueException {
        validateValue(inputLowBorder);
        validateValue(inputHighBorder);
        validateValue(inputStep);

        this.lowborder = inputLowBorder;
        this.highborder = inputHighBorder;
        this.step = inputStep;
        this.answer = inputAnswer;
    }

    private void validateValue(double value) throws InvalidRecIntegralValueException {
        if (value < 0.000001 || value > 1000000) {
            throw new InvalidRecIntegralValueException("Значение " + value + " должно быть в диапазоне от 0,000001 до 1000000.");
        }
    }
    @Override
    public String toString() {
        return lowborder + "," + highborder + "," + step + "," + answer;
}

    // Геттеры 
    public double getLowborder() {
        return lowborder;
    }

    public double getHighborder() {
        return highborder;
    }

    public double getStep() {
        return step;
    }

    public double getAnswer() {
        return answer;
    }

    // Сеттеры
    public void setLowborder(double lowborder) throws InvalidRecIntegralValueException {
        this.lowborder = lowborder;
    }

    public void setHighborder(double highborder) throws InvalidRecIntegralValueException {
        this.highborder = highborder;
    }

    public void setStep(double step) throws InvalidRecIntegralValueException {
        this.step = step;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }
}

      
public class laba1 extends javax.swing.JFrame {
    private static final int SERVER_PORT = 9876;
    private static final int BUFFER_SIZE = 1024;
    private ArrayList<RecIntegral> records;
    
    int selectedRow = 0;
    LinkedList<RecIntegral> linkedList = new LinkedList<>();
    
    public laba1() {
        initComponents();
        records = new ArrayList<>();
    
    for (int i = 0; i < 13; i++) {
        new Thread(() -> runClient()).start(); // Каждый клиент запускается в отдельном потоке
    }
        new Thread(this::receiveClientRegistrations).start();
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
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

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

        jButton4.setLabel("Заполнить");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setLabel("Очистить");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Загрузить из bin");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Сохранить в bin");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Загрузить из text");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Сохранить в text");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jButton9))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbordtextfield)
                    .addComponent(hbordtextfield)
                    .addComponent(steptextfield)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(steptextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Map<Integer, Integer> clientPorts = new HashMap<>(); // Список портов клиентов
   
   public static void runClient() {
    try {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "D:/3курс/java/Java_lab1/laba1/target/classes", "com.mycompany.laba1.Client");
        processBuilder.inheritIO(); 
        Process process = processBuilder.start(); 
        process.waitFor(); 
    } catch (IOException | InterruptedException e) {
        e.printStackTrace(); 
    }
}


    
    private void receiveClientRegistrations() {
    try (DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT)) {
        byte[] receiveData = new byte[BUFFER_SIZE];

        while (clientPorts.size() < 13) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String message = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

            if (message.startsWith("REGISTER:")) {
                int clientPort = Integer.parseInt(message.split(":")[1]);
                clientPorts.put(clientPorts.size() + 1, clientPort);
                System.out.println("Client " + clientPorts.size() + " registered on port: " + clientPort);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void sendTask(int clientId, double a, double b, double h) {
        try {
        DatagramSocket socket = new DatagramSocket();
        InetAddress clientAddress = InetAddress.getByName("localhost");

        int clientPort = clientPorts.get(clientId);
        String task = "TASK:" + clientId + ":" + a + ":" + b + ":" + h;
        byte[] sendData = task.getBytes("UTF-8");

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        socket.send(sendPacket);
        socket.close();

        System.out.println("Task sent to client " + clientId + " on port " + clientPort);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    private double receiveResults() {
        double totalResult = 0.0;
        Map<Integer, Double> results = new HashMap<>();
        
        results.clear();
        try (DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT)) {
            byte[] receiveData = new byte[BUFFER_SIZE];

            while (results.size() < clientPorts.size()) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(message);

                if (message.startsWith("RESULT:")) {
                    String[] parts = message.split(":");
                    int clientId = Integer.parseInt(parts[1]);
                    double partialResult = Double.parseDouble(parts[2]);

                    results.put(clientId, partialResult);
                    
                }
            }

            totalResult = results.values().stream().mapToDouble(Double::doubleValue).sum();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalResult;
    }
    
   
    private static LinkedList<RecIntegral> readRecIntegralsFromTextFile() {
        LinkedList<RecIntegral> recIntegrals = new LinkedList<>();
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToRead = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        double lowBorder = Double.parseDouble(parts[0].trim());
                        double highBorder = Double.parseDouble(parts[1].trim());
                        double step = Double.parseDouble(parts[2].trim());
                        double answer = Double.parseDouble(parts[3].trim());
                        recIntegrals.add(new RecIntegral(lowBorder, highBorder, step, answer));
                    }
                }
            } catch (IOException | InvalidRecIntegralValueException e) {
                System.err.println("Ошибка при чтении из файла: " + e.getMessage());
            }
        }
        return recIntegrals;
    }
    private static LinkedList<RecIntegral> deserializeAndReadRecIntegrals() {
        LinkedList<RecIntegral> recIntegrals = null;
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToRead = fileChooser.getSelectedFile();
            try (FileInputStream fileIn = new FileInputStream(fileToRead);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
                recIntegrals = (LinkedList<RecIntegral>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Ошибка при десериализации: " + e.getMessage());
            }
        }
        return recIntegrals;
    }

    private static void writeRecIntegralsToFile(List<RecIntegral> recIntegrals) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                for (RecIntegral recIntegral : recIntegrals) {
                    writer.write(recIntegral.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }
    private static void serializeAndWriteRecIntegrals(List<RecIntegral> recIntegrals) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(recIntegrals);
            } catch (IOException e) {
                System.err.println("Ошибка при сериализации: " + e.getMessage());
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.removeRow(selectedRow);
        linkedList.remove(selectedRow);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        
        String lowborder = lbordtextfield.getText();
        String highborder = hbordtextfield.getText();
        String stepStr = steptextfield.getText();
        
        double dlowborder = Double.parseDouble(lowborder);
        double dhighborder = Double.parseDouble(highborder);
        double dstep = Double.parseDouble(stepStr);
        
        try {
            linkedList.add(new RecIntegral(dlowborder,dhighborder,dstep, 0.0));
            model.addRow(new Object[]{lowborder,highborder,stepStr, " "}); 
        } catch (InvalidRecIntegralValueException ex) { 
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    selectedRow = jTable1.getSelectedRow();
if (selectedRow != -1) {
    try {
        RecIntegral record = linkedList.get(selectedRow);
        double a = record.getLowborder();
        double b = record.getHighborder();
        double h = record.getStep();


        double interval = (b - a) / 13;

        for (int i = 0; i < 13; i++) {
            double start = a + i * interval;
            double end = a + (i + 1) * interval;
            sendTask(i + 1, start, end, h); 
        }

        // Ждем результатов
        double totalResult = receiveResults();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setValueAt(totalResult, selectedRow, 3);
        linkedList.get(selectedRow).setAnswer(totalResult);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ошибка при отправке задач клиентам", "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(this, "Выберите строку для вычисления", "Ошибка", JOptionPane.WARNING_MESSAGE);
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
   private void ShowTheAnswer(double answer) {
    SwingUtilities.invokeLater(() -> {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setValueAt(answer, selectedRow, 3);
        RecIntegral recIntegral = linkedList.get(selectedRow);
        recIntegral.setAnswer(answer);
    });
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        
        for (RecIntegral ri : linkedList) {
            model.addRow(new Object[]{ri.getLowborder(), ri.getHighborder(), ri.getStep(), ri.getAnswer()});
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        linkedList = deserializeAndReadRecIntegrals();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (RecIntegral ri : linkedList) {
        model.addRow(new Object[]{ri.getLowborder(), ri.getHighborder(), ri.getStep(), ri.getAnswer()});
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        serializeAndWriteRecIntegrals(linkedList);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    linkedList = readRecIntegralsFromTextFile();
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    for (RecIntegral ri : linkedList) {
        model.addRow(new Object[]{ri.getLowborder(), ri.getHighborder(), ri.getStep(), ri.getAnswer()});
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        writeRecIntegralsToFile(linkedList);
    }//GEN-LAST:event_jButton9ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hbordtextfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
