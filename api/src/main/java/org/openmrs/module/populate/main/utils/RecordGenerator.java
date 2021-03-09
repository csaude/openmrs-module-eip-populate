package org.openmrs.module.populate.main.utils;

import java.sql.Connection;
import java.util.Date;
import java.util.UUID;

import org.openmrs.module.eip.populate.System_;
import org.openmrs.module.populate.main.model.Record;
import org.openmrs.module.populate.main.model.RecordDAO;
import org.openmrs.module.populate.main.model.base.BaseDAO;
import org.openmrs.module.populate.main.utils.db.DBException;
import org.openmrs.module.populate.monitor.Operation;
import org.openmrs.module.populate.monitor.RoboticUser;

public class RecordGenerator {
	
	private static Record generateAndInsertPerson(RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "person";
		
		String insertSQL = "INSERT INTO person(	gender," +
						    "					birthdate," +
						    "					birthdate_estimated," +
						    "					dead, " +
						    "					creator," +
						    "					voided," +
						    "					uuid," +
						    "					deathdate_estimated," +
						    "					date_created)" +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = {RandomValues.randomGender(),
								 RandomValues.randomDateBirth(),
								 false,
								 false,
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 uuid,
								 false,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, (Date) insertParams[1]);
		
		record.executeInsert(conn);
		
		//record.save(user, Operation.createPatient(), lockIt, conn);
		
		return record;
	}
	
	public static Record generateAndInsertPersonName(Record person, RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "person_name";
		
		String insertSQL = "INSERT INTO person_name(preferred," +
						    "						person_id," +
						    "						given_name," +
						    "						middle_name, " +
						    "						family_name," +
						    "						creator," +
						    "						voided," +
						    "						uuid, "+
						    "					    date_created)" +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = {true,
								 person.getRelatedOpenMrsRecordId(),
								 RandomValues.randomFirstName(),
								 RandomValues.randomMiddleName(),
								 RandomValues.randomFamilyName(),
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 uuid,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, System_.getSystemDate());
		
		record.executeInsert(conn);
		
		record.save(user, Operation.addNewPersonName(), lockIt, conn);
		
		return record;
	}
	
	public static Record generateAndInsertPersonAddress(Record person,  RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "person_address";
		
		String insertSQL = "INSERT INTO person_address(	preferred," +
						    "							person_id," +
						    "							country," +
						    "							state_province, " +
						    "							city_village," +
						    "							creator," +
						    "							voided," +
						    "							uuid,"+
						    "							date_created)" +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = {true,
								 person.getRelatedOpenMrsRecordId(),
								 "Mocambique",
								 RandomValues.randomProvinceName(),
								 "Desconhecido",
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 uuid,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, System_.getSystemDate());
		
		record.executeInsert(conn);
		
		record.save(user, Operation.addNewPersonAddress(), lockIt, conn);
		
		return record;
	}
	
