package domain.model;

import domain.util.Grade;

public class Gasoline extends FuelType {

	private Grade grade;
    
    public Gasoline() {
    	this(Grade.EIGHTYSEVEN);
    }

    public Gasoline(Grade grade) {
    	this.grade = grade;
	}

	public Grade getGrade() {
        return grade;
    }
}