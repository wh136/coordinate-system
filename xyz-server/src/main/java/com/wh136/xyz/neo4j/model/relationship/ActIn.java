package com.wh136.xyz.neo4j.model.relationship;

import com.wh136.xyz.neo4j.model.node.Movie;
import com.wh136.xyz.neo4j.model.node.Person;
import lombok.Data;
import org.neo4j.ogm.annotation.*;


@RelationshipEntity(type = "ACTED_IN")
@Data
public class ActIn {
    @GraphId
    private Long id;

    @Property
    private String role;

    @StartNode
    private Person person;

    @EndNode
    private Movie movie;
}
