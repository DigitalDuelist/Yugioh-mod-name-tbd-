package com.digitalduelist.ygocraft.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitalduelist.ygocraft.YGOCraft;
import com.digitalduelist.ygocraft.core.YGOConstants;

public class YGOLog
{
private static Logger m_logger;
	
	public static void init()
	{
		if(m_logger == null) m_logger = LogManager.getLogger(YGOConstants.MOD_NAME);
	}
	
	public static void log(Level lev, Object... mes)
	{
		for(Object o : mes)
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
