package com.wh136.xyz.dao;

import com.wh136.xyz.domain.Location;
import com.wh136.xyz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface LocationRepository extends JpaRepository<Location, String> {
    @Query("from Location where address =:address")
    Location getLongitudeLatitude(@Param("address") String address);

    @Transactional
    @Modifying
    @Query(value = "insert into t_location(address,longitude,latitude) values (?1,?2,?3)", nativeQuery = true)
    void setLongitudeLatitude(String address, String longitude, String latitude);
}
