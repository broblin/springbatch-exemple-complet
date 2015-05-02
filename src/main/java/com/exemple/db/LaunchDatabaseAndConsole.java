/**
 * 
 */
package com.exemple.db;

import org.h2.tools.Console;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * lance la base h2 à partir de spring
 * @author broblin
 *
 */
public class LaunchDatabaseAndConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext(
			"/conf/root-database-context.xml"
		);
		Console.main(args);
	}

}
