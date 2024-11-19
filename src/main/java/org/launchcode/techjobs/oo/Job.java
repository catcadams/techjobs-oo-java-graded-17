package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job= (Job) o;
        return getId() == job.getId();
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        ArrayList<JobField> jobDetails = new ArrayList<>();

        int id = this.getId();
        String name = this.getName();
        Employer employer = this.getEmployer();
        Location location = this.getLocation();
        PositionType positionType = this.getPositionType();
        CoreCompetency coreCompetency = this.getCoreCompetency();

        jobDetails.add(employer);
        jobDetails.add(location);
        jobDetails.add(positionType);
        jobDetails.add(coreCompetency);

        for (JobField details : jobDetails) {
            if (details.toString().isEmpty()) {
                details.setValue("Data not available");
            }
        }

        if (name.isEmpty()) {
            this.setName("Data not available");
        }

        if (name.isEmpty() && employer.toString().isEmpty() && location.toString().isEmpty() && positionType.toString().isEmpty()
        && coreCompetency.toString().isEmpty()) {
            return "OOPS! This job does not seem to exist.";
        }

        return System.lineSeparator()+"ID: " + id + System.lineSeparator() + "Name: " + name +System.lineSeparator() +
                "Employer: " + employer + System.lineSeparator() + "Location: " + location + System.lineSeparator() +
                "Position Type: " + positionType + System.lineSeparator() + "Core Competency: " + coreCompetency
                + System.lineSeparator();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
