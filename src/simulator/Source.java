package simulator;

import eduni.simjava.*;  

public class Source extends Sim_entity{
	
	private double delay;
	public Source(String name, double delay) {
		super(name);
		this.delay = delay;
	}

}
