package com.yash.documentManagementSimulator.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.prefs.Preferences;

import com.yash.documentManagementSimulator.registration.Trainer;

public class TrainerDAO implements Serializable{
	public Trainer trainer;
	
	//private Preferences prefs;
	private Preferences prefs;
    private static final String AI_SETTING_ID = "autoincrement";

    
    
    public int getid() {
   prefs = Preferences.userRoot().node(this.getClass().getName());
   AtomicInteger autoincTr = new AtomicInteger(prefs.getInt(AI_SETTING_ID, 100));
   

        
       //   AtomicInteger autoinc = new AtomicInteger(100);  
       //  autoincTr.incrementAndGet();
       // prefs.putInt(AI_SETTING_ID, autoincTr.get());
     
   int b=  autoincTr.incrementAndGet();
        prefs.putInt(AI_SETTING_ID, autoincTr.get());

        return b;
    }
	 public void addTrainer(int a,String name,String password)
	 {	
		 password=password.toUpperCase();
		 /*
		  * String g="TR"+a;
		   idea of this logic was proposed by miss "Kajal Jain";
		  */
		 String g="TR"+a;
		 
		 
		 try
	{
			 
		File file=new File("D:\\documentManagementSimulator\\trainer\\"+g+".txt");	
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Trainer tr=new Trainer(g,name,password);
		
		
		oos.writeObject(tr);
		
		
		System.out.println("Trainer Added !");
		System.out.println("The unique id "+g);
		oos.close();
		 }catch(Exception e){
			 e.printStackTrace();
	 }
		 
	 }
	 
	 
	 public String getTrainer(String id){
	       String name11="";
	    

			// password=password.toUpperCase();
			
	       id=id.toUpperCase();
		 try{
			 
			 
			 
			 File file1=new File("D:\\documentManagementSimulator\\trainer\\"+id+".txt");	
		FileInputStream fis2=new FileInputStream(file1);
		ObjectInputStream ois2=new ObjectInputStream(fis2);
		Trainer trainer;
		trainer = (Trainer) ois2.readObject();
            id=trainer.getTrainerId();
		name11=trainer.getTrainerName();
		System.out.println("Welcome "+name11);
		/*
		Trainer[] tra1=new Trainer[2];
			for(int i=0;i<2;i++)
		{
		tra1[i]=trainer;
		System.out.println("the id of the trainer is "+tra1[i].getTrainerId());
		}
		*/
		
		
		ois2.close();
		 }catch(FileNotFoundException nfe){
			 System.out.println("Invaild credentials");
		}catch(Exception e){
			 e.printStackTrace();
		 }
	 
		 return id;
	 }
	 public String getTrainerPassword(String id)
	 {
        id=id.toUpperCase();
		String password="";
		String name11="";
		 try{
			 
			 
			 
			 File file1=new File("D:\\documentManagementSimulator\\trainer\\"+id+".txt");	
		FileInputStream fis2=new FileInputStream(file1);
		ObjectInputStream ois2=new ObjectInputStream(fis2);
		Trainer trainer;
		trainer = (Trainer) ois2.readObject();
          password=trainer.getTrainerPassword();
          name11=trainer.getTrainerName();
  		System.out.println("Welcome "+name11);
		
		/*
		Trainer[] tra1=new Trainer[2];
			for(int i=0;i<2;i++)
		{
		tra1[i]=trainer;
		System.out.println("the id of the trainer is "+tra1[i].getTrainerId());
		}
		*/
		
		
		ois2.close();
		
		}catch(Exception e){
			 e.printStackTrace();
		 }
	 
		 return password;
	 }
	 


	 
	 
	 
}
