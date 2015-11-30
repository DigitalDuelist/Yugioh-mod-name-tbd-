package com.digitalduelist.ygocraft.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalduelist.ygocraft.YGOCraft;
import com.digitalduelist.ygocraft.core.YGOConstants;

/**
 * {@link org.apache.logging.log4j.Logger log4j Logger} wrapper.
 * 
 * @author DigitalDuelist, tim4242
 */
public class YGOLog
{
	
	/**
	 * Private {@link org.apache.logging.log4j.Logger Logger} instance
	 */
	private static Logger m_logger;

	/**
	 * {@link org.apache.logging.log4j.Logger Logger} initialization
	 */
	public static void init()
	{
		if(m_logger == null)
			m_logger = LogManager.getLogger(YGOConstants.MOD_NAME);
	}

	public static void log(Level lev, Object... mes)
	{
		for (Object o : mes)
			m_logger.log(lev, o);
	}

	public static void info(Object... mes)
	{
		log(Level.INFO, mes);
	}

	public static void debug(Object... mes)
	{
		if(YGOCraft.instance().getConfig().getDebugMode())
		{
			log(Level.INFO, mes);
		}
	}

	public static void error(Object... mes)
	{
		log(Level.ERROR, mes);
	}

	public static void fatal(Object... mes)
	{
		log(Level.FATAL, mes);
	}
}
