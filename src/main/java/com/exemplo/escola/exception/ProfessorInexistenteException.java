package com.exemplo.escola.exception;

public class ProfessorInexistenteException extends RuntimeException {
    public ProfessorInexistenteException(){
        super("Este Professor não existe no sistema!");
    }

}
