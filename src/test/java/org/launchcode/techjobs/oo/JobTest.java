package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job1.getName() );
        assertEquals("ACME", job1.getEmployer().toString());
        assertEquals("Desert", job1.getLocation().toString());
        assertEquals("Quality control", job1.getPositionType().toString());
        assertEquals("Persistence", job1.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.toString().startsWith(System.lineSeparator()));
        assertTrue(job1.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(System.lineSeparator() + "ID: "+ job1.getId() + System.lineSeparator() +"Name: Product tester"
                + System.lineSeparator()+ "Employer: ACME" + System.lineSeparator()+ "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() + "Core Competency: Persistence" +
                System.lineSeparator(), job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency(""));

        assertEquals(System.lineSeparator() + "ID: "+ job1.getId() + System.lineSeparator() +"Name: Product tester"
                + System.lineSeparator()+ "Employer: ACME" + System.lineSeparator()+ "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality control" + System.lineSeparator() + "Core Competency: Data not available" +
                System.lineSeparator(), job1.toString());
    }
}
