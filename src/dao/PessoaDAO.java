package dao;

import java.util.List;

import javax.persistence.EntityManager;

import bd.JPAUtil;
import model.Pessoa;

public class PessoaDAO {

	private EntityManager manager;

	public PessoaDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void inserir(Pessoa pessoa) {

		this.manager.getTransaction().begin();

		this.manager.persist(pessoa);

		this.manager.getTransaction().commit();

	}

	public void atualizar(Pessoa pessoa) {

		this.manager.getTransaction().begin();

		this.manager.merge(pessoa);

		this.manager.getTransaction().commit();

	}

	public void remover(Long id) {

		this.manager.getTransaction().begin();
		Pessoa p = buscar(id);
		this.manager.remove(p);
		this.manager.getTransaction().commit();

	}

	private Pessoa buscar(Long id) {

		return this.manager.find(Pessoa.class, id);

	}

	public List<Pessoa> buscarTodos() {

		return manager.createQuery("SELECT p from Pessoa p", Pessoa.class).getResultList();

	}

}
