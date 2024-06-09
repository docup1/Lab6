package Objects;

import Commands.*;
import Objects.Answer;
import Objects.Print;
import static Objects.Print.out;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Server extends Thread {
    DatagramChannel datagramChannel;
    Selector selector;
    private static final int PORT = 4100;
    private static final StringBuilder inputBuffer = new StringBuilder();

    private void init() {
        try {
            datagramChannel = DatagramChannel.open();
            datagramChannel.socket().bind(new InetSocketAddress(PORT));
            datagramChannel.configureBlocking(false);
            selector = Selector.open();
            datagramChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("SERVER STARTED, PORT: 4100");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(Answer arg, InetSocketAddress clientAddress) {
        try {
            // Serialize the object to respond
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(arg);
            objectOutputStream.close();
            byte[] serializedObjectResponseBytes = byteArrayOutputStream.toByteArray();

            // Send the response
            ByteBuffer buffer = ByteBuffer.wrap(serializedObjectResponseBytes);
            datagramChannel.send(buffer, clientAddress);
        } catch (IOException e) {
            e.printStackTrace();
            new Print().printErr();
        }
    }

    public Answer doTask(Command myObject, boolean flag) {
        // Execute the command
        try {
            if ((!(myObject instanceof Save) && !(myObject instanceof Exit)) || flag) {
                myObject.run();
            } else {
                new Print().printErr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Print().printErr();
        }
        return new Answer(out);
    }

    public void run() {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ByteBuffer userInputBuffer = ByteBuffer.allocate(1024);

        while (true) {
            try {
                // Check for network events
                if (selector.selectNow() > 0) {
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectedKeys.iterator();

                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isReadable()) {
                            DatagramChannel channel = (DatagramChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(60000);
                            InetSocketAddress clientAddress = (InetSocketAddress) channel.receive(buffer);
                            buffer.flip();

                            // Deserialize the object
                            byte[] serializedObjectBytes = new byte[buffer.remaining()];
                            buffer.get(serializedObjectBytes);
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedObjectBytes);
                            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                            Command myObject = (Command) objectInputStream.readObject();
                            objectInputStream.close();

                            // Process and send response
                            send(doTask(myObject, false), clientAddress);
                        }
                        iterator.remove();
                    }
                }

                // Check for user input
                if (System.in.available() > 0) {
                    int bytesRead = System.in.read(userInputBuffer.array());
                    if (bytesRead > 0) {
                        userInputBuffer.position(0);
                        userInputBuffer.limit(bytesRead);
                        byte[] inputBytes = new byte[bytesRead];
                        userInputBuffer.get(inputBytes);
                        String input = new String(inputBytes).trim();
                        userInputBuffer.clear();

                        System.out.printf(doTask(new CommandManager(new Analyzer(input)).getCommand(), true).toString());
                        // Process the user input as needed
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Server().start();
    }
}

