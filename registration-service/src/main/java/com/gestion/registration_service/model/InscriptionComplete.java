package com.gestion.registration_service.model;

public class InscriptionComplete {
    private Inscription inscription;
    private EventBean event;

    public InscriptionComplete(Inscription inscription, EventBean event) {
        this.inscription = inscription;
        this.event = event;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public EventBean getEvent() {
        return event;
    }
}