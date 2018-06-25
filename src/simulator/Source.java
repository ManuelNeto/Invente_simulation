package simulator;

import eduni.simjava.*;
import eduni.simjava.distributions.*;  

public class Source extends Sim_entity{
	
	private Sim_negexp_obj delay;
	private Sim_port out;
	
	public Source(String name, double mean) {
		super(name);
		this.delay = new Sim_negexp_obj("Delay", mean);
		out = new Sim_port("Out");
		add_port(out);
		add_generator(delay);
	}
	
	public void body() {
		for (int i=0; i<100; i++) {
			sim_schedule(out, 0.0, 0);
			sim_pause(delay.sample());
		}
	}
}
