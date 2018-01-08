/**
 * 
 */
package com.sudeepnm.redis.sortedsets.service;

/**
 * Bean Class to represent the Loan Data
 * @author Sudeep
 *
 */
public class LoanData {

	private String state;
	private String effDt;
	private String rate;
	
	/**
	 * Constructs that accepts State, Date and Rate as params
	 * @param st
	 * @param dt
	 * @param rt
	 */
	public LoanData(String st, String dt, String rt) {
		this.state = st;
		this.effDt = dt;
		this.rate = rt;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the effDt
	 */
	public String getEffDt() {
		return effDt;
	}

	/**
	 * @param effDt the effDt to set
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String pipe = "|";
		StringBuilder sb = new StringBuilder();
		sb.append("State: ").append(pipe).append(getState())
			.append("Effecte Date: ").append(pipe).append(getEffDt())
			.append("Rate: ").append(pipe).append(getRate());
		
		return sb.toString();
	}
	
}
