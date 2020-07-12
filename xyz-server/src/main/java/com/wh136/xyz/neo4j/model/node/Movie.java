package com.wh136.xyz.neo4j.model.node;

import com.wh136.xyz.neo4j.model.relationship.ActIn;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * 节点的属性可以再添加
 * */

@NodeEntity(label = "Movie")
@Data
public class Movie {
    @GraphId
    private Long id;

    @Property
    private int released;

    @Property
    private String tagline;

    @Property
    private String title;

    @Relationship(direction = Relationship.INCOMING, type = "ACTED_IN")
    private Set<ActIn> actIns;

}
