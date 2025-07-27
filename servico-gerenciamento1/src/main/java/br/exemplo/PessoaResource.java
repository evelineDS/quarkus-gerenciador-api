package br.exemplo;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @GET
    public List<Pessoa> list() {
        return Pessoa.listAll();
    }

    @GET
    @Path("{id}")
    public Pessoa get(@PathParam("id") Long id) {
        Pessoa pessoa = Pessoa.findById(id);
        if (pessoa == null) {
            throw new NotFoundException("Pessoa não encontrada");
        }
        return pessoa;
    }

    @POST
    @Transactional
    public Response create(Pessoa pessoa) {
        pessoa.persist();
        return Response.status(Response.Status.CREATED).entity(pessoa).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoa = Pessoa.findById(id);
        if (pessoa == null) {
            throw new NotFoundException("Pessoa não encontrada");
        }
        pessoa.nome = pessoaAtualizada.nome;
        pessoa.departamento = pessoaAtualizada.departamento;

        // Atualiza tarefas manualmente, se quiser:
        // pessoa.tarefas = pessoaAtualizada.tarefas;

        pessoa.persist();
        return Response.ok(pessoa).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = Pessoa.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Pessoa não encontrada");
        }
        return Response.noContent().build();
    }


}
