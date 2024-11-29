package datamahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi {
    private static Connection conn;
    public static Connection getConnect() {
        String host = "JDBC:mysql://localhost/db_mahasiswa",
                user = "root",
                pass = "";
        
        try{
            conn=(Connection)DriverManager.getConnection(host, user, pass);
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }return conn;
    }
    
    static Object getConnection(){
        throw new UnsupportedOperationException("Not Suggested Yet");
    }
}
