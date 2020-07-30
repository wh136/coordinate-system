package com.wh136.xyz.neo4j.repository;


import com.wh136.xyz.neo4j.model.node.Person;
import com.wh136.xyz.neo4j.model.result.PersonMovie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends GraphRepository<Person> {
    @Query("MATCH (person:Person {name: {name}})-[r:ACTED_IN]->(movie) RETURN person,collect(movie) as movies")
    List<PersonMovie> getPersonMoviesbyName(@Param("name") String name);

    @Query("MATCH (person:Person {name: {name}})-[r:ACTED_IN]->(movies) RETURN person,r,movies")
    List<Person> getPersonByName(@Param("name") String name);
}
