package com.digitalduelist.ygocraft.core;

/**
 * YGOCraft Constants container
 * 
 * @author DigitalDuelist, tim4242
 */
public final class YGOConstants
{
	/**
	 * Unused constructor, warning useless. 
	 */
	private YGOConstants()
	{
	}
	
	/**
	 * The mod id of YGOCraft.
	 */
	public static final String MOD_ID = "ygocraft";

	/**
	 * The mod name of YGOCraft.
	 */
	public static final String MOD_NAME = "YGOCraft";
	
	/**
	 * Mod version part of YGOCraft.
	 */
	public static final int MOD_VERSION_MAJ = 0, MOD_VERSION_MIN = 0, MOD_VERSION_PATCH = 1, MOD_VERSION_BUILD = 0;

	/**
	 * The version of YGOCraft.<br>
	 * Made up of the previous four constants.
	 */
	public static final String MOD_VERSION = String.format("%d.%d.%d.%d", MOD_VERSION_MAJ, MOD_VERSION_MIN, MOD_VERSION_PATCH, MOD_VERSION_BUILD);
	
	/**
	 * The sub version of YGOCraft.
	 */
	public static final String MOD_VERSION_SUB = "Card car \"D\"";

	/**
	 * Mod description of YGOCraft.
	 */
	public static final String MOD_DESCRIPTION = "A Minecraft mod about the Yugioh trading card game";

	/**
	 * Mod authors of YGOCraft.
	 */
	public static final String[] MOD_AUTHORS = new String[] { "Digital Duelist", "tim4242" };

	/**
	 * Mod credits of YGOCraft.
	 */
	public static final String MOD_CREDITS = "The FML and MCP teams";
}
