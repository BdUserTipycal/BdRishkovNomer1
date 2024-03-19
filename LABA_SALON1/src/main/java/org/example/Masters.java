package org.example;

public class Masters {
    private Integer id_master;
    private String name;
    private String surname;
    private boolean exist;

    public Masters(Integer id_master, String name, String surname, boolean exist) {
        this.id_master = id_master;
        this.name = name;
        this.surname = surname;
        this.exist = exist;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
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
