package com.example.lab10;

import DAL.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class GeoApplication extends Application {
    static GeografijaDAO geo = GeografijaDAO.getInstance();

    @Override
    public void start(Stage stage){
        //visenitno
        /*brisanjeGradova brgr = new brisanjeGradova();
        Thread brisanjeGradovaThread = new Thread(brgr);

        brisanjeDrzava brdr = new brisanjeDrzava();
        Thread brisanjeDrzavaThread = new Thread(brdr);

        dodavanjeGradova dogr = new dodavanjeGradova();
        Thread dodavanjeGradovaThread = new Thread(dogr);

        dodavanjeDrzava dodr = new dodavanjeDrzava();
        Thread dodavanjeDrzavaThread = new Thread(dodr);

        brisanjeGradovaThread.start();
        brisanjeDrzavaThread.start();
        dodavanjeGradovaThread.start();
        dodavanjeDrzavaThread.start();

        try{
            brisanjeGradovaThread.join();
            brisanjeDrzavaThread.join();

            dodavanjeGradovaThread.join();
            dodavanjeDrzavaThread.join();

            Platform.runLater(() -> {
                FXMLLoader fxmlLoader = new FXMLLoader(GeoApplication.class.getResource("glavna.fxml"));
                fxmlLoader.setController(new GlavnaController(geo));
                Scene scene;
                try {
                    scene = new Scene(fxmlLoader.load(), 620, 400);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Gradovi svijeta");
                stage.setScene(scene);
                stage.show();
            });
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        FXMLLoader fxmlLoader = new FXMLLoader(GeoApplication.class.getResource("glavna.fxml"));
        fxmlLoader.setController(new GlavnaController(geo));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 620, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Gradovi svijeta");
        stage.setScene(scene);
        stage.show();
    }

    private static final Object lock = new Object();
    static class brisanjeGradova implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                List<Grad> tmp = geo.gradovi();
                for(var x : tmp){
                    geo.obrisiGrad(x.getNaziv());
                }
            }
        }
    }

    static class brisanjeDrzava implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                List<Drzava> tmp = geo.drzave();
                for(var x : tmp){
                    geo.obrisiDrzavu(x.getNaziv());
                }
            }
        }
    }

    static class dodavanjeGradova implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                try{
                    geo.dodajGrad(new Grad("Sarajevo", 2000, "BiH"));
                    geo.dodajGrad(new Grad("Istanbul", 10000, "Turska"));
                    geo.dodajGrad(new Grad("Pariz", 10000, "Francuska"));
                    geo.dodajGrad(new Grad("Mostar", 900, "BiH"));
                }
                catch (org.sqlite.SQLiteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class dodavanjeDrzava implements Runnable{
        @Override
        public void run(){
            synchronized (lock){
                geo.dodajDrzavu(new Drzava("Austrija", "Bec"));
                geo.dodajDrzavu(new Drzava("Italija", "Rim"));
                geo.dodajDrzavu(new Drzava("Hrvatska", "Zagreb"));
                geo.dodajDrzavu(new Drzava("Spanija", "Madrid"));
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
