package com.stoom.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stoom.br.client.GoogleClient;
import com.stoom.br.client.Results;
import com.stoom.br.controllers.mapper.Converter;
import com.stoom.br.exception.AddressNotFoundException;
import com.stoom.br.model.Endereco;
import com.stoom.br.model.EnderecoEntity;
import com.stoom.br.model.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	GoogleClient googleClient;
	
	private String assembreStrAddress(Endereco endereco) {
		return endereco.getNeighbourhood()+ "+"
				+endereco.getNumber()+"+"
				+endereco.getComplement()+"+"
				+endereco.getCity()+"+"
				+endereco.getState()+"+"
				+endereco.getZipcode()+"+"
				+endereco.getCountry();
		
		// Retorna rua+jose+dos+reis+1352+RJ+BR
	}
	private Endereco resolveGeoLocalization(Endereco endereco) {
		
		try {
			if(StringUtils.isEmpty(endereco.getLatitude()) ||
				StringUtils.isEmpty(endereco.getLongitude())) {
				
				Results r = googleClient.getGeoLocalization(assembreStrAddress(endereco));
				
				if(r.getResults().size()>0) {
				   endereco.setLatitude(r.getResults().get(0).getGeometry().getLocation().getLat());	
				   endereco.setLongitude(r.getResults().get(0).getGeometry().getLocation().getLng());
				}
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			   endereco.setLatitude(0.0);	
			   endereco.setLongitude(0.0);
		}catch(Exception e) {
			   endereco.setLatitude(0.0);	
			   endereco.setLongitude(0.0);
		}
		
		return endereco;
	}
	 public Endereco createAddress( Endereco endereco) {
		
		 enderecoRepository.save(Converter.INSTANCE.mapPojoToEntityAddress(resolveGeoLocalization(endereco)));
		
		 return endereco;
	 }


	 public Endereco updateAddress( Endereco endereco, Long id) {
		 //Verifica se o registo existe na base
		 EnderecoEntity enderecoEntity = enderecoRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
		 
		 //mapeia body json para entidade de banco de dados
		 enderecoEntity = Converter.INSTANCE.mapPojoToEntityAddress( resolveGeoLocalization(endereco));
		 
		 //mapeia chave primaria 
		 enderecoEntity.setId(id);
		 enderecoRepository.save(enderecoEntity);
		 
		 endereco.setId(id);
		 
		 return endereco; // Retorna o mesmo objeto de entrada em  caso de sucesso.
	 }
	
	
	 public Endereco getAddress(  Long id) {
		//Verifica se o registo existe na base
		 EnderecoEntity entity = enderecoRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
		 
		 //mapeia entity para pojo 
		 return Converter.INSTANCE.mapEntiryToPojoAddress(entity);
		 
		 
	 }

	
	 public List<Endereco> getAllAddress() {
		 
		 List<Endereco> lstAddr = new ArrayList<Endereco>();
		  enderecoRepository.findAll().stream().forEach(i ->{
			  lstAddr.add(Converter.INSTANCE.mapEntiryToPojoAddress(i));
			  }
		  );
		 
		 return lstAddr;
	 }
	
	
	 public void deleteAddress(Long id) {
		 enderecoRepository.deleteById(id);
	 }
}
