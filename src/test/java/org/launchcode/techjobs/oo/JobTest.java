package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Mad Hatter", new Employer("Self-employed"), new Location("Wonderland"), new PositionType("Crazy maker"), new CoreCompetency("Dexterity"));
        String output = System.lineSeparator() + System.lineSeparator();
        assertEquals(output, System.lineSeparator() + System.lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Mad Hatter", new Employer("Self-employed"), new Location("Wonderland"), new PositionType("Crazy maker"), new CoreCompetency("Dexterity"));
        String output = "ID: " + testJob.getId() + System.lineSeparator() + "Name: " + testJob.getName() + System.lineSeparator() + "Employer: " + testJob.getEmployer().getValue() + System.lineSeparator() + "Location: " + testJob.getLocation().getValue() + System.lineSeparator() + "Position Type: " + testJob.getPositionType().getValue() + System.lineSeparator() + "Core Competency: " + testJob.getCoreCompetency().getValue();
        assertEquals(output,"ID: " + testJob.getId() + System.lineSeparator() + "Name: " + testJob.getName() + System.lineSeparator() + "Employer: " + testJob.getEmployer().getValue() + System.lineSeparator() + "Location: " + testJob.getLocation().getValue() + System.lineSeparator() + "Position Type: " + testJob.getPositionType().getValue() + System.lineSeparator() + "Core Competency: " + testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Mad Hatter",new Employer(""), new Location("Wonderland"), new PositionType("Crazy maker"), new CoreCompetency("Dexterity"));
        String errorMsg = "Data not available";
        String output = System.lineSeparator() + "ID: " + testJob.getId() + System.lineSeparator() + "Name: " + testJob.getName() + System.lineSeparator() + "Employer: " + errorMsg + System.lineSeparator() + "Location: " + testJob.getLocation().getValue() + System.lineSeparator() + "Position Type: " + testJob.getPositionType().getValue() + System.lineSeparator() + "Core Competency: " + testJob.getCoreCompetency().getValue() + System.lineSeparator();
        assertEquals(output, testJob.toString());
    }

}
