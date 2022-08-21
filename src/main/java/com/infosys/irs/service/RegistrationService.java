/**
 * 
 */
package com.infosys.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.irs.entity.Customer;
import com.infosys.irs.exception.InfyGoServiceException;
import com.infosys.irs.repository.CustomerRepository;

/**
 * The Class AadharService.
 */
@Service
public class RegistrationService {

	@Autowired
	private CustomerRepository customerRepository;

	public Boolean insertUser(Customer customer) throws InfyGoServiceException {

		Customer cust = customerRepository.saveAndFlush(customer);

		if (cust == null) {
			throw new InfyGoServiceException("User record not found");
		} else {
			return true;
		}

	}

}
