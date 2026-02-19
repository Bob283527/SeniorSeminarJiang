public class Students {
	
	
	public int readFile() throws IOException{
		File file = new File("SrSeminar.csv");
        
			Scanner scan = new Scanner(file);
        
			if (scan.hasNext()) {
				scan.nextLine();
			}
		private String fileName = "SrSeminar.csv";
		
		ArrayList<Student> studentArray = new ArrayList<Student>();
        
		private String time;
		private String choice1;
		private String choice2;
		private String choice3;
		private String choice4;
		private String choice5;
		private String email;
		public Student(String t, String c1, String c2, String c3, String c4, String c5, String initEmail) {
			time = t;
			choice1 = c1;
			choice2 = c2;
			choice3 = c3;
			choice4 = c4;
			choice5 = c5;
			email = initEmail;
		}
		public int getChoice1() {
				return choice1;
		}
		public int getChocie2() {
				return choice2;
		}
		public int getChoice3() {
			return choice3;
		}
		public int getChoice4() {
			return choice4;
		}
		public int getChoice5() {
			return choice5;
		}
		int i = 0;
		while (scan.hasNext() && i < studentArray.size()) {
			String line = scan.nextLine();
			String[] parts = line.split(",");
			
			String t = parts[0];
			String initEmail = parts[1];
			String c1 = parts[2];
			String c2 = parts[3];
			String c3 = parts[4];
			String c4 = parts[5];
			String c5 = parts[6];
        
			studentArray[i] = new students(t, initEmail, c1, c2, c3, c4, c5);
			i++;
		}
	}
	return studentArray[i];
}

