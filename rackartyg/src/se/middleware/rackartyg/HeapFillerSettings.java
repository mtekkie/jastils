package se.middleware.rackartyg;

public class HeapFillerSettings {
	
	private int chunkSizeInMB;
	private int waitTimeInSeconds;
	
	public int getChunkSizeInMB() {
		return chunkSizeInMB;
	}
	
	public void setChunkSizeInMB(int chunkSizeInMB) {
		this.chunkSizeInMB = chunkSizeInMB;
	}
	
	public int getWaitTimeInSeconds() {
		return waitTimeInSeconds;
	}
	
	public void setWaitTimeInSeconds(int waitTimeInSeconds) {
		this.waitTimeInSeconds = waitTimeInSeconds;
	}

	
}
