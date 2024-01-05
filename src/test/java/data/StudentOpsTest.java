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

  //Question 2
  @Test
  void shouldReturnAListOfStudents() {
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
}

