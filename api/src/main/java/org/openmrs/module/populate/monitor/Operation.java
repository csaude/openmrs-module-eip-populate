package org.openmrs.module.populate.monitor;

import org.openmrs.module.populate.main.utils.CommonUtilities;
import org.openmrs.module.populate.main.utils.RandomValues;

public class Operation {
	static CommonUtilities utilities = CommonUtilities.getInstance();
	
	static final String CREATE_PATIENT_OPERATION = "CREATE_PATIENT";
	//static final String CREATE_FILA_FORM_DATA_OPERATION = "CREATE_FILA_FORM_DATA";
	static final String GENERATE_PATIENT_PROGRAM_OPERATION = "GENERATE_PATIENT_PROGRAM";
	static final String GENERATE_PATIENT_STATE_OPERATION = "GENERATE_PATIENT_STATE";
	static final String CREATE_ENCOUNTER_OPERATION = "CREATE_ENCOUNTER";
	//static final String CREATE_VISIT_OPERATION = "CREATE_VISIT";
	static final String ADD_NEW_PERSON_NAME_OPERATION = "ADD_PERSON_NAME";
	static final String ADD_NEW_PERSON_ADDRESS = "ADD_PERSON_ADDRESS";
	static final String ADD_NEW_PATIENT_IDENTIFY = "ADD_PATIENT_IDENTIFY";
	
	static final String[] avaliableOperations = {CREATE_PATIENT_OPERATION, GENERATE_PATIENT_PROGRAM_OPERATION, GENERATE_PATIENT_STATE_OPERATION, CREATE_ENCOUNTER_OPERATION, ADD_NEW_PERSON_NAME_OPERATION, ADD_NEW_PERSON_ADDRESS, ADD_NEW_PATIENT_IDENTIFY} ;//CREATE_FILA_FORM_DATA_OPERATION, CREATE_VISIT_OPERATION
	//static final int[] durations = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
	
	//static final int[] durations = {0, 1, 2, 3, 4, 5};
	
	private String code;
	
	/**
	 * The time (senconds) takes to complete this operation
	 */
	private int duration;
	
	public Operation( String code) {
		this.code = code;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean isCreatePatientOperation() {
		return this.code.equals(Operation.CREATE_PATIENT_OPERATION);
	}
	
	/*public boolean isCreateFilaFormDataOperation() {
		return this.code.equals(Operation.CREATE_FILA_FORM_DATA_OPERATION);
	}*/
	
	public boolean isGeneratePatientProgramOperation() {
		return this.code.equals(Operation.GENERATE_PATIENT_PROGRAM_OPERATION);
	}
	
	public boolean isGeneratePatientStateOperation() {
		return this.code.equals(Operation.GENERATE_PATIENT_STATE_OPERATION);
	}
	
	public boolean isCreateEncounterOperation() {
		return this.code.equals(Operation.CREATE_ENCOUNTER_OPERATION);
	}
	
	/*
	public boolean isCreateVisitOperation() {
		return this.code.equals(Operation.CREATE_VISIT_OPERATION);
	}
	*/
	
	public boolean isAddPersonNameOperation() {
		return this.code.equals(Operation.ADD_NEW_PERSON_NAME_OPERATION);
	}
	
	public boolean isAddNewPersonAddressOperation() {
		return this.code.equals(Operation.ADD_NEW_PERSON_ADDRESS);
	}
	
	public boolean isAddNewPatientIdentifyOperation() {
		return this.code.equals(Operation.ADD_NEW_PATIENT_IDENTIFY);
	}
	
	public static Operation randomOperation(int[] durations) {
		String operationCode = avaliableOperations[RandomValues.randomInteger(avaliableOperations.length - 1)];
		
		Operation operation =  new Operation(operationCode);
		
		operation.setDuration(durations[RandomValues.randomInteger(durations.length - 1)]);
		
		return operation;
	}
	
	/*public static Operation[] randomOperations(int qtyOperations) {
		Operation[] operations = new Operation[qtyOperations];
		
		if (qtyOperations > avaliableOperations.length) throw new ForbiddenOperationException("The specified number of operations is out of range!!!");
		
		for (int i = 0; i < qtyOperations; i ++) {
			String operationCode = avaliableOperations[RandomValues.randomInteger(qtyOperations) - 1];
			
			while(findOnList(operations, operationCode) != null) {
				operationCode = avaliableOperations[RandomValues.randomInteger(qtyOperations) - 1];	
			};
			
			operations[i] =  new Operation(operationCode);
		}
		
		return operations;
	}
	
	private static Operation findOnList(Operation[] operations, String operationCode) {
		for (Operation operation : operations) {
			if (operation != null && operation.getCode().equals(operationCode)) return operation;
		}
		
		return null;
	}
	
	*/
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		
		if (!(obj instanceof Operation)) return false;
		
		return this.code.equals(((Operation)obj).getCode());
	}
	
	public static Operation createPatient() {
		return new Operation(Operation.CREATE_PATIENT_OPERATION);
	}
	
	public static Operation createPatientState() {
		return new Operation(Operation.GENERATE_PATIENT_STATE_OPERATION);
	}
	
	public static Operation createEncounter() {
		return new Operation(Operation.CREATE_ENCOUNTER_OPERATION);
	}
	
	/*public static Operation createFilaFormData() {
		return new Operation(Operation.CREATE_FILA_FORM_DATA_OPERATION);
	}*/
	
	public static Operation generatePatientProgram() {
		return new Operation(Operation.GENERATE_PATIENT_PROGRAM_OPERATION);
	}
	
	/*
	public static Operation createVisit() {
		return new Operation(Operation.CREATE_VISIT_OPERATION);
	}
	*/
	
	public static Operation addNewPersonName() {
		return new Operation(Operation.ADD_NEW_PERSON_NAME_OPERATION);
	}
	
	public static Operation addNewPersonAddress() {
		return new Operation(Operation.ADD_NEW_PERSON_ADDRESS);
	}
	
	public static Operation addPatientIdentify() {
		return new Operation(Operation.ADD_NEW_PATIENT_IDENTIFY);
	}

}
	