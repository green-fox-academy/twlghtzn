package teacherstudent;

public class Teacher {
  String teachersName;

  public Teacher(String name) {
    this.teachersName = name;
  }

  public void teach(Student student) {
    student.learn();
  }

  public void answer() {
    System.out.println(teachersName + " is answering a question");
  }

}
