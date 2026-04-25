package com.github.Gregorys2s.exceptions;

public class PersistenciaProdutoRepositoryException extends RuntimeException {
    public PersistenciaProdutoRepositoryException(String message) {
        super(message);
    }
    public PersistenciaProdutoRepositoryException(String message, Exception cause) { super(message, cause);}
}
