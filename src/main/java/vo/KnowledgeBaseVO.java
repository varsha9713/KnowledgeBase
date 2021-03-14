package vo;

public class KnowledgeBaseVO {
	
	private long knowledgeId;
	private String knowledgeDesc;
	private String customer;
	private String supportedLanguage;
	
	public KnowledgeBaseVO() {}

	public long getKnowledgeId() {
		return knowledgeId;
	}

	public void setKnowledgeId(long knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public String getKnowledgeDesc() {
		return knowledgeDesc;
	}

	public void setKnowledgeDesc(String knowledgeDesc) {
		this.knowledgeDesc = knowledgeDesc;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getSupportedLanguage() {
		return supportedLanguage;
	}

	public void setSupportedLanguage(String supportedLanguage) {
		this.supportedLanguage = supportedLanguage;
	}
	
	

}
