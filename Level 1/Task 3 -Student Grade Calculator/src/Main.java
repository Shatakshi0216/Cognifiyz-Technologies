import java.util.*;

class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of grades to be entered: ");
        int numGrades = sc.nextInt();

        char grades[] = new char[numGrades];

        System.out.println("Enter grades from A to E: ");
        for(int i = 0; i < numGrades; i++) {
            grades[i] = sc.next().charAt(0);
        }

        double totalnumGrade = 0, averageGrade = 0;

        // Converting grades into numerical values and calculating the total
        for(int i = 0; i < numGrades; i++) {
            averageGrade += gradeToNum(grades[i]);
        }

        // Calculate the average numerical grade
        totalnumGrade = averageGrade / numGrades;

        // Convert the average numerical grade back to a letter grade
        char finalGrade = numToGrade(totalnumGrade);

        System.out.println("Average of given grades is " + finalGrade);
    }

    // Method to convert a letter grade to a numerical value
    static int gradeToNum(char grade) {
        switch(grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'E':
                return 0;
            default:
                System.out.println("Enter a grade between A to E!");
                return 0;
        }
    }

    // Method to convert a numerical grade to a letter grade
    static char numToGrade(double totalnumGrade) {
        if(totalnumGrade >= 3.5)
            return 'A';
        else if(totalnumGrade >= 2.5)
            return 'B';
        else if(totalnumGrade >= 1.5)
            return 'C';
        else if(totalnumGrade >= 0.5)
            return 'D';
        else
            return 'E';
    }
}
