package server;

import java.rmi.*;
import java.rmi.registry.*;

public class ChatServerApplication {

    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(1099);
            Registry registry=LocateRegistry.getRegistry();
            ChatServer server=new ChatServer();
            ChatServerInterface chatService = server;
            registry.rebind("ChatService", chatService);
            System.out.println("Server is listening!");
            Thread.sleep(10*60 *  1000);
            System.out.println("Server stops");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}