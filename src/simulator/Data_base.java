package simulator;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_stat;
import eduni.simjava.Sim_system;
import eduni.simjava.distributions.*;

public class Data_base extends Sim_entity {
	
	private Sim_normal_obj delay;
	private Sim_port in_post, in_put, in_get, in_delete, out;
	private Sim_stat stat;
	
	public Data_base (String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
		// Port for receive events from Post
		in_post = new Sim_port("In_post");
		// Port for receive events from Put
		in_put = new Sim_port("In_put");
		// Port for receive events from Get
		in_get = new Sim_port("In_get");
		// Port for receive events from Delete
		in_delete = new Sim_port("In_delete");
		// Port for send events to Disk
		out = new Sim_port("Out");
		add_port(in_post);
		add_port(in_put);
		add_port(in_get);
		add_port(in_delete);
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
			sim_trace(1, "Disk select for I/O work.");
			// I/O jobs go to Disk
			sim_schedule(out, 0.0, 0);
			
		}
	}
}
