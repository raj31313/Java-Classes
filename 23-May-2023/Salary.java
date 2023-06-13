package newpack;

public class Salary {

	private double basic;
	private double da;
	private double pf;
	private double gross;
	private double net;

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getDa() {
		return basic;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}

	public double getNet() {
		return net;
	}

	public void setNet(double net) {
		this.net = net;
	}

	@Override
	public String toString() {
		return "Salary [basic=" + basic + ", da=" + da + ", pf=" + pf + "]";
	}

}