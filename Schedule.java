
		/*should i use the organized data from my ranker.java
		 * to place the students who submitted first until each course in the first session is filled up
		 * if the course is filed but the student put it as their first chocie then we look towards their second choice
		 * we keep going through their choices until  one of the courses have a free spot
		 * if all 5 of their choices are filled then put them into the course with the least amt of people
		 * we put the students that got their first chocie into a temp var and out them at the bottom of the array 
		 * then for second sessiosn we start where we left off so now the students who didnt get their first chocie has a chance to get it now
		 * and those who got their first chocie will either get their second or third or fourth or fifth
		 * whenever a student gets one of their 5 choices replace the choice used with a 0
		 * so now when we start placing students inbto the second session we know to not use the choice that has a 0 
		 * keep repeating until all 5 sessions and their courses are filled
		 * 
		 * do a course popularity ranker to know whch courses should get a second session
		 * look at the numbers in choice 1 those are worth 5 points tpwards the course counter
		 * choice 2 is 4 points, choice 3 is 3 points etc...
		 * the most popular courses get a second time to run
		 * 
		 * so any student that did not get their number one choice in the popular course has a chance to get it now based on time
		 * 
		 * theres also 2 slots for each course
		 */
		 //need to move the students used to bottom of list though
		 //x = Student.length;
		 //for (i = 0; i < Student.length; i+=16) {
			//j = 0;
			//String[] session = x.substring(0, i);
			//return("Session" + j + ": " + session);
			//j++;
		//}
import java.util.*;

public class Schedule {

    private int courses = 18;
    private int timeSlots = 5;
    private int slots = 2;  // max times each course can run
    private int maxStudentsPerClass = 16;

    private int[][] courseSeats;  // course and slot get number of student
    private int[][] courseAssignments;  // course slot get 1 if run, 0 if not run
    private String[] studentEmails;  // keep track of email
    private int[][] studentCourses;  // student index get array of course they take
    private String[][] studentDetails;  // student index get array of "CourseID-TimeSlot-Room"
    private int[] studentCount;  // track how many class each student have

    public Schedule() {
        courseSeats = new int[courses][slots];
        courseAssignments = new int[courses][slots];
        
        // make empty box for all course and slot
        // put zero in all place mean nothing there yet
        for (int i = 0; i < courses; i++) {
            for (int j = 0; j < slots; j++) {
                courseSeats[i][j] = 0;
                courseAssignments[i][j] = 0;
            }
        }
    }

    public void initializeStudentArrays(ArrayList<Student> students) {
        // set up array for track student stuff
        studentEmails = new String[students.size()];
        studentCourses = new int[students.size()][5];
        studentDetails = new String[students.size()][5];
        studentCount = new int[students.size()];
        
        // start all counter at zero mean nothing assign yet
        for (int i = 0; i < students.size(); i++) {
            studentEmails[i] = students.get(i).getEmail();
            studentCount[i] = 0;
            for (int j = 0; j < 5; j++) {
                studentCourses[i][j] = 0;
                studentDetails[i][j] = "";
            }
        }
    }

    public void createSchedule(ArrayList<Student> students) {
        // set up all the student array first
        initializeStudentArrays(students);
        
        // first find which course most student want
        // use rank system i make for this
        int[] coursePopularity = calculateCoursePopularity(students);
        assignSecondSlots(coursePopularity);
		
		System.out.println("\n=== PUT STUDENT IN CLASS ===\n");

        // go through all five time slot
        // student who come first get pick first (student who click form early)
        for (int timeSlot = 0; timeSlot < timeSlots; timeSlot++) {
            System.out.println("--- TIME SLOT " + (timeSlot + 1) + " ---");
            
            // try put each student in classroom for this time slot
            // if student get first choice, move them end of line
            // that way other student get turn at their first want
            for (int s = 0; s < students.size(); s++) {
                boolean placed = false;
                Student student = students.get(s);

                // only put in schedule if student not have five class yet
                // must have five class no more no less is rule
                if (studentCount[s] >= 5) {
                    continue;
                }

                // try put student in one of five choice they make
                // go from best choice to worst choice
                for (int choiceIndex = 0; choiceIndex < 5; choiceIndex++) {
                    int courseID = student.getChoice(choiceIndex);

                    // skip if choice already used (zero mean gone)
                    // when student get class we mark choice zero so no use again
                    if (courseID == 0) {
                        continue;
                    }

                    // check if student already take this class before
                    // student cannot go same class two time that not allowed
                    boolean alreadyTaken = false;
                    for (int k = 0; k < studentCount[s]; k++) {
                        if (studentCourses[s][k] == courseID) {
                            alreadyTaken = true;
                            break;
                        }
                    }
                    if (alreadyTaken) {
                        continue;
                    }
