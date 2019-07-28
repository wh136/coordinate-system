package com.wh136.xyz.dao;

import com.wh136.xyz.domain.User;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends CrudRepository<LocationRepository, String> {
    @Query("from Location where address =:address")
    public String getLongitudeLatitude(@Param("address") String address);

    public String setLongitudeLatitude(String address, String logitude, String latitude);
}
