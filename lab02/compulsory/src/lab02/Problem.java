package lab02;

public class Problem {
    private Source sources[];
    private Destination destinations[];
    private int destNumber, sourceNumber;
    private int distances[][];

    Problem() {
        this.destNumber = 0;
        this.sourceNumber = 0;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
        this.destNumber = destinations.length;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
        this.sourceNumber = sources.length;
    }

    public void addDestination(Destination dest) {
        destinations[destNumber++] = dest;
    }

    public void addSource(Source source) {
        sources[sourceNumber++] = source;
    }

    public void setDistances(int[][] distances) {
        this.distances = distances;
    }

}
