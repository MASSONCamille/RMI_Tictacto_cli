package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    public String ReStart() throws RemoteException;
    public boolean Play(int x, int y) throws RemoteException;
    public boolean Play(int pos) throws RemoteException;
    public int getPlayer() throws RemoteException;
    public boolean TestGagne(int pos) throws RemoteException;
    public boolean TestEgal() throws RemoteException;
    public void NextPlayer() throws RemoteException;
    public String ImprGrille() throws RemoteException;
}