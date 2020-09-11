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
public class ReleaseTeam implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String department;
    private String name;
    private String updated_by;
    private String updated_when;
}
