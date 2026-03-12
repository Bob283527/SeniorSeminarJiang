import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arraylist;

public class SessionList {
	//called from Main or another proggram
	//create AL of session objects
	ArrayList <Session> srSessList = new ArrayList<Session>();
	public SessionList {
		//Instance vars?
	}
	/*LoadSessions loads data
	 *  and creates arralist of Session objects
	 *  from Session class (diff from Session)
	 */ 
	public void loadSessions() { //return type? AL of sess Objs
		File myObj = new File("sessions.csv");
		//try-with-resources: Scanner will be closed automatically
		try (Scanner myReader = new Scanner(myObj)) {
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] info = data.split(",");
				int sessID = Integer.parseInt(info[0]);
				Session sess = new Session(sessID, info[1], info[2]);
				//id, sess, presenter passed to a constructor
				//add that new sess obj to a <AL> of sess objects?
				srSessLis.add(sess); //call to Session Constructor
				//System.out.println(data + "\n"); //print aach line
				System.out.println("Array elements: " + info[0] + "-" + info[1] + "-" + info[2] + "\n"); //print each line
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
	
