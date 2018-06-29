package simulator;

import eduni.simjava.Sim_system;

public class Main {

	public static void main(String[] args) {
		Sim_system.initialise();
		Source source = new Source("Source", 120.0, 40.5);
		Facede facede = new Facede("Facede", 240.0, 50.0);
		Post post = new Post("Post", 160.5, 40.0);
		Put put = new Put("Put", 160.5, 60.0);
		Get get = new Get("Get", 220.5, 30.5);
		Delete delete = new Delete("Delete", 140.5, 30.0);
		Data_base db = new Data_base("Database", 250.0, 160.0);
		Disk disk = new Disk("Disk", 340.0, 130.0);
		
		Sim_system.link_ports("Source", "Out", "Facede", "In");
		Sim_system.link_ports("Facede", "Out_post", "Post", "In");
		Sim_system.link_ports("Facede", "Out_put", "Put", "In");
		Sim_system.link_ports("Facede", "Out_get", "Get", "In");
		Sim_system.link_ports("Facede", "Out_delete", "Delete", "In");
		Sim_system.link_ports("Post", "Out", "Database", "In_post");
		Sim_system.link_ports("Put", "Out", "Database", "In_put");
		Sim_system.link_ports("Get", "Out", "Database", "In_get");
		Sim_system.link_ports("Delete", "Out", "Database", "In_delete");
		Sim_system.link_ports("Database", "Out", "Disk", "In");
		Sim_system.set_trace_detail(false, true, false);
		Sim_system.run();
		

	}

}
