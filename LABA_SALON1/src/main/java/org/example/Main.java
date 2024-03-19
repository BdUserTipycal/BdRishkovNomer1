package org.example;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        IRepository<Clients> clientsList = new ClientRep();
        IRepository<Masters> mastersList = new MasterRep();
        //clientsList.addObj(new Clients (null, "Мистер", "Баб", true));
        //clientsList.update(new Clients(11,"Мистер", "Бин", true));
        //clientsList.delete(new Clients(11,"Мистер", "Бин", true));
        //mastersList.addObj(new Masters (null, "Тимурчик", "Галаветдинчик", true));
        //mastersList.update(new Masters (4, "Тема", "Горелович", true));
        //mastersList.delete(new Masters (4, "Тема", "Горелович", true));
        List<Masters> masters = mastersList.getAll();
        List<Clients> clients = clientsList.getAll();
        //clientsList.delete(clients.get(10));

        /*System.out.println("Вывод всех клиентов: ");
        for(Clients cl: clients){
            FunctionsBD.ClientsOut(cl);
        }

        System.out.println("\n" + "Вывод всех мастеров: ");
        for(Masters ma: masters){
            FunctionsBD.MastersOut(ma);
        }

        System.out.println("\n" + "Вывод клиентов с существующей записью: ");
        for(Clients cl: clients){
            FunctionsBD.ClientsOutTrue(cl);
        }

        System.out.println("\n" + "Вывод клиентов без записи: ");
        for(Clients cl: clients){
            FunctionsBD.ClientsOutFalse(cl);
        }*/
    }
}