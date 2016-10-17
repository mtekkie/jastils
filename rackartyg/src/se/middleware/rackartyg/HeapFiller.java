package se.middleware.rackartyg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Startup
@Singleton
@Path("/heap")
public class HeapFiller {
	
	private HeapFillerSettings settings;
	private Boolean isStarted = false;
	private Date startTime;
	private int numberOfAllocations;
	private int MBFilled;
	private ArrayList <char[]> data = new ArrayList<char[]>();

	@GET
	@Produces("application/json")
	public Object getInfo () {
		HeapFillerInfo hfi = new HeapFillerInfo();
		
		hfi.setIsStarted(isStarted);
		hfi.setSettings(this.settings);
		hfi.setMBFilled(MBFilled);
		hfi.setNumberOfAllocations(numberOfAllocations);
		hfi.setStartTime(startTime);
		
		return hfi;	
	}
	
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void startFormData(@FormParam("chunkSizeInMB") int chunkSizeInMB, @FormParam("waitTimeInSeconds") int  waitTimeInSeconds){
		HeapFillerSettings settings = new HeapFillerSettings();
		settings.setChunkSizeInMB(chunkSizeInMB);
		settings.setWaitTimeInSeconds(waitTimeInSeconds);
		start(settings);
	}
	
	@POST
	@Consumes("application/json")
	public void start (HeapFillerSettings settings){
		this.settings = settings;
		this.startTime = new Date();
		this.isStarted = true;
		
		//Loop forever or until stopped. 
		while (true){
			// UTF-16, each char is 2 bytes. a = 1 MB
			char[] a = new char [(this.settings.getChunkSizeInMB()*1024*1024/2)];
			Arrays.fill(a, 'r');
			data.add(a);
			this.MBFilled=this.MBFilled+this.settings.getChunkSizeInMB();
			this.numberOfAllocations=this.numberOfAllocations+1;
			
			try {
				Thread.sleep(settings.getWaitTimeInSeconds()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}