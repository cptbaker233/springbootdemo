package com.pactera.controller;

import com.pactera.pojo.Agent;
import com.pactera.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AgentController {

    @Autowired
    AgentService agentService;

    /* get请求/agent返回agent列表视图 */
    @RequestMapping(value = "/agent", method = RequestMethod.GET)
    public String listAgents(Model m) {
        List<Agent> agents = agentService.listAgents();
        m.addAttribute("agents", agents);
        return "agentsList";
    }

    /* post请求/agent/update, 跳转到更新席座页面 */
    @RequestMapping(value = "/agent/update", method = RequestMethod.POST)
    public String updateAgent(Agent agent, Model m) {
        agent = agentService.selectAgent(agent);
        m.addAttribute("agent", agent);
        return "updateAgent";
    }

    /* put请求到/agent/{work_id}, 执行更新席座信息业务 */
    @RequestMapping(value = "/agent/{work_id}", method = RequestMethod.PUT)
    public String updateAgentCommit(Agent agent, HttpServletRequest req) {
        String ip = req.getRemoteAddr();
        System.out.println("访问者的ID地址是: " + ip);
        agentService.updateAgent(agent);
        return "redirect:/agent";
    }

    /* delete请求到/agent/{work_id}, 执行删除席座业务 */
    @RequestMapping(value = "/agent/{work_id}", method = RequestMethod.DELETE)
    public String deleteAgent(Agent agent) {
        agentService.deleteAgent(agent);
        return "redirect:/agent";
    }

    /* get请求到/agent/inset, 跳转到添加席座页面 */
    @RequestMapping(value = "/agent/insert", method = RequestMethod.GET)
    public String insertAgent() {
        return "insertAgent";
    }

    /* post请求到/agent, 执行添加席座业务 */
    @RequestMapping(value = "/agent", method = RequestMethod.POST)
    public String insertAgentCommit(Agent agent) {
        agentService.insertAgent(agent);
        return "redirect:/agent";
    }

}