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
	
	private CommonUtilities utilities;
	private static System_ system;
	private Configurations config;
	private List<RoboticUser> roboticUsers;
	private DBConnectionService dbService;
	
	private Date currDate;
	private RandomValues randomValues;

	private System_() {
		logger = Logger.getLogger(System_.class);
		this.utilities = CommonUtilities.getInstance();
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
		if (system == null) system = new System_();
	
		return system;
	}
	
	public Configurations getConfig() {
		return config;
	}
	
	public void start(Configurations conf) {
		this.config = conf;
		
		this.roboticUsers = new ArrayList<RoboticUser>(config.getQtyUsers());
		
		DBConnectionInfo dbConnInfo = new DBConnectionInfo();
		dbConnInfo.setConnectionURI(conf.getDbURL());
		dbConnInfo.setDataBaseUserName("root");
		dbConnInfo.setDataBaseUserPassword("root");
		dbConnInfo.setDriveClassName("com.mysql.jdbc.Driver");
		
		this.dbService = DBConnectionService.init(dbConnInfo);
		this.randomValues = new RandomValues(config);
		
		log("The system is starting with the following parameters:");
		
		log("DB URL: " + conf.getDbURL());
		log("Start Date: " + conf.getSystemStartDate());
		log("Qty Users: " + conf.getQtyUsers());
		log("Day DUration: " + conf.getDayDuration());
		
		this.currDate = config.getSystemStartDate();
		
		for (int i = 0; i < config.getQtyUsers(); i++) {
			RoboticUser roboticUser = generateRoboticUser();
			
			roboticUsers.add(roboticUser);
			
			ThreadPoolService.getInstance().createNewThreadPoolExecutor("USER_" + roboticUser.getUserName().toUpperCase()).execute(roboticUser);
		}
		
		while(true) {
			try {
				Thread.sleep(config.getDayDuration() * 1000);
				log("New day started");
				
				this.currDate = DateAndTimeUtilities.addDaysDate(this.currDate, 1);
				
			} catch (InterruptedException e) {
			}
			
		}
	}
	
	public RandomValues getRandomValues() {
		return randomValues;
	}
	
	public synchronized RoboticUser generateRoboticUser() {
		String userName = this.randomValues.randomFirstName();
		
		while (findGeneratedUser(userName) != null) {
			userName = randomValues.randomFirstName();
		}
		
		RoboticUser u = new RoboticUser(randomValues.randomFirstName(), this);
	
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
	
}
