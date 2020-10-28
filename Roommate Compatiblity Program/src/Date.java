
public class Date {
	private int year;
	private int month;
	private int day;


	public Date (int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int compare (Date dt) {
		int yearsDiffInDays = 0;
		int daysDifference = 0;

		int monthDifference = 0;

		yearsDiffInDays = (365 *(Math.abs(this.year-dt.getYear())));
		
		//System.out.println("Years Different in Days: " + yearsDiffInDays);
		
		daysDifference = (Math.abs(dayOfYear()-dt.dayOfYear()));

		//System.out.println("Days difference: " + daysDifference);
		
		monthDifference = (Math.abs(yearsDiffInDays - daysDifference));
		
		//System.out.println("Difference in days: " + totalDifference);
		monthDifference /= 30;
		if(monthDifference > 60)
			return 60;
		else
			return monthDifference;
	}


	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9:  totalDays += 31;
		case 8:  totalDays += 31;
		case 7:  totalDays += 30;
		case 6:  totalDays += 31;
		case 5:  totalDays += 30;
		case 4:  totalDays += 31;
		case 3:  totalDays += 28;
		case 2:  totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}
}
