package simulator;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;

public class Get extends Sim_entity{

	private double delay;
	private Sim_port in, out;
	public Get(String name, double delay) {
		super(name);
		this.delay = delay;
		in= new Sim_port("In");
		out = new Sim_port("Out");
		add_port(in);
		add_port(out);
	}

}
