package sk.fri.uniza.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sk.fri.uniza.db.IotNodeDAO;
import sk.fri.uniza.model.IotNode;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/IotNode") // Swagger
@Path("/IotNode") // Koreňová adresa kolekcie koncových bodov
// pre prístup k zdrojom domácností // Súčasť JAX-RS
@Produces(MediaType.APPLICATION_JSON)// Výstupné dáta sú vo forme JSON //JAX-RS
@Consumes(MediaType.APPLICATION_JSON) //Vstupné dáta sú vo forme JSON //JAX-RS
public class IoTNodeResource {

    private IotNodeDAO iotNodeDAO;

    public IoTNodeResource(IotNodeDAO iotNodeDAO) {
        this.iotNodeDAO = iotNodeDAO;
    }


    @POST // JAX-RS
    @UnitOfWork //Otvorí novú hibernate session //Dropwizzard
    @ApiOperation(value = "Pridá nové dáta") // Swagger
    public IotNode createIotNode(IotNode iotNode) {

        return iotNodeDAO.create(iotNode);
    }

    @PUT /*JAX-RS*/
    @UnitOfWork //Otvorí novú hibernate session // Dropwizard
    @ApiOperation(value = "Úprava existujúcej domácnosti")
    public IotNode updateIotNode(IotNode iotNode) {

        return iotNodeDAO.update(iotNode);
    }

    @GET // JAX-RS
    @Path("id") // JAX-RS
    @UnitOfWork //Otvorí novú hibernate session // Dropwizzard
    @ApiOperation(value = "Získanie dát o konkrétnej domácnosti a konkrétneho" +
            " typu") // Swagger
    public IotNode findIotNode(Long id) {

        return iotNodeDAO.findById(id);
    }

    @GET // JAX-RS
    @UnitOfWork //Otvorí novú hibernate session // Dropwizzard
    @ApiOperation(value = "Získanie dát o konkrétnej domácnosti a konkrétneho" +
            " typu") // Swagger
    public List<IotNode> allIotNodes() {

        return iotNodeDAO.allIotNodes();
    }

}
