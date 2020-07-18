package src;

public class CodingHours {
    public static void main(String[] args) {

        float dailyCodingHours = 6;
        float semesterWeeks = 17;
        float weeklyWorkdays = 5;
        float weeklyWorkingHours = 52;
        float attendeeCodingHoursPerSemester = dailyCodingHours * semesterWeeks * weeklyWorkdays;
        int attendeeCodingHoursPerSemesterI = (int) attendeeCodingHoursPerSemester;
        System.out.println("Hours spent coding by an attendee: " + attendeeCodingHoursPerSemesterI);

        float codingHourPercentage = attendeeCodingHoursPerSemester / (semesterWeeks * weeklyWorkingHours);
        int codingHourPercentageInt = (int) (codingHourPercentage * 100);
        System.out.println("Percentage of coding hours int the semester: " + codingHourPercentageInt + "%");
    }
}
