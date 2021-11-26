package activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Plane plane = new Plane(10);
		plane.onboard("John");
        plane.onboard("Steve");
        plane.onboard("Anna");
        
        System.out.println("Plane took off at: " + plane.takeOff());
        //Print list of people on board
        System.out.println("People on the plane: " + plane.getPassengers());
        
        Thread.sleep(5000);
        //Plane has landed
        plane.land();
        
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
	}

}
