package lab02;

public class Main {

    public static void main(String[] args) {
        Source S1 = new Source("s1");
        Source S2 = new Source("s2");
        Source S3 = new Source("s3");

        S1.setType(SourceType.FACTORY);
        S2.setType(SourceType.WAREHOUSE);
        S3.setType(SourceType.WAREHOUSE);

        System.out.println(S1);
        System.out.println(S2);
        System.out.println(S3);
    }
}
