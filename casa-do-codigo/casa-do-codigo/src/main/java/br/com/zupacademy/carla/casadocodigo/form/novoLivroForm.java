package br.com.zupacademy.carla.casadocodigo.form;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.zupacademy.carla.casadocodigo.modelo.Autor;
import br.com.zupacademy.carla.casadocodigo.modelo.Categoria;
import br.com.zupacademy.carla.casadocodigo.modelo.novoLivro;
import br.com.zupacademy.carla.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.carla.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.carla.casadocodigo.repository.novoLivroRepository;

public class novoLivroForm {

	// Unico
	@NotNull
	private String titulo;

	@NotNull
	@Size(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@DecimalMin("20.0")
	private Double preco;

	@NotNull
	@Min(100)
	private int numeroPaginas;

	@Future
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataPublicao;

	// Unico
	@NotNull
	private String isbn;

	
	private Long idAutor;
	
	private Long idCategoria;

	public novoLivroForm() {

	}

	public novoLivroForm(@NotNull String titulo, @NotNull @Size(max = 500) String resumo, String sumario,
			@NotNull @DecimalMin("20.0") Double preco, @NotNull @Min(100) int numeroPaginas,
			@Future @DateTimeFormat(pattern = "dd-MM-yyyy")Date dataPublicao, @NotNull String isbn,  Long idCategoria,  Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.dataPublicao = dataPublicao;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	
		
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

	public Long getIdCategoria() {
		return idCategoria;
	}
	
	public Long getIdAutor() {
		return idAutor;
	}

	public novoLivro converter(EntityManager em) {
		
		Autor autor = em.find(Autor.class, this.idAutor);
		
		Categoria categoria = em.find(Categoria.class, this.idCategoria);

		novoLivro livro = new novoLivro(titulo, resumo, sumario, preco, numeroPaginas, dataPublicao, isbn, categoria, autor);
		
		return livro;
	}
	
	


}
