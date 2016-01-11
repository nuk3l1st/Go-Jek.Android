package org.codehaus.jackson.annotate;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
@JacksonAnnotation
public @interface JsonManagedReference
{
  String value() default "defaultReference";
}


/* Location:              /Users/michael/Downloads/dex2jar-2.0/GO_JEK.jar!/org/codehaus/jackson/annotate/JsonManagedReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */