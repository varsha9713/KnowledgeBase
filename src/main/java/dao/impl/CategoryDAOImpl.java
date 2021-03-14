package dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import dao.CategoryDAO;
import exception.CategoryException;
import vo.CategoryVO;

public class CategoryDAOImpl implements CategoryDAO{
	
	Gson gson=new Gson();
	
	public CategoryDAOImpl() {}

	@Override
	public List<CategoryVO> getCategory(String knowledgeId) throws CategoryException {
		
		List<CategoryVO> data = null;

			 JsonReader reader;
			try {
				reader = new JsonReader(new FileReader("C:\\Temp\\Categories.json"));
				reader.setLenient(true);
				data = gson.fromJson(reader, List.class);

			} catch (FileNotFoundException e) {
				throw new CategoryException("File not found");
			}
		 
		return data;
	}

	@Override
	public void addCategory(CategoryVO category) throws CategoryException {
		try {
			JsonReader reader = new JsonReader(new FileReader("C:\\Temp\\Categories.json"));
	    	reader.setLenient(true);
	    	List<CategoryVO> data = gson.fromJson(reader, List.class);
	    	
	    	for(CategoryVO c : data)
	    		if(c.getCategoryId() == category.getCategoryId())
	    			throw new CategoryException("Record already exists");
	    	
	    	data.add(category);
	    	String json = gson.toJson(data);
	    	
	    	FileWriter myWriter = new FileWriter("C:\\Temp\\Categories.json");
	    	myWriter.write(json);
	        myWriter.close();
			
		}catch(FileNotFoundException e) {
			throw new CategoryException("File not found");
		} catch (IOException e) {
			throw new CategoryException("Error while writing");
		}
        
	}

	@Override
	public void updateCategory(CategoryVO categoryVO) throws CategoryException{
		boolean isFound=false;
		try {
			JsonReader reader = new JsonReader(new FileReader("C:\\Temp\\Categories.json"));
	    	reader.setLenient(true);
	    	List<CategoryVO> data = gson.fromJson(reader, List.class);
	    	
	    	for(CategoryVO c : data)
	    		if(c.getCategoryId() == categoryVO.getCategoryId()) {
	    			data.add(categoryVO);
	    	    	String json = gson.toJson(data);
	    	    	
	    	    	FileWriter myWriter = new FileWriter("C:\\Temp\\Categories.json");
	    	    	myWriter.write(json);
	    	        myWriter.close();
	    	        isFound=true;
	    		}
	    	
	    	if(!isFound)
	    		throw new CategoryException("Record not found");
	    	
			
		}catch(FileNotFoundException e) {
			throw new CategoryException("File not found");
		} catch (IOException e) {
			throw new CategoryException("Error while writing");
		}
	}

}
