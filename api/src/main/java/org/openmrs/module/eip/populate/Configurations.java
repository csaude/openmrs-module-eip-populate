package org.openmrs.module.eip.populate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.openmrs.module.populate.main.utils.ObjectMapperProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Configurations {
	private String dbURL;
	private int qtyUsers;
	private int dayDuration;
	private Date systemStartDate;
	private int[] operationsDuration;
	private int[] providers;
	private int[] encounterTypes;
	private int[] visitTypes;
	private int[] patientIdentifyTypes;
	private int[] programs;
	
	public Configurations() {
		
	}
	
	public String getDbURL() {
		return dbURL;
	}
	
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	
	public int getQtyUsers() {
		return qtyUsers;
	}
	
	public void setQtyUsers(int qtyUsers) {
		this.qtyUsers = qtyUsers;
	}
	
	public int getDayDuration() {
		return dayDuration;
	}
	
	public void setDayDuration(int dayDuration) {
		this.dayDuration = dayDuration;
	}
	
	public Date getSystemStartDate() {
		return systemStartDate;
	}
	
	public void setSystemStartDate(Date systemStartDate) {
		this.systemStartDate = systemStartDate;
	}
	
	public int[] getOperationsDuration() {
		return operationsDuration;
	}
	
	public void setOperationsDuration(int[] operationsDuration) {
		this.operationsDuration = operationsDuration;
	}
	
	public static Configurations loadFromFile(File file) throws IOException {
		Configurations conf = Configurations.loadFromJSON(new String(Files.readAllBytes(file.toPath())));
		
		return conf;
	}
	
	public int[] getProviders() {
		return providers;
	}

	public void setProviders(int[] providers) {
		this.providers = providers;
	}

	public int[] getEncounterTypes() {
		return encounterTypes;
	}

	public void setEncounterTypes(int[] encounterTypes) {
		this.encounterTypes = encounterTypes;
	}

	public int[] getVisitTypes() {
		return visitTypes;
	}

	public void setVisitTypes(int[] visitTypes) {
		this.visitTypes = visitTypes;
	}

	public int[] getPatientIdentifyTypes() {
		return patientIdentifyTypes;
	}

	public void setPatientIdentifyTypes(int[] patientIdentifyTypes) {
		this.patientIdentifyTypes = patientIdentifyTypes;
	}

	public int[] getPrograms() {
		return programs;
	}

	public void setPrograms(int[] programs) {
		this.programs = programs;
	}

	public static Configurations loadFromJSON (String json) {
		try {
			Configurations config = new ObjectMapperProvider().getContext(Configurations.class).readValue(json, Configurations.class);
			
			return config;
		} catch (JsonParseException e) {
			e.printStackTrace();
		
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			
			throw new RuntimeException(e);
		} 
	}

}
