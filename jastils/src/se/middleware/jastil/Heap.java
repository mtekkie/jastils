	package se.middleware.jastil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("info/heap")
public class Heap {
	@GET
	@Produces("application/json")
	public Object getInfo () {
		return new HeapInfo();
		
	}
}
