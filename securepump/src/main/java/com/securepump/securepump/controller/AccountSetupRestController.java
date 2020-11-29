package com.securepump.securepump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securepump.securepump.exception.RecordAlreadyPresentException;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.exception.UserNotFoundException;
import com.securepump.securepump.model.AccountCreationEntity;
import com.securepump.securepump.model.CustomerCreationEntity;
import com.securepump.securepump.model.SupplierCreationEntity;
import com.securepump.securepump.service.AccountCreationService;
import com.securepump.securepump.service.CustomerCreationService;
import com.securepump.securepump.service.SupplierCreationService;

@RestController
@RequestMapping("/AccountSetup")
public class AccountSetupRestController {

	 @Autowired 
	 AccountCreationService accountService;
	 @Autowired
	 CustomerCreationService customerService;
	 @Autowired
	SupplierCreationService supplierService;
	 @RequestMapping("/getAccountDetails")
		public List<AccountCreationEntity>  getAllAccounts() {
			List<AccountCreationEntity> listAccounts = accountService.getAllAccounts();
			return listAccounts;
		}
	@PostMapping(value="/AccountCreate/Accounts")
	public ResponseEntity  AccountCreate(
				 @RequestBody AccountCreationEntity account)
		{
			
			AccountCreationEntity accountEntity=accountService.createOrUpdateAccounts(account);
			return ResponseEntity.ok(HttpStatus.OK);
		}
	
	@GetMapping("/getAccount/{id}")
	public AccountCreationEntity retrieveUser(@PathVariable Long id) throws RecordNotFoundException {
		
		AccountCreationEntity account=accountService.getAccountsById(id);
		if(account==null)
			throw new UserNotFoundException("id-"+ id);
		return account;
	}
	@DeleteMapping("/deleteAccount/{id}")
	public void deleteAccount(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
		accountService.deleteAccountsById(id);
	
	}
	@PutMapping("/updateAccount/{id}")
	public ResponseEntity  updateAccount(
			 @RequestBody AccountCreationEntity account,@PathVariable long id)
	{
		
		AccountCreationEntity accountEntity=accountService.createOrUpdateAccounts(account);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	@RequestMapping("/getCustomerDetails")
	public List<CustomerCreationEntity> getAllCustomers() {
		List<CustomerCreationEntity> listCustomer=customerService.getAllCutomer();
		return listCustomer;
	}
	@PostMapping(value="/CustomerCreate/Customer")
	public ResponseEntity  customerCreate(
				 @RequestBody CustomerCreationEntity customer) {
		boolean s=customerService.getCustomerByMobile(customer.getMobileNo());
		if(s==true)
			throw new RecordAlreadyPresentException("user Already Present");
		customerService.createOrUpdateCustomer(customer);
		return ResponseEntity.ok(HttpStatus.OK);
		
	}
	@GetMapping("/getCustomer/{id}")
	public CustomerCreationEntity getCustomer(@PathVariable Long id) throws RecordNotFoundException{
		CustomerCreationEntity customer=customerService.getCustomerById(id);
		if(customer==null)
			throw new UserNotFoundException("User not Found "+ id);
		return customer;
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity deleteCustomer(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
		customerService.deleteCustomerById(id);
		return ResponseEntity.ok(HttpStatus.OK);	
	}
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity  updateCustomer(
			 @RequestBody CustomerCreationEntity customer,@PathVariable long id)
	{
		CustomerCreationEntity customerEntity=customerService.createOrUpdateCustomer(customer);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@RequestMapping("/getSuppliers")
	public List<SupplierCreationEntity> supplierCreate( ) {
		List<SupplierCreationEntity> listSuppliers=supplierService.getAllSuppliers();
		return listSuppliers;
	}
	@GetMapping("/getSupplier/{id}")
	public SupplierCreationEntity getSupplier(@PathVariable Long id) throws RecordNotFoundException{
		SupplierCreationEntity supplier=supplierService.getSupplierById(id);
		if(supplier==null)
			throw new UserNotFoundException("User not Found "+ id);
		return supplier;
	}
	@PostMapping(value="/SupplierCreate/Supplier")
	public ResponseEntity  supplierCreate(
				 @RequestBody SupplierCreationEntity supplier) {
		boolean s=supplierService.getSupplierNameOrMobile(supplier.getSupplierName(), supplier.getMobileNo());
		if(s==true)
			throw new RecordAlreadyPresentException("user Already Present");
		supplierService.createOrUpdateSupplier(supplier);
		return ResponseEntity.ok(HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteSupplier/{id}")
	public ResponseEntity deleteSupplier(@PathVariable(name = "id") Long id) throws RecordNotFoundException {
		supplierService.deleteSupplierById(id);
		return ResponseEntity.ok(HttpStatus.OK);	
	}
	@PutMapping("/updateSupplier/{id}")
	public ResponseEntity  updateSupplier(
			 @RequestBody SupplierCreationEntity supplier,@PathVariable long id)
	{
		SupplierCreationEntity supplierEntity=supplierService.createOrUpdateSupplier(supplier);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	

}

