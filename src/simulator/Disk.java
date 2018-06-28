package simulator;
import eduni.simjava.*;
import eduni.simjava.distributions.*;

public class Disk extends Sim_entity{

	private Sim_normal_obj delay;
	private Sim_port in, out;
	private Sim_stat stat;
	public Disk(String name, double mean, double var) {
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
		set_stat(stat);
	}
	
	public void body() {
        while (Sim_system.running()) {
          Sim_event e = new Sim_event();
          sim_get_next(e);
          sim_trace(1, "Disk requested started");
          sim_process(delay.sample());
          sim_completed(e);
        }
      }
	
}
