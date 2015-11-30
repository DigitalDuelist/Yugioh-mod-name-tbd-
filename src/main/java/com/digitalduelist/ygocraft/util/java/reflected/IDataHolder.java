package com.digitalduelist.ygocraft.util.java.reflected;

public interface IDataHolder
{
	public Class<?> getDataType();
	
	public ReflectedObject get();
	
	public ReflectedObject set(ReflectedObject data);
}
