package com.digitalduelist.ygocraft.core;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * YGO Configuration wrapper.
 * 
 * @author DigitalDuelist, tim4242
 */
public class YGOConfig
{
	/**
	 * {@link Configuration} instance.
	 */
	private Configuration m_config;

	/**
	 * Main constructor.
	 * 
	 * @param config
	 *            The file to generate to.
	 */
	public YGOConfig(File config)
	{
		m_config = new Configuration(config);
	}

	/** OCD option */
	private boolean m_ocd;
	/** Debug Mode option */
	private boolean m_debugMode;

	/**
	 * Reloads the configuration file.
	 */
	public void reload()
	{
		m_config.load();

		m_debugMode = m_config.getBoolean("Debug Mode", "debug", false, "Activates all debug features");

		m_ocd = m_config.getBoolean("OCD", "extra", true, "Adds OCD fixes");

		m_config.save();
	}

	/**
	 * @return If Debug Mode is enabled.
	 */
	public boolean getDebugMode()
	{
		return m_debugMode;
	}

	/**
	 * @return If OCD fixes are enabled. 
	 */
	public boolean getOCD()
	{
		return m_ocd;
	}
}
