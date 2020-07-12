package com.wh136.xyz.neo4j.service;

import com.wh136.xyz.neo4j.config.SocialNetworkLabel;
import com.wh136.xyz.neo4j.config.SocialNetworkType;
import com.wh136.xyz.neo4j.repository.PersonRepository;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
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

    public void createCypherNodeUse(GraphDatabaseService graphDB) {
        try (Transaction transaction = graphDB.beginTx()) {
            Node userJohn = graphDB.createNode();
            userJohn.setProperty("name", "John Johnson");
            userJohn.setProperty("type","user");
            Node userKate = graphDB.createNode();
            userKate.setProperty("name", "Kate Smith");
            userKate.setProperty("type","user");
            Node userJack = graphDB.createNode();
            userJack.setProperty("name", "Jack Jeffries");
            userJack.setProperty("type","user");
//            Node movieFargo = graphDB.createNode(LabelCity.MOVIE);
//            movieFargo.setProperty("name", "Fargo");
//            movieFargo.setProperty("type","movie");
//            Node movieAlien = graphDB.createNode(LabelCity.MOVIE);
//            movieAlien.setProperty("name", "Alien");
//            movieAlien.setProperty("type","movie");
//            Node movieHeat = graphDB.createNode(SocialNetworkLabel.MOVIE);
//            movieHeat.setProperty("name", "Heat");
//            movieHeat.setProperty("type","movie");
            userJohn.createRelationshipTo(userKate, SocialNetworkType.IS_FRIEND_OF);
            userJohn.createRelationshipTo(userJack, SocialNetworkType.IS_FRIEND_OF);
//            Relationship real1 = userJohn.createRelationshipTo(movieFargo, SocialNetworkType.HAS_SEEN);
//            real1.setProperty("Stars", 5);
//            Relationship real2 = userJack.createRelationshipTo(movieFargo, SocialNetworkType.HAS_SEEN);
//            real2.setProperty("Stars", 4);
//            Relationship real3 = userJack.createRelationshipTo(movieAlien, SocialNetworkType.HAS_SEEN);
//            real3.setProperty("Stars", 5);
//            Relationship real4 = userKate.createRelationshipTo(movieHeat, SocialNetworkType.HAS_SEEN);
//            real4.setProperty("Stars", 3);
            // 提交事务
            transaction.success();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("社交网络初始化完毕！");
        }
    }

    @Override
    public PersonRepository getPersonRepository() {
        return personRepository;
    }
}
