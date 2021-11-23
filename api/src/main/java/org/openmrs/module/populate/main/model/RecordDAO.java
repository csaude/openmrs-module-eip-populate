package org.openmrs.module.populate.main.model;

import java.sql.Connection;

import org.openmrs.module.populate.main.model.base.BaseDAO;
import org.openmrs.module.populate.main.utils.db.DBException;
import org.openmrs.module.populate.main.utils.exceptions.ForbiddenOperationException;
import org.openmrs.module.populate.monitor.Operation;
import org.openmrs.module.populate.monitor.RoboticUser;

public class RecordDAO extends BaseDAO {
	public static void executeRecordInsert(Record record, Connection conn) throws DBException {
		BaseDAO.executeDBQuery(record.getInsertSQL(), record.getInsertParams(), conn);
		
		record.setRelatedOpenMrsRecordId(retrieveRecordIdByUuid(record.getRelatedOpenMrsRecordTable(), record.getRelatedOpenMrsRecordUuid(), conn));
	}
	
	public static boolean recordExists(String tableName, int recordId, Connection conn) throws DBException {
		Object[] params = {recordId};
	
		String sql = " SELECT	" + tableName + "_id related_open_mrs_record_id " +
					 " FROM		" + tableName + 
					 " WHERE 	" + tableName + "_id";
		
		return find(Record.class, sql, params, conn) != null;
	}
	
	public static int retrieveRecordIdByUuid(String tableName, String uuid, Connection conn) throws DBException {
		Object[] params = {uuid};
	
		if (tableName.equals("patient")) tableName = "person";
		
		String sql = " SELECT	" + tableName + "_id related_open_mrs_record_id " +
					 " FROM		" + tableName + 
					 " WHERE 	uuid = ? ";
		
		return find(Record.class, sql, params, conn).getRelatedOpenMrsRecordId();
	}
	
	public static void insert(Record record, RoboticUser user, Operation operation, boolean lock, Connection conn) throws DBException {
		Object[] params = {record.getRelatedOpenMrsRecordId(),
						   record.getRelatedOpenMrsRecordUuid(),
						   record.getRelatedOpenMrsRecordTable(),
						   record.getRelatedOpenMrsRecordDate(),
						   user.getUserName(),
						   operation.getCode(),
						   lock};
		
		String sql = " INSERT INTO eip_populate_record ( related_open_mrs_record_id, " +
					 "									 related_open_mrs_record_uuid,"+
					 "									 related_open_mrs_record_table,"+
					 "									 related_open_mrs_record_date," +
					 "									 user_name,"+
					 "									 operation, " + 
					 "									 locked)" +
					 " VALUES(?," +
					 "		  ?," +
					 "		  ?,"+
					 "		  ?,"+
					 "		  ?," +
					 "		  ?," +
					 "		  ?)";
		
		executeQuery(sql, params, conn);
	}
	
	public static synchronized Record findPatient(Operation nextOperation, Connection conn) throws DBException {
		if (nextOperation.isCreateEncounterOperation()){
			return findPatientForNextEncounter(conn);
		}
		else
		if (nextOperation.isAddNewPatientIdentifyOperation()) {
			return findPatientForDemograficUpdate(conn);
		}
		else
		if (nextOperation.isAddNewPersonAddressOperation()) {
			return findPatientForDemograficUpdate(conn);
		}
		else
		if (nextOperation.isAddPersonNameOperation()) {
			return findPatientForDemograficUpdate(conn);
		}
		else
		if (nextOperation.isGeneratePatientProgramOperation()) {
			return findPatientForProgram(conn);
		}
		else throw new ForbiddenOperationException("Not supported operation for find patient");
	}
	
	private static synchronized Record findPatientForNextEncounter(Connection conn) throws DBException {
		Object[] params = {"patient", false, 5096, org.openmrs.module.eip.populate.System_.getSystemDate()};
		
		String sql = " SELECT patient_id related_open_mrs_record_id " +
					 " FROM patient INNER JOIN eip_populate_record on eip_populate_record.related_open_mrs_record_id = patient.patient_id " +
					 " WHERE eip_populate_record.related_open_mrs_record_table = ? " +
					 "		 AND eip_populate_record.locked = ? " +	
					 "		 AND NOT EXISTS ( SELECT * " +
					 " 						  FROM encounter INNER JOIN obs ON obs.encounter_id = encounter.encounter_id " +
					 " 						  WHERE obs.concept_id = ? " +
					 "								AND patient.patient_id = encounter.patient_id " +
					 "		 						AND obs.value_datetime > ?) ";
		
		
		Record record = find(Record.class, sql, params, conn);
		
		if (record != null) {
			record.lock(conn);
		}
		
		return record;
	}
	
