package com.exemplo.escola.exception;

public class MateriaInexistenteException extends RuntimeException{

    public MateriaInexistenteException(){
        super("Esta Matéria não existe no sistema!");
    }
}
