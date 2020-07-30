package com.wh136.xyz.neo4j.service;

import com.wh136.xyz.neo4j.config.SocialNetworkLabel;
import com.wh136.xyz.neo4j.config.SocialNetworkType;
import com.wh136.xyz.neo4j.repository.PersonRepository;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 在这个社交网络里，有用户节点、电影节点、介绍关系、朋友关系、看过这部电影的关系，
 * 以及可以根据电影喜欢程度为它们打1~5分。这是个很常见的Neo4j入门图
 * */
@Service
public class Neo4jMgrImpl implements Neo4jMgr {
    private static final Logger logger = LoggerFactory.getLogger((Neo4jMgrImpl.class));

    @Resource(name = "personRepository")
    PersonRepository personRepository;



    @Override
    public PersonRepository getPersonRepository() {
        return personRepository;
    }
}
