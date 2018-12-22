package br.com.douglasffilho.reactivespring.domain.impl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BaseDocument implements br.com.douglasffilho.reactivespring.domain.Document {

    private static final long serialVersionUID = -7308590271581200518L;

    @Id
    private String id;

    private String email;

}
