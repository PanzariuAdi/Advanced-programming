package lab02;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
         Source S1 = new Warehouse("Bogota", 10);
         Source S2 = new Factory("Medellin", 35);
         Source S3 = new Warehouse("Cali", 25);

         Destination D1 = new Destination("Miami", 20);
         Destination D2 = new Destination("New York", 25);
         Destination D3 = new Destination("San Francisco", 25);

         Problem p = new Problem(3, 3);
         p.addSource(S1);
         p.addSource(S2);
         p.addSource(S3);

         p.addDest(D1);
         p.addDest(D2);
         p.addDest(D3);

         int[][] costs = new int[3][3];
         costs[0][0] = 2;
         costs[0][1] = 3;
         costs[0][2] = 1;

         costs[1][0] = 5;
         costs[1][1] = 4;
         costs[1][2] = 8;

         costs[2][0] = 5;
         costs[2][1] = 6;
         costs[2][2] = 8;
         p.setCosts(costs);
//         p.showSources();
//         p.showDest();
         p.solve();

    }
}
