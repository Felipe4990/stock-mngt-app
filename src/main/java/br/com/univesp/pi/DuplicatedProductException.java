package br.com.univesp.pi;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicatedProductException extends DataIntegrityViolationException {
    public DuplicatedProductException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
