package com.digitalduelist.ygocraft.util.java.reflected;

public interface ICallable
{
	public Class<?>[] getTypes();
	
	public ReflectedObject call(Object... args);
}
