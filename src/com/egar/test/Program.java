package com.egar.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ui.Model;

/**
 * User: nchebykina
 * Date: 27.08.12
 * Time: 11:39
 */
public class Program {
    private static final Logger logger = Logger.getLogger(Program.class);
	private static final String CFG_SPRING = "appContext.xml";
	private static final String CFG_LOG4J = "log4j.properties";

	public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(CFG_SPRING);
//        ApplicationContext ctx = init();
//		if (ctx != null) {
//			System.out.println("initialized..");
//		}
//        StdScheduler sb = (StdScheduler)ctx.getBean("scheduler");
//        try {
//            sb.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
        Model model = (Model)ctx.getBean("model");

    }

	private static ApplicationContext init() {
		// Log4J initialization
		LogManager.resetConfiguration();
		PropertyConfigurator.configure(CFG_LOG4J);

		// Spring initialization
		try {
			return new FileSystemXmlApplicationContext(CFG_SPRING);
		} catch (BeansException e) {
			System.out.println("Cannot initialize Spring");
            e.printStackTrace();
		}

		return null;
	}
}
