package org.openmrs.module.eip.populate;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openmrs.module.populate.main.utils.FileUtilities;

public class Main {

	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		
		System_.getInstance().start();
		
		//generateArrayFromFile();
	}

	/**
	* Inicializa o Logger da Aplicacao
	* 
	* @param context
	*/
	public void loadLogger() {
		/*logger.info("Entrando no metodo loadLogger.");
		java.net.URL url = Thread.currentThread().getContextClassLoader().getResource("log4j.properties");
		DOMConfigurator.configure(url);
		logger.info("Saindo do metodo loadLogger.");*/
		
		PropertyConfigurator.configure(getClass().getResource("/log4j.properties"));
	} 
	
	public static void generateArrayFromFile() throws IOException {
		List<String> list = FileUtilities.readAllFileAsListOfString("encounter_types");
		
		for (String line : list) {
			System.out.print(line + ", ");
		}
		
	}

}
