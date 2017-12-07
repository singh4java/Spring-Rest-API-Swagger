package com.reference.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reference.api.domain.Employee;
import com.reference.api.domain.EmployeeRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Fetch a list of Employee
	 * @return a list of Employee
	 */
    @RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch all Employee")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")}) 
    public List<Employee> employee() {
    	List<Employee> employee = (List<Employee>) employeeRepository.findAll();
    	
    	return employee;
    }
    
    
    /**
     * Finds a employee by <code>id</code>
     * 
     * @param id employee id
     * 
     * @return the {@link Employee} object
     */
    @RequestMapping(path = "/{id}", 
    				method = RequestMethod.GET)
    @ApiOperation(value = "Fetch a employee")
    public Employee employee(@PathVariable Long id) {
    	return employeeRepository.findOne(id);
    }
    
    
    /**
     * Adds a employee
     * 
     * @param employee
     * @return
     */
    @RequestMapping(path = "/add",
    				method = RequestMethod.POST,
    				 consumes =  MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add a employee")
    public Employee add(@RequestBody Employee employee) {
    	Employee savedEmployee =  employeeRepository.save(employee);
    	
    	return savedEmployee;
    }

    
    /**
     * Updates the employee
     * 
     * @param employee
     * @return
     */
    @RequestMapping(path = "/update",
    				method = RequestMethod.PUT)
    @ApiOperation(value = "Update a employee")
    public Employee update(@RequestBody Employee employee) {
    	Employee savedEmployee =  employeeRepository.save(employee);
    	
    	return savedEmployee;
    }
    
    
    /**
     * Deletes employee identified with <code>id</code>
     * @param id
     */
    @RequestMapping(path = "/{id}", 
			method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a employee")
    public void delete(@PathVariable Long id) {
    	employeeRepository.delete(id);
    }

}
