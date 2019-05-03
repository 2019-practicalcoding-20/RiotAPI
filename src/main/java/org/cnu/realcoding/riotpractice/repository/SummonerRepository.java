package org.cnu.realcoding.riotpractice.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cnu.realcoding.riotpractice.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public class SummonerRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Collection<LeaguePositionDTO> insertLeaguePositionDTOs(List<LeaguePositionDTO> leaguePositionDTOs) {
        return mongoTemplate.insertAll(leaguePositionDTOs);
    }

//    public LeaguePositionDTO findLeaguePositionBySummonerName(String summonerName) {
//        Query query = new Query();
//
//        query.addCriteria(Criteria.where("name").is(summonerName));
//        query.with(Sort.by(Sort.Order.desc("_id")));
//
//        return mongoTemplate.findOne(query, LeaguePositionDTO.class);
//    }
}
