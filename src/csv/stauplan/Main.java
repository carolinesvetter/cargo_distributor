package csv.stauplan;

public class Main {
    /**
     * "Abschlussprüfung Winter 2011/12 - Fachinformatiker/in Anwendungsentwicklung - Ganzheitliche Aufgaben 1"
     * → 4. Handlungsabschnitt
     * * There are 3 bays, each bay is split in 4 tiers
     * * In every bay there can be put a max amount of 4 containers
     * * Containers are distributed by descending weight: heaviest to lightest
     * * A Container will be distributed into the Bay with the lowest total weight
     * * The first container will be put into Bay 1
     * * If they Bays are all filled, or no Containers are available, the distribution will be stopped.
     */

    public static void main(String[] args) {
        Container[] containers = new Container[14];
        int weights = 50;
        // generate containers
        for (int i = 0; i < containers.length; i++) {
            containers[i] = new Container(i + 1, weights--);
        }

        outputString("All generated Containers: \n");
        outputArray(containers);
//        withSingleArrays(containers);
        withMultidimensionalArray(containers);
    }

    private static void withSingleArrays(Container[] containers) {
        int maxTier = 4;
        Container[] bay1 = new Container[maxTier];
        int bay1index = 0;
        int bay1weight = 0;

        Container[] bay2 = new Container[maxTier];
        int bay2index = 0;
        int bay2weight = 0;

        Container[] bay3 = new Container[maxTier];
        int bay3index = 0;
        int bay3weight = 0;

        outputString("\n\nDistribution Process: \n");
        // sort containers into bays
        for (Container c :
                containers) {
            if (bay1weight <= bay2weight && bay1index < maxTier) {
                if (bay1weight <= bay3weight) {
                    bay1[bay1index] = c;
                    bay1weight += c.getWeight();
                    bay1index++;
                } else {
                    bay3[bay3index] = c;
                    bay3weight += c.getWeight();
                    bay3index++;
                }
            } else if (bay2index <= bay3index && bay2index < maxTier) {
                bay2[bay2index] = c;
                bay2weight += c.getWeight();
                bay2index++;
            } else {
                if (bay3index < maxTier) {
                    bay3[bay3index] = c;
                    bay3weight += c.getWeight();
                    bay3index++;
                } else {
                    outputString("Bays are full. " + c.toString() + " not distributed.\n");
                    //break;
                }
            }
            outputString("Bay 1: " + bay1index + ", ");
            outputString("Bay 2: " + bay2index + ", ");
            outputString("Bay 3: " + bay3index + "\n");

        }
        outputString("\n\nBay 1:\n");
        outputArray(bay1);
        outputString("Total Bay1Weight = " + bay1weight + "\n\n");
        outputString("Bay 2:\n");
        outputArray(bay2);
        outputString("Total Bay2Weight = " + bay2weight + "\n\n");
        outputString("Bay 3:\n");
        outputArray(bay3);
        outputString("Total Bay3Weight = " + bay3weight + "\n\n");
    }


    public static Container[][] bays = new Container[3][4];
    public static int[] bayWeight = new int[3];
    public static int[] bayIndex = new int[3];

    private static void withMultidimensionalArray(Container[] containers) {
        int maxTier = 4;
        outputString("\n\nDistribution Process: \n");
        // sort containers into bays
        for (Container c :
                containers) {
            if (bayWeight[0] <= bayWeight[1] && bayIndex[0] < maxTier) {
                if (bayWeight[0] <= bayWeight[2]) {
                    fillBay(0, c);
                } else {
                    fillBay(2, c);
                }
            } else if (bayIndex[1] <= bayIndex[2] && bayIndex[1] < maxTier) {
                fillBay(1, c);
            } else {
                if (bayIndex[2] < maxTier) {
                    fillBay(2, c);
                } else {
                    outputString("Bays are full. " + c.toString() + " not distributed.\n");
                    //break;
                }
            }
            outputString("Bay 1: " + bayIndex[0] + ", ");
            outputString("Bay 2: " + bayIndex[1] + ", ");
            outputString("Bay 3: " + bayIndex[2] + "\n");

        }
        outputString("\n\nBay 1:\n");
        outputArray(bays[0]);
        outputString("Total bayWeight[0] = " + bayWeight[0] + "\n\n");
        outputString("Bay 2:\n");
        outputArray(bays[1]);
        outputString("Total bayWeight[1] = " + bayWeight[1] + "\n\n");
        outputString("Bay 3:\n");
        outputArray(bays[2]);
        outputString("Total bayWeight[2] = " + bayWeight[2] + "\n\n");

    }

    private static void fillBay(int i, Container c) {
        bays[i][bayIndex[i]] = c;
        bayWeight[i] += c.getWeight();
        bayIndex[i]++;
    }

    public static void outputString(String s) {
        System.out.print(s);
    }

    public static void outputArray(Object[] o) {
        for (Object n :
                o) {
            outputString(n.toString() + "\n");
        }

    }
}
