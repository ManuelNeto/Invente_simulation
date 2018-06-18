package simulator;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;

public class Facede extends Sim_entity{
	
	private double delay;
	private Sim_port in, out_post, out_put, out_get, out_delete;
	public Facede(String name, double delay) {
		super(name);
		this.delay = delay;
		in = new Sim_port("In");
		out_post = new Sim_port("Out_post");
		out_put = new Sim_port("Out_put");
		out_get = new Sim_port("Out_get");
		out_delete = new Sim_port("Out_delete");
		add_port(in);
		add_port(out_post);
		add_port(out_put);
		add_port(out_get);
		add_port(out_delete);
	}

}
