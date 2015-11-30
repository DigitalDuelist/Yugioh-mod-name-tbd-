package com.digitalduelist.ygocraft.util.java.reflected;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.digitalduelist.ygocraft.util.java.reflected.comps.AnnotatablePart;

import cpw.mods.fml.relauncher.ReflectionHelper;

public class ReflectedObject implements IAnnotatable
{

	private Class<?> m_self;
	private Object m_obj;

	private ReflectedMethod[] m_methods;
	private ReflectedField[] m_fields;

	public static ReflectedObject create(Object obj)
	{
		if(obj == null) return null;
		
		if(obj instanceof Class) return new ReflectedObject((Class<?>) obj, null);
		
		return new ReflectedObject(obj.getClass(), obj);
	}
	
	public static ReflectedObject createFromClass(String name)
	{
		try
		{
			return create(Class.forName(name));
		} catch(ClassNotFoundException e)
		{
			return null;
		}
	}

	public static ReflectedObject $(Object obj)
	{
		return create(obj);
	}

	private ReflectedObject(Class<?> cls, Object obj)
	{
		m_self = cls;
		m_obj = obj;

		m_annos = new AnnotatablePart(ElementType.TYPE, m_self.getAnnotations());
	}

	public Class<?> getWrappedClass()
	{
		return m_self;
	}

	@SuppressWarnings("unchecked")
	public <T> T getObject()
	{
		return (T) m_obj;
	}

	public ReflectedField[] getFields()
	{
		if(m_fields == null)
		{
			Field[] fi = m_self.getDeclaredFields();

			m_fields = new ReflectedField[fi.length];

			for (int i = 0; i < fi.length; i++)
				m_fields[i] = new ReflectedField(this, fi[i]);
		}

		return m_fields;
	}

	public ReflectedMethod[] getMethods()
	{
		if(m_methods == null)
		{
			Method[] fi = m_self.getDeclaredMethods();

			m_methods = new ReflectedMethod[fi.length];

			for (int i = 0; i < fi.length; i++)
				m_methods[i] = new ReflectedMethod(this, fi[i]);
		}

		return m_methods;
	}

	public ReflectedField findField(String... names)
	{
		Field f = ReflectionHelper.findField(getWrappedClass(), names);

		if(f == null) { return null; }

		return new ReflectedField(this, f);
	}

	public ReflectedMethod findMethod(String[] names, Class<?>[] types)
	{
		Method res = null;

		for (String s : names)
		{
			try
			{
				res = getWrappedClass().getDeclaredMethod(s, types);
			} catch(Exception e)
			{
			}

			if(res != null) return new ReflectedMethod(this, res);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(ReflectedField rf)
	{
		if(rf == null) return null;

		ReflectedObject res2 = rf.get();

		if(res2 == null) return null;

		T res = null;

		try
		{
			res = (T) res2.getObject();
		} catch(ClassCastException e)
		{
			return null;
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getMethodResult(ReflectedMethod rm, Object... args)
	{
		if(rm == null) return null;

		ReflectedObject res2 = rm.call(args);

		if(res2 == null) return null;

		T res = null;

		try
		{
			res = (T) res2.getObject();
		} catch(ClassCastException e)
		{
			return null;
		}

		return res;
	}

	public <T> T getFieldValue(String... names)
	{
		return getFieldValue(findField(names));
	}

	public <T> T getMethodResult(String[] names, Class<?>[] types, Object... args)
	{
		return getMethodResult(findMethod(names, types));
	}

	// ANNOTATION

	private AnnotatablePart m_annos;

	@Override
	public ElementType getType()
	{
		return m_annos.getType();
	}

	@Override
	public boolean hasAnnotation(Class<? extends Annotation> anno)
	{
		return m_annos.hasAnnotation(anno);
	}

	@Override
	public <A extends Annotation> A getAnnotation(Class<A> anno)
	{
		return m_annos.getAnnotation(anno);
	}

	@Override
	public Annotation[] getAnnotations()
	{
		return m_annos.getAnnotations();
	}

	@Override
	public Class<? extends Annotation>[] getAnnotationTypes()
	{
		return m_annos.getAnnotationTypes();
	}
}
