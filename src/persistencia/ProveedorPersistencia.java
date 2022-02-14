package persistencia;

import principal.GestorTallerMecanicException;
import model.Taller;


/**
 *
 * @author jtech
 */
public interface ProveedorPersistencia {
    public void desarTaller(String nomFitxer, Taller taller)throws GestorTallerMecanicException;
    public void carregarTaller(String nomFitxer)throws GestorTallerMecanicException; 
}
