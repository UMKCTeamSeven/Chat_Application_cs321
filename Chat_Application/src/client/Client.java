package client;

import server.*;
import java.rmi.*;
import java.util.Calendar;
import java.util.LinkedList;

public class Client {

    ChatServerInterface server;
    String username;
    ConnectFrame connectframe;
    ClientFrame clientframe;
    
    public void init(){
        connectframe = new ConnectFrame(this);
        connectframe.setVisible(true);
    }
    
    public void connect(String username, String ip_address, Calendar date) {
        try {
            server = (ChatServerInterface) Naming.lookup("rmi://" + ip_address + "/ChatService");
            this.username = username;
            this.server.connect(username);
            this.connectframe.setVisible(false);
            clientframe = new ClientFrame(this);
            this.clientframe.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    
        public LinkedList<String> get_chat(String username,Calendar date) {
         try {
            return server.get_chat(username, date);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }       
    }
        
         public LinkedList<String> user_list(String username,Calendar date) {
         try {
            return server.user_list(username);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }       
    }
        
        
        public void send_story(String username,Calendar date,String story){
         try {
            server.send_message(story, username, date);
        } catch (Exception e) {
            System.out.println(e);
        }            
        }
    
        public static void main(String args[]) {
        try {
            Client client = new Client();
            client.init();  
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
