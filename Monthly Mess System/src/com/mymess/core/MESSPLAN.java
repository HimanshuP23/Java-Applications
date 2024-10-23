package com.mymess.core;

public enum MESSPLAN {
	MONTHLY(3000,1), QUARTERLY(11700,3), HALFYEARLY(17500,6), YEARLY (32000,12);
	
	 int messfees;
	 int month;
	

	private MESSPLAN(int messfees,int month) {
		this.messfees = messfees;
		this.month = month;
	}

	
	public long getMonth() {
		return month;
	}


	public int getMessfees() {
		return messfees;
	}


	public void setMessfees(int messfees) {
		this.messfees = messfees;
	}
	

	
}
