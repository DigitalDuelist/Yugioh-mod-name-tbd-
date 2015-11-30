/**
 * 
 */
package com.digitalduelist.ygocraft.util.java;

import java.util.Arrays;
import java.util.List;

/**
 * @author tim4242
 * @author philipas
 * 
 */
public class JavaHelper
{

	/**
	 * Checks if the String is an instance of an Integer
	 * 
	 * @param str
	 *            The String you want to check
	 * @return If the String is an instance of Integer
	 */
	public static boolean isInt(String str)
	{
		try
		{
			Integer.parseInt(str);
		} catch(Exception e)
		{
			return false;
		}

		return true;
	}

	/**
	 * Checks if the String is an instance of a Float
	 * 
	 * @param str
	 *            The String you want to check
	 * @return If the String is an instance of Float
	 */
	public static boolean isFloat(String str)
	{
		try
		{
			Float.parseFloat(str);
		} catch(Exception e)
		{
			return false;
		}

		return true;
	}

	/**
	 * Checks if the String is an instance of a Double
	 * 
	 * @param str
	 *            The String you want to check
	 * @return If the String is an instance of Double
	 */
	public static boolean isDouble(String str)
	{
		try
		{
			Double.parseDouble(str);
		} catch(Exception e)
		{
			return false;
		}

		return true;
	}

	public static int packII(int l, int r)
	{
		if(l < Short.MAX_VALUE && l > Short.MIN_VALUE && r < Short.MAX_VALUE && r > Short.MIN_VALUE) { return (l << 16) | r; }

		return 0;
	}

	public static int getIIL(int packed)
	{
		return (packed >>> 16);
	}

	public static int getIIR(int packed)
	{
		return (packed & 0xFFFF);
	}

	public static int packIB(int l, boolean r)
	{
		if(l < Short.MAX_VALUE && l > Short.MIN_VALUE) { return (l << 16) | (r ? 1 : 0); }

		return 0;
	}

	public static int getIBL(int packed)
	{
		return (packed >>> 16);
	}

	public static boolean getIBR(int packed)
	{
		return ((packed & 0xFFFF) == 1 ? true : false);
	}

	public static int[] getLongestString(Object... str)
	{
		int[] res = new int[2];

		for (int i = 0; i < str.length; i++)
		{
			String s = str[i].toString();

			if(s.length() > res[0])
			{
				res[1] = i;
				res[0] = s.length();
			}

		}

		return res;
	}

	public static final String BOX_SEPERATOR = "<SEPERATE>";

	public static Object[] boxInString(char top, char corner, char side, Object... str)
	{
		
		
		int[] temp = getLongestString(str);

		String[] res = new String[str.length + 2];
		int len = temp[0] + 4;

		StringBuilder sep = new StringBuilder(len);

		char[] repA = new char[len];

		Arrays.fill(repA, top);

		repA[0] = corner;
		repA[repA.length - 1] = corner;

		sep.append(repA);

		res[0] = sep.toString();
		res[res.length - 1] = sep.toString();
		
		for (int i = 0; i < str.length; i++)
		{

			String print = str[i].toString();

			if(print.equals(BOX_SEPERATOR))
			{
				res[i + 1] = res[0];
			}
			else
			{
				StringBuilder t = new StringBuilder(len - 2);

				t.append(side + " ");

				t.append(print);

				while (true)
				{
					if(t.length() >= t.capacity()) break;

					t.append(" ");
				}

				t.append(" " + side);

				res[i + 1] = t.toString();
			}

		}

		return res;
	}

	public static Object[] boxInString(char top, Object... str)
	{
		return boxInString(top, top, top, str);
	}

	public static Object[] boxInString(Object... str)
	{
		return boxInString('-', '+', '|', str);
	}
	
	public static <T> List<T> addAllNonNull(List<T> l, T... data)
	{
		if(l == null)
			return l;
		
		for(T d : data)
		{
			l.add(d);
		}
		
		return l;
	}

}
