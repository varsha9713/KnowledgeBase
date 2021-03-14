package dao;

import java.util.List;

import exception.CategoryException;
import vo.CategoryVO;

public interface CategoryDAO {
	
	public List<CategoryVO> getCategory(String knowledgeId) throws CategoryException;
	
	public void addCategory(CategoryVO category) throws CategoryException;
	
	public void updateCategory(CategoryVO categoryVO) throws CategoryException;	

}
