/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import DataModels.KasReport;
import DataModels.Mahasiswa;
import DataModels.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Fadli
 */
public class DatabaseInstance {
    protected Connection connect;
    
    public DatabaseInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect  = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_kas_mahasiswa", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    };
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return connect  = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_kas_mahasiswa", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return connect;
        }
    };
    
    public DatabaseResultResponse loginUser(String username, String password) {
        String query = "SELECT * FROM user WHERE username=? AND password=?";
        String status = null;
        
        connect  = getConnection();
        ArrayList<User> result = new ArrayList<>();
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setString(2, password);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    
                    status = rs.getString("status");
                    
                    if(status.equals("pending")) {
                        return new DatabaseResultResponse(300, "Akun anda belum bisa login!", null);
                    };
                    
                    String nim = rs.getString("nim");
                    String name = rs.getString("name");
                    String usernameUser = rs.getString("username");
                    
                    User currUser = new User(nim, name, usernameUser, status);
                    result.add(currUser);
                    return new DatabaseResultResponse(200, "success", null);
                } else {
                    return new DatabaseResultResponse(300, "Username or Password Is Incorrect!", null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    };
    
     public DatabaseResultResponse registUser(String nim, String name, String username, String password) {
        String query = "insert into user(nim, name, username, password, status) values ( ?, ?, ?, ?, ?)";
        String status = null;
        
        ArrayList<User> result = new ArrayList<User>();
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, nim);
            pst.setString(2, name);
            pst.setString(3, username);
            pst.setString(4, password);
            pst.setString(5, "pending");
            
            pst.executeUpdate();
            
            return new DatabaseResultResponse(200, "Sukses Mendaftarkan Akun Baru!", null);
        } catch (SQLException e) {
            int errCode = e.getErrorCode();
            System.out.println(errCode);
            if(errCode == 1452) {
                return new DatabaseResultResponse(500, "Ops! Sepertinya anda mahasiswa luar\nBeritahu Sekretaris untuk mendaftarkanmu!", null);
            }
            if(errCode == 1062) {
                return new DatabaseResultResponse(300, "NIM sudah terdaftar!\nCoba yang lain!", null);
            }
            e.printStackTrace();
            return new DatabaseResultResponse(500, e.getMessage(), null);
        }
    };
     
    public DatabaseResultResponse addMahasiswa(String nim, String name, String noPhone, String gender) {
        String query = "insert into mahasiswa(nim, name, no_phone, gender) values ( ?, ?, ?, ?)";
        
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, nim);
            pst.setString(2, name);
            pst.setString(3, noPhone);
            pst.setString(4, gender);
            
            pst.executeUpdate();
            
            return new DatabaseResultResponse(200, "Berhasil Menambahkan Data\nMahasiswa!", null);
        } catch (SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, e.getMessage(), null);
        }
    };
    
    public DatabaseResultResponse getMahasiswa() {
        String query = "SELECT * from mahasiswa";
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        
        try(Connection connect = getConnection();
            PreparedStatement statment = connect.prepareStatement(query)) {
            
            try(ResultSet result = statment.executeQuery()) {
                while(result.next()) {
                    String nim = result.getString("nim");
                    String name = result.getString("name");
                    String noPhone = result.getString("no_phone");
                    String gender = result.getString("gender");
                    
                    Mahasiswa mhs = new Mahasiswa(nim, name, noPhone, gender);
                    listMahasiswa.add(mhs);
                }
            };
            
            return new DatabaseResultResponse(200, "success", listMahasiswa);
        } catch(SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, "failed", null);
        }
    };
    
    public DatabaseResultResponse addKasTransaction(String nim, String date, String name, double income, double expanse, String desc, String type) {
        String query = "insert into report_kas(nim_mahasiswa, tanggal, name, income, expanse, description, type) values ( ?, ?, ?, ?, ?, ?, ?)";
        
        connect = getConnection();
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, nim);
            pst.setString(2, date);
            pst.setString(3, name);
            pst.setDouble(4, income);
            pst.setDouble(5, expanse);
            pst.setString(6, desc);
            pst.setString(7, type);
            
            pst.executeUpdate();
            
            return new DatabaseResultResponse(200, "Berhasil Menambahkan Pembayaran Kas!", null);
        } catch (SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, e.getMessage(), null);
        }
    };
    
    public DatabaseResultResponse deleteKasReport(int id) {
        String query = "DELETE FROM report_kas WHERE id = ?";
        
        connect = getConnection();
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            
            return new DatabaseResultResponse(200, "Berhasil Menambahkan Pembayaran Kas!", null);
        } catch (SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, e.getMessage(), null);
        }
    };
    
    public DatabaseResultResponse deleteMahasiswa(String nim) {
        String query = "DELETE FROM mahasiswa WHERE nim = ?";
        
        connect = getConnection();
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, nim);
            pst.executeUpdate();
            
            return new DatabaseResultResponse(200, "Berhasil Menghapus Mahasiswa!", null);
        } catch (SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, e.getMessage(), null);
        }
    };
    
    
    public DatabaseResultResponse getKasReport() {
        String query = "SELECT * from report_kas";
        ArrayList<KasReport> listkasReport = new ArrayList<>();
        
        try(Connection connect = getConnection();
            PreparedStatement statment = connect.prepareStatement(query)) {
            
            try(ResultSet result = statment.executeQuery()) {
                while(result.next()) {
                    int id = result.getInt("id");
                    String nim = result.getString("nim_mahasiswa");
                    String name = result.getString("name");
                    String date = result.getString("tanggal");
                    double income = result.getDouble("income");
                    double expanse = result.getDouble("expanse");
                    String desc = result.getString("description");
                    String type = result.getString("type");
                    
                    KasReport report = new KasReport(id, nim, name, desc, date, type, income, expanse);
                    listkasReport.add(report);
                }
            };
            
            return new DatabaseResultResponse(200, "success", listkasReport);
        } catch(SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, "failed", null);
        }
    };
    
    public DatabaseResultResponse getKasReportDetail(String nimMhs) {
        String query = "SELECT * from report_kas where nim_mahasiswa = ?";
        ArrayList<KasReport> listkasReport = new ArrayList<>();
        
        try(Connection connect = getConnection();
            PreparedStatement statment = connect.prepareStatement(query)) {
            statment.setString(1, nimMhs);
            
            try(ResultSet result = statment.executeQuery()) {
                while(result.next()) {
                    int id = result.getInt("id");
                    String nim = result.getString("nim_mahasiswa");
                    String name = result.getString("name");
                    String date = result.getString("tanggal");
                    double income = result.getDouble("income");
                    double expanse = result.getDouble("expanse");
                    String desc = result.getString("description");
                    String type = result.getString("type");
                    
                    KasReport report = new KasReport(id, nim, name, desc, date, type, income, expanse);
                    listkasReport.add(report);
                }
            };
            
            return new DatabaseResultResponse(200, "success", listkasReport);
        } catch(SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, "failed", null);
        }
    };
    
    public DatabaseResultResponse getKasReportDetail(int idKas) {
        String query = "SELECT * from report_kas where id = ?";
        ArrayList<KasReport> listkasReport = new ArrayList<>();
        
        try(Connection connect = getConnection();
            PreparedStatement statment = connect.prepareStatement(query)) {
            statment.setInt(1, idKas);
            
            try(ResultSet result = statment.executeQuery()) {
                while(result.next()) {
                    int id = result.getInt("id");
                    String nim = result.getString("nim_mahasiswa");
                    String name = result.getString("name");
                    String date = result.getString("tanggal");
                    double income = result.getDouble("income");
                    double expanse = result.getDouble("expanse");
                    String desc = result.getString("description");
                    String type = result.getString("type");
                    
                    KasReport report = new KasReport(id, nim, name, desc, date, type, income, expanse);
                    listkasReport.add(report);
                }
            };
            
            return new DatabaseResultResponse(200, "success", listkasReport);
        } catch(SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, "failed", null);
        }
    };
    
    public DatabaseResultResponse updateReportKas(int idKas, String date, String name, double income, double expanse, String desc, String type) {
        String query = "UPDATE report_kas SET tanggal = ?, name = ?, income = ?, expanse = ?, description = ?, type = ? WHERE id = ?;";
        
        connect = getConnection();
        try (PreparedStatement pst = connect.prepareStatement(query)) {
            pst.setString(1, date);
            pst.setString(2, name);
            pst.setDouble(3, income);
            pst.setDouble(4, expanse);
            pst.setString(5, desc);
            pst.setString(6, type);
            pst.setInt(7, idKas);
            pst.executeUpdate();
            
            return new DatabaseResultResponse(200, "Berhasil Mengedit Pembayaran Kas!", null);
        } catch (SQLException e) {
            e.printStackTrace();
            return new DatabaseResultResponse(500, e.getMessage(), null);
        }        
    }
}
