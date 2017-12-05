package com.yash.documentManagementSimulator.dao;
//import org.apache.commons.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.prefs.Preferences;


import com.yash.documentManagementSimulator.registration.Category;
import com.yash.documentManagementSimulator.registration.Trainer;



    public class CategoryDAO implements Serializable
    {
    private Preferences prefs1;
    private static final String AI_SETTING_ID = "autoincrement";
    
    public int getid() 
    {
       prefs1 = Preferences.userRoot().node(this.getClass().getName());
       AtomicInteger autoincCtg = new AtomicInteger(prefs1.getInt(AI_SETTING_ID, 100));
       int b=  autoincCtg.incrementAndGet();
       prefs1.putInt(AI_SETTING_ID, autoincCtg.get());
       return b;
    }
	
	
	
	
	
	public void createCategory(int ctgId,String ctgName,String ctgSection, boolean ctg_status)
	  {
        String filename="CATG"+ctgId;
		try
		{
		File file=new File("D:\\documentManagementSimulator\\category\\"+filename+".txt");	
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Category cat=new Category(filename,ctgName,ctgSection,ctg_status);
		oos.writeObject(cat);
		System.out.println("category  Added !");
		System.out.println("The unique id "+filename);
		oos.close();
		}catch(Exception e){
		e.printStackTrace();
	 } 
	 }
	 
	 	
		
		
	
	public void editCategoryName(String UniqueCtgId,String newCatName)
	{
        String filename=UniqueCtgId;
        filename=filename.toUpperCase();
        String catName;
        boolean catStatus=true; 
        String ctgSection="";
        Category category;
    	
        try
        {
        File file1=new File("D:\\documentManagementSimulator\\category\\"+filename+".txt");	
		FileInputStream fis2=new FileInputStream(file1);
		ObjectInputStream ois2=new ObjectInputStream(fis2);
		category = (Category) ois2.readObject();
		catStatus=category.getCategoryStatus();
 		catName=category.getCategoryName();	
 		 ctgSection=category.getCategorySection();
		/*
		Trainer[] tra1=new Trainer[2];
			for(int i=0;i<2;i++)
		{
		tra1[i]=trainer;
		System.out.println("the id of the trainer is "+tra1[i].getTrainerId());
		}
		*/
		ois2.close();
		}catch(FileNotFoundException fnfe)
		 {
			System.out.println("file not found");
		 }
		 catch(Exception e){
			 e.printStackTrace();
	     	 }
               File file=new File("D:\\documentManagementSimulator\\category\\"+filename+".txt");	
		      boolean bool = false;
		      try {
                 bool = file.delete();
		         System.out.println("File deletion progress : "+bool);
		         System.out.println("category  updated !");
		         //System.out.println("File deleted: "+bool);
				FileOutputStream fos1=new FileOutputStream(file);
				ObjectOutputStream oos1=new ObjectOutputStream(fos1);
				Category cat=new Category(filename,newCatName,ctgSection,catStatus);
				oos1.writeObject(cat);
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
	}// ends 
	
	
	public void editCategoryStatus(String UniqueCtgId,boolean newCatStatus)
	{

        String filename=UniqueCtgId;
        filename=filename.toUpperCase();
        //
        String catName="";
        boolean catOldStatus; 
        String ctgSection="";

        Category category1;
    	try{
        File file1=new File("D:\\documentManagementSimulator\\category\\"+filename+".txt");	
		FileInputStream fis2=new FileInputStream(file1);
		ObjectInputStream ois2=new ObjectInputStream(fis2);
		category1 = (Category) ois2.readObject();
		catOldStatus=category1.getCategoryStatus();
 		catName=category1.getCategoryName();	
         ctgSection=category1.getCategorySection();

 		ois2.close();
		}catch(FileNotFoundException fnfe)
		 {
		System.out.println("file not found");
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
        File file=new File("D:\\documentManagementSimulator\\category\\"+filename+".txt");	
		      boolean bool = false;
		      
		      try {
                 
		       
		         bool = file.delete();
		         
		         // prints
		         System.out.println("old File deletion progress : "+bool);
		         				
				
				FileOutputStream fos1=new FileOutputStream(file);
				ObjectOutputStream oos1=new ObjectOutputStream(fos1);
				Category cat=new Category(filename,catName,ctgSection,newCatStatus);
		        oos1.writeObject(cat);
	          
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
		      System.out.println("category  updated !");

	}
	
	public void deleteCategory(String filename)
	{
		
	     filename=filename.toUpperCase();   
		
	      
	      try {
	    	  File file=new File("D:\\documentManagementSimulator\\category\\"+filename+".txt");	
		      boolean bool = false;   
	         bool = file.delete();
	         
             if(bool==true)System.out.println(" Old File deleted ");	        
          else System.out.println("  File not  deleted ");	        
       	         
	      }
	          catch(Exception fnfe)
	          {
	        	  System.out.println("Invalid catg id file not found");
	          
	          }
	          
	}
	
	public void searchCategory()
	{
		
	}
	public void showAllAvailableCategories()
	{
		int count=0;
		File folder = new File("D:\\documentManagementSimulator\\category\\");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile() && file.getName().endsWith(".txt")) {
		    try {
		    	Category category3; 
		    	FileInputStream fis2=new FileInputStream(file);
				ObjectInputStream ois2=new ObjectInputStream(fis2);
				category3 = (Category) ois2.readObject();
				System.out.println("the status of category :"+category3.getCategoryStatus()); //boolean displayCatOldStatus=category3.getCategoryStatus();
		 		System.out.println("the category name  :"+category3.getCategoryName());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category Id    :"+category3.getCategoryId());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category Id    :"+category3.getCategorySection());//String displayCatName=category3.getCategoryName();	
		 		
				ois2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}catch(Exception e)
			{
				System.out.println("Error!!!");
				
			}
		    /* do somthing with content */
		  count++;
		  }// if ends  

		  
		}// for ends
		if(count==0) System.out.println("No Categories Found");

	}
	public void showActiveCategories()
	{
        int count=0;
		File folder = new File("D:\\documentManagementSimulator\\category\\");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile() && file.getName().endsWith(".txt")) {
		    try {
		    	Category category3; 
		    	FileInputStream fis2=new FileInputStream(file);
				ObjectInputStream ois2=new ObjectInputStream(fis2);
				category3 = (Category) ois2.readObject();
			
				if(category3.getCategoryStatus()==true)
				{//boolean displayCatOldStatus=category3.getCategoryStatus();
		 		System.out.println("the category name  :"+category3.getCategoryName());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category Id    :"+category3.getCategoryId());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category section    :"+category3.getCategorySection());//String displayCatName=category3.getCategoryName();	
			 	}
				ois2.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}catch(Exception e)
			{
				System.out.println("Error!!!");
				
			}
		    /* do somthing with content */
		  count++;
		  }//if ends
		  
		}// for ends
	
		if(count==0) System.out.println("ActiveCategories does not exist");

	}
	
	public void showNonActiveCategories()
	{
		File folder = new File("D:\\documentManagementSimulator\\category\\");
		File[] listOfFiles = folder.listFiles();
        int count=0;
		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile() && file.getName().endsWith(".txt")) {
		    try {
		    	Category category3; 
		    	FileInputStream fis2=new FileInputStream(file);
				ObjectInputStream ois2=new ObjectInputStream(fis2);
				category3 = (Category) ois2.readObject();
			
				if(category3.getCategoryStatus()==false)
				{//boolean displayCatOldStatus=category3.getCategoryStatus();
		 		System.out.println("the category name  :"+category3.getCategoryName());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category Id    :"+category3.getCategoryId());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category section    :"+category3.getCategorySection());//String displayCatName=category3.getCategoryName();
				}
				ois2.close();
			} catch (IOException e) {
					e.printStackTrace();
			}catch(Exception e)
			{
				System.out.println("Error!!!");
				
			}
		    /* do somthing with content */
		    count++;

		  }// if ends
				}// for ends
		if(count==0) System.out.println("NonActiveCategories does not exist");
		
		
	}

}
