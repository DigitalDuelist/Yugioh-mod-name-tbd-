package com.digitalduelist.ygocraft.util.java.reflected;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.digitalduelist.ygocraft.util.java.reflected.comps.AnnotatablePart;

public class ReflectedMethod implements IAnnotatable, IMember, ICallable
{

	private ReflectedObject m_parent;
	private Method m_self;

	ReflectedMethod(ReflectedObject parent, Method self)
	{
		m_parent = parent;
		m_self = self;
		
		m_self.setAccessible(true);

		m_annos = new AnnotatablePart(ElementType.METHOD, m_self.getAnnotations());
	}

	public Method getMethod()
	{
		return m_self;
	}

	// CALLABLE

	@Override
	public Class<?>[] getTypes()
	{
		return m_self.getParameterTypes();
	}

	@Override
	public ReflectedObject call(Object... args)
	{
		try
		{

			try
			{
				return ReflectedObject.create(m_self.invoke(m_parent.getObject(), args));
			} catch(IllegalAccessException e)
			{
			} catch(IllegalArgumentException e)
			{
			} catch(InvocationTargetException e)
			{
			}

		} catch(ClassCastException e)
		{
		}

		return null;
	}

	// MEMBER

	@Override
	public ReflectedObject getParent()
	{
		return m_parent;
	}

	// ANNOTATABLE

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
