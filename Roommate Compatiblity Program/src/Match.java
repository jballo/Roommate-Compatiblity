import java.util.NoSuchElementException;
import java.util.Scanner;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Match {
	public static void main(String[] args) throws IOException {
		Student[] students = new Student[100]; 

		System.out.print("Enter the name of the file to open: ");
		Scanner kbd = new Scanner(System.in);
		String filename = kbd.next();
		kbd.close();

		try {
			Scanner input = new Scanner(new FileReader(filename));
			// C:/Users/Jonathan/Downloads/Students.txt
			// C:/Users/Jonathan/Downloads/FullRoster.txt

			int counter = 0;
			//Reading
			while(input.hasNextLine() && counter < 100) { //Assures we are within the bounds of the max student amnt
				Scanner line = new Scanner(input.nextLine());
				line.useDelimiter("[:\t \r]"); 
				line.useDelimiter("[\t-]");
				String name = line.next();
				//System.out.println("Name: " + name);           //Test
				char gender = line.next().charAt(0);
				//System.out.println("Gender: " + gender);      //Test
				int month = line.nextInt();
				//System.out.println("Month: " + month);        //Test
				int day = line.nextInt();
				//System.out.println("Day: " + day);            //Test
				int year = line.nextInt();
				//System.out.println("Year: " + year);           //Test
				int quietTime = line.nextInt();
				//System.out.println("QuietTime Value: " + quietTime);//Test
				int music = line.nextInt();
				//System.out.println("Music Value: " + music);      //Test   
				int reading = line.nextInt();
				//System.out.println("Reading Value: " + reading);  //Test
				int chatting = line.nextInt();
				//System.out.println("Chatting Value: " + chatting); //Test
				Date dt = new Date(year, month, day);
				Preference pref = new Preference(quietTime, music, reading, chatting);
				students[counter] = new Student(name, gender, dt, pref);
				counter++;
				line.close();
			}

			input.close();

			//Check Compatiblity
			System.out.println();

			for(int i = 0; i < counter; i++) {
				if(!students[i].getMatched()) { //Will only follow on to compare if the current student is matched
					int bestStudentMarker = 0;   //Marks the index for the best student match so far
					int bestScore = 0;
					//System.out.println(students[i].getName() + ": " + students[i].getMatched());  TEST
					for(int j = i+1; j < counter; j++) {
						if(!students[j].getMatched()) {          //Assures that no student being compared is already matched
							int currentScore = students[i].compare(students[j]);
							if(currentScore > bestScore) {
								bestScore = students[i].compare(students[j]);
								bestStudentMarker = j;
							}
						}
					}
					if(bestScore <= 0) {
						System.out.println(students[i].getName() + " has no matches.");
					}else {
						System.out.println(students[i].getName() + " matches with " + students[bestStudentMarker].getName() + " with the score " + bestScore);
						students[i].setMatch();
						students[bestStudentMarker].setMatch();
					}
				}
			}
		}catch (FileNotFoundException e){
			System.out.println(e);
		}catch (NoSuchElementException e){
			System.out.println(e);
		}
	}

}
