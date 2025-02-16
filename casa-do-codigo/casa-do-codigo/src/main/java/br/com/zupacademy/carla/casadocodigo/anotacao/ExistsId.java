package br.com.zupacademy.carla.casadocodigo.anotacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ExistsIdValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface ExistsId {

	String message() default "Este país não esta cadastrado no nosso banco de dados";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String fieldName();

	Class<?> domainClass();
}
