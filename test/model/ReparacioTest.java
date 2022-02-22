/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author jtech
 */
public class ReparacioTest {
    
    public ReparacioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
            System.out.println("* UtilsJUnit4Test: @BeforeClass method");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* UtilsJUnit4Test: @AfterClass method");
    }

    /**
     * Test of getCodi method, of class Reparacio.
     */
    @Test
    public void testGetCodi() {
        System.out.println("getCodi");
        String codi = "g1"; 
        String dataInici = "1";
        String dataFi = "31";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        String expResult = "g1";
        String result = instance.getCodi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCodi method, of class Reparacio.
     */
    @Test
    public void testSetCodi() {
        System.out.println("setCodi");
        String codi = "s1";
        String newCodi = "new1";
        String dataInici = "1";
        String dataFi = "31";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        instance.setCodi(newCodi);
        String result = instance.getCodi();
        assertEquals("new1", result);
    }

    /**
     * Test of getDataInici method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testGetDataInici() {
        System.out.println("getDataInici");
        Reparacio instance = null;
        String expResult = "";
        String result = instance.getDataInici();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataInici method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testSetDataInici() {
        System.out.println("setDataInici");
        String dataInici = "";
        Reparacio instance = null;
        instance.setDataInici(dataInici);
    }

    /**
     * Test of getDataFi method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testGetDataFi() {
        System.out.println("getDataFi");
        Reparacio instance = null;
        String expResult = "";
        String result = instance.getDataFi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataFi method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testSetDataFi() {
        System.out.println("setDataFi");
        String dataFi = "";
        Reparacio instance = null;
        instance.setDataFi(dataFi);
    }

    /**
     * Test of getPreu method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testGetPreu() {
        System.out.println("getPreu");
        Reparacio instance = null;
        double expResult = 0.0;
        double result = instance.getPreu();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPreu method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testSetPreu() {
        System.out.println("setPreu");
        double preu = 0.0;
        Reparacio instance = null;
        instance.setPreu(preu);
    }

    /**
     * Test of getClient method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        Reparacio instance = null;
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClient method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client client = null;
        Reparacio instance = null;
        instance.setClient(client);
    }

    /**
     * Test of getElements method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testGetElements() {
        System.out.println("getElements");
        Reparacio instance = null;
        Map<String, ArrayList> expResult = null;
        Map<String, ArrayList> result = instance.getElements();
        assertEquals(expResult, result);
    }

    /**
     * Test of setElements method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testSetElements() {
        System.out.println("setElements");
        Map<String, ArrayList> elements = null;
        Reparacio instance = null;
        instance.setElements(elements);
    }

    /**
     * Test of addReparacio method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testAddReparacio() {
        System.out.println("addReparacio");
        Reparacio expResult = null;
        Reparacio result = Reparacio.addReparacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateComponent method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testUpdateComponent() {
        System.out.println("updateComponent");
        Reparacio instance = null;
        instance.updateComponent();
    }

    /**
     * Test of addMecanic method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testAddMecanic() throws Exception {
        System.out.println("addMecanic");
        Mecanic mecanic = null;
        Reparacio instance = null;
        instance.addMecanic(mecanic);
    }

    /**
     * Test of addRecanvi method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testAddRecanvi() throws Exception {
        System.out.println("addRecanvi");
        Recanvi recanvi = null;
        Reparacio instance = null;
        instance.addRecanvi(recanvi);
    }

    /**
     * Test of addPreu method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testAddPreu() {
        System.out.println("addPreu");
        int totalHores = 0;
        Reparacio instance = null;
        instance.addPreu(totalHores);
    }

    /**
     * Test of showComponent method, of class Reparacio.
     */
    @Ignore
    @Test
    public void testShowComponent() {
        System.out.println("showComponent");
        Reparacio instance = null;
        instance.showComponent();
    }
    
}
