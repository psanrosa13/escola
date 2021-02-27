package com.exemplo.escola.exception;

public class TurmaInexistenteException extends RuntimeException{

    public TurmaInexistenteException(){
        super("Esta Turma não existe no sistema!");
    }
}
