import java.sql.*;
import java.util.Scanner;

public class PatientService {
    Scanner sc = new Scanner(System.in);

    //add paitent detail

public void addPatient(){
    try(Connection conn = DBConnection.getConnection()) {
        System.out.println("Enter Patient Name :");
        String name = sc.nextLine();

        System.out.println("Enter Age :");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Gender :");
        String gender = sc.nextLine();

        System.out.println("Enter Disease :");
        String disease = sc.nextLine();

        String query = "INSERT INTO patients (name, age ,gender ,disease) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,name);
        ps.setInt(2,age);
        ps.setString(3,gender);
        ps.setString(4,disease);
        ps.executeUpdate();

        System.out.println("Patient added successfully !!!");

    }
    catch(Exception e){
        e.printStackTrace();
    }
}

//view patient
public void viewPatients(){
    try(Connection conn = DBConnection.getConnection()){
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM patients");

        System.out.println("ID | Name | Age | Gender | Disease");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("gender") + " | " +
                        rs.getString("disease"));
    }
    System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("gender") + " | " +
                        rs.getString("disease"));
}
    

catch(Exception e){
    e.printStackTrace();
}
}

//check patient 
public void checkPatient(){
    try(Connection conn = DBConnection.getConnection()){
        System.out.println("Enter Patient Id to check :");
        int id = sc.nextInt();
        sc.nextLine();


        String query = "SELECT * FROM patients where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
                System.out.println("Patient Found:");
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Disease: " + rs.getString("disease"));
            } else {
                System.out.println("Patient not found with ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


