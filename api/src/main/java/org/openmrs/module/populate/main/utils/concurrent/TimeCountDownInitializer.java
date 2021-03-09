/**
 * 
 */
package org.openmrs.module.populate.main.utils.concurrent;

/**
 * @author jpboane
 *
 */
public interface TimeCountDownInitializer {
	public void onFinish();
	
	public String getThreadNamingPattern();
}
