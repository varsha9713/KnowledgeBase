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

import dao.KnowledgeDAO;
import exception.CategoryException;
import exception.KnowledgeBaseException;
import vo.CategoryVO;
import vo.KnowledgeBaseVO;


@Path("knowledgeBase")
@Produces(MediaType.APPLICATION_JSON)
public class KnowledgeResourceV1 {
	
	@Inject
	KnowledgeDAO knowledgeDao;
	
	
	@GET
	@Path("{knowledgeId}")
	public Response getKnowledge(@PathParam("knowledgeId") String knowledgeId) {
		
		if(null == knowledgeId || knowledgeId.isEmpty())
			throw new RuntimeException("knowledgeId cannot be null");
		
		KnowledgeBaseVO knowledgeBaseVO = null;
		try {
			knowledgeBaseVO = knowledgeDao.getKnowledgeBase(knowledgeId);
		} catch (KnowledgeBaseException e) {
			throw new RuntimeException("Get operation failed");
		}
				
		return Response.ok().entity(knowledgeBaseVO).build();		
	}
	
	
	@POST
	@Path("add")
	public Response addCategories(@Valid KnowledgeBaseVO knowledgeVO) {
		
		try {
			knowledgeDao.addKnowledgeBase(knowledgeVO);
		} catch ( KnowledgeBaseException e) {
			throw new RuntimeException("Add failed");
		}
		
		return Response.ok().build();
	}
	
	@POST
	@Path("{id}")
	public Response updateCategories(@PathParam("knowledgeId") String knowledgeId,@Valid KnowledgeBaseVO knowledgeVO) {
	
		if(null == knowledgeId || knowledgeId.isEmpty())
			throw new RuntimeException("CategoryId cannot be null");
		
		try {
			
			knowledgeDao.updateKnowledgeBase(knowledgeVO);
		} catch ( KnowledgeBaseException e) {
			throw new RuntimeException("Update failed");
		}
				
		return Response.ok().build();	
	} 

}
