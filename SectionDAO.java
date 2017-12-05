package com.yash.documentManagementSimulator.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.prefs.Preferences;

import com.yash.documentManagementSimulator.registration.*;

public class SectionDAO implements Serializable {
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

	
	public void createSection(int sectionId,String sectionName, boolean sectionstatus)
	  {
        String filename="CATG"+sectionId;
		try
		{
		File file=new File("D:\\documentManagementSimulator\\section\\"+filename+".txt");	
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Section  sec=new Section(filename,sectionName,sectionstatus);
		oos.writeObject(sec);
		System.out.println("section  Added !");
		System.out.println("The unique id "+filename);
		oos.close();
		}catch(Exception e){
		e.printStackTrace();
	  
	  
	}
}
	public void editSectionName(String UniqueCtgId,String newSecName)
	{
        String filename=UniqueCtgId;
        filename=filename.toUpperCase();
       // String catName;
        boolean secStatus=true; 
       
        Section section;
    	
        try
        {
        File file1=new File("D:\\documentManagementSimulator\\section\\"+filename+".txt");	
		FileInputStream fis2=new FileInputStream(file1);
		ObjectInputStream ois2=new ObjectInputStream(fis2);
		section = (Section) ois2.readObject();
		secStatus=section.isSectionStatus();
 		//catName=section.getSectionName();	
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
               File file=new File("D:\\documentManagementSimulator\\section\\"+filename+".txt");	
		      boolean bool = false;
		      try {
                 bool = file.delete();
		         System.out.println("File deletion progress : "+bool);
		         System.out.println("section  updated !");
		         //System.out.println("File deleted: "+bool);
				FileOutputStream fos1=new FileOutputStream(file);
				ObjectOutputStream oos1=new ObjectOutputStream(fos1);
				Section cat=new Section(filename,newSecName,secStatus);
				oos1.writeObject(cat);
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
	}
	public void editSectionStatus(String UniqueCtgId,boolean newSecStatus)
	{
        String filename=UniqueCtgId;
        filename=filename.toUpperCase();
        String secName="";
        //boolean secStatus=true; 
       
        Section section;
    	
        try
        {
        File file1=new File("D:\\documentManagementSimulator\\section\\"+filename+".txt");	
		FileInputStream fis2=new FileInputStream(file1);
		ObjectInputStream ois2=new ObjectInputStream(fis2);
		section = (Section) ois2.readObject();
		//secStatus=section.isSectionStatus();
 		secName=section.getSectionName();	
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
               File file=new File("D:\\documentManagementSimulator\\section\\"+filename+".txt");	
		      boolean bool = false;
		      try {
                 bool = file.delete();
		         System.out.println("File deletion progress : "+bool);
		         System.out.println("section  updated !");
		         //System.out.println("File deleted: "+bool);
				FileOutputStream fos1=new FileOutputStream(file);
				ObjectOutputStream oos1=new ObjectOutputStream(fos1);
				Section cat=new Section(filename,secName,newSecStatus);
				oos1.writeObject(cat);
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
	}
	
	public void deleteSection(String UniqueSecId)
	{
        String filename=UniqueSecId;
        filename=filename.toUpperCase();
        String sectionName="";
       
        Section section;
    	
        try {
               File file=new File("D:\\documentManagementSimulator\\section\\"+filename+".txt");	
               FileInputStream fis2=new FileInputStream(file);
       		ObjectInputStream ois2=new ObjectInputStream(fis2);
       		section = (Section) ois2.readObject();
       		sectionName=section.getSectionName();
               boolean bool = false;
		      
                 bool = file.delete();
		         System.out.println("File deletion progress : "+bool);
		 		int count=0;
				File folder = new File("D:\\documentManagementSimulator\\category\\");
				File[] listOfFiles = folder.listFiles();

				for (int i = 0; i < listOfFiles.length; i++) {
				  File file4 = listOfFiles[i];
				  if (file4.isFile() && file4.getName().endsWith(".txt")) {
				    try {
				    	Category category3; 
				    	FileInputStream fis4=new FileInputStream(file4);
						ObjectInputStream ois4=new ObjectInputStream(fis4);
						category3 = (Category) ois2.readObject();
						if(category3.getCategorySection().equalsIgnoreCase(sectionName))
							file4.delete();
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

				}
        }/*catch(FileNotFoundException nfe)
        {
        System.out.println("file not found");
        }*/
        catch(Exception e)
        {
        	System.out.println("file not found");
        	
        }
	}
	public void searchSection()
	{
		
	}
	public void showAllAvailableSections()
	{
		
		int count=0;
		File folder = new File("D:\\documentManagementSimulator\\section\\");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile() && file.getName().endsWith(".txt")) {
		    try {
		    	Section section; 
		    	FileInputStream fis2=new FileInputStream(file);
				ObjectInputStream ois2=new ObjectInputStream(fis2);
				section = (Section) ois2.readObject();
				System.out.println("the status of category :"+section.isSectionStatus()); //boolean displayCatOldStatus=category3.getCategoryStatus();
		 		System.out.println("the category name  :"+section.getSectionName());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category Id    :"+section.getSectionId());//String displayCatName=category3.getCategoryName();	
		 		
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
		if(count==0) System.out.println("No section Found");

		
	}
	public void showActiveSections()
	{
		
		int count=0;
		File folder = new File("D:\\documentManagementSimulator\\section\\");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile() && file.getName().endsWith(".txt")) {
		    try {
		    	Section section; 
		    	FileInputStream fis2=new FileInputStream(file);
				ObjectInputStream ois2=new ObjectInputStream(fis2);
				section = (Section) ois2.readObject();
				if(section.isSectionStatus()==true)
				{
				System.out.println("the status of category :"+section.isSectionStatus()); //boolean displayCatOldStatus=category3.getCategoryStatus();
		 		System.out.println("the category name  :"+section.getSectionName());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category Id    :"+section.getSectionId());//String displayCatName=category3.getCategoryName();	
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
		if(count==0) System.out.println("No section Found");

		
		
	}
	public void showNonActiveSections()
	{
		

		int count=0;
		File folder = new File("D:\\documentManagementSimulator\\section\\");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile() && file.getName().endsWith(".txt")) {
		    try {
		    	Section section; 
		    	FileInputStream fis2=new FileInputStream(file);
				ObjectInputStream ois2=new ObjectInputStream(fis2);
				section = (Section) ois2.readObject();
				if(section.isSectionStatus()==false)
				{
				System.out.println("the status of category :"+section.isSectionStatus()); //boolean displayCatOldStatus=category3.getCategoryStatus();
		 		System.out.println("the category name  :"+section.getSectionName());//String displayCatName=category3.getCategoryName();	
		 		System.out.println("the category Id    :"+section.getSectionId());//String displayCatName=category3.getCategoryName();	
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
		if(count==0) System.out.println("No section Found");

		
		
		
	}

}
