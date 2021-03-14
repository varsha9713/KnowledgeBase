package dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import dao.KnowledgeDAO;
import exception.CategoryException;
import exception.KnowledgeBaseException;
import vo.CategoryVO;
import vo.KnowledgeBaseVO;

public class KnowledgeDAOImpl implements KnowledgeDAO {
	
	private Gson gson=new Gson();

	@Override
	public KnowledgeBaseVO getKnowledgeBase(String knowledgeId) throws KnowledgeBaseException {

		KnowledgeBaseVO data = null;

			 JsonReader reader;
			try {
				reader = new JsonReader(new FileReader("C:\\Temp\\KnowledgeBase.json"));
				reader.setLenient(true);
				data = gson.fromJson(reader, List.class);

			} catch (FileNotFoundException e) {
				throw new KnowledgeBaseException("Get operation not successful");
			}
		 
		return data;
	}

	@Override
	public void addKnowledgeBase(KnowledgeBaseVO knowledgeBaseVO) throws KnowledgeBaseException {
		try {
			JsonReader reader = new JsonReader(new FileReader("C:\\Temp\\KnowledgeBase.json"));
	    	reader.setLenient(true);
	    	List<KnowledgeBaseVO> data = gson.fromJson(reader, List.class);
	    	
	    	data.add(knowledgeBaseVO);
	    	String json = gson.toJson(data);
	    	
	    	FileWriter myWriter = new FileWriter("C:\\Temp\\KnowledgeBase.json");
	    	myWriter.write(json);
	        myWriter.close();
			
		}catch(FileNotFoundException e) {
			throw new KnowledgeBaseException("File not found");
		} catch (IOException e) {
			throw new KnowledgeBaseException("Error while writing");
		}
		
	}

	@Override
	public void updateKnowledgeBase(KnowledgeBaseVO knowledgeBaseVO) throws KnowledgeBaseException {
		boolean isFound=false;
		try {
			JsonReader reader = new JsonReader(new FileReader("C:\\Temp\\KnowledgeBase.json"));
	    	reader.setLenient(true);
	    	List<KnowledgeBaseVO> data = gson.fromJson(reader, List.class);
	    	
	    	for(KnowledgeBaseVO c : data)
	    		if(c.getKnowledgeId() == knowledgeBaseVO.getKnowledgeId()) {
	    			data.add(knowledgeBaseVO);
	    	    	String json = gson.toJson(data);
	    	    	
	    	    	FileWriter myWriter = new FileWriter("C:\\Temp\\KnowledgeBase.json");
	    	    	myWriter.write(json);
	    	        myWriter.close();
	    	        isFound=true;
	    		}
	    	
	    	if(!isFound)
	    		throw new KnowledgeBaseException("Record not found");
	    	
			
		}catch(FileNotFoundException e) {
			throw new KnowledgeBaseException("File not found");
		} catch (IOException e) {
			throw new KnowledgeBaseException("Error while writing");
		}
		
	}

}
