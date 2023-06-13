package newpack;

interface Hospital{
	public void patientname();
}

interface Medicine extends Hospital{
	public void medname();
}

class Health implements Medicine{
	public void patientname() {
		System.out.println("Suresh");
	}
	
	public void medname() {
		System.out.println("Paracetamol");
	}
}

public class InterTask {
	
	public static void main(String[] args)
	{
		Health h = new Health();
		h.patientname();
		h.medname();
	}

}
