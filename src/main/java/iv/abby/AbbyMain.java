package iv.abby;

public class AbbyMain {

    private static final String PATH = "e:\\test.txt";

    public static void main(String[] args) {
        JsonConvert jConv = new JsonConvert();
       // jConv.printObj(JsonData.am);
        jConv.printFromFile(PATH);
      //  jConv.printObj(SimplePojo.POJO);
    }
}
