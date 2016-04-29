package domain.model;

import domain.core.MainController;
import domain.util.Console;
import domain.util.Grade;

public class GradeSelector {

	private Grade selectedGrade;

    public void selectGrade() {
		System.out.println("Select gasoline grade - (87, 89, or 93):  ");
    	String gradeId = Console.getScanner().nextLine();
    	
    	MainController.getInstance().selectGrade(gradeId);
    }

	public Grade getSelectedGrade() {
		return selectedGrade;
	}

	public void setSelectedGrade(Grade selectedGrade) {
		this.selectedGrade = selectedGrade;
	}
}