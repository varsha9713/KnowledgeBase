package dao;

import java.util.List;

import exception.KnowledgeBaseException;
import vo.KnowledgeBaseVO;

public interface KnowledgeDAO {

	public KnowledgeBaseVO getKnowledgeBase(String knowledgeId) throws KnowledgeBaseException;
	
	public void addKnowledgeBase(KnowledgeBaseVO knowledgeBaseVO) throws KnowledgeBaseException;
	
	public void updateKnowledgeBase(KnowledgeBaseVO knowledgeBaseVO) throws KnowledgeBaseException;	


}
