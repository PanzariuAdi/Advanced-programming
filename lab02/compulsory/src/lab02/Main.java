package lab02;

public class Main {

    public static void main(String[] args) {
        Source S1 = new Source();
        Source S2 = new Source();
        Source S3 = new Source();

        S1.setType(SourceType.FACTORY);
        S2.setType(SourceType.WAREHOUSE);
        S3.setType(SourceType.WAREHOUSE);

        System.out.println(S1);
        System.out.println(S2);
        System.out.println(S3);
    }
}
