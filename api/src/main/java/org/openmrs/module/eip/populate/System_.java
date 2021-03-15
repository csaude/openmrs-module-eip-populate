package org.openmrs.module.eip.populate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openmrs.module.populate.main.utils.CommonUtilities;
import org.openmrs.module.populate.main.utils.DateAndTimeUtilities;
import org.openmrs.module.populate.main.utils.RandomValues;
import org.openmrs.module.populate.main.utils.concurrent.ThreadPoolService;
import org.openmrs.module.populate.main.utils.db.DBConnectionInfo;
import org.openmrs.module.populate.main.utils.db.DBConnectionService;
import org.openmrs.module.populate.main.utils.db.OpenConnection;
import org.openmrs.module.populate.monitor.Operation;
import org.openmrs.module.populate.monitor.RoboticUser;

public class System_ {
	static Logger logger;
	
	private final static int QTY_USERS = 10;
	//private final static int OPERATION_INTERVAL = 20;
	private final static int DATE_DURATION = 60;
	private static final Date SYSTEM_START_DATE = DateAndTimeUtilities.createDate("01-01-2017");
	
	private CommonUtilities utilities;
	
	private Date startDate;
	private Date currDate;
	private int dateDuration;
	private int qtyUsers;
	
	private static System_ system;
	//private TimeCountDown timeCountDown;
	//private int operationInterval;
	
	private List<RoboticUser> roboticUsers;
	private DBConnectionService dbService;
	
	private System_(Date startDate, int dateDuration, int qtyUsers) {
		//loadLogger();
		
		logger = Logger.getLogger(System_.class);
		
		this.startDate = startDate;
		this.dateDuration = dateDuration;
		
		this.utilities = CommonUtilities.getInstance();
		this.qtyUsers = qtyUsers;
		//this.operationInterval = operationInterval;
		this.roboticUsers = new ArrayList<RoboticUser>(qtyUsers);
		
		DBConnectionInfo dbConnInfo = new DBConnectionInfo();
		dbConnInfo.setConnectionURI("jdbc:mysql://10.10.2.2:3307/openmrs_ile?autoReconnect=true&useSSL=false");
		dbConnInfo.setDataBaseUserName("root");
		dbConnInfo.setDataBaseUserPassword("root");
		dbConnInfo.setDriveClassName("com.mysql.jdbc.Driver");
		
		this.dbService = DBConnectionService.init(dbConnInfo);
	}
	
	public OpenConnection openConnection() {
		return this.dbService.openConnection();
	}
	
	public CommonUtilities getUtilities() {
		return utilities;
	}
	
	public static Date getSystemDate() {
		return getInstance().currDate;
	}
	
	public static System_ getInstance() {
		if (system == null) system = new System_(System_.SYSTEM_START_DATE, System_.DATE_DURATION, System_.QTY_USERS);
	
		return system;
	}
	
	public void start() {
		this.currDate = this.startDate;
		
		log("The system is starting...");
		
		for (int i = 0; i < qtyUsers; i++) {
			RoboticUser roboticUser = generateRoboticUser();
			
			roboticUsers.add(roboticUser);
			
			ThreadPoolService.getInstance().createNewThreadPoolExecutor("USER_" + roboticUser.getUserName().toUpperCase()).execute(roboticUser);
		}
		
		//this.timeCountDown = TimeCountDown.wait(this, this.dateDuration, "");
		
		
		while(true) {
			try {
				Thread.sleep(this.dateDuration * 1000);
				log("New day started");
				
				this.currDate = DateAndTimeUtilities.addDaysDate(this.currDate, 1);
				
			} catch (InterruptedException e) {
			}
			
		}
	}
	

	public synchronized RoboticUser generateRoboticUser() {
		String userName = RandomValues.randomFirstName();
		
		while (findGeneratedUser(userName) != null) {
			userName = RandomValues.randomFirstName();
		}
		
		RoboticUser u = new RoboticUser(RandomValues.randomFirstName());
	
		return u;
	}
	
	public RoboticUser findGeneratedUser(String userName) {
		for (RoboticUser u : this.roboticUsers) {
			if (u.getUserName().equals(userName)) return u;
		}
		
		return null;
	}

	public static void log(String msg) {
		logger.info(msg + "[SYSTEM DATE: " + DateAndTimeUtilities.formatToDDMMYYYY(getSystemDate()) + "]");
	}
	
	public static void logOperationStarted(RoboticUser user, Operation operation) {
		String logMsg = "STARTED OPERATION [ code: " + operation.getCode() + ", duration: " + operation.getDuration() +"] BY USER ["+user.getUserName() + "]";
		
		log(logMsg);
	}
	
	public static void logOperationFinished(RoboticUser user, Operation operation) {
		String logMsg = "FINISHED OPERATION [" + operation.getCode() + "] BY USER ["+user.getUserName() + "]";
		
		log(logMsg);
	}
	
	/*@Override
	public void onFinish() {
		this.currDate = DateAndTimeUtilities.addDaysDate(this.currDate, 1);
		
		this.timeCountDown.restart();
		
		//TimeCountDown.wait(this, this.dateDuration, "");
	}

	@Override
	public String getThreadNamingPattern() {
		return "system";
	}*/
	
	
}
