package com.dante.examples.notetaker;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/note")
@Stateless
public class NoteREST {

	@Inject
	protected NoteDao noteDao;

	@Path("/")
	@POST
	public Response saveNote(String message) {
		Note note = new Note();
		note.setMessage(message);
		noteDao.save(note);
		return Response.ok().build();
	}

	@Path("/query")
	@GET
	public Response getAllNotes() {
		List<Note> notes = noteDao.getAll();
		return Response.ok(notes).build();
	}
}
