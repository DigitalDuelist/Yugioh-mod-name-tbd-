package com.digitalduelist.ygocraft.api;

public class YGOAPI
{
	private IYGOAPI m_api;

	private static YGOAPI m_instance;

	public static void setup(IYGOAPI api)
	{
		if(!Thread.currentThread().getStackTrace()[2].getClassName().equals("com.digitalduelist.ygocraft.YGOCraft"))
			throw new UnsupportedOperationException("You can't call this method from here");
		
		instance().m_api = api;
	}

	public static YGOAPI instance()
	{
		if(m_instance == null)
			m_instance = new YGOAPI();

		return m_instance;
	}

	public IYGOAPI getCommonAPI()
	{
		return m_api;
	}

	public static IYGOAPI api()
	{
		return instance().getCommonAPI();
	}
}
