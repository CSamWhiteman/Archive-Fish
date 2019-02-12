package model;

import java.text.DecimalFormat;

public class CreditCard {
	// User identifiers
	String fname;
	String lname;
	int accountNum;
	
	// User variables
	double balance;
	double payment;
	double interestAccrual;
	
	// Constants
	double percentToPay;
	private double initialPayment;
	final double interest = 0.015;
	
	// formatting
	DecimalFormat df = new DecimalFormat("0.00"); 
	
	public void oneMonth() { //only to be called in makeTable()
		//update variables
		interestAccrual = balance * interest;
		balance = balance + interestAccrual;
		
		payment = balance * percentToPay;
		balance = balance - payment;
	}
		
	public String makeTable(CreditCard cc) {
		// table head	
		String thead;
		thead =   "<thead>"
				+ "<th>Month</th>"
				+ "<th>Interest</th>"
				+ "<th>Payment</th>"
				+ "<th>Balance</th>"
				+ "</thead>";
		
		// table row
		String tbody = "";
		// first row housekeeping
		initialPayment = balance * percentToPay;
		int month = 1;
		String trow;
		while (balance > initialPayment) {
			cc.oneMonth();
			trow = 	  "<tr>"
					+ "<td>" + month + "</td>" 				//month ++
					+ "<td>$" + df.format(interestAccrual) + "</td>"	//how much interest accrual this month?
					+ "<td>$" + df.format(payment) + "</td>"			//how much was the payment this month?
					+ "<td>$" + df.format(balance) + "</td>"			//how much is the ending balance, after last two operations?
					+ "</tr>";
			tbody = tbody + trow;
			month++;
			
		}
		
		// last month
		interestAccrual = balance * interest;
		balance = balance + interestAccrual;
		payment = balance;
		balance = 0;
		trow = 	  "<tr>"
				+ "<td>" + month + "</td>" 				//month ++
				+ "<td>$" + df.format(interestAccrual) + "</td>"	//how much interest accrual this month?
				+ "<td>$" + df.format(payment) + "</td>"			//how much was the payment this month?
				+ "<td>$" + df.format(balance) + "</td>"			//how much is the ending balance, after last two operations?
				+ "</tr>";
		tbody = tbody + trow;
		
		
		
		String open = "<table>";
		String close = "</table>";
		String table = open + thead + tbody + close;
		return table;
	}

	public String makeInformation(CreditCard cc) {
		String out;
		out = "<p><em>Name:</em> " + fname + " " + lname + "</p>"
			+  "<p><em>Account Number:</em> " + accountNum + "</p>" 
			+  "<p><em>Balance Due:</em> $" + balance + "</p>";
		return out;
	}
	
	public CreditCard(String fname, String lname,int accountNum, double balance, double percentToPay) {
		this.fname = fname;
		this.lname = lname;
		this.accountNum = accountNum;
		this.balance = balance;
		this.percentToPay = percentToPay;
	}
	
	public CreditCard() {
		this.fname = "Sam";
		this.lname = "Whiteman";
		this.accountNum = 1;
		this.balance = 500;
		this.percentToPay = 0.10;
	}
	
	

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the percentToPay
	 */
	public double getPercentToPay() {
		return percentToPay;
	}

	/**
	 * @param percentToPay the percentToPay to set
	 */
	public void setPercentToPay(double percentToPay) {
		this.percentToPay = percentToPay;
	}

	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}
}
