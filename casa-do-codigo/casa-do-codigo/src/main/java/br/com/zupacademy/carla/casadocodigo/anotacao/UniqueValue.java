package br.com.zupacademy.carla.casadocodigo.anotacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface UniqueValue {

	 	String message() default "Valor inválido";
	 
	    Class<?>[] groups() default {};
	 
	    Class<? extends Package>[] payload() default {};
	 
	    String fieldName();
	    Class<?> domainClass();
}
