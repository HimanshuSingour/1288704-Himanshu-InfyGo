/**
 * 
 */
package com.infosys.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.irs.dto.LoginDetails;
import com.infosys.irs.entity.Customer;
import com.infosys.irs.exception.ExceptionConstants;
import com.infosys.irs.exception.InfyGoServiceException;
import com.infosys.irs.repository.CustomerRepository;

/**
 * The Class AadharService.
 */
@Service
public class LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	public boolean isUserValid(LoginDetails customerLogin) throws InfyGoServiceException {

		Customer customer = customerRepository.findById(customerLogin.getUserId()).get();

		if (customer == null) {
			throw new InfyGoServiceException(ExceptionConstants.USER_NOT_FOUND.toString(), "User record not found");
		} else if (!(customer.getPassword().equals(customerLogin.getPassword()))) {
			throw new InfyGoServiceException(ExceptionConstants.USER_INVALID.toString(), "Invalid credentials");
		}
		return true;

	}

}
