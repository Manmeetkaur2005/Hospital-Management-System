import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();

        while (true) {
            System.out.println("\n========= Hospital Management System =========");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Check Doctor");
            System.out.println("4. Add Patient");
            System.out.println("5. View Patients");
            System.out.println("6. Check Patient");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    doctorService.addDoctor();
                    break;
                case 2:
                    doctorService.viewDoctors();
                    break;
                case 3:
                    doctorService.checkDoctor();
                    break;
                case 4:
                    patientService.addPatient();
                    break;
                case 5:
                    patientService.viewPatients();
                    break;
                case 6:
                    patientService.checkPatient();
                    break;
                case 7:
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
