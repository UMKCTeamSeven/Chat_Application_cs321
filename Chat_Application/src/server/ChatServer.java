package server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Calendar;
import java.util.LinkedList;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface{
    
    String chat_window;
    String online_users;
    LinkedList<Story> stories=new LinkedList<Story>();
    LinkedList<String> usernames=new LinkedList<String>();

    ChatServer() throws RemoteException{
        super();
    }
    
    public LinkedList<String> get_chat(String username, Calendar date) throws RemoteException{
        LinkedList<String> requested_stories=new LinkedList<String>();
        for(Story story:stories){
            if(!story.username.equals(username) && story.date.compareTo(date)>0){
                requested_stories.add(story.toString());
            }
        }
        
        return requested_stories;
    }
    
    public LinkedList<String> user_list(String username) throws RemoteException{
        return usernames;
    }
    
    public void send_message(String message,String username,Calendar date) throws RemoteException{
        if(username_exists(username)){
            Story story=new Story(username,message,date);
            stories.add(story);
        }
    }
    
    public void disconnect(String username) throws RemoteException
    {
        usernames.remove(username);
    }
    
    public void connect(String username) throws RemoteException{
        if(!username_exists(username))
            usernames.add(username);    
    }
    
    boolean username_exists(String username){
         for(String user:usernames){
            if(user.equals(username))//if the username exists
                return true;
        }
         return false;
    }
}
