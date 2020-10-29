package com.stoom.br.controllers.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.stoom.br.model.Endereco;
import com.stoom.br.model.EnderecoEntity;

@Mapper
public interface Converter {
	
	Converter INSTANCE = Mappers.getMapper(Converter.class);
	
	@Mapping(target="id", source="enitity.id")
	@Mapping(target="streetName", source="enitity.streetName")
	@Mapping(target="number", source="enitity.number")	 
	@Mapping(target="complement", source="enitity.complement")	 
	@Mapping(target="neighbourhood", source="enitity.neighbourhood") 
	@Mapping(target="city", source="enitity.city")
	@Mapping(target="state", source="enitity.state")	 
	@Mapping(target="country", source="enitity.country")
	@Mapping(target="zipcode", source="enitity.zipcode")	 
	@Mapping(target="latitude", source="enitity.latitude")
	@Mapping(target="longitude", source="enitity.lonfitude")
	
	public Endereco mapEntiryToPojoAddress(EnderecoEntity entity);
	
	@Mapping(target="streetName", source="pojo.streetName")
	@Mapping(target="number", source="pojo.number")	 
	@Mapping(target="complement", source="pojo.complement")	 
	@Mapping(target="neighbourhood", source="pojo.neighbourhood") 
	@Mapping(target="city", source="pojo.city")
	@Mapping(target="state", source="pojo.state")	 
	@Mapping(target="country", source="pojo.country")
	@Mapping(target="zipcode", source="pojo.zipcode")	 
	@Mapping(target="latitude", source="pojo.latitude")
	@Mapping(target="longitude", source="pojo.lonfitude")
	
	public EnderecoEntity mapPojoToEntityAddress(Endereco pojo);
	
	
	
}
