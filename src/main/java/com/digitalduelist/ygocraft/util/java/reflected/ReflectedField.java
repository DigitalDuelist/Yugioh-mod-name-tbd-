package com.digitalduelist.ygocraft.util.java.reflected;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

import com.digitalduelist.ygocraft.util.java.reflected.comps.AnnotatablePart;

public class ReflectedField implements IAnnotatable, IMember, IDataHolder
{

	private Field m_self;
	private ReflectedObject m_parent;

	ReflectedField(ReflectedObject parent, Field self)
	{
		m_parent = parent;
		m_self = self;
		
		m_self.setAccessible(true);

		m_annos = new AnnotatablePart(ElementType.FIELD, m_self.getAnnotations());
	}

	public Field getField()
	{
		return m_self;
	}

	// MEMBER

	@Override
	public ReflectedObject getParent()
	{
		return m_parent;
	}

	// DATA HOLDER

	public Class<?> getDataType()
	{
		return m_self.getType();
	}
	
	@Override
	public ReflectedObject get()
	{

		try
		{
			try
			{
				return ReflectedObject.create(m_self.get(m_parent.getObject()));
			} catch(IllegalArgumentException e)
			{
			} catch(IllegalAccessException e)
			{
			}
		} catch(ClassCastException e)
		{
			return null;
		}

		return null;
	}

	@Override
	public ReflectedObject set(ReflectedObject data)
	{
		ReflectedObject t = this.get();

		try
		{
			m_self.set(m_parent.getObject(), data.getObject());
		} catch(Exception e)
		{
			return null;
		}

		return t;
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
