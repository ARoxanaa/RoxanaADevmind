package P2_SurpriseApp;

public class Main {
    public static void addSurprises(IBag addTo, ISurprise[] surprises) {
        if (surprises != null) {
            for (int i = 0; i < surprises.length; i++) {
                addTo.put(surprises[i]);
            }
        }
    }
    public static void main(String[] args){
        //create GiveSurprise objects that initialize different types of containers and wait times
        GiveSurpriseAndApplause applause = new GiveSurpriseAndApplause("random",-1);
        GiveSurpriseAndHug hug = new GiveSurpriseAndHug("fifo", 1);
        GiveSurpriseAndSing sing = new GiveSurpriseAndSing("lifo",1);
        GiveSurpriseAndApplause applauseLifo = new GiveSurpriseAndApplause("lifo",5);
        GiveSurpriseAndHug hugRandom = new GiveSurpriseAndHug("random",3);
        GiveSurpriseAndSing singFifo = new GiveSurpriseAndSing("fifo",3);

        // add surprises to containers
        addSurprises(applause.getContainer(),GatherSurprises.gather(0));
        addSurprises(hug.getContainer(),GatherSurprises.gather(5));
        addSurprises(sing.getContainer(),GatherSurprises.gather(12));
        addSurprises(applauseLifo.getContainer(),GatherSurprises.gather(8));
        addSurprises(hugRandom.getContainer(),GatherSurprises.gather(0));
        addSurprises(singFifo.getContainer(),GatherSurprises.gather(12));

        // test give surprises functions
        applause.give();
        applause.giveAll();
        applause.give();

        System.out.println("applause finished");
        System.out.println();

        hug.give();
        hug.giveAll();
        hug.give();

        System.out.println("hug finished");
        System.out.println();


        sing.give();
        sing.giveAll();
        sing.give();

        System.out.println("sing finished");
        System.out.println();

        applauseLifo.give();
        applauseLifo.giveAll();
        applauseLifo.give();

        System.out.println("applauseLifo finished");
        System.out.println();

        hugRandom.give();
        hugRandom.giveAll();
        hugRandom.give();

        System.out.println("hugRandom finished");
        System.out.println();

        singFifo.give();
        singFifo.giveAll();
        singFifo.give();

        System.out.println("singFifo finished");
        System.out.println();


    }
}
