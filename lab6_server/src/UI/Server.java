package UI;

import Commands.CommandManager;
import Objects.Analyzer;
import Objects.Print;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import static Objects.Print.out;

public class Server extends Thread {

    private DatagramSocket socket;
    private String received;
    private DatagramPacket sendpacket;
    private DatagramPacket getpacket;
    private InetAddress address;
    private boolean running;
    int bl = 5000;
    private byte[] sendbuf;
    private byte[] getbuf= new byte[bl];

    public Server() {
        try{
            socket = new DatagramSocket(4445);
        }catch (Exception e){}
    }

    public void run() {
        running = true;
        while (running) {
            getpacket = new DatagramPacket(getbuf, getbuf.length);
            try{
                socket.receive(getpacket);
            }catch (Exception e){}
            address = getpacket.getAddress();
            int port = getpacket.getPort();
            getpacket = new DatagramPacket(getbuf, getbuf.length, address, port);
            received = new String(getpacket.getData(), 0, getpacket.getLength());
            received = received.split(" -end- ")[0];
            if(!received.equals("exit") && !received.equals("save")){
                new CommandManager(
                        new Analyzer(received)
                );
            }
            else{
                new Print().printErr();
            }
            sendbuf = out.getBytes();
            sendpacket = new DatagramPacket(
                    sendbuf,
                    sendbuf.length,
                    address,
                    port
            );
            try{
                socket.send(sendpacket);
            }catch (Exception e){}
            new CommandManager(
                    new Analyzer("save")
            );
        }
        socket.close();
    }
}
