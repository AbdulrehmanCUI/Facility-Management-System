import java.util.InputMismatchException;
import java.util.Scanner;
class SmartFacilities{
    protected String DeviceName;
    protected String Location;
    protected boolean Status;
    // Constructor :
        // Zero Argument
    public SmartFacilities(){
    }
        // Parameterized
    public SmartFacilities(String DeviceName, String Location, boolean Status){
        this.DeviceName = DeviceName;
        this.Location = Location;
        this.Status = Status;
    }

    // Setters
    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public void setLocation(String location) {
        Location = location;
    }
    public void setStatus(boolean Status){
        this.Status = Status;
    }

    // Getters
    public String getDeviceName() {
        return DeviceName;
    }
    public String getLocation() {
        return Location;
    }
    public boolean getStatus(){return Status;}

    public void display() {
        System.out.println("Device Name: " + DeviceName);
        System.out.println("Location: " + Location);
        System.out.println("Status: " + Status);
    }
    public void activate(){
        Status = true;
    }
    public void deactivate(){
        Status = false;
    }
}// End of Class SmartFacilites

class Projector extends SmartFacilities{

    // Zero Arg. Constructor
    public Projector(){
    }

    // Parameterized Constructor
    public Projector(String DeviceName, String Location, boolean status){
        super(DeviceName, Location, status);
    }

    // Activate
    public void activate(){
        super.activate();
        System.out.println("The Projector is presenting");
    }
    public void deactivate(){
        super.deactivate();
        System.out.println("The Projector is not presenting");
    }
} // End of Smart Facilities

class ClimateControl extends SmartFacilities{

    // Constructor
    public ClimateControl(){
    }

    public ClimateControl(String DeviceName, String Location, boolean status){
        super(DeviceName, Location, status);
    }

    // Activate
    public void activate(){
        super.activate();
        System.out.println("Maintaining Room Temperature.");
    }
    // Deactivate
    public void deactivate() {
        super.deactivate();
        System.out.println("Not Working Room Temperature.");
    }
}// End of ClimateControl

class Camera extends SmartFacilities{
    // Constructor
    public Camera(){

    }
    public Camera(String DeviceName, String Location, boolean status){
        super(DeviceName,Location,status);
    }
    // Activate
    public void activate() {
        super.activate();
        System.out.println("The camera is monitoring.");
    }

    // Deactivate
    public void deactivate() {
        super.deactivate();
        System.out.println("The camera is not monitoring.");
    }
}// End of Camera

class Management{
    protected SmartFacilities[] devices;
    public int count;

    // Constructor
    public Management(int size){
        devices = new SmartFacilities[size];
        count = 0;
    }
    public Management(){

    }

    // 1) Display method
    public void Display(){
        for(int i = 0; i < count; i++){
            System.out.println("Index: " + i);
            devices[i].display();
            System.out.println();
        }
    }
    // 2) Compare
    public void Compare(SmartFacilities d1, SmartFacilities d2){
        if(d1.getDeviceName().equals(d2.getDeviceName()) && d1.getLocation().equals(d2.getLocation())){
            System.out.println("\ntrue, They both are equal.");
        }else System.out.println("\nfalse, They both are different. \n");;
    }
    // 3) Add Device
    public void AddDevice(SmartFacilities d){
        devices[count] = d;
        count++;
    }

    // 4) Activate
    public void ActivateProjector(int i){
        if(i >= 0 && i < count){
            devices[i].activate();
        }else System.out.println("Invalid input");
    }

    public void ActivateClimateControl(int i){
        if(i >= 0 && i < count){
            devices[i].activate();
        }else System.out.println("Invalid input");
    }

    public void ActivateCamera(int i){
        if(i >= 0 && i < count){
            devices[i].activate();
        }else System.out.println("Invalid input");
    }

    // 5) Deactivate
    public void DeactivateProjector(int i){
        if(i >= 1 && i < count){
            devices[i].deactivate();
        }
    }

    public void DeactivateClimateControl(int i){
        if(i >= 1 && i < count){
            devices[i].deactivate();
        }
    }

    public void DeactivateCamera(int i){
        if(i >= 1 && i < count){
            devices[i].deactivate();
        }
    }
}// Managing Class End

