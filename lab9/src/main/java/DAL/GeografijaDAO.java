package DAL;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private static Connection conn;
    private GeografijaDAO(){
        String url = "jdbc:sqlite:identifier.sqlite";
        try{
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM grad");
        }
        catch (SQLException e) {
            regenerisiBazu();
        }
    }
    public static GeografijaDAO getInstance(){
        if(instance == null) instance = new GeografijaDAO();
        return instance;
    }
    public static void removeInstance() {
        try{
            instance.conn.close();
            instance = null;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void vratiNaDefault() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE grad SET drzava = NULL;");
        stmt.executeUpdate("DELETE FROM drzava;");
        stmt.executeUpdate("DELETE FROM grad;");
        regenerisiBazu();
    }
    private void regenerisiBazu(){
        try{
            Scanner ulaz = new Scanner(new FileInputStream("geografijabaza.db.sql"));
            StringBuilder sqlUpit = new StringBuilder();
            while(ulaz.hasNext()){
                sqlUpit.append(ulaz.nextLine());
                if(sqlUpit.length() > 1 && sqlUpit.charAt(sqlUpit.length() - 1) == ';'){
                    try{
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit.toString());
                        sqlUpit.setLength(0);
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private int zadnjiIndeksGrada(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT id FROM grad ORDER BY id DESC;");
            return result.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int zadnjiIndeksDrzave(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT id FROM drzava ORDER BY id DESC;");
            return result.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public ArrayList<Grad> gradovi(){
        ArrayList<Grad> g = new ArrayList<>();
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT g.naziv, g.broj_stanovnika, d.naziv " +
                    "FROM grad g, drzava d " +
                    "WHERE g.drzava = d.id;");
            while(result.next()){
                g.add(new Grad(result.getString(1), result.getInt(2), result.getString(3)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }
    public Grad glavniGrad(String drzava){
        try{
            PreparedStatement psGlavniGrad = conn.prepareStatement("SELECT g.naziv, g.broj_stanovnika " +
                    "FROM grad g, drzava d " +
                    "WHERE d.naziv = ? AND d.glavni_grad = g.id;");
            psGlavniGrad.setString(1, drzava);
            ResultSet result = psGlavniGrad.executeQuery();

            if(!result.next()) return null;
            else return new Grad(result.getString(1), result.getInt(2), drzava);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void obrisiDrzavu(String drzava){
        try{
            PreparedStatement ps2 = conn.prepareStatement("UPDATE grad SET drzava = null " +
                    "WHERE drzava = (SELECT d.id FROM drzava d WHERE d.naziv = ?);");
            ps2.setString(1, drzava);
            ps2.executeUpdate();

            PreparedStatement ps1 = conn.prepareStatement("DELETE FROM drzava WHERE naziv = ?;");
            ps1.setString(1, drzava);
            ps1.executeUpdate();

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM grad WHERE drzava IS NULL;");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajGrad(Grad grad){
        try{
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO grad VALUES (?, ?, ?, NULL);");
            int j = zadnjiIndeksGrada()+1;
            ps1.setInt(1, j);
            ps1.setString(2, grad.getNaziv());
            ps1.setInt(3, grad.getBroj_stanovnika());
            ps1.executeUpdate();

            if(!(grad.getDrzava().isEmpty())){
                PreparedStatement ps2 = conn.prepareStatement("INSERT INTO drzava VALUES (?, ?, ?);");
                int i = zadnjiIndeksDrzave()+1;
                ps2.setInt(1, i);
                ps2.setString(2, grad.getDrzava());
                ps2.setInt(3, j);
                ps2.executeUpdate();

                PreparedStatement ps3 = conn.prepareStatement("UPDATE grad SET drzava = ? WHERE id = ?;");
                ps3.setInt(1, i);
                ps3.setInt(2, j);
                ps3.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajDrzavu(Drzava drzava){
        try{
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO drzava VALUES (?, ?, NULL);");
            int i = zadnjiIndeksDrzave()+1;
            ps1.setInt(1, i);
            ps1.setString(2, drzava.getNaziv());
            ps1.executeUpdate();

            if(!(drzava.getGlavni_grad().isEmpty())){
                PreparedStatement ps2 = conn.prepareStatement("INSERT INTO grad VALUES (?, ?, NULL, ?);");
                int j = zadnjiIndeksGrada()+1;
                ps2.setInt(1, j);
                ps2.setString(2, drzava.getGlavni_grad());
                ps2.setInt(3, i);
                ps2.executeUpdate();

                PreparedStatement ps3 = conn.prepareStatement("UPDATE drzava SET glavni_grad = ? WHERE id = ?;");
                ps3.setInt(1, j);
                ps3.setInt(2, i);
                ps3.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void izmijeniGrad(Grad grad){
        try{
            PreparedStatement ps1 = conn.prepareStatement("SELECT d.naziv FROM grad g, drzava d WHERE g.naziv = ? AND g.drzava = d.id;");
            ps1.setString(1, grad.getNaziv());
            ResultSet res = ps1.executeQuery();
            if(!res.next()) return;
            String oldDrzava = res.getString(1);

            if(nadjiDrzavu(grad.getDrzava()) == null){
                dodajDrzavu(new Drzava(grad.getDrzava(), ""));
            }

            PreparedStatement ps = conn.prepareStatement("UPDATE grad SET (broj_stanovnika, drzava) = (SELECT ?, d.id FROM drzava d WHERE d.naziv = ?) " +
                                                             "WHERE naziv = ?;");
            ps.setInt(1, grad.getBroj_stanovnika());
            ps.setString(2, grad.getDrzava());
            ps.setString(3, grad.getNaziv());
            ps.executeUpdate();

            if(!oldDrzava.equals(grad.getDrzava())){
                PreparedStatement ps2 = conn.prepareStatement("DELETE FROM drzava WHERE naziv = ?;");
                ps2.setString(1, oldDrzava);
                ps2.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Drzava nadjiDrzavu(String drzava){
        try{
            PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM drzava WHERE naziv = ?;");
            ps1.setString(1, drzava);
            ResultSet res = ps1.executeQuery();
            if(!res.next()) return null;

            PreparedStatement ps = conn.prepareStatement("SELECT g.naziv FROM drzava d, grad g WHERE d.naziv = ? AND d.glavni_grad = g.id;");
            ps.setString(1, drzava);
            ResultSet result = ps.executeQuery();
            return new Drzava(drzava, result.getString(1));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
