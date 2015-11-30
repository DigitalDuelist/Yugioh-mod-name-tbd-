package com.digitalduelist.ygocraft.core;

public final class YGOConstants
{
	private YGOConstants()
	{
	}
	
	public static final String MOD_ID = "ygocraft";

	public static final String MOD_NAME = "YGOCraft";
	
	public static final int MOD_VERSION_MAJ = 0, MOD_VERSION_MIN = 0, MOD_VERSION_PATCH = 1, MOD_VERSION_BUILD = 0;

	public static final String MOD_VERSION = String.format("%d.%d.%d.%d", MOD_VERSION_MAJ, MOD_VERSION_MIN, MOD_VERSION_PATCH, MOD_VERSION_BUILD);
	
	public static final String MOD_VERSION_SUB = "Card car \"D\"";

	public static final String MOD_DESCRIPTION = "A Minecraft mod about the Yugioh trading card game";

	public static final String[] MOD_AUTHORS = new String[] { "Digital Duelist", "tim4242" };

	public static final String MOD_CREDITS = "The FML and MCP teams";
}
