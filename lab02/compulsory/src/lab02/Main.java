package lab02;

public class Main {

    public static void main(String[] args) {
        Source sources[] = new Source[3];
        Destination destinations[] = new Destination[3];

        for(int i = 0; i < 3; i++) {
            sources[i] = new Source("s");
            destinations[i] = new Destination("d");
        }

        sources[0].setName("S1");
        sources[1].setName("S2");
        sources[2].setName("S3");
        destinations[0].setName("D1");
        destinations[1].setName("D1");
        destinations[2].setName("D1");

        sources[0].setSupply(10);
        sources[1].setSupply(35);
        sources[2].setSupply(25);

        destinations[0].setDemand(20);
        destinations[1].setDemand(25);
        destinations[2].setDemand(25);
    }
}
