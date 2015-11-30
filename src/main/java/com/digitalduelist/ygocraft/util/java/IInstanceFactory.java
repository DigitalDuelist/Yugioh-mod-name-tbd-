package com.digitalduelist.ygocraft.util.java;

public interface IInstanceFactory<RESULT>
{
	public RESULT create(Object... args);
}
