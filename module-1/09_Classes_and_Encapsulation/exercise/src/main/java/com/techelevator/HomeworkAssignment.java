package com.techelevator;

public class HomeworkAssignment {

    /*
        Member Variables
            earnedMarks
            possibleMarks
            SubmitterName

        Constructor
            accepts possibleMarks and submitterName

        How it Works
            input possibleMarks and submitterName
            calculate letterGrade (derived)
            return letterGrade based on intervals
     */

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    /*
    Constructor
     */

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    /*
    Getters and Setters
     */

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public String getLetterGrade() {
        int earnedMarks = getEarnedMarks();
        int possibleMarks = getPossibleMarks();
        if ((earnedMarks * 100) / possibleMarks  >= 90) {
            return "A";
        } else if ((earnedMarks * 100) / possibleMarks >= 80) {
            return "B";
        } else if ((earnedMarks * 100) / possibleMarks >= 70) {
            return "C";
        } else if ((earnedMarks * 100) / possibleMarks >= 60) {
            return "D";
        } else {
            return "F";
        }

    }

}
