package simulator;

import eduni.simjava.Sim_entity;


import eduni.simjava.Sim_event;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_stat;
import eduni.simjava.Sim_system;
import eduni.simjava.distributions.*;

public class Facede extends Sim_entity{
	
	private Sim_normal_obj delay;
	private Sim_random_obj prob;
	private Sim_port in, out_post, out_put, out_get, out_delete;
	private Sim_stat stat;
	
	public Facede(String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
		this.prob = new Sim_random_obj("Probability");
		// Port for receive events from Source
		in = new Sim_port("In");
		// Port for send events to Post
		out_post = new Sim_port("Out_post");
		// Port for send events to Put
		out_put = new Sim_port("Out_put");
		// Port for send events to Get
		out_get = new Sim_port("Out_get");
		// Port for send events to Delete
		out_delete = new Sim_port("Out_delete");
		add_port(in);
		add_port(out_post);
		add_port(out_put);
		add_port(out_get);
		add_port(out_delete);
		add_generator(delay);
		add_generator(prob);
		stat = new Sim_stat();
		stat.add_measure(Sim_stat.UTILISATION);
		stat.add_measure(Sim_stat.WAITING_TIME);
		stat.add_measure(Sim_stat.QUEUE_LENGTH);
		stat.add_measure(Sim_stat.ARRIVAL_RATE);
		stat.add_measure(Sim_stat.RESIDENCE_TIME);
		set_stat(stat);
	}
	
	public void body() {
		while(Sim_system.running()) {
			Sim_event e = new Sim_event();
			// Get the next event
			sim_get_next(e);
			// Process the event
			sim_process(delay.sample());
			sim_completed(e);
			double p = prob.sample();
			// 30% of the jobs will be sent to Post
			if (p < 0.30) {
				sim_trace(1, "Post request");
				sim_schedule(out_post, 0.0, 1);
			// 20% of the jobs will be sent to Put
			} else if (p < 0.50) {
				sim_trace(1, "Put request");
				sim_schedule(out_put, 0.0, 1);
			// 40% of the jobs will be sent to Get
			} else if (p < 0.90) {
				sim_trace(1, "Get request");
				sim_schedule(out_get, 0.0, 1);
			// 10% of the jobs will be sent t Delete
			} else {
				sim_trace(1, "Delete request");
				sim_schedule(out_delete, 0.0, 1);
			}
		}
	}

}
