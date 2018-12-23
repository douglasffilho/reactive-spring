package br.com.douglasffilho.reactivespring.domain.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDocument implements br.com.douglasffilho.reactivespring.domain.Document {

    private static final long serialVersionUID = -7308590271581200518L;

    @Id
    private String id;

}
