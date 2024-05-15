package Objects;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private DatagramSocket socket;
    private InetAddress address;
    private DatagramPacket packet;
    private DatagramPacket getpacket;
    private String ip = "localhost";
    private String received;
    int bl = 5000;
    private byte[] buf;
    private byte[] getbuf = new byte[bl];
    public Client() {
        try{
            socket = new DatagramSocket();
            address = InetAddress.getByName(ip);
        }catch (Exception e){}
    }

    public String send(String msg) {
        try{
            msg += " -end- ";
            buf = msg.getBytes();
            packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            getpacket = new DatagramPacket(getbuf, getbuf.length);
            socket.receive(getpacket);
            received = new String(getpacket.getData(), 0, getpacket.getLength());
            return received;
        }catch (Exception e){return null;}
    }
    public void close() {
        socket.close();
    }
}
