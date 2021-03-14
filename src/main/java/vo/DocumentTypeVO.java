package vo;

public class DocumentTypeVO {
	
	
	private long knowledgeId;
	private long documentTypeId;
	private String docType;
	private String column1Name;
	private String column2Name;

	public DocumentTypeVO() {}

	public long getKnowledgeId() {
		return knowledgeId;
	}

	public void setKnowledgeId(long knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public long getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getColumn1Name() {
		return column1Name;
	}

	public void setColumn1Name(String column1Name) {
		this.column1Name = column1Name;
	}

	public String getColumn2Name() {
		return column2Name;
	}

	public void setColumn2Name(String column2Name) {
		this.column2Name = column2Name;
	}
	
	
}
