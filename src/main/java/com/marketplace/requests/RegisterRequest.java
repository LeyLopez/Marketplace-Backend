package com.marketplace.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String firstName;
    String lastName;
    // AGREGAR UN BOTON DESLIZABLE QUE PERMITA ELEGIR ENTRE REGISTRARSE COMO CLIENTE O COMO VENDEDOR---!!!!!!!!!!!!!!!!!!!!
}
