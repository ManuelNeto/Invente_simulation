package simulator;
import eduni.simjava.*;
import eduni.simjava.distributions.*;

public class Disk extends Sim_entity{

	private Sim_normal_obj delay;
	private Sim_port in, out;
	public Disk(String name, double mean, double var) {
		super(name);
		this.delay = new Sim_normal_obj("Delay", mean, var);
		in = new Sim_port("In");
		out = new Sim_port("Out");
		add_port(in);
		add_port(out);
		add_generator(delay);
	}
	
	public void body() {
        while (Sim_system.running()) {
          Sim_event e = new Sim_event();
          sim_get_next(e);
          sim_process(delay.sample());
          sim_completed(e);
        }
      }
	
}
