package simulator;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_stat;
import eduni.simjava.Sim_system;
import eduni.simjava.distributions.Sim_normal_obj;

public class Put extends Sim_entity{

	private Sim_normal_obj delay;
	private Sim_port in, out;
	private Sim_stat stat;

	public Put(String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
		in = new Sim_port("In");
		out = new Sim_port("Out");
		add_port(in);
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
		while (Sim_system.running()) {
			Sim_event e = new Sim_event();
			sim_get_next(e);
			sim_process(delay.sample());
			sim_trace(1, "Sending put request to Database");
			sim_schedule(out, 0.0, 0);
		}
	}

}
