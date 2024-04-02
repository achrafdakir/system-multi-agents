package agents;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.wrapper.ControllerException;

public class MyAgent extends Agent {
    @Override
    protected void setup() {
        String nom = null;
        if (this.getArguments().length==1){
            nom = (String) this.getArguments()[0];
        }
        System.out.println("****** Initialisation de l'agent :"+this.getAID().getName());
        System.out.println("Je suis entrain de chercher : "+nom);

        /*
        addBehaviour(new Behaviour() {
            private int compteur = 0;
            @Override
            public void action() {
                compteur++;
                System.out.println("Action..."+compteur);
            }

            @Override
            public boolean done() {
                if (compteur == 100)
                    return true;
                return false;
            }
        });
         */

        /*
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("S'execute une seule fois");
            }
        });
         */

        /*
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("Action...");
            }
        });
         */
        /*
        addBehaviour(new TickerBehaviour(this,1000) {
            @Override
            protected void onTick() {
                System.out.println("**Action Tick**");
            }
        });
         */

        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        addBehaviour(parallelBehaviour);
        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("One shot action");
            }
        });

        parallelBehaviour.addSubBehaviour(new Behaviour() {
            private int compteur = 0;
            @Override
            public void action() {
                compteur++;
                System.out.println("Tentative "+compteur);
            }

            @Override
            public boolean done() {
                if (compteur == 20)
                    return true;
                return false;
            }
        });
    }

    @Override
    protected void beforeMove() {
        try {
            System.out.println("****** avant migration de "+this.getContainerController().getContainerName());
        } catch (ControllerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void afterMove() {
        try {
            System.out.println("****** après migration de "+this.getContainerController().getContainerName());
        } catch (ControllerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void takeDown() {
        System.out.println("****** Je m'arrete *********");
    }
}
