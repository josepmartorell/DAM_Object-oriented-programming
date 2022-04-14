package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Client;
import model.Mecanic;
import model.Recanvi;
import model.Reparacio;
import model.Taller;
import model.Vehicle;
import principal.Component;
import principal.GestorTallerMecanicException;

/**
 *
 * @author jtech
 */
public class GestorMySQL implements ProveedorPersistencia {

    private Taller taller;

    private Connection conn; //Connexió a la base de dades

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    /*
     PreparedStatement necessaris
     */

 /*
     * TODO
     *
     * Obtenir un taller
     * 
     * Sentència select de la taula tallers
     * Columnes: totes
     * Files: la del taller el CIF del qual coincideixi amb el passat per paràmetre
     *
     */
    private static String codiTallerSQL = "SELECT * FROM tallers b WHERE b.cif = ?";

    private PreparedStatement codiTallerSt;

    /*
     * TODO
     *
     * Afegir un taller
     * 
     * Sentència per afegir un taller en la taula tallers
     * Els valors dels camps són els que es passaran per paràmetre
     *
     */
    private static String insereixTallerSQL = "INSERT INTO tallers(cif, nom, adreca) VALUES (?, ?, ?)";

    private PreparedStatement insereixTallerSt;

    /*
     * TODO
     *
     * Actualitzar un taller
     * 
     * Sentència per actualitzar un taller de la taula tallers
     * Files a actualitzar: la que corresponguin al CIF passat per paràmetre
     * Columnes a actualitzar: nom i adreca amb els altres valors passats per paràmetre
     *
     */
    private static String actualitzaTallerSQL = " UPDATE tallers SET nom=?, adreca = ? WHERE cif = ? ";

    private PreparedStatement actualitzaTallerSt;

    /*
     * TODO
     *
     * Eliminar recanvis (donat el codi d'un taller)
     * 
     * Sentència que elimina els recanvis de la taula recanvis relacionats amb un taller
     * Files a eliminar: les que es corresponguin al CIF del taller passat per paràmetre
     *
     */
    private static String eliminaRecanviSQL = " DELETE FROM recanvis WHERE taller = ?";

    private PreparedStatement eliminaRecanviSt;
    
    
    private static String eliminaClientSQL = " DELETE FROM clients WHERE taller = ?";

    private PreparedStatement eliminaClientSt;
    
    
    private static String eliminaMecanicSQL = " DELETE FROM mecanics WHERE taller = ?";

    private PreparedStatement eliminaMecanicSt;
    
    
    private static String eliminaVehicleSQL = " DELETE FROM vehicles WHERE taller = ?";

    private PreparedStatement eliminaVehicleSt;
    
    
    private static String eliminaReparacioSQL = " DELETE FROM reparacions WHERE taller = ?";
    
    private PreparedStatement eliminaReparacioSt;

    /*
     * TODO
     *
     * Afegir un recanvi
     * 
     * Sentència que afegix un recanvi a la taula de recanvis
     * Els valors dels camps són els que es passaran per paràmetre
     *
     */
    private static String insereixRecanviSQL = "INSERT INTO recanvis(codi, nom, fabricant, preu, taller) VALUES (?, ?, ?, ?, ?)";

    private PreparedStatement insereixRecanviSt;
    
    
    private static String insereixClientSQL = "INSERT INTO clients(nif, nom, telefon, correu, taller) VALUES (?, ?, ?, ?, ?)";

    private PreparedStatement insereixClientSt;
    
    
    private static String insereixMecanicSQL = "INSERT INTO mecanics(nif, nom, telefon, correu, taller) VALUES (?, ?, ?, ?, ?)";

    private PreparedStatement insereixMecanicSt;
    
    
    private static String insereixVehicleSQL = "INSERT INTO vehicles(matricula, marca, model, color, taller) VALUES (?, ?, ?, ?, ?)";

    private PreparedStatement insereixVehicleSt;
    
    
    private static String insereixReparacioSQL = "INSERT INTO reparacions(codi, dataInici, dataFi, taller) VALUES (?, ?, ?, ?)";
    
    private PreparedStatement insereixReparacioSt;


