package containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class SampleContainer {
    public static void main(String[] args) throws ControllerException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profileImpl = new ProfileImpl();
        //se connecter dans le MainContainer
        profileImpl.setParameter(ProfileImpl.MAIN_HOST,"localhost");

        AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
        agentContainer.start();
    }
}
