package br.com.crud.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Size(max = 8)
	@NotBlank
	private String cep;

    @NotBlank
    @Size(max = 100)
    private String logradouro;

    @NotBlank
    @Size(max = 50)
    private String bairro;

    @NotBlank
    @Size(max = 50)
    private String cidade;

    @NotNull
	@Enumerated(EnumType.STRING)
	private UF uf;

	private String complemento;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@PrePersist
	@PreUpdate
	public void removerMascaraCep() {
		this.cep = this.cep.replace(".", "")
				.replace("-", "");
	}

	public String getCep() {

		try {
			MaskFormatter mf = new MaskFormatter("#####-###");
			mf.setValueContainsLiteralCharacters(false);
			this.cep = mf.valueToString(this.cep);
		} catch (ParseException e) {
			e.getCause();
		}

		return this.cep;
	}

}
