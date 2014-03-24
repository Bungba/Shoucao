package com.Validator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Users;

@Controller
public class UserValidator {
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String userLogin(@Valid Users user, BindingResult result) {
		System.out.println("------------------->UserValidator");
		if (result.hasErrors()) {
			return "index";
		} else {
			return "success";
		}
	}

}
