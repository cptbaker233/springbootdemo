package com.pactera.mapper;

import com.pactera.pojo.Agent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AgentMapper {
    List<Agent> listAgents();

    void updateAgent(Agent agent);

    void deleteAgent(Agent agent);

    void insertAgent(Agent agent);

    Agent selectAgent(Agent agent);
}