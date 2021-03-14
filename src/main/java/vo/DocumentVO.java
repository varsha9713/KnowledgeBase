package vo;

public class DocumentVO {

	private long knowledgeId;
	private long documentId;
	private long documentTypeId;
	private String column1;
	private String column2;
	
	public DocumentVO() {}
	
	public long getKnowledgeId() {
		return knowledgeId;
	}
	public void setKnowledgeId(long knowledgeId) {
		this.knowledgeId = knowledgeId;
	}
	public long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}
	public long getDocumentTypeId() {
		return documentTypeId;
	}
	public void setDocumentTypeId(long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	
	
	
}
