package com.henripay.spellclientservice.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ClientDto {
    @NotBlank(message = "Shouldn't be blank")
    @NotNull(message = "Shouldn't be null")
    @Email(message = "Invalid email")
    private String email;

    @Override
    public String toString() {
        return "Client: "+this.email;
    }
}
