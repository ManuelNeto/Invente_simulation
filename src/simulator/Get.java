package simulator;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.distributions.Sim_normal_obj;

public class Get extends Sim_entity{

	private Sim_normal_obj delay;
	private Sim_port in, out;
	public Get(String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
		in= new Sim_port("In");
		out = new Sim_port("Out");
		add_port(in);
		add_port(out);
		add_generator(delay);
	}

}
