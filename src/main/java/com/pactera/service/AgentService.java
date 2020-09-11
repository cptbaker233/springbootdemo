package com.pactera.service;

import com.pactera.mapper.AgentMapper;
import com.pactera.pojo.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "agentInfoes")
public class AgentService {
    @Autowired
    AgentMapper agentMapper;

    /* 列出所有席座 */
    @Cacheable(key = "'allAgents'")
    public List<Agent> listAgents() {
        return agentMapper.listAgents();
    }

    /* 根据传入的席座对象, 更新该席座信息 */
    @Caching(evict = {@CacheEvict(key = "'allAgents'")}, put = {@CachePut(key = "'agent-'+ #agent.getWork_id()")})
    public Agent updateAgent(Agent agent) {
        agentMapper.updateAgent(agent);
        return agentMapper.selectAgent(agent);
    }

    /* 根据传入的席座对象, 删除该席座信息 */
    @Caching(evict = {@CacheEvict(key = "'allAgents'"), @CacheEvict(key = "'agent-' + #agent.getWork_id()")})
    public void deleteAgent(Agent agent) {
        agentMapper.deleteAgent(agent);
    }

    /* 根据传入的席座对象, 添加该席座信息 */
    @Caching(evict = {@CacheEvict(key = "'allAgents'")}, cacheable = {@Cacheable(key = "'agent-' + #agent.getWork_id()")})
    public Agent insertAgent(Agent agent) {
        agentMapper.insertAgent(agent);
        return agentMapper.selectAgent(agent);
    }

    /* 查询单个座席信息 */
    @Cacheable(key = "'agent-' + #agent.getWork_id()")
    public Agent selectAgent(Agent agent) {
        return agentMapper.selectAgent(agent);
    }
}