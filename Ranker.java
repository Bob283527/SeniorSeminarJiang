public class Ranker {
	
	public void Ranker {
		//look at the time since its split into 3 parts; hour: minute: second
		/* 	int[] parts = line.split(":");
		 * int hour = parts[0]
		 * int minute = parts[1]
		 * int second = parts[3]
		 * then compare with other students if hour == hour of both students move to minutes if minutes are tge same move to seconds
		 */
		public int readFile() throws IOException{
			File file = new File("SrSeminar.csv");
        
				Scanner scan = new Scanner(file);
        
				if (scan.hasNext()) {
					scan.nextLine();
				}
			private String fileName = "SrSeminar.csv";
			public void studentsTime(int h, int m, int s) {
				hours = h;
				minutes = m;
				seconds = s;
			} 
			public int getHours() {
				return hours;
			}
			public int getMinutes() {
				return minutes;
			}
			public int getSeconds() {
				return seconds;
			}
			int i = 0;
			while (scan.hasNext() && i < studentArray.size()) {
				String line = scan.nextLine();
				int[] parts = line.split(":");
			
				int h = parts[0];
				int m = parts[1];
				int s = parts[2];
				studentArray[i] = new studentsTime(h, m, s);
				i++;
		}
	}
	for (int j = 0; j < studentArray[i]; j++) {
		int i = 0;
		if studentArray[i]
	}
}




}

