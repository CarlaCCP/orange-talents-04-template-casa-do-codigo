package br.com.zupacademy.carla.casadocodigo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.zupacademy.carla.casadocodigo.anotacao.UniqueValue;

@Entity
public class novoLivro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	// Unico
	@NotNull
	//@UniqueValue(domainClass = novoLivro.class, fieldName="titulo")
	private String titulo;
	
	@NotNull @Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @DecimalMin("20.0")
	private Double preco;
	
	@NotNull @Min(100)
	private int numeroPaginas;
	
	@Future
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	// ou DateTime com @JsonFormat(pattern = "padrao da data aqui", shape = Shape.STRING)
	//fazer um set de data para forçar o datetimeFormat​
	private Date dataPublicao;
	
	// Unico
	@NotNull
	private String isbn;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;
	
//	@ManyToMany
//	private List<Autor> autor = new ArrayList<>();

	public novoLivro(@NotNull  String titulo, @NotNull @Size(max = 500) String resumo, String sumario,
			@NotNull @DecimalMin("20.0") Double preco, @NotNull @Min(100) int numeroPaginas,
			@Future @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataPublicao, @NotNull String isbn, @NotNull Categoria  categoria, @NotNull Autor autor) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.dataPublicao = dataPublicao;
		this.isbn = isbn;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	@Deprecated
	public novoLivro() {
		
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public Date getDataPublicao() {
		return dataPublicao;
	}

	public String getIsbn() {
		return isbn;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	
	
	
}
