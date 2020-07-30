package teacherstudent;

public class Main {
  public static void main(String[] args) {
    //Create Student and Teacher classes
    //Student
    //learn() -> prints the student is learning something new
    //question(teacher) -> calls the teachers answer method
    //Teacher
    //teach(student) -> calls the students learn method
    //answer() -> prints the teacher is answering a question
    //Instantiate a Student and Teacher object
    //Call the student's question() method and the teacher's teach() method

    Student bela = new Student("Béla");
    Teacher jozsiBa = new Teacher("Józsi bá");

    bela.question(jozsiBa);
    jozsiBa.teach(bela);
  }

}
