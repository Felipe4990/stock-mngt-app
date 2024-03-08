package br.com.univesp.pi.application.domain.model;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Money {
    public Integer value;
    public Integer decimals;
    public String type;
    public String signal;
}
