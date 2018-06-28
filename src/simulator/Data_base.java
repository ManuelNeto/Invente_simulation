package simulator;

import eduni.simjava.Sim_entity;
import eduni.simjava.Sim_port;
import eduni.simjava.Sim_stat;
import eduni.simjava.distributions.*;

public class Data_base extends Sim_entity {
	
	private Sim_normal_obj delay;
	private Sim_port in_post, in_put, in_get, in_delete, out;
	private Sim_stat stat;
	
	public Data_base (String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
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
		stat = new Sim_stat();
		stat.add_measure(Sim_stat.UTILISATION);
		stat.add_measure(Sim_stat.WAITING_TIME);
		stat.add_measure(Sim_stat.QUEUE_LENGTH);
		
	}

}
