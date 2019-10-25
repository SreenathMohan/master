package com.eob.reconciliation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eob.reconciliation.model.EobRec;
import com.eob.reconciliation.repo.EobRecRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(value = "eob", description = "Operations pertaining to EOB ")
public class HomeController {

	@Autowired
	EobRecRepo eobRecRepo;

	@ApiOperation(value = "View a list of available eobs", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/eobs", method = RequestMethod.GET, produces = "application/json")
	public List<EobRec> hello() {
		System.out.println(" Inside hello method");
		return eobRecRepo.findAll();
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/eobs/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<EobRec> get(@PathVariable Integer id) {
		System.out.println("*** Inside GetMethod");
		return eobRecRepo.findById(id);
	}
	
	@RequestMapping(value = "/eobs/name/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getEobName(@PathVariable Integer id) {
		System.out.println("*** Inside GetMethod");
		return eobRecRepo.findById(id).get().getEobName();
	}
	

}
