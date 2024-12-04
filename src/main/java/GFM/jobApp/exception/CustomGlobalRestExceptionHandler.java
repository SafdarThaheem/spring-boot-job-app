package GFM.jobApp.exception;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
public class CustomGlobalRestExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage().toLowerCase(Locale.ROOT));
        errors.put("status", HttpStatus.PRECONDITION_FAILED.getReasonPhrase().toUpperCase(Locale.ROOT));
        return new ResponseEntity<>(errors, HttpStatus.PRECONDITION_FAILED);
    }
}
