package vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryVO {
	
	
	private long categoryId;
	
	private long knowledgeId;
	
	@NotNull(message = "categoryName cannot be null")
	@Size(min = 5,max = 59, message = "Cannot exceed 59 characters.")
	private String categoryName;
	
	public CategoryVO() {		
	}


	public long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	public long getKnowledgeId() {
		return knowledgeId;
	}


	public void setKnowledgeId(long knowledgeId) {
		this.knowledgeId = knowledgeId;
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	

}
