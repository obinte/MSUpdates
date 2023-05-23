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
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
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
            
            customfield_10074 = Variable de calculos   // Incluye si es servidor web, etc etc
            Esfuerzo
            conocimiento
            */
            HttpResponse<JsonNode> response = Unirest.get("https://obinte.atlassian.net/rest/api/3/search?").basicAuth("jtabango@obinte.com",
                    "ATATT3xFfGF0ys5q6N7kVEpeI7fBBGh87PHxeCducoisEp6n4aXtrX3-HpSBPtdnD_XSDockCcZadzq6AnHj0Xqt8ECEFOHkW9YqSgmE1xr1yK32Tz8MRh06rgfXC6doAfYv-amCDk1jAjggx7Y6Y9SpBGbl0zzyuv22j4Wz1cfHLiKZ9iZ5w0E=E0589FEC")
                    .header("Accept", "application/json")
                    .queryString("jql", "project = AR AND assignee = EMPTY AND type IN (Task,Story) ")
                    .queryString("fields", "key,summary,customfield_10015,customfield_10000, customfield_10074")
                    .asJson();
            JsonNode jsonResponse = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            IssuesResponse issuesResponse = objectMapper.readValue(jsonResponse.getObject().toString(), IssuesResponse.class);
            return issuesResponse.getIssues();
        } catch (Exception e) {
            System.out.println("Error al conectarse a JIRA: " + e.getMessage());
        }
        return null;
    }

}
