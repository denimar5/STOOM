package com.stoom.br.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stoom.br.controllers.mapper.Converter;
import com.stoom.br.model.Endereco;
import com.stoom.br.service.EnderecoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("http://localhost:9090")
@RestController
@RequestMapping("/api")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@ApiOperation(value = "Realiza a inclusão de um endereco.")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),                
        @ApiResponse(code = 404, message = "Não encontrado."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno.")})
    	@RequestMapping(value = "/endereco",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
	 public Endereco createAddress(@Valid @RequestBody Endereco endereco) {
					
		 return enderecoService.createAddress(endereco);
	 }

	@ApiOperation(value = "Realiza a atualizao de um endereco.")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),                
        @ApiResponse(code = 404, message = "Não encontrado."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno.")})
    	@RequestMapping(value = "/endereco/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
	 public Endereco updateAddress(@Valid @RequestBody Endereco endereco, @PathVariable(name = "id", required = true) Long id) {
		 return enderecoService.updateAddress(endereco, id);
	 }
	
	@ApiOperation(value = "Realiza a consulta de um endereco.")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),                
        @ApiResponse(code = 404, message = "Não encontrado."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno.")})
    	@RequestMapping(value = "/endereco/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
	 public Endereco getAddress(@Valid @RequestBody Endereco endereco, @PathVariable(name = "id", required = true) Long id) {
		 return enderecoService.getAddress(id);
	 }

	@ApiOperation(value = "Retorna uma lista de todos enderecos.")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),                     
        @ApiResponse(code = 500, message = "Ocorreu um erro interno.")})
    	@RequestMapping(value = "/endereco",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
	 public List<Endereco> getAllAddress() {
		 return enderecoService.getAllAddress();
	 }
	
	@ApiOperation(value = "Realiza a consulta de um endereco.")
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),                
        @ApiResponse(code = 404, message = "Não encontrado."),
        @ApiResponse(code = 500, message = "Ocorreu um erro interno.")})
    	@RequestMapping(value = "/endereco/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
	 public void deleteAddress(@PathVariable(name = "id", required = true) Long id) {
		  enderecoService.deleteAddress(id);;
	 }
}
