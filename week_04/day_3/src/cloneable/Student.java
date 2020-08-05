package cloneable;

public class Student extends Person{
  String previousOrganization;
  int skippedDays;

  public Student(String name, int age, String gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  public Student() {
    super();
    previousOrganization = "The School of Life";
    skippedDays = 0;
  }

  @Override
  public void getGoal() {
    System.out.println("Be a junior software developer.");
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender + " from " + this.previousOrganization + " who skipped " + this.skippedDays + " days from the course already.");
  }

  public void skipDays(int numberOfDays) {
    this.skippedDays += numberOfDays;
  }

  @Override
  public Student clone() {
    String cloneName = this.name.toLowerCase() + "TheClone";
    Student clone = new Student(cloneName, age, gender, previousOrganization);
    return clone;
  }
}
