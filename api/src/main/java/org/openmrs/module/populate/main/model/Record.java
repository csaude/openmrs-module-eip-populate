package org.openmrs.module.populate.main.model;

import java.sql.Connection;
import java.util.Date;

import org.openmrs.module.populate.main.model.base.BaseVO;
import org.openmrs.module.populate.main.utils.db.DBException;
import org.openmrs.module.populate.monitor.Operation;
import org.openmrs.module.populate.monitor.RoboticUser;

public class Record extends BaseVO{
	private int id;
	
	private int relatedOpenMrsRecordId;
	private String relatedOpenMrsRecordUuid;
	private String relatedOpenMrsRecordTable;
	private Date relatedOpenMrsRecordDate;
	
	private String insertSQL;
	private Object[] insertParams;
	
	public Record() {
	}
	
	public Record(String relatedOpenMrsRecordUuid, String relatedOpenMrsRecordTable, String insertSQL, Object[] insertParams, Date relatedOpenMrsRecordDate) {
		this.relatedOpenMrsRecordUuid = relatedOpenMrsRecordUuid;
		this.relatedOpenMrsRecordTable = relatedOpenMrsRecordTable;
		this.insertSQL = insertSQL;
		this.insertParams = insertParams;
		this.relatedOpenMrsRecordDate = relatedOpenMrsRecordDate;
	}
	
	public int getRelatedOpenMrsRecordId() {
		return relatedOpenMrsRecordId;
	}

	public void setRelatedOpenMrsRecordId(int relatedOpenMrsRecordId) {
		this.relatedOpenMrsRecordId = relatedOpenMrsRecordId;
	}

	public String getRelatedOpenMrsRecordUuid() {
		return relatedOpenMrsRecordUuid;
	}

	public void setRelatedOpenMrsRecordUuid(String relatedOpenMrsRecordUuid) {
		this.relatedOpenMrsRecordUuid = relatedOpenMrsRecordUuid;
	}

	public String getRelatedOpenMrsRecordTable() {
		return relatedOpenMrsRecordTable;
	}

	public void setRelatedOpenMrsRecordTable(String relatedOpenMrsRecordTable) {
		this.relatedOpenMrsRecordTable = relatedOpenMrsRecordTable;
	}

	public Date getRelatedOpenMrsRecordDate() {
		return relatedOpenMrsRecordDate;
	}

	public void setRelatedOpenMrsRecordDate(Date relatedOpenMrsRecordDate) {
		this.relatedOpenMrsRecordDate = relatedOpenMrsRecordDate;
	}

	public void setInsertParams(Object[] insertParams) {
		this.insertParams = insertParams;
	}

	public int get_Id() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getInsertSQL() {
		return insertSQL;
	}

	public void setInsertSQL(String insertSQL) {
		this.insertSQL = insertSQL;
	}

	public Object[] getInsertParams() {
		return insertParams;
	}

	public void executeInsert(Connection conn) throws DBException {
		RecordDAO.executeRecordInsert(this, conn);
	}
	
	public void save(RoboticUser user, Operation operation, boolean lock, Connection conn) throws DBException {
		RecordDAO.insert(this, user, operation, lock, conn);
	}
	
	public static Record fastCreate(int relatedOpenMrsRecordId) {
		Record r = new Record(null, null, null, null, null);
		
		r.setRelatedOpenMrsRecordId(relatedOpenMrsRecordId);
		
		return r;
	}

	public void unlock(Connection conn) throws DBException {
		RecordDAO.unlock(this, conn);
	}	
	
	public void lock(Connection conn) throws DBException {
		RecordDAO.lock(this, conn);
	}	

}
