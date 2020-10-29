package com.stoom.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data 
@Entity
@Table(name = "STOOM_ADDRESS")
public class EnderecoEntity {
	
	@NotEmpty(message = "O campo id é obrigatorio")
	@Id
	@Column(name = "ADDR_ID")
	private Long id;
	
	@NotEmpty(message = "O campo street name é obrigatorio")
	@Column(name = "ADDR_STREET_NAME")
	private String streetName;
	
	@NotEmpty(message = "O campo  nunber é obrigatorio")
	@Column(name = "ADDR_STREET_NUMBER")
	private Integer number;
	
	@Column(name = "ADDR_STREET_COMPLEMENT")
	private String complement;
	
	@NotEmpty(message = "O campo neighbourhood é obrigatorio")
	@Column(name = "ADDR_STREET_NGBHOOD")
	private String  neighbourhood;
	
	@NotEmpty(message = "O campo city é obrigatorio")
	@Column(name = "ADDR_STREET_CITY")
	private String  city;
	
	@NotEmpty(message = "O campo state é obrigatorio")
	@Column(name = "ADDR_STREET_STATE")
	private String  state;
	
	@NotEmpty(message = "O campo country é obrigatorio")
	@Column(name = "ADDR_STREET_COUNTRY")
	private String country;
	
	@NotEmpty(message = "O campo zip é obrigatorio")
	@Column(name = "ADDR_STREET_ZIP")
	private String  zipcode;
	
	@Column(name = "ADDR_STREET_LATITUDE")
	private Double latitude;
	
	@Column(name = "ADDR_STREET_LONGITUDE")
	private Double longitude;
	

}
