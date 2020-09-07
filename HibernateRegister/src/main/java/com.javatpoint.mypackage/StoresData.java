//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoresData {

    private int numArt;
    private String name;
    private int stock;
    private String type;

    public StoresData() {
    }

    public int getNumArt() {
        return numArt;
    }

    public void setNumArt(int numArt) {
        this.numArt = numArt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void main(String[] var0) {
        StandardServiceRegistry var1 = (new StandardServiceRegistryBuilder()).configure("hibernate.cfg.xml").build();
        Metadata var2 = (new MetadataSources(var1)).getMetadataBuilder().build();
        SessionFactory var3 = var2.getSessionFactoryBuilder().build();
        Session var4 = var3.openSession();
        Transaction var5 = var4.beginTransaction();
        com.javatpoint.mypackage.Stores var6 = new com.javatpoint.mypackage.Stores();
        var6.setNumRef(123);
        var6.setAddress("");
        var6.setName("Remera Blanca Lisa");
        var4.save(var6);
        var5.commit();
        System.out.println("successfully saved");
        var3.close();
        var4.close();
    }
}
