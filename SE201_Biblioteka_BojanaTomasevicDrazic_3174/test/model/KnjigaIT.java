/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bojana
 */
public class KnjigaIT {
    
    public KnjigaIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Knjiga.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Knjiga instance = new Knjiga();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrojPrimeraka method, of class Knjiga.
     */
    @Test
    public void testGetBrojPrimeraka() {
        System.out.println("getBrojPrimeraka");
        Knjiga instance = new Knjiga();
        int expResult = 0;
        int result = instance.getBrojPrimeraka();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBrojPrimeraka method, of class Knjiga.
     */
    @Test
    public void testSetBrojPrimeraka() {
        System.out.println("setBrojPrimeraka");
        int brojPrimeraka = 0;
        Knjiga instance = new Knjiga();
        instance.setBrojPrimeraka(brojPrimeraka);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Knjiga.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Knjiga instance = new Knjiga();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNaziv method, of class Knjiga.
     */
    @Test
    public void testGetNaziv() {
        System.out.println("getNaziv");
        Knjiga instance = new Knjiga();
        String expResult = "";
        String result = instance.getNaziv();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNaziv method, of class Knjiga.
     */
    @Test
    public void testSetNaziv() {
        System.out.println("setNaziv");
        String naziv = "";
        Knjiga instance = new Knjiga();
        instance.setNaziv(naziv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutor method, of class Knjiga.
     */
    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        Knjiga instance = new Knjiga();
        String expResult = "";
        String result = instance.getAutor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutor method, of class Knjiga.
     */
    @Test
    public void testSetAutor() {
        System.out.println("setAutor");
        String autor = "";
        Knjiga instance = new Knjiga();
        instance.setAutor(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIzdavac method, of class Knjiga.
     */
    @Test
    public void testGetIzdavac() {
        System.out.println("getIzdavac");
        Knjiga instance = new Knjiga();
        String expResult = "";
        String result = instance.getIzdavac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIzdavac method, of class Knjiga.
     */
    @Test
    public void testSetIzdavac() {
        System.out.println("setIzdavac");
        String izdavac = "";
        Knjiga instance = new Knjiga();
        instance.setIzdavac(izdavac);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGodinaIzdanja method, of class Knjiga.
     */
    @Test
    public void testGetGodinaIzdanja() {
        System.out.println("getGodinaIzdanja");
        Knjiga instance = new Knjiga();
        int expResult = 0;
        int result = instance.getGodinaIzdanja();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGodinaIzdanja method, of class Knjiga.
     */
    @Test
    public void testSetGodinaIzdanja() {
        System.out.println("setGodinaIzdanja");
        int godinaIzdanja = 0;
        Knjiga instance = new Knjiga();
        instance.setGodinaIzdanja(godinaIzdanja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Knjiga.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Knjiga instance = new Knjiga();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
