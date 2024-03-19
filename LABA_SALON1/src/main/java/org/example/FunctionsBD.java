package org.example;

public class FunctionsBD {
    public static void ClientsOut(Clients clients){
        System.out.println(clients.getId_client() + " " + clients.getName() + " " + clients.getSurname() + " " + clients.getExist());
    }
    public static void ClientsOutTrue(Clients clients){
        if (clients.getExist() == true) {
            System.out.println(clients.getId_client() + " " + clients.getName() + " " + clients.getSurname() + " " + clients.getExist());
        }
    }
    public static void ClientsOutFalse(Clients clients){
        if (clients.getExist() == false) {
            System.out.println(clients.getId_client() + " " + clients.getName() + " " + clients.getSurname() + " " + clients.getExist());
        }
    }
    public static void MastersOut(Masters masters){
        System.out.println(masters.getId_master() + " " + masters.getName() + " " + masters.getSurname() + " " + masters.getExist());
    }
    public static void MastersOutTrue(Masters masters){
        if (masters.getExist() == true) {
            System.out.println(masters.getId_master() + " " + masters.getName() + " " + masters.getSurname() + " " + masters.getExist());
        }
    }
    public static void MastersOutFalse(Masters masters){
        if (masters.getExist() == false) {
            System.out.println(masters.getId_master() + " " + masters.getName() + " " + masters.getSurname() + " " + masters.getExist());
        }
    }
}
