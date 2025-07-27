package br.exemplo;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tarefas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarefaResource {

    @GET
    public List<Tarefa> list() {
        return Tarefa.listAll();
    }

    @GET
    @Path("{id}")
    public Tarefa get(@PathParam("id") Long id) {
        Tarefa tarefa = Tarefa.findById(id);
        if (tarefa == null) {
            throw new NotFoundException("Tarefa não encontrada");
        }
        return tarefa;
    }

    @POST
    @Transactional
    public Response create(Tarefa tarefa) {
        tarefa.persist();
        return Response.status(Response.Status.CREATED).entity(tarefa).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefa = Tarefa.findById(id);
        if (tarefa == null) {
            throw new NotFoundException("Tarefa não encontrada");
        }

        tarefa.titulo = tarefaAtualizada.titulo;
        tarefa.descricao = tarefaAtualizada.descricao;
        tarefa.prazo = tarefaAtualizada.prazo;
        tarefa.departamento = tarefaAtualizada.departamento;
        tarefa.duracao = tarefaAtualizada.duracao;
        tarefa.finalizada = tarefaAtualizada.finalizada;
        tarefa.pessoa = tarefaAtualizada.pessoa;

        tarefa.persist();
        return Response.ok(tarefa).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = Tarefa.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Tarefa não encontrada");
        }
        return Response.noContent().build();
    }


    @PUT
    @Path("/alocar/{idTarefa}")
    @Transactional
    public Response alocarPessoaNaTarefa(@PathParam("idTarefa") Long idTarefa, Pessoa pessoaEntrada) {
        Tarefa tarefa = Tarefa.findById(idTarefa);
        if (tarefa == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Tarefa não encontrada").build();
        }

        Pessoa pessoa = Pessoa.findById(pessoaEntrada.id);
        if (pessoa == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Pessoa não encontrada").build();
        }

        if (!tarefa.departamento.equalsIgnoreCase(pessoa.departamento)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Departamento da pessoa não corresponde ao da tarefa").build();
        }

        tarefa.pessoa = pessoa;
        tarefa.persist();

        return Response.ok(tarefa).build();
    }

    @PUT
    @Path("/finalizar/{id}")
    @Transactional
    public Response finalizarTarefa(@PathParam("id") Long id) {
        Tarefa tarefa = Tarefa.findById(id);
        if (tarefa == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Tarefa não encontrada").build();
        }

        tarefa.finalizada = true;
        tarefa.persist();

        return Response.ok(tarefa).build();
    }

}
