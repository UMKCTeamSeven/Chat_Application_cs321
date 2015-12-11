package server;
import java.rmi.*;
import java.util.Calendar;
import java.util.LinkedList;

public interface ChatServerInterface extends Remote{
    public LinkedList<String> get_chat(String username, Calendar date) throws RemoteException;
    public LinkedList<String> user_list(String username) throws RemoteException;
    public void send_message(String message,String username,Calendar date) throws RemoteException;
    public void connect(String username) throws RemoteException;
    public void disconnect(String username) throws RemoteException;
}
