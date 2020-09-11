package com.github.dylanz666.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : dylanz
 * @since : 09/11/2020
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lead implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long leadId;
    public String email;
}
