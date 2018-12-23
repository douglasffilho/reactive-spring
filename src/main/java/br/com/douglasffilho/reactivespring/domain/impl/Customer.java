package br.com.douglasffilho.reactivespring.domain.impl;

import br.com.douglasffilho.reactivespring.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseDocument {

    private static final long serialVersionUID = 2041325806361374412L;
    private String email;

    private String telephone;

    private Gender gender;

}
