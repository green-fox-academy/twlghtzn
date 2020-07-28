package teacherstudent;

public class Student {
  String studentsName;

  public Student(String name) {
    this.studentsName = name;
  }

  public void learn() {
    System.out.println(studentsName + " is learning");
  }

  public void question(Teacher teacher) {
    teacher.answer();
  }

}
