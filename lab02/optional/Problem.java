/**
 * Solve the problem by crossing the matrix and choose the smallest price for every demand.
 *
 *
 */

package lab02;

public class Problem {
    Source[] sources;
    Destination[] destinations;
    int nrSupplies, nrDemands;
    int[][] costs;
    int totalCost;

    Problem(int numberSources, int numberDest) {
        nrDemands = 0;
        nrSupplies = 0;
        this.sources = new Source[numberSources];
        this.destinations = new Destination[numberDest];
        this.costs = new int[numberSources][numberDest];
    }

    public void solve() {
        int sourceP = 0, destP = 0;
        for(int i = 0; i < nrDemands; i++) {
            while(destinations[i].getDemands() != 0) {
                int minim = 32000;
                for(int j = 0; j < nrSupplies; j++) {
                    if (costs[i][j] < minim && sources[j].getCapacity() > 0) {
                        minim = costs[i][j];
                        sourceP = j;
                        destP = i;
                    }
                }
                int supp, dem;
                supp = sources[sourceP].getCapacity();
                dem = destinations[i].getDemands();

                if(supp == dem) {
                    totalCost += costs[sourceP][destP] * supp;
                    sources[sourceP].setCapacity(0);
                    destinations[i].setDemands(0);
                    System.out.println("D" + (i + 1) + " units ---> " + supp + " cost " + costs[sourceP][destP] * dem);
                } else if (supp > dem) {
                    totalCost += costs[sourceP][destP] * dem;
                    System.out.println("D" + (i + 1) + " units ---> "  + dem + " cost " + costs[sourceP][destP] * dem);
                    sources[sourceP].setCapacity(supp - dem);
                    destinations[i].setDemands(0);
                } else {
                    totalCost += costs[sourceP][destP] * supp;
                    System.out.println("D" + (i + 1) + " units ---> " + (dem - supp) + " cost " + costs[sourceP][destP] * supp);
                    sources[sourceP].setCapacity(0);
                    destinations[i].setDemands(dem - supp);
                }
//                System.out.println("Total cost -> " + totalCost);
            }
        }

        System.out.println(totalCost);
    }

    public void addSource(Source source) {
        sources[nrSupplies] = source;
        nrSupplies++;
    }

    public void addDest(Destination dest) {
        destinations[nrDemands] = dest;
        nrDemands++;
    }

    public void showSources() {
        for(int i = 0; i < sources.length; i++) {
            System.out.println(sources[i]);
        }
    }

    public void showDest() {
        for(int i = 0; i < destinations.length; i++) {
            System.out.println(destinations[i]);
        }
    }

    public int[][] getCosts() {        return costs;
    }

    public void setCosts(int[][] costs) {
        this.costs = costs;
    }
}
