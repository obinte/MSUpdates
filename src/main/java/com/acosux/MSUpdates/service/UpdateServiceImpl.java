/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acosux.MSUpdates.service;

import com.acosux.MSUpdates.dao.UpdateDao;
import com.acosux.MSUpdates.util.Issues;
import com.acosux.MSUpdates.util.IssuesResponse;
import com.acosux.MSUpdates.util.JiraTask;
import com.acosux.MSUpdates.util.UpdateTO;
import com.acosux.MSUpdates.util.VersionTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;

/**
 * @author Trabajo
 */
@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateDao actualizacionDao;

    @Override
    public List<UpdateTO> buscarActualizacionesPorVersion(String version) throws Exception {
        return actualizacionDao.buscarActualizacionesPorVersion(version);
    }

    @Override
    public List<VersionTO> listarVersiones() throws Exception {
        return actualizacionDao.listarVersiones();
    }

    @Override
    public List<Issues> listarTareas() throws Exception {
        try {
            /*
            customfield_10057 = Desarrollador
            customfield_10074 = Variable de calculos   // Incluye si es servidor web, etc etc
            customfield_10059 == Fecha fin programación
            customfield_10060 == Fecha fin revision
            customfield_10055 == Modulo
            customfield_10056 == Objetivo de la tarea
            customfield_10016 == Story  POint
            customfield_10075 == Esfuerzo 
            customfield_10076 == conocimiento
            customfield_10075 == Esfuerzo 
            customfield_10076 == conocimiento
            
             */
            HttpResponse<JsonNode> response = Unirest.get("https://obinte.atlassian.net/rest/api/3/search?").basicAuth(
                    "jtabango@obinte.com",
                    "ATATT3xFfGF0OroeCTSRDEvN5Rr6yyHunt-pnGmU83lyaVXs5Y3mkkJxLfbWVvNuPZlzeEXmxB7xCLwCx0sDtI6xqkItFl49TvpcqQvCzDBvX1a2PuHWjkJIVO9wcL-Z--k9K6TTFdBjA5CDtLq-oHDzCMCf-MQ_0_9G5fLdpGbmaXpE7WYEACY=66794C5C")
                    .header("Accept", "application/json")
                    .queryString("jql", "project = AR AND assignee = EMPTY AND type IN (Story)")
                    .queryString("fields", "key,summary,customfield_10057,customfield_10015,customfield_10000, customfield_10074,customfield_10059,customfield_10060, customfield_10055, customfield_10056,customfield_10016,customfield_10075,customfield_10076")
                    .asJson();

            JsonNode jsonResponse = response.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            IssuesResponse issuesResponse = objectMapper.readValue(jsonResponse.getObject().toString(), IssuesResponse.class);
            return issuesResponse.getIssues();
        } catch (JsonProcessingException | UnirestException e) {
            System.out.println("Error al conectarse a JIRA: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizarTarea(String key, String fields) throws Exception {
        try {
           //   .body("{\"fields\": {\"customfield_10016\": 30, }}") ejemplo de como debe ir el body
            HttpResponse<JsonNode> response = Unirest.put("https://obinte.atlassian.net/rest/api/3/issue/{issueKey}")
                    .basicAuth(
                            "jtabango@obinte.com",
                            "ATATT3xFfGF0OroeCTSRDEvN5Rr6yyHunt-pnGmU83lyaVXs5Y3mkkJxLfbWVvNuPZlzeEXmxB7xCLwCx0sDtI6xqkItFl49TvpcqQvCzDBvX1a2PuHWjkJIVO9wcL-Z--k9K6TTFdBjA5CDtLq-oHDzCMCf-MQ_0_9G5fLdpGbmaXpE7WYEACY=66794C5C")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .routeParam("issueKey",key )
                    .body("{fields : {"+fields+"}}")
                    .asJson();
            System.out.print(response.getBody().toString());
        } catch (UnirestException e) {
            System.out.println("Error al conectarse a JIRA: " + e.getMessage());
        }
    }

}
