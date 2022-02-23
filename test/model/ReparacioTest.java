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
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        String expResult = "r108";
        String result = instance.getCodi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCodi method, of class Reparacio.
     */
    @Test
    public void testSetCodi() {
        System.out.println("setCodi");
        String codi = "r108";
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        String setCodi = "r115";
        instance.setCodi(setCodi);
        String expResult = "r115";
        String result = instance.getCodi();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataInici method, of class Reparacio.
     */
    @Test
    public void testGetDataInici() {
        System.out.println("getDataInici");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        String expResult = "2022/03/31";
        String result = instance.getDataInici();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataInici method, of class Reparacio.
     */
    @Test
    public void testSetDataInici() {
        System.out.println("setDataInici");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        String setDataInici = "2022/04/01";
        instance.setDataInici(setDataInici);
        String expResult = "2022/04/01";
        String result = instance.getDataInici();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDataFi method, of class Reparacio.
     */
    @Test
    public void testGetDataFi() {
        System.out.println("getDataFi");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        String expResult = "2022/04/04";
        String result = instance.getDataFi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataFi method, of class Reparacio.
     */
    @Test
    public void testSetDataFi() {
        System.out.println("setDataFi");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        String setDataFi = "2022/04/08";
        instance.setDataFi(setDataFi);
        String expResult = "2022/04/08";
        String result = instance.getDataFi();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPreu method, of class Reparacio.
     */
    @Test
    public void testGetPreu() {
        System.out.println("getPreu");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        instance.setPreu(0.0);
        double expResult = 0.0;
        double result = instance.getPreu();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPreu method, of class Reparacio.
     */
    @Test
    public void testSetPreu() {
        System.out.println("setPreu");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        double setPreu = 475.0;
        instance.setPreu(setPreu);
        double expResult = 475.0;
        double result = instance.getPreu();
    }

    /**
     * Test of getClient method, of class Reparacio.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClient method, of class Reparacio.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        String codi = "r108"; 
        String dataInici = "2022/03/31";
        String dataFi = "2022/04/04";
        Reparacio instance = new Reparacio(codi, dataInici, dataFi);
        Client client = null;
        instance.setClient(client);
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
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

    
}
