package lu.its4u.demo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("hello")
public class ApiService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHello(@Context SecurityContext securityContext) {
		if (securityContext != null && securityContext.getUserPrincipal() != null) {
			String name = securityContext.getUserPrincipal().getName();
			return Response.ok("Hello " + name).build();
		}
		return Response.ok("Hello World !").build();
	}
}