	@SuppressWarnings("unused")
	public static Record generateAndInsertPatient(RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		Record person = generateAndInsertPerson(user, lockIt, conn);
		Record personName = generateAndInsertPersonName(person, user, lockIt, conn);
		Record personAddress = generateAndInsertPersonAddress(person, user, lockIt, conn);
		
		String recordTable = "patient";
		
		String insertSQL = "INSERT INTO patient(patient_id," +
						    "					creator," +
						    "					voided," +
						    "					date_created)" +
						    "VALUES  (?,"+
						    "		  ?,"+
						    "		  ?,"+
						    "		  ?)";
		
		Object[] insertParams = {person.getRelatedOpenMrsRecordId(),
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record patient = new Record(person.getRelatedOpenMrsRecordUuid(), recordTable, insertSQL, insertParams, person.getRelatedOpenMrsRecordDate());
		
		patient.executeInsert(conn);
		
		Record patientIdentify = generateAndInsertPatientIdentify(patient, user, lockIt, conn);
		
		patient.save(user, Operation.createPatient(), lockIt, conn);
		
		return patient;
	}
	
	public static Record generateAndInsertPatientIdentify(Record patient, RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "patient_identifier";
		
		String insertSQL = "INSERT INTO patient_identifier(	patient_id," +
						    "								identifier," +
						    "								identifier_type," +
						    "								preferred, " +
						    "								location_id," +
						    "								creator," +
						    "								voided," +
						    "								uuid, "+
						    "								date_created)" +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = {patient.getRelatedOpenMrsRecordId(),
								 RandomValues.randomPatientIdentify(),
								 RandomValues.randomPatientIdentifyType(),
								 RandomValues.randomBoolean(),
								 DefaultValues.DEFAULT_LOCATION_ID,
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 uuid,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, System_.getSystemDate());
		
		record.executeInsert(conn);
		
		record.save(user, Operation.addPatientIdentify(), lockIt, conn);
		
		return record;
	}
	
	public static Record generateAndInsertPatientProgram(Record patient, RoboticUser user, boolean lockIt,  Connection conn) throws DBException {
		Record lastProgram = RecordDAO.findLastPatientProgram(patient, conn);
		
		if (lastProgram != null) {
			RecordGenerator.finishPatientProgram(lastProgram, conn);
		}
		
		String uuid = UUID.randomUUID().toString();
		String recordTable = "patient_program";
		
		String insertSQL = "INSERT INTO patient_program(	patient_id," +
						    "								program_id," +
						    "								location_id," +
						    "								date_enrolled,"+
						    "								creator," +
						    "								voided," +
						    "								uuid, " +
						    "								date_created)" +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = {patient.getRelatedOpenMrsRecordId(),
								 RandomValues.randomProgramId(),
								 DefaultValues.DEFAULT_LOCATION_ID,
								 System_.getSystemDate(),
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 uuid,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, (Date) insertParams[3]);
		
		record.executeInsert(conn);
		
		record.save(user, Operation.generatePatientProgram(), lockIt, conn);

		return record;
	}
	
	private static void finishPatientProgram(Record program, Connection conn) throws DBException {
		Object[] params = {program.getRelatedOpenMrsRecordId(),
						   System_.getSystemDate()};
		
		String sql = "UPDATE 	patient_program " +
					 "SET 		date_completed = ? " +
					 "WHERE 	patient_program_id = ? ";
		
		BaseDAO.executeDBQuery(sql, params, conn);
	}

	public static Record generateAndInsertPatientState(Record patientProgram, RoboticUser user, boolean lockIt,  Connection conn) throws DBException {
		Record lastState = RecordDAO.findLastStateOfProgram(patientProgram, conn);
		
		if (lastState != null) {
			RecordGenerator.finishPatientState(lastState, conn);
		}
		
		
		String uuid = UUID.randomUUID().toString();
		String recordTable = "patient_state";
		
		String insertSQL = "INSERT INTO patient_state(	patient_program_id," +
						    "							state," +
						    "							start_date," +
						    "							creator," +
						    "							voided," +
						    "							uuid," +
						    "							date_created) "+
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = {patientProgram.getRelatedOpenMrsRecordId(),
								 1,
								 System_.getSystemDate(),
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 uuid,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, (Date) insertParams[2]);
		
		record.executeInsert(conn);
		
		record.save(user, Operation.createPatientState(), false, conn);
		
		return record;
	}
	
	private static void finishPatientState(Record state, Connection conn) throws DBException {
		Object[] params = {System_.getSystemDate(),
						   state.getRelatedOpenMrsRecordId()};
		
		String sql = "UPDATE 	patient_state " +
					 "SET 		end_date = ? " +
					 "WHERE 	patient_state_id = ? ";
		
		BaseDAO.executeDBQuery(sql, params, conn);
	}
	
	private static Record generateAndInsertVisit(Record patient, RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "visit";
		
		String insertSQL = "INSERT INTO visit(	patient_id," +
						    "					visit_type_id," +
						    "					date_started," +
						    "					creator," +
						    "					voided," +
						    "					uuid,"+
						    "				 	date_created) " +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
							"		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = {patient.getRelatedOpenMrsRecordId(),
								 RandomValues.randomVisitType(),
								 System_.getSystemDate(),
								 DefaultValues.DEFAULT_USER_ID,
								 false,
								 uuid,
								 DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, (Date) insertParams[2]);
		
		record.executeInsert(conn);
		
		return record;
	}
	
