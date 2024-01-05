package data;

import challenges.StudentOps;
import domain.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentOpsTest {

  private static List<Student> students;

  @BeforeAll
  static void setUp() throws IOException {
    // Fetch data before all tests
    students = FetchData.getStudentList();
  }

  // Question 1
  @Test
  void shouldReturnEmptyListWhenNoStudentsMatchGender() {
    List<Student> filteredStudents = StudentOps.filterStudentsByGender(students, "Other");
    assertThat(filteredStudents).isEmpty();
  }

  @Test
  void shouldReturnListStudentsMatchingGender() {
    List<Student> filteredStudents = StudentOps.filterStudentsByGender(students, "Female");
    assertEquals("Female", filteredStudents.get(5).getGender());
  }

  // Question 2
  @Test
  void shouldAtLeastReturnAListOfStudentsForSortedAge() {
    List<Student> sortedAge = StudentOps.sortStudentsByAge(students);
    assertNotNull(sortedAge);
  }

  @Test
  void shouldReturnYoungestStudent() {
    List<Student> sortedAge = StudentOps.sortStudentsByAge(students);
    assertEquals(students.get(47),sortedAge.get(0));
  }

  @Test
  void shouldReturnOldestStudent() {
    List<Student> sortedAge = StudentOps.sortStudentsByAge(students);
    assertEquals(students.get(270), sortedAge.get(sortedAge.size() - 1));
  }

  // Question 3
  @Test
  void shouldReturnAnAverageNumberAboveZero() {
    double average = StudentOps.averageAge(students);
    assertTrue(average > 0);
  }

  @Test
  void shouldReturnAverage() {
    double average = StudentOps.averageAge(students);
    assertEquals(35.094, average);
  }

  // Question 4
  @Test
  void shouldAtLeastReturnListForFullNames() {
    List<String> fullNames = StudentOps.showFullNames(students);
    assertNotNull(fullNames);
  }

  @Test
  void shouldReturnFirstFullName() {
    List<String> fullNames = StudentOps.showFullNames(students);
    assertEquals("Kaitlyn Padden", fullNames.get(0));
  }

  // Question 5

  @Test
  void shouldAtLeastReturnAListOfStudentsForGender() {
    List<Student> groupedByGender = StudentOps.groupByGender(students);
    assertNotNull(groupedByGender);
  }

  @Test
  void shouldReturnFalseForNonMatchingGenders() {
    List<Student> sortedGenders = StudentOps.groupByGender(students);
    assertNotEquals("Agender", students.get(0).getGender());

  }

  // Question 6
  @Test
  void shouldAtLeastReturnANumberAboveZero() {
    int maxAge = StudentOps.maxAge(students);
    System.out.println(maxAge);
    assertTrue(maxAge > 0);
  }



}

