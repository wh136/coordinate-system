package com.wh136.xyz.neo4j.service;

import com.wh136.xyz.neo4j.repository.PersonRepository;

public interface Neo4jMgr {

    PersonRepository getPersonRepository();
}
