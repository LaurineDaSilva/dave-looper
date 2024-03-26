package co.simplon.davelooper.controllers.errors;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
class ControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatusCode status, WebRequest request) {
	List<ValidationError> errors = ex.getFieldErrors().stream()
		.map((e) -> new ValidationError(e.getField(), e.getCode()))
		.toList();
	return handleExceptionInternal(ex, errors, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
	    Object body, HttpHeaders headers, HttpStatusCode statusCode,
	    WebRequest request) {
	if (logger.isDebugEnabled()) {
	    logger.debug("An unexpected (?) exception occured mate!", ex);
	}
	return super.handleExceptionInternal(ex, body, headers, statusCode,
		request);
    }
}
