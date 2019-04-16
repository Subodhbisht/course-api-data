package io.course.springbootstarter.hanldeException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ResouceNotFoundException.class)
	public ResponseEntity<ErrorDetail> resourceNotFoundException(Exception exception,WebRequest request){
		ErrorDetail errorDetail = new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false),"Dekho kya aata hai");
		return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
	}

}
