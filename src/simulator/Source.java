package simulator;

import eduni.simjava.*;

import eduni.simjava.distributions.*;  

public class Source extends Sim_entity{
	
	private Sim_normal_obj delay;
	private Sim_port out;
	private Sim_stat stat;
	
	public Source(String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
		out = new Sim_port("Out");
		add_port(out);
		add_generator(delay);
		stat = new Sim_stat();
		stat.add_measure(Sim_stat.UTILISATION);
		stat.add_measure(Sim_stat.WAITING_TIME);
		stat.add_measure(Sim_stat.QUEUE_LENGTH);
		stat.add_measure(Sim_stat.ARRIVAL_RATE);
		stat.add_measure(Sim_stat.RESIDENCE_TIME);
		set_stat(stat);
	}
	
	public void body() {
		for (int i=0; i<100; i++) {
			sim_trace(1,"Sending requests to Facede.");
			sim_schedule(out, 0.0, 0);
			sim_pause(delay.sample());
		}
	}
}
