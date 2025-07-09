import java.sql.*;
import java.util.Scanner;

public class DoctorService {
    Scanner sc = new Scanner(System.in);

    //method to aad doctor detail

    public void addDoctor(){
        try (Connection conn = DBConnection.getConnection()){

            System.out.println("Enter Doctor Name:");
            String name = sc.nextLine();

            System.out.println("Enter Age:");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Gender:");
            String gender = sc.nextLine();

            System.out.println("Enter Specialization:");
            String specialization = sc.nextLine();

            String query = "INSERT INTO doctors(name,age,gender,specialization) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, specialization);
            ps.executeUpdate();

            System.out.println("Doctor details added successfully !");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //view doctor details

    public void viewDoctors(){
        try(Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM doctors");
            System.out.println("ID | Name | Age | Gender | Specialization");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " +
                rs.getInt("age") + " | " + rs.getString("gender") + " | " + rs.getString("specialization"));
                
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //check doctor method

    public void checkDoctor() {
    try (Connection conn = DBConnection.getConnection()) {
        System.out.print("Enter Doctor ID to check: ");
        int id = sc.nextInt();

        String query = "SELECT * FROM doctors WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Doctor Found:");
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Gender: " + rs.getString("gender"));
            System.out.println("Specialization: " + rs.getString("specialization"));
        } else {
            System.out.println("Doctor not found with ID: " + id);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}



    
}
