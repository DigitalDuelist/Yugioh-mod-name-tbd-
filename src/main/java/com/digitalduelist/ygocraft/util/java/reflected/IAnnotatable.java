package com.digitalduelist.ygocraft.util.java.reflected;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;

public interface IAnnotatable
{
	
	public ElementType getType();
	
	public boolean hasAnnotation(Class<? extends Annotation> anno);
	
	public <A extends Annotation> A getAnnotation(Class<A> anno);
	
	public Annotation[] getAnnotations();
	
	public Class<? extends Annotation>[] getAnnotationTypes();
	
}	
