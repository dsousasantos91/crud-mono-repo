package br.com.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
	@Pattern(regexp = "^[áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑa-zA-Z0-9_ ]*")
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

	@NotNull
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Endereco endereco;

	@NotEmpty
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private List<Telefone> telefones;

	@NotEmpty
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private List<EMail> emails;

	@PrePersist
	@PreUpdate
	public void removerMascaraCpf() {
		this.cpf = this.cpf.replace(".", "")
				.replace("-", "");
	}

	public String getCpf() {

		try {
			MaskFormatter mf = new MaskFormatter("###.###.###-##");
			mf.setValueContainsLiteralCharacters(false);
			this.cpf = mf.valueToString(this.cpf) ;
		} catch (ParseException e) {
			e.getCause();
		}

		return this.cpf;
	}

}
