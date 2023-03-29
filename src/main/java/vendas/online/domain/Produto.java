package main.java.vendas.online.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="produto", description="Produto")
public class Produto {

    @Id
    @Schema(description="Identificador único")
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="Nome", minLength = 1, maxLength=50, nullable = false)
    private String nome;

    @NotNull
    @Indexed(unique = true, background = true)
    @Schema(description="Código", nullable = false)
    private Long cpf;

    @NotNull
    @Schema(description="Serial", nullable = false)
    private Long tel;

    @NotNull
    @Size(min = 1, max = 50)
    @Indexed(unique = true, background = true)
    @Schema(description="Email fornecedor", minLength = 1, maxLength=50, nullable = false)
    @Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="Marca", minLength = 1, maxLength=50, nullable = false)
    private String end;




}



