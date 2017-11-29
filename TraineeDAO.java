package com.yash.documentManagementSimulator.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.prefs.Preferences;

import com.yash.documentManagementSimulator.registration.Trainer;

public class TraineeDAO implements Serializable{
	public Trainer trainer;
	
	private Preferences prefs;
    private static final String AI_SETTING_ID = "autoincrement";

    public AtomicInteger testPrefs() {
        prefs = Preferences.userRoot().node(this.getClass().getName());

        AtomicInteger autoincTr = new AtomicInteger(prefs.getInt(AI_SETTING_ID, 100));
     //   AtomicInteger autoinc = new AtomicInteger(100);
        System.out.println("Unique ID of trainer is" + autoincTr);


        prefs.putInt(AI_SETTING_ID, autoincTr.get());
        return autoincTr;
    }
	 public void addTrainer(AtomicInteger a,String name,String password)
	 {	
		 String g="TR"+a;
		 
		 
		 try{
		File file=new File("D:\\documentManagementSimulator\\trainer\\"+g+".txt");	
		FileOutputStream fos=new FileOutputStream(file,true);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Trainer tr=new Trainer(g,name,password);
		
		
		oos.writeObject(tr);
		System.out.println("Trainer Added !");
		System.out.println("The unique id ");
		oos.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	 }
	 
	 
	 public void getTrainer(int id,String password){
		 try{
			 
			 
			 String g="TR"+id;
			 File file1=new File("D:\\documentManagementSimulator\\trainer\\"+g+".txt");	
		FileInputStream fis2=new FileInputStream(file1);
		ObjectInputStream ois2=new ObjectInputStream(fis2);
		Trainer trainer;
		trainer = (Trainer) ois2.readObject();
		System.out.println("Account Detail: \n"+trainer);
		
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
	 
	 
	 }
	 
	 
	
}
