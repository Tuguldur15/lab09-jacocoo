package mn.edu.must.sqat;

public class ScholarshipCalculator {

    // 1. Дүнгийн үсэг тооцох (60.0 зааг дээр >= 60 болгож засварлав)
    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    // 2. Голч дүн (GPA) тооцох
    public double calculateGpa(String[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException("Grades list cannot be empty");
        }
        double total = 0;
        for (String g : grades) {
            switch (g) {
                case "A": total += 4.0; break;
                case "B": total += 3.0; break;
                case "C": total += 2.0; break;
                case "D": total += 1.0; break;
                case "F": total += 0.0; break;
                default:
                    throw new IllegalArgumentException("Invalid grade: " + g);
            }
        }
        return total / grades.length;
    }

    // 3. Тэтгэлгийн хувь тооцох
    public int calculateScholarship(double gpa, int credits, boolean hasDisciplinaryAction) {
        if (gpa < 0 || gpa > 4.0 || credits < 0) {
            throw new IllegalArgumentException("Invalid input range");
        }
        if (hasDisciplinaryAction) {
            return 0;
        }
        if (gpa >= 3.8 && credits >= 15) {
            return 100;
        } else if (gpa >= 3.5 && credits >= 12) {
            return 75;
        } else if (gpa >= 3.0 && credits >= 12) {
            return 50;
        }
        return 0;
    }
}
