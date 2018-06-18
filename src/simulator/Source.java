package simulator;

import eduni.simjava.*;  

public class Source extends Sim_entity{
	
	private double delay;
	private Sim_port out;
	
	public Source(String name, double delay) {
		super(name);
		this.delay = delay;
		out = new Sim_port("Out");
		add_port(out);
	}
}
