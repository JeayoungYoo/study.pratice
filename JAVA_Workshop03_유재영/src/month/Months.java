package month;

public class Months {
	public int getDays (int months) {
		int lastday=0;
		if (months==9 || months==4 || months==6 || months==11)
			lastday=30;
		else if (months==1 || months==3 || months==5 || months==7 || months==8 || 
				months==10 || months==12)
			lastday=31;
		else
			lastday=28;
		return lastday;
	}
}
