package com.wh136.xyz.neo4j.model.result;


import com.wh136.xyz.neo4j.model.node.Movie;
import com.wh136.xyz.neo4j.model.node.Person;
import lombok.Data;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.Set;

@QueryResult
@Data
public class PersonMovie {

    private Person person;

    private Set<Movie> movies;
}

