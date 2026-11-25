package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.web.dto.ReservationRequest;
import tn.esprit.autolocapi.web.dto.ReservationResponse;

@Component
public class ReservationMapper {

    // The vehicule and client relations are set by the service.
    public Reservation toEntity(ReservationRequest request) {
        Reservation reservation = new Reservation();
        updateEntity(reservation, request);
        return reservation;
    }

    public void updateEntity(Reservation reservation, ReservationRequest request) {
        reservation.setDateDebut(request.dateDebut());
        reservation.setDateFin(request.dateFin());
        reservation.setStatut(request.statut());
    }

    public ReservationResponse toResponse(Reservation reservation) {
        return new ReservationResponse(
                reservation.getIdReservation(),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                reservation.getStatut(),
                reservation.getVehicule().getIdVehicule(),
                reservation.getClient().getIdClient());
    }
}
