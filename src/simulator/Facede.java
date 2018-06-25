package simulator;

import eduni.simjava.Sim_entity;

import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_system;
import eduni.simjava.distributions.*;

public class Facede extends Sim_entity{
	
	private Sim_normal_obj delay;
	private Sim_port in, out_post, out_put, out_get, out_delete;
	public Facede(String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
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
		add_generator(delay);
	}
	
	public void body() {
		while(Sim_system.running()) {
			Sim_event e = new Sim_event();
			sim_get_next(e);
			sim_process(delay.sample());
			sim_completed(e);
		}
	}

}
