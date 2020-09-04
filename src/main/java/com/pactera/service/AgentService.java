package com.pactera.service;

import com.pactera.mapper.AgentMapper;
import com.pactera.pojo.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {
    @Autowired
    AgentMapper agentMapper;

    /* 列出所有席座 */
    public List<Agent> listAgents() {
        return agentMapper.listAgents();
    }

    /* 根据传入的席座对象, 更新该席座信息 */
    public void updateAgent(Agent agent) {
        agentMapper.updateAgent(agent);
    }

    /* 根据传入的席座对象, 删除该席座信息 */
    public void deleteAgent(Agent agent) {
        agentMapper.deleteAgent(agent);
    }

    /* 根据传入的席座对象, 添加该席座信息 */
    public void insertAgent(Agent agent) {
        agentMapper.insertAgent(agent);
    }
}