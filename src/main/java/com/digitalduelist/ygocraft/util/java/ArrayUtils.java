/**
 * 
 */
package com.digitalduelist.ygocraft.util.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tim4242
 * 
 * 
 *
 */
public class ArrayUtils
{

	public static <T> List<T> asList(T[] arr)
	{
		return (List<T>) new ArrayList<T>(Arrays.asList(arr));
	}

	public static <T> ArrayList<T> asArrayList(T[] arr)
	{
		return new ArrayList<T>(Arrays.asList(arr));
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] asArray(List<T> list)
	{
		return (T[]) list.toArray();
	}

	public static <T, V> Map<T, V> asMap(List<T> keys, List<V> values)
	{
		if(keys.size() != values.size()) throw new IllegalArgumentException("keys and values don't have the same length!");

		HashMap<T, V> res = new HashMap<T, V>(keys.size());

		for (int i = 0; i < keys.size(); i++)
			res.put(keys.get(i), values.get(i));

		return (Map<T, V>) res;
	}

	public static <T, V> Map<T, V> asMap(T[] keys, V[] values)
	{
		return asMap(asList(keys), asList(values));
	}

	public static <T> ArrayList<T> getArrayListWithCapacity(int size)
	{
		ArrayList<T> res = new ArrayList<T>(size);

		for (int i = 0; i <= size; i++)
			res.add(null);

		return res;
	}

	public static <T> T[] arrayConcat(T[]... arrs)
	{
		int totalLen = 0;
		for (T[] a : arrs)
		{
			totalLen += a.length;
		}
		
		@SuppressWarnings("unchecked")
		T[] res = (T[]) Array.newInstance(arrs.getClass().getComponentType().getComponentType(), totalLen);
		int i = 0;
		for (T[] a : arrs)
		{
			System.arraycopy(a, 0, res, i, a.length);
			i += a.length;
		}
		return res;
	}

}
