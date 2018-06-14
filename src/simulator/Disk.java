package simulator;
import eduni.simjava.*;

public class Disk extends Sim_entity{

	private double delay;
	public Disk(String name, double delay) {
		super(name);
		this.delay = delay;
	}
	
}
