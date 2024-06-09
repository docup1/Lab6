package Objects;

import Commands.Command;
import Commands.Help;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Client {
    byte[] serializedObjectBytes;
    ObjectOutputStream objectOutputStream;
    ByteArrayOutputStream byteArrayOutputStream;
    DatagramSocket datagramSocket;
    InetAddress inetAddress;
    int port = 4100;
    public Client() {
        try{
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            datagramSocket = new DatagramSocket();
            inetAddress = InetAddress.getByName("127.0.0.1");
        }catch (Exception e){System.out.println("Connection error");}
    }
    public void send(Command msg) {
        try{
            // Сериализуйте объект
            objectOutputStream.writeObject(msg);
            objectOutputStream.close();
            serializedObjectBytes = byteArrayOutputStream.toByteArray();

            // Создайте пакет данных
            DatagramPacket datagramPacket = new DatagramPacket(serializedObjectBytes, serializedObjectBytes.length, inetAddress, port);

            // Отправьте пакет
            datagramSocket.send(datagramPacket);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Answer receive() {
        try{
            // При необходимости получите ответ
            byte[] responseBuffer = new byte[60000];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            datagramSocket.receive(responsePacket);

            byte[] serializedObjectBytes = Arrays.copyOfRange(responseBuffer, 0, responsePacket.getLength());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedObjectBytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Answer myObject = (Answer) objectInputStream.readObject();
            objectInputStream.close();
            return myObject;
        }catch (Exception e){}
        return new Answer("Server error");
    }
    public void close() {

    }
}