    /*
     * TODO
     *
     * Seleccionar els recanvis d'un taller
     * 
     * Sentència que selecciona els recanvis de la taula recanvis d'un taller determinat
     * Columnes: totes
     * Files: totes les que el CIF del taller coincideixi amb el passat per paràmetre
     *
     */
    private static String selRecanvisSQL = " SELECT * FROM recanvis WHERE taller = ?";

    private PreparedStatement selRecanvisSt;
    
    
    private static String selClientsSQL = " SELECT * FROM clients WHERE taller = ?";

    private PreparedStatement selClientsSt;
    
    
    private static String selMecanicsSQL = " SELECT * FROM mecanics WHERE taller = ?";

    private PreparedStatement selMecanicsSt;
    
    
    private static String selVehiclesSQL = " SELECT * FROM vehicles WHERE taller = ?";

    private PreparedStatement selVehiclesSt;
    
   
    private static String selReparacioSQL = " SELECT * FROM reparacions WHERE taller = ?";
    
    private PreparedStatement selReparacioSt;

    /*
     *TODO
     * 
     *Paràmetres: cap
     *
     *Acció:
     *  - Heu d'establir la connexio JDBC amb la base de dades EAC112122S1
     *  - Heu de crear els objectes PrepareStatement declarats com a atributs d'aquesta classe
     *    amb els respectius SQL declarats com a atributs just sobre cadascun d'ells.
     *  - Heu de fer el catch de les possibles excepcions (en aquest mètode no llançarem GestorTallerMecanicException,
     *    simplement, mostreu el missatge a consola de l'excepció capturada)
     *
     *Retorn: cap
     *
     */
    public void estableixConnexio() throws SQLException {
        String urlBaseDades = "jdbc:mysql://localhost:3306/EAC112122S1";
        String usuari = "root";
        String contrasenya = "root123";

        try {
            conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
            codiTallerSt = conn.prepareStatement(codiTallerSQL);
            insereixTallerSt = conn.prepareStatement(insereixTallerSQL);
            actualitzaTallerSt = conn.prepareStatement(actualitzaTallerSQL);
            eliminaRecanviSt = conn.prepareStatement(eliminaRecanviSQL);
            eliminaClientSt = conn.prepareStatement(eliminaClientSQL);
            eliminaMecanicSt = conn.prepareStatement(eliminaMecanicSQL);
            eliminaVehicleSt = conn.prepareStatement(eliminaVehicleSQL);
            eliminaReparacioSt = conn.prepareStatement(eliminaReparacioSQL);
            insereixRecanviSt = conn.prepareStatement(insereixRecanviSQL);
            insereixClientSt = conn.prepareStatement(insereixClientSQL);
            insereixMecanicSt = conn.prepareStatement(insereixMecanicSQL);
            insereixVehicleSt = conn.prepareStatement(insereixVehicleSQL);
            insereixReparacioSt = conn.prepareStatement(insereixReparacioSQL);
            selRecanvisSt = conn.prepareStatement(selRecanvisSQL);
            selClientsSt = conn.prepareStatement(selClientsSQL);
            selMecanicsSt = conn.prepareStatement(selMecanicsSQL);
            selVehiclesSt = conn.prepareStatement(selVehiclesSQL);
            selReparacioSt = conn.prepareStatement(selReparacioSQL);
        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void tancaConnexio() throws SQLException {
        try {
            conn.close();
        } finally {
            conn = null;
        }
    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer i el taller a desar
     *
     *Acció:
     *  - Heu de desar el taller sobre la base de dades:
     *      - El taller s'ha de desar a la taula tallers (nomFitxer passat per paràmetre és el codi del taller)
     *      - Cada recanvi del taller, s'ha de desar com a registre de la taula recanvis.
     *      - Heu de tenir en compte que si el taller ja existeix, heu de fer el següent:
     *          - Actualitzar el registre taller ja existent
     *          - Eliminar tots els recanvis d'aquest taller de la taula tallers i després inserir els nous com si es tractes
     *            d'un nou taller.
     *  - Si al fer qualsevol operació es produeix una excepció, llavors heu de llançar l'excepció GestorTallerMecanicException amb codi "GestorJDBC.desar"
     *
     *Retorn: cap
     *
     */
    @Override
    public void desarTaller(String nomFitxer, Taller taller) throws GestorTallerMecanicException {

        try {
            if (conn == null) {
                estableixConnexio();
            }

            codiTallerSt.setString(1, taller.getCif());
            ResultSet registresTaller = codiTallerSt.executeQuery();

            if (registresTaller.next()) { //Existeix el taller 

                //Actualitzar taller
                actualitzaTallerSt.setString(3, taller.getCif());
                actualitzaTallerSt.setString(1, taller.getNom());
                actualitzaTallerSt.setString(2, taller.getAdreca());
                actualitzaTallerSt.executeUpdate();

                //Eliminem recanvis
                eliminaRecanviSt.setString(1, taller.getCif());
                eliminaRecanviSt.executeUpdate();
                
                //Eliminem clients
                eliminaClientSt.setString(1, taller.getCif());
                eliminaClientSt.executeUpdate();
                
                //Eliminem mecanics
                eliminaMecanicSt.setString(1, taller.getCif());
                eliminaMecanicSt.executeUpdate();
                
                //Eliminem vehicles
                eliminaVehicleSt.setString(1, taller.getCif());
                eliminaVehicleSt.executeUpdate();
                
                //Eliminem vehicles
                eliminaVehicleSt.setString(1, taller.getCif());
                eliminaVehicleSt.executeUpdate();
                
                //Eliminen reparacions
                eliminaReparacioSt.setString(1, taller.getCif());
                eliminaReparacioSt.executeUpdate();

            } else { //El taller no existeix

                //Actualitzar taller
                insereixTallerSt.setString(1, taller.getCif());
                insereixTallerSt.setString(2, taller.getNom());
                insereixTallerSt.setString(3, taller.getAdreca());
                insereixTallerSt.executeUpdate();
            }

            //Insercio recanvis del taller
            for (Component component : taller.getComponents()) {
                if (component != null && component instanceof Recanvi) {
                    insereixRecanviSt.setString(1, ((Recanvi) component).getCodi());
                    insereixRecanviSt.setString(2, ((Recanvi) component).getNom());
                    insereixRecanviSt.setString(3, ((Recanvi) component).getFabricant());
                    insereixRecanviSt.setDouble(4, ((Recanvi) component).getPreu());
                    insereixRecanviSt.setString(5, taller.getCif());
                    insereixRecanviSt.executeUpdate();
                }
            }
            
            //Insercio clients del taller
            for (Component component : taller.getComponents()) {
                if (component != null && component instanceof Client) {
                    insereixClientSt.setString(1, ((Client) component).getNif());
                    insereixClientSt.setString(2, ((Client) component).getNom());
                    insereixClientSt.setString(3, ((Client) component).getTelefon());
                    insereixClientSt.setString(4, ((Client) component).getCorreu());
                    insereixClientSt.setString(5, taller.getCif());
                    insereixClientSt.executeUpdate();
                }
            }
            
            //Insercio mecanics del taller
            for (Component component : taller.getComponents()) {
                if (component != null && component instanceof Mecanic) {
                    insereixMecanicSt.setString(1, ((Mecanic) component).getNif());
                    insereixMecanicSt.setString(2, ((Mecanic) component).getNom());
                    insereixMecanicSt.setString(3, ((Mecanic) component).getTelefon());
                    insereixMecanicSt.setString(4, ((Mecanic) component).getCorreu());
                    insereixMecanicSt.setString(5, taller.getCif());
                    insereixMecanicSt.executeUpdate();
                }
            }
            
            //Insercio vehicles del taller
            for (Component component : taller.getComponents()) {
                if (component != null && component instanceof Vehicle) {
                    insereixVehicleSt.setString(1, ((Vehicle) component).getMatricula());
                    insereixVehicleSt.setString(2, ((Vehicle) component).getMarca());
                    insereixVehicleSt.setString(3, ((Vehicle) component).getModel());
                    insereixVehicleSt.setString(4, ((Vehicle) component).getColor());
                    insereixVehicleSt.setString(5, taller.getCif());
                    insereixVehicleSt.executeUpdate();
                }
            }
            
            //Insercio reparacions del taller
            for (Component component: taller.getComponents()){
                if (component != null && component instanceof Reparacio){
                    insereixReparacioSt.setString(1, ((Reparacio) component).getCodi());
                    insereixReparacioSt.setString(2, ((Reparacio) component).getDataInici());
                    insereixReparacioSt.setString(3, ((Reparacio) component).getDataFi());
                    insereixReparacioSt.setString(4, taller.getCif());
                    insereixReparacioSt.executeUpdate();
                }
            }

            tancaConnexio();

        } catch (SQLException ex) {
            throw new GestorTallerMecanicException("GestorJDBC.desar");
        }

    }

    /*
     *TODO
     * 
     *Paràmetres: el nom del fitxer del taller
     *
     *Acció:
     *  - Heu de carregar el taller des de la base de dades (nomFitxer passat per paràmetre és el codi del taller)
     *  - Per fer això, heu de cercar el registre taller de la taula amb CIF = nomFitxer
     *  - A més, heu d'afegir els recanvis al taller a partir de la taula recanvis
     *  - Si al fer qualsevol operació es dona una excepció, llavors heu de llançar l'excepció GestorTallerMecanicException 
     *    amb codi "GestorJDBC.carregar"
     *  - Si el nomFitxer donat no existeix a la taula tallers (és a dir, el CIF = nomFitxer no existeix), llavors
     *    heu de llançar l'excepció GestorTallerMecanicException amb codi "GestorJDBC.noexist"
     *
     *Retorn: cap
     *
     */
    @Override
    public void carregarTaller(String nomFitxer) throws GestorTallerMecanicException {
        try {

            if (conn == null) {
                estableixConnexio();
            }

            codiTallerSt.setString(1, nomFitxer);
            ResultSet registresTallers = codiTallerSt.executeQuery();

            // Només hi poden haver 0 o 1 resultats
            if (registresTallers.next()) {

                taller = new Taller(registresTallers.getString("cif"), registresTallers.getString("nom"), registresTallers.getString("adreca"));

                //Seleccionem els recanvis de la taula recanvis i els afegim al taller
                selRecanvisSt.setString(1, taller.getCif());

                ResultSet registresRecanvis = selRecanvisSt.executeQuery();

                while (registresRecanvis.next()) {
                    taller.addRecanvi(new Recanvi(registresRecanvis.getString("codi"), registresRecanvis.getString("nom"), registresRecanvis.getString("fabricant"), registresRecanvis.getDouble("preu")));
                }
                
                //Seleccionem els clients de la taula clients i els afegim al taller
                selClientsSt.setString(1, taller.getCif());

                ResultSet registresClients = selClientsSt.executeQuery();

                while (registresClients.next()) {
                    taller.addClient(new Client(registresClients.getString("nif"), registresClients.getString("nom"), registresClients.getString("telefon"), registresClients.getString("correu")));
                }
                
                //Seleccionem els mecanics de la taula mecanics i els afegim al taller
                selMecanicsSt.setString(1, taller.getCif());

                ResultSet registresMecanics = selMecanicsSt.executeQuery();

                while (registresMecanics.next()) {
                    taller.addMecanic(new Mecanic(registresMecanics.getString("nif"), registresMecanics.getString("nom"), registresMecanics.getString("telefon"), registresMecanics.getString("correu")));
                }
                
                //Seleccionem els vehicles de la taula vehicles i els afegim al taller
                selVehiclesSt.setString(1, taller.getCif());

                ResultSet registresVehicles = selVehiclesSt.executeQuery();

                while (registresVehicles.next()) {
                    taller.addVehicle(new Vehicle(registresVehicles.getString("matricula"), registresVehicles.getString("marca"), registresVehicles.getString("model"), registresVehicles.getString("color")));
                }
                
                //Seleccionem les reparacions de la taula reparacions i els afegim al taller
                selReparacioSt.setString(1, taller.getCif());

                ResultSet registresReparacions = selReparacioSt.executeQuery();

                while (registresReparacions.next()) {
                    taller.addReparacio(new Reparacio(registresReparacions.getString("codi"), registresReparacions.getString("dataInici"), registresReparacions.getString("dataFi")));
                }

            } else {
                
                throw new GestorTallerMecanicException("GestorMySQL.noExisteix");
            }
            tancaConnexio();

        } catch (SQLException ex) {
            throw new GestorTallerMecanicException("GestorMySQL.carregar");
        }
    }

}
