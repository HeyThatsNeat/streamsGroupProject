package challenges;

import data.FetchData;
import domain.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentOps {
  //  1. Filter Students by Gender: Write a method to filter a list of students by their gender.

  public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
    return students.stream()
            .filter(student -> student.getGender().equalsIgnoreCase(gender))
            .toList();
  }

  //2. Sort Students by Age: Sort the list of students by their age (based on date of birth).
  public static List<Student> sortStudentsByAge(List<Student> students) {
    LocalDate currentDate = LocalDate.now();
    students.forEach(student -> {
      LocalDate dob = student.getDob();
      Period period = Period.between(dob, currentDate);
      student.setAgeYear(period.getYears());
      student.setAgeMonth(period.getMonths());
      student.setAgeDay(period.getDays());
    });
    return students.stream()
            .sorted(Comparator.comparing(Student::getAgeDay))
            .sorted(Comparator.comparing(Student::getAgeMonth))
            .sorted(Comparator.comparing((Student::getAgeYear)))
            .toList();
  }

  //3. Calculate Average Age: Calculate the average age of all students.
  public static double averageAge(List<Student> students) {
    LocalDate currentDate = LocalDate.now();
    students.forEach(student -> {
      LocalDate dob = student.getDob();
      Period period = Period.between(dob, currentDate);
      student.setAgeYear(period.getYears());
    });
    return students.stream()
            //mapToDouble is usually for converting to numbers
            .mapToDouble(Student::getAgeYear)
            .average()
            .orElse(0);
  }

  //4. Print Student Names: Print the full names of all students.
  public static List<String> showFullNames(List<Student> students) {
    return students.stream()
            .map(s -> s.getFirst_name() + " " + s.getLast_name())
            .limit(5)
            .toList();
  }

}
