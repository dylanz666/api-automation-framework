package com.github.dylanz666.domain;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author : dylanz
 * @since : 09/14/2020
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "agent_config")
public class AgentConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String _id;
    private JSONObject application;
}
