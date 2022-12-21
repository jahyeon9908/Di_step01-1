package com.mono.di.entity;

import com.mono.di.ui.Printer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Personinfo {
    private Printer printer;
    private List<String> names;
    private List<Person> persons;
    private Map<String, Integer> ages;
    private Set<String> emails;

    public Personinfo() {
    }

    public Personinfo(Printer printer, List<String> names, List<Person> persons, Map<String, Integer> ages, Set<String> emails) {
        this.printer = printer;
        this.names = names;
        this.persons = persons;
        this.ages = ages;
        this.emails = emails;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Map<String, Integer> getAges() {
        return ages;
    }

    public void setAges(Map<String, Integer> ages) {
        this.ages = ages;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public void print(String s) {
        printer.print(s);
    }

    @Override
    public String toString() {
        return "Personinfo{" +
                "printer=" + printer +
                ", names=" + names +
                ", persons=" + persons +
                ", ages=" + ages +
                ", emails=" + emails +
                '}';
    }
}
