package org.example;

public class Clients {
    private Integer id_client;
    private String name;
    private String surname;
    private boolean exist;

    public Clients(Integer id_client, String name, String surname, boolean exist) {
        this.id_client = id_client;
        this.name = name;
        this.surname = surname;
        this.exist = exist;
    }
    public int getId_client() {
        return id_client;
    }
    public void setId_client(int in_client) {
        this.id_client = in_client;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean getExist(){return exist;}
    public void setExist(boolean exist){this.exist = exist;}
}
