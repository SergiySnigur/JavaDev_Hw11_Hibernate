
package homework;

import homework.entities.client.Client;
import homework.entities.client.ClientCrudService;
import homework.entities.planet.Planet;
import homework.entities.planet.PlanetCrudService;
import homework.entities.ticket.Ticket;
import homework.entities.ticket.TicketCrudService;
import homework.utils.database.DatabaseInitService;


public class App {

    public static void main(String[] args) {
        new DatabaseInitService().initDb();

        Client newClient = new Client();
        Planet toPlanet = new Planet();
        Planet fromPlanet = new Planet();
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

//        newClient.setName("Olena");
//        clientCrudService.createClient(newClient);

//        toPlanet.setId("KEP");
//        toPlanet.setName("Kepler");
//        planetCrudService.createPlanet(toPlanet);

//        fromPlanet.setId("GJ");
//        fromPlanet.setName("1214b");
//        planetCrudService.createPlanet(fromPlanet);

//        clientCrudService.updateClientById(12, "Zarina");
//        System.out.println(planetCrudService.getAllPlanets().toString());
//        System.out.println(clientCrudService.getAllClients().toString());


//        ticketCrudService.createTicket(clientCrudService.getClientById(12),
//                planetCrudService.getPlanetById("KEP"),
//                planetCrudService.getPlanetById("GJ"));
        System.out.println(ticketCrudService.getAllTickets().toString());

//        ticketCrudService.deleteTicketById(11);


    }
}
