package com.github.Gregorys2s.exceptions;

public class AcharProdutoException extends RuntimeException {
    public AcharProdutoException(String message) {
        super(message);
    }
    public AcharProdutoException(String message, Exception cause) { super(message, cause);}
}
