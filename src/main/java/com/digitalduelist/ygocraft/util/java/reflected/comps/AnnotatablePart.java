package com.digitalduelist.ygocraft.util.java.reflected.comps;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;

import com.digitalduelist.ygocraft.util.java.reflected.IAnnotatable;

public class AnnotatablePart implements IAnnotatable
{
	private ElementType m_type;
	private Annotation[] m_annos;
	private Class<? extends Annotation>[] m_annoTypes;
	
	public AnnotatablePart(ElementType type, Annotation[] annos)
	{
		m_type = type;
		m_annos = annos;
	}

	@Override
	public ElementType getType()
	{
		return m_type;
	}

	@Override
	public boolean hasAnnotation(Class<? extends Annotation> anno)
	{
		for(Annotation a : getAnnotations())
		{
			if(anno.isAssignableFrom(a.annotationType())) return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A extends Annotation> A getAnnotation(Class<A> anno)
	{
		for(Annotation a : getAnnotations())
		{
			if(anno.isAssignableFrom(a.annotationType())) return (A) a;
		}
		
		return null;
	}

	@Override
	public Annotation[] getAnnotations()
	{
		return m_annos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends Annotation>[] getAnnotationTypes()
	{
		if(m_annoTypes == null)
		{
			Annotation[] anos = getAnnotations();
			
			m_annoTypes = new Class[anos.length];
			
			for(int i = 0; i < anos.length; i++)
			{
				m_annoTypes[i] = anos[i].annotationType();
			}
		}
		
		return m_annoTypes;
	}
}
