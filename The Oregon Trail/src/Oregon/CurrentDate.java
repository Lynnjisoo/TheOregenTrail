package Oregon;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CurrentDate {
	public static CurrentDate cDate; //Singleton instance 
	
	Date date;
	
	public static long  unix_march	 = 1488326400000L;
	public static long  unix_april	 = 1491004800000L;
	public static long  unix_may	 = 1493596800000L;
	public static long  unix_june	 = 1496275200000L;
	public static long  unix_july	 = 1498867200000L;
	
	
	private CurrentDate(Date date) {
		this.date = date;
		
	}
	
	public void daysForward(int days) {
		//Create instance of calendar class
		Calendar cal = Calendar.getInstance();
		//Set time in the calendar object to the time of our date 
		cal.setTime(this.date);
		//add a number of days to the date(number passed in as days)
		cal.add(Calendar.DATE, days);
		this.date = cal.getTime();
		
	}
	
	public int  dayOfTheWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	//date.
	
	public String outputDate() {
		SimpleDateFormat df = new SimpleDateFormat("MMMM d");
		return df.format(this.cDate);
	}
	
	public static Date setupCurrentDate() {
		long[] options = {unix_march, unix_april, unix_may, unix_june, unix_july};
		//1. Output options
		listDateOptions(options);
		//2. Get/Validate user input
		int response = getUserDepartureMonth(options);
		//3. Setup and return the Date object 
		return new Date(options[response]);
	}
	
	private static int getUserDepartureMonth(long[] options) {
		Scanner input = new Scanner(System.in);
		
		while (true) {
			if(input.hasNextInt()) {
			int choice = input.nextInt();
				if((choice < 1 || choice > options.length)) {
					System.out.println("Please insert a valid option!");
					continue;
				}
				return choice - 1;
			}else{
				System.out.println("Please enter a number! ");
				input.nextLine();
				}
		}
	}

	public static void listDateOptions(long[] unix_timestamps) {
		//turning these options into actual dates
		SimpleDateFormat df = new SimpleDateFormat("MMMM");
		Date[] dates = new Date[unix_timestamps.length];
		
		for(int i = 0; i < unix_timestamps.length; i++) {
			dates[i] = new Date(unix_timestamps[i]);
			
		}
		//Output
		System.out.println("When would you like to embark on your journey?");
		for(int i = 0; i < unix_timestamps.length; i++) {
			System.out.printf("%d. %-7s%n", i + 1, df.format(dates[i]));
		}
	}
	
	public static CurrentDate getCurrentDate() {
		//check it cDate is null
		//if it is null, set it up
		//return cDate 
		
		if(cDate == null) {
			Date date = setupCurrentDate(); 
			cDate = new CurrentDate(date);
		}
		return cDate;
	}
	
	public int getDayInYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_YEAR);
	}
}
