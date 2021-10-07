package com.wildcodeschool.devtechchallenge.controller;

import com.wildcodeschool.devtechchallenge.dto.ArgonauteDto;
import com.wildcodeschool.devtechchallenge.entity.Argonaute;
import com.wildcodeschool.devtechchallenge.service.ArgonauteService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test d'integration sur les apis de gestion de membres d'equipage
 *
 * @author Nelima BADJENE
 * @since 6/10/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArgonauteITest {

    @Autowired
    private ArgonauteService argonauteService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Before
    public void setUp() {
        baseUrl = "http://localhost:" + port;
    }

    @Test
    public void shouldCreateMember() {
        //given
        ArgonauteDto argonauteDto = new ArgonauteDto();
        argonauteDto.setNom("Kylian Mbappe");

        //when
        HttpEntity<Object> httpEntity = new HttpEntity<>(argonauteDto, new HttpHeaders());
        ResponseEntity<Argonaute> response = restTemplate.exchange(baseUrl + "/api/argonautes",
                HttpMethod.POST, httpEntity, Argonaute.class);

        //then
        Assert.assertNotNull(response);
        Argonaute argonaute = response.getBody();
        Assert.assertNotNull(argonaute);
        Assert.assertEquals(argonauteDto.getNom(), argonaute.getNom());
    }

    @Test
    public void shouldGetAllMembers() {
        //given
        for (int i=0; i<3; i++) {
            Argonaute argonaute = new Argonaute();
            argonaute.setNom("Mbappe" + i);
            argonauteService.create(argonaute);
        }

        //when
        HttpEntity<Object> httpEntity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Argonaute[]> response = restTemplate.exchange(baseUrl + "/api/argonautes",
                HttpMethod.GET, httpEntity, Argonaute[].class);

        //then
        Assert.assertNotNull(response);
        Argonaute[] argonautes = response.getBody();
        Assert.assertNotNull(argonautes);
        Assert.assertEquals(3, argonautes.length);
        Assert.assertEquals("Mbappe0", argonautes[0].getNom());
        Assert.assertEquals("Mbappe1", argonautes[1].getNom());
        Assert.assertEquals("Mbappe2", argonautes[2].getNom());
    }

    @After
    public void tearDown() throws Exception {
        argonauteService.getRepository().deleteAll();
    }
}
