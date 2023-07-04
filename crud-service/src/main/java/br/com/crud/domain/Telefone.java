package br.com.crud.domain;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.NotNull;
import java.text.ParseException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer ddd;

    @NotBlank
    private String numero;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @PrePersist
    @PreUpdate
    public void removerMascaraNumero() {
        this.numero = this.numero.replace("-", "");
    }

    public String getNumero() {
        try {
            MaskFormatter mf = new MaskFormatter("####-####");
            mf.setValueContainsLiteralCharacters(false);

            if (this.tipo.equals(TipoTelefone.CELULAR)) {
                mf.setMask("#####-####");
            }

            this.numero = mf.valueToString(this.numero);
        } catch (ParseException e) {
            e.getCause();
        }

        return this.numero;
    }

}
