package application;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import dao.CategoryDAO;
import dao.impl.CategoryDAOImpl;

public class CommonBinder extends AbstractBinder{

	@Override
	protected void configure() {
		bind(new CategoryDAOImpl()).to(CategoryDAO.class);
		
	}

}
