package greenfox;

import java.util.ArrayList;
import java.util.List;

public class Cohort {
  String name;
  List<Student> students;
  List<Mentor> mentors;

  public Cohort(String name) {
    this.name = name;
    this.students = new ArrayList<>();
    this.mentors = new ArrayList<>();
  }

  public void addStudent(Student newStudent) {
    students.add(newStudent);
  }

  public void addMentor(Mentor newMentor) {
    mentors.add(newMentor);
  }

  public void info() {
    System.out.println("The " + this.name + " cohort has " + this.students.size() + " students and " + this.mentors.size() + " mentors.");
  }
}