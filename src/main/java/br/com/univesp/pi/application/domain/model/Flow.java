package br.com.univesp.pi.application.domain.model;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Flow {

    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date timestamp;
    public Money balance;
}
