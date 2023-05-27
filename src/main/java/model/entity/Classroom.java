package model.entity;

public class Classroom {

    private Professor professor;
    public Classroom() {

        professor = new Professor();
    }

    public Professor getProfessor(){
        return professor;
    }
}
