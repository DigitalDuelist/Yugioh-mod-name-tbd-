package com.digitalduelist.ygocraft.api;

/**
 * YGOCraft API initializer.<br>
 * Contains instances of all API classes.
 * 
 * @author DigitalDuelist, tim4242
 */
public class YGOAPI
{
	/**
	 * The {@link IYGOAPI} instance.
	 */
	private IYGOAPI m_api;

	/**
	 * The singleton instance.
	 */
	private static YGOAPI m_instance;

	/**
	 * Setup method.<br>
	 * <b><em>CAN ONLY BE CALLED FROM YGOCraft</em></b>
	 * 
	 * @param api The {@link IYGOAPI} instance.
	 */
	public static void setup(IYGOAPI api)
	{
		//Test if it was called from YGOCraft
		if(!Thread.currentThread().getStackTrace()[2].getClassName().equals("com.digitalduelist.ygocraft.YGOCraft"))
			throw new UnsupportedOperationException("You can't call this method from here");
		
		instance().m_api = api;
	}

	/**
	 * Singleton instance
	 * 
	 * @return The {@link m_instance} of this class.
	 */
	public static YGOAPI instance()
	{
		if(m_instance == null)
			m_instance = new YGOAPI();

		return m_instance;
	}

	/**
	 * @return The {@link IYGOAPI} instance.
	 */
	public IYGOAPI getCommonAPI()
	{
		return m_api;
	}

	/**
	 * @return The {@link IYGOAPI} instance.
	 */
	public static IYGOAPI api()
	{
		return instance().getCommonAPI();
	}
}
