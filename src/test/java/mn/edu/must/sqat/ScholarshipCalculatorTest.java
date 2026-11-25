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

    // ХЭСЭГ A: Зөвхөн хэвийн урсгалын (Happy Path) тестүүд
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
}
