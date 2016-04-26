package domain.model;

import domain.util.Grade;

public class Gasoline extends FuelType {

    Grade grade;
    
    public Gasoline() {
    	
    }

    public Gasoline(Grade grade) {
    	this.grade = grade;
	}

	public Grade getGrade() {
        return grade;
    }
}