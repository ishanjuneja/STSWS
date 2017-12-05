package com.yash.documentManagementSimulator.dao;

public interface SectionDAOInterface {
	
	public void createSection(int sectionName);
	public void editSection();
	public void deleteSection();
	public void searchSection();
	public void showAllAvailableSections();
	public void showActiveSections();
	public void showNonActiveSections();

}
