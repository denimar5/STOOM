package com.stoom.br.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class Endereco {

	@Id
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo street name é obrigatorio")
	private String streetName;
	
	@NotEmpty(message = "O campo  nunber é obrigatorio")	
	private Integer number;
	
	@Column(name = "ADDR_STREET_COMPLEMENT")
	private String complement;
	
	@NotEmpty(message = "O campo neighbourhood é obrigatorio")
	private String  neighbourhood;
	
	@NotEmpty(message = "O campo city é obrigatorio")
	private String  city;
	
	@NotEmpty(message = "O campo state é obrigatorio")
	private String  state;
	
	@NotEmpty(message = "O campo country é obrigatorio")
	private String country;
	
	@NotEmpty(message = "O campo zip é obrigatorio")
	private String  zipcode;
	
	private Double latitude;
		
	private Double longitude;
	
}
