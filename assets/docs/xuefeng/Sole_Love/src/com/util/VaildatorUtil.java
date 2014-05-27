package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.persistence.Entity;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Entity
public class VaildatorUtil {
	private static final Validator validator;
	static {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public Validator getVaildator() {
		return validator;
	}

	public VaildatorUtil() {

	}

	public static <T> Map<String, String> message(T t) {
		Map<String, String> map = new HashMap<String, String>();
		Set<ConstraintViolation<T>> constraintViolations = validator
				.validate(t);
		Iterator<ConstraintViolation<T>> it = constraintViolations.iterator();
		while (it.hasNext()) {
			ConstraintViolation<T> c = it.next();
			map.put(c.getPropertyPath().toString(), c.getMessage());
		}
		return map;
	}
}