public class CodingHours {
  public static void main(String[] args) {

    // An average Green Fox attendee codes 6 hours daily
    // The semester is 17 weeks long
    //
    // Print how many hours is spent with coding in a semester by an attendee,
    // if the attendee only codes on workdays.
    //
    // Print the percentage of the coding hours in the semester if the average
    // work hours weekly is 52


    int dailyHours = 6;
    int semesterWeeks = 17;
    int daysPerWeek = 5;
    int avgWorkHoursPerWeek = 52;

    float totalWorkHoursPerSemester = avgWorkHoursPerWeek * semesterWeeks;
    System.out.println(totalWorkHoursPerSemester);
    float codingHoursPerSemester = dailyHours * daysPerWeek * semesterWeeks;
    System.out.println(codingHoursPerSemester);

    int percentageOfCodingHours =
        (int) ((codingHoursPerSemester / totalWorkHoursPerSemester) * 100);
    System.out.println(percentageOfCodingHours + "%");
  }
}
