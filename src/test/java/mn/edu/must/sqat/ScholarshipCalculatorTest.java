package mn.edu.must.sqat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScholarshipCalculatorTest {

    private ScholarshipCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new ScholarshipCalculator();
    }

    // ХЭСЭГ A: Хэвийн урсгалын тестүүд
    @Test
    @DisplayName("A1. Хэвийн A дүн тооцох")
    void happyPathLetterGrade() {
        assertEquals("A", calc.letterGrade(95.0));
    }

    @Test
    @DisplayName("A2. Хэвийн GPA тооцох")
    void happyPathGpa() {
        String[] grades = {"A", "B"};
        assertEquals(3.5, calc.calculateGpa(grades), 0.001);
    }

    @Test
    @DisplayName("A3. 100% тэтгэлэг авах хэвийн тохиолдол")
    void happyPathScholarship() {
        assertEquals(100, calc.calculateScholarship(3.9, 16, false));
    }

    // ХЭСЭГ B: Бүх branch болон exception урсгалыг шалгах тестүүд
    @Test
    @DisplayName("B1. letterGrade хязгаараас хэтэрсэн утга ба бусад үсгэн дүн")
    void letterGradeBranches() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-2.5));
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101.0));
        assertEquals("B", calc.letterGrade(84.0));
        assertEquals("C", calc.letterGrade(72.5));
        assertEquals("F", calc.letterGrade(45.0));
    }

    @Test
    @DisplayName("B2. calculateGpa үсгэн дүнгүүдийн салбар ба буруу утга")
    void gpaBranches() {
        assertEquals(2.0, calc.calculateGpa(new String[]{"C"}), 0.001);
        assertEquals(1.0, calc.calculateGpa(new String[]{"D"}), 0.001);
        assertEquals(0.0, calc.calculateGpa(new String[]{"F"}), 0.001);
        assertThrows(IllegalArgumentException.class, () -> calc.calculateGpa(new String[]{"X"}));
    }

    @Test
    @DisplayName("B3. calculateScholarship нөхцөлүүдийн бүх салбар")
    void scholarshipBranches() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculateScholarship(-0.5, 15, false));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateScholarship(3.7, -1, false));

        assertEquals(0, calc.calculateScholarship(3.95, 16, true));
        assertEquals(75, calc.calculateScholarship(3.65, 14, false));
        assertEquals(50, calc.calculateScholarship(3.15, 12, false));
        assertEquals(0, calc.calculateScholarship(2.4, 9, false));
        assertEquals(0, calc.calculateScholarship(3.85, 11, false));
    }

    // ХЭСЭГ C: Давталтын заагийн тестүүд (0, 1, 2+ удаа)
    @Test
    @DisplayName("C1. Давталт 0 удаа ажиллах (null болон хоосон массив)")
    void loopZeroIterations() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculateGpa(null));
        assertThrows(IllegalArgumentException.class, () -> calc.calculateGpa(new String[]{}));
    }

    @Test
    @DisplayName("C2. Давталт 1 удаа ажиллах")
    void loopSingleIteration() {
        assertEquals(3.0, calc.calculateGpa(new String[]{"B"}), 0.001);
    }

    @Test
    @DisplayName("C3. Давталт 2 ба түүнээс олон удаа ажиллах")
    void loopMultipleIterations() {
        assertEquals(2.333, calc.calculateGpa(new String[]{"A", "C", "D"}), 0.01);
    }
}
