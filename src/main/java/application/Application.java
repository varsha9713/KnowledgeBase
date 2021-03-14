package application;

import org.glassfish.jersey.server.ResourceConfig;

import resource.CategoryResourceV1;

public class Application extends ResourceConfig{

	public Application() {
		register(CategoryResourceV1.class);
		register(new CommonBinder());
	}
}
