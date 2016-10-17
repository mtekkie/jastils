package se.middleware.jastil;

public class HeapInfo {
	
	private long usedMemory;
	private long freeMemory;
	private long totalMemory;
	private long maxMemory;
	private static int mb = 1024*1024;
	private Runtime runtime = Runtime.getRuntime();
	
	
	public long getUsedMemory() {
		usedMemory=(runtime.totalMemory() - runtime.freeMemory()) / mb;
		return usedMemory;
	}
	public long getFreeMemory() {
		freeMemory=runtime.freeMemory() / mb;
		return freeMemory;
	}
	public long getTotalMemory() {
		totalMemory=runtime.totalMemory() / mb;
		return totalMemory;
	}
	public long getMaxMemory() {
		maxMemory=runtime.maxMemory() / mb;
		return maxMemory;
	}

}
