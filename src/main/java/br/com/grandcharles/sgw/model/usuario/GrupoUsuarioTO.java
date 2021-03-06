package br.com.grandcharles.sgw.model.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tbGrupoUsuario")
public class GrupoUsuarioTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@NotBlank
	@Size(max=40)
	@Column(name="strNome", length=40, nullable=false)
	private String nome;

	@NotBlank
	@Size(max=40)
	@Column(name="strDescricao", length=40, nullable=false)
	private String descricao;

	@ManyToMany(mappedBy="lstGrupoUsuario", cascade = CascadeType.ALL)
	private List<UsuarioTO> lstUsuario = new ArrayList<>();
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<UsuarioTO> getLstUsuario() {
		return lstUsuario;
	}
	public void setLstUsuario(List<UsuarioTO> lstUsuario) {
		this.lstUsuario = lstUsuario;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoUsuarioTO other = (GrupoUsuarioTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
