package simulator;
import eduni.simjava.*;

public class Disk extends Sim_entity{

	private double delay;
	private Sim_port in, out;
	public Disk(String name, double delay) {
		super(name);
		this.delay = delay;
		in = new Sim_port("In");
		out = new Sim_port("Out");
		add_port(in);
		add_port(out);
	}
	
}