	private static synchronized Record findPatientForDemograficUpdate(Connection conn) throws DBException {
		Object[] params = {"patient", false};
		
		String sql = " SELECT 	patient_id related_open_mrs_record_id " +
					 " FROM 	patient INNER JOIN eip_populate_record on eip_populate_record.related_open_mrs_record_id = patient.patient_id " +
					 " WHERE 	eip_populate_record.related_open_mrs_record_table = ? " +
					 "		 	AND eip_populate_record.locked = ? ";
		
		Record record = find(Record.class, sql, params, conn);
		
		if (record != null) {
			record.lock(conn);
		}
		
		return record;
	}
	
	private static synchronized Record findPatientForProgram(Connection conn) throws DBException {
		Object[] params = {"patient", false};
		
		String sql = " SELECT patient_id related_open_mrs_record_id  " +
					 " FROM patient INNER JOIN eip_populate_record on eip_populate_record.related_open_mrs_record_id = patient.patient_id " +
					 " WHERE eip_populate_record.related_open_mrs_record_table = ? " +
					 "		 AND eip_populate_record.locked = ? ";
		
		Record record = find(Record.class, sql, params, conn);
	
		if (record != null) {
			record.lock(conn);
		}
		
		return record;
	}
	
	public static synchronized Record findPatientProgramForState(Connection conn) throws DBException {
		Object[] params = {"patient_program", false};
		
		String sql = " SELECT 	patient_program_id related_open_mrs_record_id  " +
					 " FROM 	patient_program INNER JOIN eip_populate_record on eip_populate_record.related_open_mrs_record_id = patient_program.patient_program_id " +
					 " WHERE 	eip_populate_record.related_open_mrs_record_table = ? " +
					 "		 	AND eip_populate_record.locked = ? ";
		
		
		Record record = find(Record.class, sql, params, conn);
		
		if (record != null) {
			record.lock(conn);
		}
		
		return record;
	}
	
	
	public static Record findLastStateOfProgram(Record patientProgram, Connection conn) throws DBException {
		Object[] params = {patientProgram.getRelatedOpenMrsRecordId()};

		String sql = " SELECT 	patient_state_id related_open_mrs_record_id  " +
					 " FROM 	patient_state " +
					 " WHERE 	patient_state_id  = (	SELECT max(patient_state_id) " +
					 "									FROM patient_state " +
					 "									WHERE patient_program_id = ?) ";
		
		return find(Record.class, sql, params, conn);
	}
	
	public static Record findLastPatientProgram(Record patient, Connection conn) throws DBException {
		Object[] params = {patient.getRelatedOpenMrsRecordId()};
		
		String sql = " SELECT 	patient_program_id related_open_mrs_record_id  " +
					 " FROM 	patient_program " +
					 " WHERE 	patient_id  = (	SELECT max(patient_program_id) " +
					 "							FROM patient_program " +
					 "							WHERE patient_id = ?) ";
		
		return find(Record.class, sql, params, conn);
	}

	private static synchronized void lockUnLock(Record record, boolean lock, Connection conn) throws DBException {
		Object[] params = {lock,
						   record.getRelatedOpenMrsRecordId(),
						   record.getRelatedOpenMrsRecordTable()};
	
		String sql = "UPDATE eip_populate_record " +
					 "SET    locked = ? " +
					 "WHERE  related_open_mrs_record_id = ? " +
					 "		 AND related_open_mrs_record_table = ? ";	
		
		executeQuery(sql, params, conn);
	}

	public static void unlock(Record record, Connection conn) throws DBException {
		lockUnLock(record, false, conn);
	}
	
	public static void lock(Record record, Connection conn) throws DBException {
		lockUnLock(record, true, conn);
	}
}
