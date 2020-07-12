package com.wh136.xyz.neo4j.controller;


import com.wh136.xyz.neo4j.model.node.Person;
import com.wh136.xyz.neo4j.model.result.PersonMovie;
import com.wh136.xyz.neo4j.repository.PersonRepository;
import com.wh136.xyz.neo4j.service.Neo4jMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PersonController {

    @Resource
    private Neo4jMgr neo4jMgr;

    @RequestMapping(method = RequestMethod.GET, path = "/rest/v1/person")
    public List<PersonMovie> getMoviesByPersonName(@RequestParam String name) {
        return neo4jMgr.getPersonRepository().getPersonMoviesbyName(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rest/v2/person")
    public List<Person> getPersonRels(@RequestParam String name) {
        List<Person> people = neo4jMgr.getPersonRepository().getPersonByName(name);
        return people;
    }

}
