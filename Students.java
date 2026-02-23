public class Student {

    private int time;          
    private String email;
    private int[] choices;

    public Student(int submissionTime, String studentEmail, int c1, int c2, int c3, int c4, int c5) {

        time = submissionTime;
        email = studentEmail;

        choices = new int[5];
        choices[0] = c1;
        choices[1] = c2;
        choices[2] = c3;
        choices[3] = c4;
        choices[4] = c5;
    }

    public int getTime() {
        return time;
    }

    public String getEmail() {
        return email;
    }

    public int[] getChoices() {
        return choices;
    }

    public int getChoice(int index) {
        return choices[index];
    }

    public String toString() {
        return email + " | Time: " + time;
    }
}
