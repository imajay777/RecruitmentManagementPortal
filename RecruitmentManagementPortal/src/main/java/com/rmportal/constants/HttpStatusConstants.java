package com.rmportal.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author saurabh
 * Http Status Response messages and code
 */

@Getter // Generate getter
@AllArgsConstructor //Generate all args constructor
public enum HttpStatusConstants {

	
	 OK("OK.",200),
	 CREATED("Created.",201),
	 ACCEPTED("Accepted.",202),
	 NON_AUTHORITATIVE_INFORMATION("Non-Authoritative Information.",203),
	 NO_CONTENT("No Content.",204),
	 RESET_CONTENT("Reset Content.",205),
	 PARTIAL_CONTENT("Partial Content.",206),
	 NOT_MODIFIED("Not Modified.",304),
	 BAD_REQUEST("Bad Request.",400),
	 UNAUTHORIZED("Unauthorized.",401),
	 FORBIDDEN("Forbidden.",403),
	 NOT_FOUND("Not Found.",404),
	 METHOD_NOT_ALLOWED("Method Not Allowed.",405),
	 NOT_ACCEPTABLE("Not Acceptable.",406),
	 PROXY_AUTHENTICATION_REQUIRED("Proxy Authentication Required.",407),
	 REQUEST_TIME_OUT("Request Time-Out.",408),
	 CONFLICT("Conflict.",409),
	 GONE("Gone.",410),
	 REQUEST_ENTITY_TOO_LARGE("Request Entity Too Large.",413),
	 URI_TOO_LARGE("Request-URI Too Large.",414),
	 UNSUPPORTED_MEDIA("Unsupported Media Type.",415),
	 INTERNAL_SERVER_ERROR("Internal Server Error.",500),
	 NOT_IMPLEMENTED("Not Implemented.",501),
	 BAD_GATEWAY("Bad Gateway.",502),
	 SERVICE_UNAVAILABLE("Service Unavailable.",503),
	 GATEWAY_TIMEOUT("Gateway Timeout.",504),
	 VERSION_NOT_SUPPORTED("HTTP Version Not Supported.",505); 
	 
	public String status;
	public int id;

}
