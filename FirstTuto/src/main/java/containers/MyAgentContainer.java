package containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class MyAgentContainer {
    public static void main(String[] args) throws ControllerException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profileImpl = new ProfileImpl();
        profileImpl.setParameter(ProfileImpl.MAIN_HOST,"localhost");

        AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
        //Déployer un agent dans un Container
        AgentController agent1 = agentContainer.createNewAgent("Agent1", "agents.MyAgent", new Object[]{"SDIA"});
        agent1.start();
    }
}
