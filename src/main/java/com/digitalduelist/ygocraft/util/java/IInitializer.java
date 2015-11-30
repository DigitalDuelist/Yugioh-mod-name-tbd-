package com.digitalduelist.ygocraft.util.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface IInitializer
{
	public Class<?> getInitializableClass();

	public Class<?>[] getConstructorTypes();

	public Method getConstructor();

	public Object[] getDefaultParams();

	public static class InitHelper
	{
		public Object initialize(IInitializer ini)
		{
			try
			{
				return ini.getConstructor().invoke(null, ini.getDefaultParams());
			} catch(IllegalAccessException e)
			{
				e.printStackTrace();
			} catch(IllegalArgumentException e)
			{
				e.printStackTrace();
			} catch(InvocationTargetException e)
			{
				e.printStackTrace();
			}

			return null;
		}
	}
}
