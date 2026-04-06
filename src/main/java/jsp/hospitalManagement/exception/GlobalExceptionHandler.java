package jsp.hospitalManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jsp.hospitalManagement.service.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(NoDepartmentFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoDepartmentFoundException(NoDepartmentFoundException exception){
		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(exception.getMessage());
		response.setData("Failure");
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception){
        ResponseStructure<String> response = new ResponseStructure<String>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setData("Failure");
        
        return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSpecializationFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoSpecializationFoundException(NoSpecializationFoundException exception){
		   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.NOT_FOUND.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoDoctorFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoDoctorFoundException(NoDoctorFoundException exception){
		   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.NOT_FOUND.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoPatientFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoPatientFoundException(NoPatientFoundException exception){
		   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.NOT_FOUND.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(DuplicateDepartmentException.class)
    public ResponseEntity<ResponseStructure<String>> handleDuplicateDepartmentException(NoPatientFoundException exception){
		   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.BAD_REQUEST.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoAppointmentFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleNoAppointmentFoundException(NoAppointmentFoundException exception){
    	   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.NOT_FOUND.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoMedicalRecordFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleNoMedicalRecordFoundException(NoMedicalRecordFoundException exception){
    	   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.NOT_FOUND.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidAppointmentStateException.class)
    public ResponseEntity<ResponseStructure<String>> handleInvalidAppointmentStateException(InvalidAppointmentStateException exception){
    	   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.NOT_FOUND.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);  
    }
    @ExceptionHandler(NoPrescriptionFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleNoPrescriptionFoundException(NoPrescriptionFoundException exception){
    	   ResponseStructure<String> response = new ResponseStructure<String>();
	       response.setStatusCode(HttpStatus.NOT_FOUND.value());
	       response.setMessage(exception.getMessage());
	       response.setData("Failure");
	        
	       return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);  
    }
}
