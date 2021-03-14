package resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.CategoryDAO;
import exception.CategoryException;
import vo.CategoryVO;

@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResourceV1 {
	
	
	@Inject
	CategoryDAO categoryDAO;
	
	
	@GET
	@Path("{knowledgeId}")
	public Response getCategories(@PathParam("knowledgeId") String knowledgeId) {
		
		if(null == knowledgeId || knowledgeId.isEmpty())
			throw new RuntimeException("knowledgeId cannot be null");
		
		List<CategoryVO> categoryVOList = null;
		try {
			categoryVOList = categoryDAO.getCategory(knowledgeId);
		} catch (CategoryException e) {
			throw new RuntimeException("Get operation failed");
		}
				
		return Response.ok().entity(categoryVOList).build();		
	}
	
	
	@POST
	@Path("add/{knowledgeId}")
	public Response addCategories(@PathParam("knowledgeId") String knowledgeId, @Valid CategoryVO categoryVO) {
		
		try {
			categoryDAO.addCategory(categoryVO);
		} catch (CategoryException e) {
			throw new RuntimeException("Add failed");
		}
		
		return Response.ok().build();
	}
	
	@POST
	@Path("{id}")
	public Response updateCategories(@PathParam("categoryId") String categoryId,@Valid CategoryVO categoryVO) {
	
		if(null == categoryId || categoryId.isEmpty())
			throw new RuntimeException("CategoryId cannot be null");
		
		try {
			
			categoryDAO.updateCategory(categoryVO);
		} catch (CategoryException e) {
			throw new RuntimeException("Update failed");
		}
				
		return Response.ok().build();	
	}

}
