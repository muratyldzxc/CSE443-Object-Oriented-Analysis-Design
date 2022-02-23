package demo;

import emailAddressBook.*;

public class Demo {

	public static void main(String[] args) {
		EmailAddress allGroupEmailAddresss = new GroupEmailAddress("GTU University Student", "gtustudent@gtu.edu.tr");
		
		EmailAddress engFacultyGroupEmailAddress = new GroupEmailAddress("Engineering Faculty", "engstudent@gtu.edu.tr");
		EmailAddress funFacultyGroupEmailAddress = new GroupEmailAddress("Fundamental Sciences Faculty", "fsstudent@gtu.edu.tr");
		
		
		EmailAddress cseDepartmentGroupEmailAddress = new GroupEmailAddress("CSE Department Student", "csestudent@gtu.edu.tr");
		EmailAddress envDepartmentGroupEmailAddress = new GroupEmailAddress("ENV Department Student", "envstudent@gtu.edu.tr");
		EmailAddress mseDepartmentGroupEmailAddress = new GroupEmailAddress("MSE Department student", "msestudent@gtu.edu.tr");
		
		EmailAddress mathDepartmentGroupEmailAddress = new GroupEmailAddress("MATH Department Student", "mathstudent@gtu.edu.tr");
		EmailAddress phyDepartmentGroupEmailAddress = new GroupEmailAddress("PHY Department Student", "phystudent@gtu.edu.tr");
	
		
		allGroupEmailAddresss.add(engFacultyGroupEmailAddress);
		allGroupEmailAddresss.add(funFacultyGroupEmailAddress);
		
		engFacultyGroupEmailAddress.add(cseDepartmentGroupEmailAddress);
		engFacultyGroupEmailAddress.add(envDepartmentGroupEmailAddress);
		engFacultyGroupEmailAddress.add(mseDepartmentGroupEmailAddress);
		
		funFacultyGroupEmailAddress.add(mathDepartmentGroupEmailAddress);
		funFacultyGroupEmailAddress.add(phyDepartmentGroupEmailAddress);
		
		 // add GroupEmailAddress items here
		cseDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Murat Yildiz 1", "muratyldz1@gtu.edu.tr"));
		cseDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Murat Yildiz  2", "muratyldz2@gtu.edu.tr"));
		cseDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Murat Yildiz 3", "muratyldz3@gtu.edu.tr"));
		
		envDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Ahmet Yilmaz 1", "ahmetylmz1@gtu.edu.tr"));
		envDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Ahmet Yilmaz  2", "ahmetylmz2@gtu.edu.tr"));
		
		mseDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Elif Kucuk 1", "elifkucuk1@gtu.edu.tr"));
		mseDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Elif Kucuk  2", "elifkucuk2@gtu.edu.tr"));
		
		
		mathDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Furkan Kilit 1", "furkanklt1@gtu.edu.tr"));
		mathDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Furkan Kilit  2", "furkanklt2@gtu.edu.tr"));
		mathDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Furkan Kilit 3", "furkanklt3@gtu.edu.tr"));
		
		phyDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Bulut Aras 1", "bulutaras1@gtu.edu.tr"));
		phyDepartmentGroupEmailAddress.add(new PersonalEmailAddress("Bulut Aras  2", "bulutaras2@gtu.edu.tr"));
		
		 // add more GroupEmailAddress items here
		
		EmailAddressBook emailAddressBook = new EmailAddressBook(allGroupEmailAddresss);
		
		emailAddressBook.printEmailAddressBook();

	}

}
