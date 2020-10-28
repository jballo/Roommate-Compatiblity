
public class Student {
	private String name = "";
	private char gender;
	private Date birthdate;
	private Preference pref;
	private Boolean matched = false;


	public Student (String name, char gender, Date birthdate, Preference pref) {
		//System.out.println("Inside Student Constructor so name is " + name + " and gender is " + gender);
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.pref = pref;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public Preference getPreference() {
		return pref;
	}

	public Boolean getMatched() {
		return matched;
	}
	public void setMatch() {
		matched = true;
	}

	public int compare(Student st) {
		if(!(st.getGender() == gender)) {
			return 0;
		}else {
			//System.out.println("Comparison between " + getName()+ " & " + st.getName());

			int compatScore = 0;         //Highest = 100 & lowest = 0
			int tempPref = 40-pref.compare(st.getPreference());
			//System.out.println("Preference Dif: " + tempPref);
			int tempAgeDif = (60-birthdate.compare(st.birthdate));
			//System.out.println("Age Dif: " + tempAgeDif);
			//System.out.println("Age Dif in months: " + tempAgeDif);



			compatScore = tempPref + tempAgeDif;

			if(compatScore >= 100) 
				return 100;
			else if(compatScore <= 0) 
				return 0;
			else
				return compatScore;
		}

	}

}
