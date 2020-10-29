package com.stoom.br.exception;

public class AddressNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException(Long id)
	{
		super("Address id not found : " + id);
	}

}
