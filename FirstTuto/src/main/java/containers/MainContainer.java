package containers;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class MainContainer {
    public static void main(String[] args) throws ControllerException {
        //Exécuter le framework jade : Récupère l'instance du moteur d'exécution JADE
        Runtime runtime = Runtime.instance();
        //Crée un nouveau profil pour la configuration de la plateforme JADE.
        ProfileImpl profileImpl = new ProfileImpl();
        //Spécifie un paramètre dans le profil pour activer l'interface graphique de la plateforme JADE
        profileImpl.setParameter(ProfileImpl.GUI,"true");

        //Crée un conteneur principal d'agents en utilisant le profil spécifié
        AgentContainer mainContainer = runtime.createMainContainer(profileImpl);
        mainContainer.start();
    }
}
