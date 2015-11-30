package com.digitalduelist.ygocraft;

import static com.digitalduelist.ygocraft.core.YGOConstants.MOD_AUTHORS;
import static com.digitalduelist.ygocraft.core.YGOConstants.MOD_CREDITS;
import static com.digitalduelist.ygocraft.core.YGOConstants.MOD_DESCRIPTION;
import static com.digitalduelist.ygocraft.core.YGOConstants.MOD_ID;
import static com.digitalduelist.ygocraft.core.YGOConstants.MOD_NAME;
import static com.digitalduelist.ygocraft.core.YGOConstants.MOD_VERSION;
import static com.digitalduelist.ygocraft.core.YGOConstants.MOD_VERSION_SUB;

import java.io.File;
import java.util.Arrays;

import com.digitalduelist.ygocraft.api.YGOAPI;
import com.digitalduelist.ygocraft.core.YGOConfig;
import com.digitalduelist.ygocraft.core.impl.YGOAPIImpl;
import com.digitalduelist.ygocraft.util.YGOLog;
import com.digitalduelist.ygocraft.util.java.JavaHelper;
import com.digitalduelist.ygocraft.util.java.reflected.ReflectedObject;

import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModContainer.Disableable;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION_SUB)
public class YGOCraft
{

	public static final YGOCraft INSTANCE = new YGOCraft();

	@Mod.Metadata
	public static ModMetadata METADATA;

	private YGOCraft()
	{
		YGOLog.init();
	}

	@Mod.InstanceFactory
	public static YGOCraft instance()
	{
		return INSTANCE;
	}
	
	private YGOConfig m_config;

	@Mod.EventHandler
	public void construction(FMLConstructionEvent event)
	{
		YGOLog.init();
		
		YGOAPI.setup(new YGOAPIImpl());
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		m_config = new YGOConfig(new File(event.getModConfigurationDirectory(), MOD_ID + ".cfg"));
		
		m_config.reload();
		
		YGOLog.info(getConfig().getDebugMode());
		
		YGOLog.debug(JavaHelper.boxInString("Initializing YGOCraft", JavaHelper.BOX_SEPERATOR, "Mod Name: " + MOD_NAME, "Mod ID: " + MOD_ID, "Mod Version: " + MOD_VERSION + " \"" + MOD_VERSION_SUB + "\""));
		
		setupMetadata();
		
		if(m_config.getOCD())
		setDisableability(Loader.instance().activeModContainer(), Disableable.NEVER);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
	
	public YGOConfig getConfig()
	{
		return m_config;
	}

	private void setupMetadata()
	{
		METADATA.autogenerated = false;
		METADATA.modId = MOD_ID;
		METADATA.name = MOD_NAME;
		METADATA.version = MOD_VERSION;
		METADATA.description = MOD_DESCRIPTION;
		METADATA.authorList = Arrays.<String> asList(MOD_AUTHORS);
		METADATA.credits = MOD_CREDITS;
	}

	private void setDisableability(ModContainer mc, Disableable disable)
	{
		if(mc instanceof FMLModContainer)
		{
			ReflectedObject.$(mc).findField("disableability").set(ReflectedObject.$(disable));
		}
	}
}
