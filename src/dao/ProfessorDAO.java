package dao;

import models.Professor;

public class ProfessorDAO {
	private BD bd;
	private Professor professor;
	
	public ProfessorDAO() {
		this.bd = null;
		this.professor = null;
	}
	
	public void setBd(BD bd) {
		this.bd = bd;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
