package com.mycompany.laba1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Client {
    private static final int SERVER_PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        DatagramSocket clientSocket = null;

        try {
            clientSocket = new DatagramSocket(); // Автоматически выбирает порт
            int clientPort = clientSocket.getLocalPort();

            System.out.println("Client started. Listening on port: " + clientPort);

            // Отправляем серверу информацию о своём порте
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String registerMessage = "REGISTER:" + clientPort;
            byte[] registerData = registerMessage.getBytes("UTF-8");
            DatagramPacket registerPacket = new DatagramPacket(registerData, registerData.length, serverAddress, SERVER_PORT);
            clientSocket.send(registerPacket);

            byte[] receiveData = new byte[BUFFER_SIZE];

            while (true) {
                try {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(receivePacket);

                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
                    System.out.println("Received task: " + message);

                    if (message.startsWith("TASK:")) {
                        String[] parts = message.split(":");
                        if (parts.length != 5) {
                            System.err.println("Invalid task format: " + message);
                            continue;
                        }

                        int clientId = Integer.parseInt(parts[1]);
                        double a = Double.parseDouble(parts[2]);
                        double b = Double.parseDouble(parts[3]);
                        double h = Double.parseDouble(parts[4]);

                        double result = calculateIntegral(a, b, h);
                        try {
                            String response = "RESULT:" + clientId + ":" + result;
                            byte[] sendData = response.getBytes("UTF-8");
                            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                            clientSocket.send(sendPacket);
                            System.out.println("Result sent to server: " + result);
                            clientSocket.close();
                            System.exit(0);
                        } catch (SocketTimeoutException e) {
                            System.out.println("Result not sent to server");
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    private static double calculateIntegral(double a, double b, double h) {
        double sum = 0.0;
        double x = a;

        while (x + h <= b) {
            sum += (h / 2.0) * (Math.cos(x) + Math.cos(x + h));
            x += h;
        }

        if (x < b) {
            double last_h = b - x;
            sum += (last_h / 2.0) * (Math.cos(x) + Math.cos(b));
        }

        return sum;
    }
}
