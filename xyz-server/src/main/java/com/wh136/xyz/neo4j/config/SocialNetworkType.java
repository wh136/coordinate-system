package com.wh136.xyz.neo4j.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.neo4j.graphdb.RelationshipType;

import java.util.Arrays;
import java.util.Objects;


@Getter
@AllArgsConstructor
public enum  SocialNetworkType implements RelationshipType {
    CONTAINED_IN(0),
    IS_FRIEND_OF(1),
    HAS_SEEN(2);
    private int value;

    public static SocialNetworkType findByValue(int value) {
        return Arrays.stream(SocialNetworkType.values()).filter((item) -> Objects.equals(item.getValue(), value)).findFirst().orElse(null);
    }
}
