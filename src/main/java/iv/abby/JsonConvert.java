package iv.abby;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import iv.abby.abbyEntity.ArticleModel;
import iv.abby.abbyEntity.Translation;
import iv.abby.abbyEntity.genereted.G1;


import java.io.File;
import java.io.IOException;

public class JsonConvert {

    public void printObj(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        try {
          //  Minicard card = mapper.readValue(json, Minicard.class);
          //  Translation card = mapper.readValue(json, Translation.class);
          //  SimplePojo card = mapper.readValue(json, SimplePojo.class);
            ArticleModel card = mapper.readValue(json, ArticleModel.class);
            System.out.println(card.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void printFromFile(String path) {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Translation card = mapper.readValue(file, Translation.class);
            G1 card = mapper.readValue(file, G1.class);
            System.out.println(card);
            //System.out.println(card.translation.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