public class FacilityManagement {
    public static void main(String[] args) {

        // Defining a Scanner object for input
        Scanner console = new Scanner(System.in);

        try {
            // Record book
            System.out.print("Enter the size of your record: ");
            int size = console.nextInt();
            Management m = new Management(size);

        // Projector array
        Projector[] projectors = new Projector[size / 3];

        // Climate Control Array
        ClimateControl[] climatecontrols = new ClimateControl[size / 3];

        // Camera
        Camera[] cameras = new Camera[size / 3];


        // Defining different devices
        Projector p = new Projector("Lenovo", "AB3", true);
        ClimateControl cc = new ClimateControl("Sony", "FB 2", false);
        Camera c = new Camera("Nikon", "G05", false);

        // Adding the device to the record
        m.AddDevice(p);
        m.AddDevice(cc);
        m.AddDevice(c);

        m.Compare(cc, c);

        m.Display();
        System.out.println("The ABOVE CODE WAS A TRIAL \n\n\n");
        // Welcoming message
        System.out.println("<=== Welcome to Facility Management System: ===>");
        // Looping
        boolean flag = true;
            do{
                    // Option Select
                    System.out.println("1) Press 1 to Add a new Device \n2) Press 2 to Activate a Device \n3) Press 3 to Deactivate a device \n4) Press 4 to Display the information \n5) Exit the program. \n");
                    System.out.print("Select your option: ");
                    int action = console.nextInt();

                    // Adding a device
                    if (action == 1) {
                        System.out.println("You are adding a new device...");
                        System.out.println("Which device are you adding \n1) Projector \n2) Climate Control \n3) Camera");
                        int choicename = console.nextInt();

                        // Selection to add a new Device
                        // To add a projector
                        if (choicename == 1) {
                            System.out.print("Projector Name: ");
                            String name = console.next();
                            System.out.print("Location: ");
                            String location = console.next();
                            boolean stat = false;
                            Projector p1 = new Projector(name, location, stat);
                            m.AddDevice(p1);
                            System.out.println("Device has been added...\n");
                            // To add Climate control
                        } else if (choicename == 2) {
                            System.out.print("Device Name: ");
                            String name = console.next();
                            System.out.print("Location: ");
                            String location = console.next();
                            boolean stat = false;
                            ClimateControl c1 = new ClimateControl(name, location, stat);
                            m.AddDevice(c1);
                            System.out.println("Device has been added...\n");

                            // To add a camera
                        } else if (choicename == 3) {
                            System.out.print("Device Name: ");
                            String name = console.next();
                            System.out.print("Location: ");
                            String location = console.next();
                            boolean stat = false;
                            Camera ca1 = new Camera(name, location, stat);
                            m.AddDevice(ca1);
                            System.out.println("Device has been added...\n");


                        } else System.out.println("error");
                    }

                    // Activating a device
                    else if (action == 2) {
                        // Showing all devices
                        m.Display();
                        // Asking for Index
                        System.out.print("Select the device you want to activate: ");
                        int index = console.nextInt();

                        // Activating that device
                        if (m.devices[index].Status != true) {
                            m.devices[index].activate();
                            System.out.println("Device has been activated...");
                        } else System.out.println("Device already active");


                        // Showing the current status
                        m.devices[index].getDeviceName();
                        m.devices[index].getLocation();
                        m.devices[index].getStatus();

                        // Deactivating a device
                    } else if (action == 3) {
                        // Showing all devices
                        m.Display();
                        // Asking for Index
                        System.out.print("Select the device you want to Deactivate: ");
                        int index = console.nextInt();

                        // Deactivating that device
                        if (m.devices[index].Status != false) {
                            m.devices[index].deactivate();
                            System.out.println("Device has been deactivated...");
                        } else {
                            System.out.println("The Device is already Deactivated");
                        }

                        // Showing the current status
                        m.devices[index].getDeviceName();
                        m.devices[index].getLocation();
                        m.devices[index].getStatus();
                    } else if (action == 4) {
                        System.out.println("Showing all devices...");
                        m.Display();
                    } else if (action == 5) {
                        System.out.println("Thank you for choosing this system...");
                        flag = false;
                    } else System.out.println("Error try again");
                }while(flag != false);

        }catch (InputMismatchException inp){
            System.out.println(inp);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}// End of Main class