package com.dante.examples.notetaker;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class NoteDao {

	@PersistenceContext
	protected EntityManager em;

	public boolean save(Note note) {
		em.persist(note);
		return true;
	}

	public List<Note> getAll() {
		Query query = em.createQuery("from Note");
		return query.getResultList();
	}
}
