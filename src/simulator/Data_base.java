package simulator;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.distributions.*;

public class Data_base extends Sim_entity {
	
	private Sim_poisson_obj delay;
	private Sim_port in_post, in_put, in_get, in_delete, out;
	
	public Data_base (String name, double mean) {
		super(name);
		this.delay = new Sim_poisson_obj("Delay", mean);
		in_post = new Sim_port("In_post");
		in_put = new Sim_port("In_put");
		in_get = new Sim_port("In_get");
		in_delete = new Sim_port("In_delete");
		out = new Sim_port("Out");
		add_port(in_post);
		add_port(in_put);
		add_port(in_get);
		add_port(in_delete);
		add_port(out);
		add_generator(delay);
	}

}
