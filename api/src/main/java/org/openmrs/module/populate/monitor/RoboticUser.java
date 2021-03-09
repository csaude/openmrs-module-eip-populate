package org.openmrs.module.populate.monitor;

import java.sql.Connection;

import org.openmrs.module.eip.populate.System_;
import org.openmrs.module.populate.main.model.Record;
import org.openmrs.module.populate.main.model.RecordDAO;
import org.openmrs.module.populate.main.utils.RecordGenerator;
import org.openmrs.module.populate.main.utils.concurrent.MonitoredOperation;
import org.openmrs.module.populate.main.utils.concurrent.TimeController;
import org.openmrs.module.populate.main.utils.db.DBException;
import org.openmrs.module.populate.main.utils.db.OpenConnection;
import org.openmrs.module.populate.main.utils.exceptions.ForbiddenOperationException;

public class RoboticUser implements MonitoredOperation{
	private String userName;
	//private Operation[] operations;
	
	//private int nextOperation;
	
	public RoboticUser(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	/*
	public void determineOperations(int qtyOperations) {
		this.nextOperation = 0;
		this.operations = Operation.randomOperations(qtyOperations);
	}
	*/
	
	@Override
	public void run() {
		while(true) {
			Operation nextOperation = Operation.randomOperation();
			
			executeNextOperation(nextOperation);
			
			try {Thread.sleep(1000*nextOperation.getDuration());} catch (InterruptedException e) {}
			
			//this.nextOperation = determineNextOperation();
		}
	}

	/*
	private int determineNextOperation() {
		int nextOp = nextOperation + 1;
		
		if (nextOp > this.operations.length) nextOp = 0;
		
		return nextOp;
	}*/

	//Operation nextOperation;
	
	@SuppressWarnings("unused")
	private Operation tmpNextOperation() {
		Operation nextOperation = Operation.randomOperation();
		
		if (nextOperation == null) return Operation.createPatient();
		
		if (nextOperation.isCreatePatientOperation()) return Operation.createEncounter();
		
		if (nextOperation.isCreateEncounterOperation()) return Operation.generatePatientProgram();
		
		if (nextOperation.isGeneratePatientProgramOperation()) return Operation.createPatientState();
		
		if (nextOperation.isGeneratePatientStateOperation()) return Operation.addNewPersonAddress();
		
		if (nextOperation.isAddNewPersonAddressOperation()) return Operation.addNewPersonName();
		
		if (nextOperation.isAddPersonNameOperation()) return Operation.addPatientIdentify();
		
		throw new ForbiddenOperationException("Finished");
	}
	
	private void executeNextOperation(Operation nextOperation) {
		
		OpenConnection conn = System_.getInstance().openConnection();
		
		try {
			if (nextOperation.isCreatePatientOperation()) {
				System_.logOperationStarted(this, nextOperation);
				
				RecordGenerator.generateAndInsertPatient(this, false, conn);
				
				System_.logOperationFinished(this, nextOperation);
			}
			else
			if (nextOperation.isCreateEncounterOperation()) {
				System_.logOperationStarted(this, nextOperation);
				
				Record patient = RecordDAO.findPatient(nextOperation, conn);
				
				if (patient == null) {
					patient = RecordGenerator.generateAndInsertPatient(this, true, conn);
				}
				
				RecordGenerator.generateAndInsertEncounter(patient, this, false, conn);
				
				patient.unlock(conn);
				
				System_.logOperationFinished(this, nextOperation);
			}
			else
			if(nextOperation.isGeneratePatientProgramOperation()) {
				System_.logOperationStarted(this, nextOperation);
				
				generatePatientProgram(false, conn);
				
				System_.logOperationFinished(this, nextOperation);
			}
			else
			if(nextOperation.isGeneratePatientStateOperation()) {
				System_.logOperationStarted(this, nextOperation);
				
				Record program = RecordDAO.findPatientProgramForState(conn);
				
				if (program == null) {
					program = generatePatientProgram(true, conn);
				}
				
				RecordGenerator.generateAndInsertPatientState(program, this, false, conn);
				
				program.unlock(conn);
				
				System_.logOperationFinished(this, nextOperation);
			}
			else
			if (nextOperation.isAddNewPatientIdentifyOperation()) {
				System_.logOperationStarted(this, nextOperation);
				
				Record patient = RecordDAO.findPatient(nextOperation, conn);
				
				if (patient == null) {
					patient = RecordGenerator.generateAndInsertPatient(this, true, conn);
				}
				
				RecordGenerator.generateAndInsertPatientIdentify(patient, this, false, conn);
				
				patient.unlock(conn);
			
				System_.logOperationFinished(this, nextOperation);
			}
			else
			if (nextOperation.isAddNewPersonAddressOperation()) {
				System_.logOperationStarted(this, nextOperation);
				
				Record patient = RecordDAO.findPatient(nextOperation, conn);
				
				if (patient == null) {
					patient = RecordGenerator.generateAndInsertPatient(this, true, conn);
				}
				
				RecordGenerator.generateAndInsertPersonAddress(patient, this, false, conn);
				
				patient.unlock(conn);	
				
				System_.logOperationFinished(this, nextOperation);
			}
			else
			if (nextOperation.isAddPersonNameOperation()) {
				System_.logOperationStarted(this, nextOperation);
				
				Record patient = RecordDAO.findPatient(nextOperation, conn);
				
				if (patient == null) {
					patient = RecordGenerator.generateAndInsertPatient(this, true, conn);
				}
				
				RecordGenerator.generateAndInsertPersonName(patient, this, false, conn);
				
				patient.unlock(conn);	
				System_.logOperationFinished(this, nextOperation);
			}
			else throw new ForbiddenOperationException("The operation '"+nextOperation.getCode() + "' is not supported!");
			
			conn.markAsSuccessifullyTerminected();
		} catch (DBException e) {
			e.printStackTrace();
		}
		finally {
			conn.finalizeConnection();
		}
	}
	
	private Record generatePatientProgram(boolean lockIt, Connection conn) throws DBException {
		Record patient = RecordDAO.findPatient(Operation.generatePatientProgram(), conn);
		
		if (patient == null) {
			patient = RecordGenerator.generateAndInsertPatient(this, true, conn);
		}
		
		Record record = RecordGenerator.generateAndInsertPatientProgram(patient, this, false, conn);
		
		patient.unlock(conn);
		
		if (lockIt) record.lock(conn);
		
		return record;
	}
	
	@Override
	public TimeController getTimer() {
		return null;
	}

	@Override
	public void requestStop() {
	}

	@Override
	public boolean stopRequested() {
		return false;
	}

	@Override
	public boolean isNotInitialized() {
		return false;
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public boolean isStopped() {
		return false;
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public boolean isPaused() {
		return false;
	}

	@Override
	public boolean isSleeping() {
		return false;
	}

	@Override
	public void changeStatusToRunning() {
	}

	@Override
	public void changeStatusToStopped() {
	}

	@Override
	public void changeStatusToFinished() {
	}

	@Override
	public void changeStatusToPaused() {
	}

	@Override
	public void changeStatusToSleeping() {
	}

	@Override
	public void onStart() {
	}

	@Override
	public void onSleep() {
	}

	@Override
	public void onStop() {
	}

	@Override
	public void onFinish() {
	}

	@Override
	public int getWaitTimeToCheckStatus() {
		return 0;
	}
}
