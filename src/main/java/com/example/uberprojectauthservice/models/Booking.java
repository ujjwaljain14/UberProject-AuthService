package com.example.uberprojectauthservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{

        @Enumerated(value = EnumType.STRING)
        private BookingStatus bookingStatus;

        @Temporal(TemporalType.TIMESTAMP)
        private Date startTime;

        @Temporal(TemporalType.TIMESTAMP)
        private Date endTime;

        private  Long totalDistance;

        @ManyToOne(fetch = FetchType.LAZY)
        private Driver driver;

        @ManyToOne(fetch = FetchType.LAZY)
        private Passenger passenger;

}
