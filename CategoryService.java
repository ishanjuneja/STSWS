package com.yash.documentManagementSimulator.dao;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

import com.yash.documentManagementSimulator.dao.CategoryDAO;

public class CategoryService implements Serializable
{
	CategoryDAO cdao =new CategoryDAO();
	
	
	public void createCategory(String name,String section,boolean status)
	{
		int ai=cdao.getid();
		cdao.createCategory(ai,name,section,status); 
		
		
		
		
	//	ctgId++;
		//cdao.createCategory(ctgId,name,status);
		
		
	}
	public void editCategoryName(String UniqueCtgId,String newCatName)
	{
		
		
			
			cdao.editCategoryName(UniqueCtgId, newCatName);
		
		
	}
	public void editCategoryStatus(String UniqueCtgId,boolean feed)
	{
		
		
		
			cdao.editCategoryStatus(UniqueCtgId, feed);
		
	}
	public void deleteCategory(String filename)
	{
		
		cdao.deleteCategory(filename);
		
	}
	public void searchCategory()
	{
		
	}
	public void showAllAvailableCategories()
	{
		cdao.showAllAvailableCategories();
	}
	public void showActiveCategories()
	{
		cdao.showActiveCategories();
	}
	public void showNonActiveCategories()
	{
		cdao.showNonActiveCategories();
		
	}

}
