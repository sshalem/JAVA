package demo;

enum ErrorMessagesEnum {

    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided id is not found"),
    AUTHENTICATION_FAILED("Authentication failed"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    COULD_NOT_DELETE_RECORD("Could not delete record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified");

	private String errorMessage;

	private ErrorMessagesEnum(String errorMessage) {
		this.errorMessage = errorMessage;
		// Reminder : enum constructor called separately for each  constant
		// See the output
		System.out.println("Constructor called for : " + this.toString());
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

public class _5_EnumPrivateFieldConstructorAndGetterSetter {

	public static void main(String[] args) {
			
		String message = ErrorMessagesEnum.EMAIL_ADDRESS_NOT_VERIFIED.getErrorMessage();
		System.out.println(message);
		
		ErrorMessagesEnum.EMAIL_ADDRESS_NOT_VERIFIED.setErrorMessage("new EMAIL Error message to define in ENUM");
		String newMessage = ErrorMessagesEnum.EMAIL_ADDRESS_NOT_VERIFIED.getErrorMessage();
		System.out.println(newMessage);
	}

}

/**
	Output :
	
	Constructor called for : MISSING_REQUIRED_FIELD
	Constructor called for : RECORD_ALREADY_EXISTS
	Constructor called for : INTERNAL_SERVER_ERROR
	Constructor called for : NO_RECORD_FOUND
	Constructor called for : AUTHENTICATION_FAILED
	Constructor called for : COULD_NOT_UPDATE_RECORD
	Constructor called for : COULD_NOT_DELETE_RECORD
	Constructor called for : EMAIL_ADDRESS_NOT_VERIFIED
	Email address could not be verified
	new EMAIL Error message to define in ENUM
*/