package se.middleware.rackartyg;

import java.util.Date;

public class HeapFillerInfo {

	private HeapFillerSettings settings;
	private int MBFilled;
	private Date startTime;
	private int numberOfAllocations;
	private Boolean isStarted;
	
	public HeapFillerSettings getSettings() {
		return settings;
	}

	public void setSettings(HeapFillerSettings settings) {
		this.settings = settings;
	}

	public int getMBFilled() {
		return MBFilled;
	}

	public void setMBFilled(int mBFilled) {
		MBFilled = mBFilled;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getNumberOfAllocations() {
		return numberOfAllocations;
	}

	public void setNumberOfAllocations(int numberOfAllocations) {
		this.numberOfAllocations = numberOfAllocations;
	}

	public Boolean getIsStarted() {
		return isStarted;
	}

	public void setIsStarted(Boolean isStarted) {
		this.isStarted = isStarted;
	}
	
	
}
