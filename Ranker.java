import java.io.*;
import java.util.*;

public class Ranker {

    public ArrayList<Student> readFile() throws IOException {

        ArrayList<Student> studentList = new ArrayList<Student>();

        File file = new File("SrSeminar.csv");
        Scanner scan = new Scanner(file);
		scan.nextLine();

        while (scan.hasNextLine()) {

            String line = scan.nextLine();
            String[] parts = line.split(",");

            String timeString = parts[0].trim();
            String[] timeParts = timeString.split(":");

            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            int second = Integer.parseInt(timeParts[2]);

            int totalSeconds = hour * 3600 + minute * 60 + second;

            String email = parts[1].trim();

            int c1 = Integer.parseInt(parts[2].trim());
            int c2 = Integer.parseInt(parts[3].trim());
            int c3 = Integer.parseInt(parts[4].trim());
            int c4 = Integer.parseInt(parts[5].trim());
            int c5 = Integer.parseInt(parts[6].trim());

            Student student = new Student(totalSeconds, email, c1, c2, c3, c4, c5);

            studentList.add(student);
        }

        scan.close();
        return studentList;
    }


    public void sortByTime(ArrayList<Student> students) {

        for (int i = 0; i < students.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < students.size(); j++) {

                if (students.get(j).getTime() < students.get(minIndex).getTime()) {
                    minIndex = j;
                }
            }

            Student temp = students.get(i);
            students.set(i, students.get(minIndex));
            students.set(minIndex, temp);
        }
    }
}
