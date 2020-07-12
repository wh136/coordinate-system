package com.wh136.xyz.neo4j.model.node;

import com.wh136.xyz.neo4j.model.relationship.ActIn;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity(label = "Person")
@Data
public class Person {
    @GraphId
    private Long id;

    @Property
    private int born;

    @Property
    private String name;

    @Relationship(direction = Relationship.OUTGOING, type = "ACTED_IN")
    private Set<ActIn> ActInList;

}
