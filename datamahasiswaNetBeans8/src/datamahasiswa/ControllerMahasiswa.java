package datamahasiswa;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

public class ControllerMahasiswa {
    ArrayList<ModelMahasiswa> ArrayData;
    DefaultTableModel tabelModel;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    public ControllerMahasiswa(){
        ArrayData = new ArrayList<ModelMahasiswa>();
    }
    
    public void InsertData(String npm, String nama, int tinggi, boolean pindahan){
        try {
        // Establish database connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiwa", "root", "");

        // Prepare SQL Insert statement
        String sql = "INSERT INTO data_mahasiswa (NPM, Nama, Tinggi, Pindahan) VALUES (?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        
        // Set parameters for the SQL statement
        pstmt.setString(1, npm);
        pstmt.setString(2, nama);
        pstmt.setInt(3, tinggi);
        pstmt.setBoolean(4, pindahan);
        
        // Execute insert operation
        pstmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    
    public DefaultTableModel showData(){
        String[] kolom = {"NPM", "Nama", "Tinggi", "Pindahan"};
        DefaultTableModel tabelModel = new DefaultTableModel(kolom, 0); // Initialize with column headers only

    try {
        // Establish connection to the database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiwa", "root", "");
        stmt = conn.createStatement();

        // Execute SQL query to retrieve data
        String sql = "SELECT NPM, Nama, Tinggi, Pindahan FROM data_mahasiswa";
        rs = stmt.executeQuery(sql);

        // Process the result set
        while (rs.next()) {
            Object[] row = {
                rs.getString("NPM"),
                rs.getString("Nama"),
                rs.getFloat("Tinggi"),
                rs.getBoolean("Pindahan")
            };
            tabelModel.addRow(row);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close the resources
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        return tabelModel;
    }
}