	public static Record generateAndInsertEncounter(Record patient, RoboticUser user, boolean lockIt,  Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "encounter";
		
		Record visit = generateAndInsertVisit(patient, user, lockIt, conn);
		
		String insertSQL = "INSERT INTO encounter(	encounter_type," +
						    "						patient_id," +
						    "						form_id,"+
						    "						encounter_datetime,"+
						    "						visit_id,"+
						    "						creator," +
						    "						voided," +
						    "						uuid," +
						    "				 		date_created) " +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = { RandomValues.randomEncounterType(),
								  patient.getRelatedOpenMrsRecordId(),
								  DefaultValues.FILA_FORM_ID,
								  visit.getRelatedOpenMrsRecordDate(),
								  visit.getRelatedOpenMrsRecordId(),
								  DefaultValues.DEFAULT_USER_ID,
								  false,
								  uuid,
								  DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, visit.getRelatedOpenMrsRecordDate());
		
		record.executeInsert(conn);
		
		record.save(user, Operation.createEncounter(), false,  conn);

		generateAndInsertFilaData(record, patient, user, lockIt, conn);
		
		return record;
	}
	
	private static void generateAndInsertFilaData(Record encounter, Record person, RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		generateAndInsertEncounterProvider(encounter, user, lockIt, conn);
		
		Integer quantidadeAviada = RandomValues.randomMedicationQtyAvailable();
		Record qtyConcept = Record.fastCreate(1715);
		generateAndInsertObs(encounter, person, qtyConcept, "value_numeric", quantidadeAviada, conn);
		
		
		String posology= RandomValues.randomMedicationPosology();
		Record posologyConcept = Record.fastCreate(1711);
		
		generateAndInsertObs(encounter, person, posologyConcept, "value_text", posology, conn);
		
		Date returnDate= DateAndTimeUtilities.addDaysDate(encounter.getRelatedOpenMrsRecordDate(), quantidadeAviada);
		Record returnDateConcept = Record.fastCreate(5096);
		
		generateAndInsertObs(encounter, person, returnDateConcept, "value_datetime", returnDate, conn);
	
		Integer levaCamp= RandomValues.randomBooleanConceptAswer();
		Record booleanCodedConcept = Record.fastCreate(23856);
		
		generateAndInsertObs(encounter, person, booleanCodedConcept, "value_coded", levaCamp, conn);
	
		if (levaCamp == RandomValues.booleanConceptAswers[0]) {
			Integer campNumber = RandomValues.randomInteger(1000000);
			generateAndInsertObs(encounter, person, qtyConcept, "value_numeric", campNumber, conn);
		}
	}
	
	public static Record generateAndInsertObs(Record encounter, Record person, Record concept, String valueField, Object value, Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "obs";
		
		String insertSQL = "INSERT INTO obs(	person_id," +
						    "					concept_id," +
						    "					encounter_id,"+
						    "					obs_datetime,"+
						    ""+					valueField + "," + 
						    "					comments,"+
						    "					creator," +
						    "					voided," +
						    "					uuid," +
						    "					date_created) " +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = { person.getRelatedOpenMrsRecordId(),
								  concept.getRelatedOpenMrsRecordId(),
								  encounter.getRelatedOpenMrsRecordId(),
								  encounter.getRelatedOpenMrsRecordDate(),
								  value,
								  DefaultValues.DEFAULT_OBS_COMMENTS,
								  DefaultValues.DEFAULT_USER_ID,
								  false,
								  uuid,
								  DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, encounter.getRelatedOpenMrsRecordDate());
		
		record.executeInsert(conn);
		
		return record;
	}
	
	public static Record generateAndInsertEncounterProvider(Record encounter, RoboticUser user, boolean lockIt, Connection conn) throws DBException {
		String uuid = UUID.randomUUID().toString();
		String recordTable = "encounter_provider";
		
		String insertSQL = "INSERT INTO encounter_provider(	encounter_id," +
						    "								provider_id," +
						    "								encounter_role_id,"+
						    "								creator," +
						    "								voided," +
						    "								uuid,"+
						    "								date_created)" +
						    "VALUES( ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?,"+
						    "		 ?)";
		
		Object[] insertParams = { encounter.getRelatedOpenMrsRecordId(),
								  RandomValues.randomProviderId(),
								  DefaultValues.DEFAULT_ENCOUNTER_ROLE_ID,
								  DefaultValues.DEFAULT_USER_ID,
								  false,
								  uuid, 
								  DateAndTimeUtilities.getCurrentDate()
								 };
		
		Record record = new Record(uuid, recordTable, insertSQL, insertParams, encounter.getRelatedOpenMrsRecordDate());
		
		record.executeInsert(conn);
		
		return record;
	}
	
}
