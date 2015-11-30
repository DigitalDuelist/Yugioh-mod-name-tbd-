package com.digitalduelist.ygocraft.core;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class YGOConfig
{
	private Configuration m_config;

	public YGOConfig(File config)
	{
		m_config = new Configuration(config);
	}

	private boolean m_ocd;
	private boolean m_debugMode;

	public void reload()
	{
		m_config.load();

		m_debugMode = m_config.getBoolean("Debug Mode", "debug", false, "Activates all debug features");
		
		m_ocd = m_config.getBoolean("OCD", "extra", true, "Adds OCD fixes");

		m_config.save();
	}

	public boolean getDebugMode()
	{
		return m_debugMode;
	}
	
	public boolean getOCD()
	{
		return m_ocd;
	}
}
