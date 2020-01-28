package iv.abby;

public class AbbyMain {

    private static final String PATH = "e:\\test1.txt";

    public static void main(String[] args) {
        JsonConvert jConv = new JsonConvert();
        jConv.jsonToObj(JsonData.WISH);
       // jConv.printFromFile(PATH);
      //  jConv.printObj(SimplePojo.POJO);
    }
}
