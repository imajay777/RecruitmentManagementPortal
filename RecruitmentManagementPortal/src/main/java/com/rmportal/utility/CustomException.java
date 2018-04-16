package com.rmportal.utility;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@ToString(includeFieldNames=true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class CustomException extends Exception {
	
	int id;
	String status;
	

	public CustomException(int id, String status) {
		super(status);
		this.status = status;
		this.id = id;
	}
	
	

}
