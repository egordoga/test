package iv.abby;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import iv.abby.abbyEntity.dto.ExampleDto;
import iv.abby.abbyEntity.dto.TranslWithExDto;
import iv.abby.abbyEntity.genereted.Body;
import iv.abby.abbyEntity.genereted.GsonObj;
import iv.abby.abbyEntity.genereted.Item;
import iv.abby.abbyEntity.genereted.Markup;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JsonConvert {

    public void printObj(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        try {
            //  Minicard card = mapper.readValue(json, Minicard.class);
            //  Translation card = mapper.readValue(json, Translation.class);
            //  SimplePojo card = mapper.readValue(json, SimplePojo.class);
          //  ArticleModel card = mapper.readValue(json, ArticleModel.class);
           // System.out.println(card.toString());
            GsonObj gsonObj = mapper.readValue(json, GsonObj.class);
            StringBuilder sb = convertBody(gsonObj.getBodies());
            System.out.println("LIST --------------------------- SIZE: ");
            List<TranslWithExDto> list = convertSbToObj(sb);
            for (TranslWithExDto translWithExDto : list) {
                System.out.println(translWithExDto);
            }
            System.out.println("SIZE " + list.size());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void printFromFile(String path) {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Translation card = mapper.readValue(file, Translation.class);
            GsonObj card = mapper.readValue(JsonData.LOOK, GsonObj.class);
            System.out.println(card);
            //System.out.println(card.translation.get(0));
            if (card.getBodies().size() > 1) {
                for (Body body : card.getBodies()) {
                    switch (body.getNode()) {
                        case LIST:

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertSimpleParagraph(Markup markupIn) {
        StringBuilder sb = new StringBuilder();
        for (Markup markup : markupIn.getMarkupList()) {
            sb.append(markup.getText());
        }
        return sb.toString();
    }

    private String convertParagraph(Markup markupIn) {
        StringBuilder sb = new StringBuilder();
        for (Markup markup : markupIn.getMarkupList()) {
            switch (markup.getNode()) {
                case TEXT:
                    sb.append(markup.getText());
                    break;
                case COMMENT:
                    sb.append(convertSimpleParagraph(markup));
                    break;
                case ABBREV:
                    sb.append("/")
                            .append(markup.getText())
                            .append("/ ");
                    break;
                default:
                    return "";
            }
        }
        return sb.toString();
    }

    private TranslWithExDto convertListItem(Item item, List<TranslWithExDto> twes, StringBuilder sb) {
        TranslWithExDto twe = new TranslWithExDto();
        List<ExampleDto> exs = new ArrayList<ExampleDto>();
        String s = "";
        for (Markup markup : item.getMarkupList()) {
            switch (markup.getNode()) {
                case PARAGRAPH:
                    s = convertParagraph(markup).trim();
                    if (!s.equals("") && !(s.startsWith("/") && s.endsWith("/"))) {
                        twe = new TranslWithExDto();
                        twe.transl = s;
                    }
                    sb.append("TTTRRR").append(s).append("!*!");
                    System.out.println("TR " + s);
                    break;
                case LIST:
                    for (Item markupItem : markup.getItems()) {
                        convertListItem(markupItem, twes, sb);
                    }
                    break;
                case EXAMPLES:
                   // List<ExampleDto> exs = new ArrayList<ExampleDto>();
                    twe.exs = convertExampleItem(markup.getItems(), /*exs,*/ sb);
                   // twe.exs = exs;
                    break;
                default:
                    return null;
            }
        }
        twes.add(twe);
        return twe;
    }





//    private TranslWithExDto convertSimpleListItem(Item item, List<TranslWithExDto> twes) {
//        TranslWithExDto twe = new TranslWithExDto();
//        List<ExampleDto> exs = new ArrayList<ExampleDto>();
//        String s = "";
//        for (Markup markup : item.getMarkupList()) {
//            switch (markup.getNode()) {
//                case PARAGRAPH:
//                    s = convertParagraph(markup);
//                    twe.transl = s;
//                    System.out.println("TR " + s);
//                    break;
//                case LIST:
//                    for (Item markupItem : markup.getItems()) {
//                        convertListItem(markupItem, twes);
//                    }
//                    break;
//                case EXAMPLES:
//                    // List<ExampleDto> exs = new ArrayList<ExampleDto>();
//                    /*twe.exs = */convertExampleItem(markup.getItems(), exs);
//                    twe.exs = exs;
//                    break;
//                default:
//                    return null;
//            }
//        }
//        twes.add(twe);
//        return twe;
//    }


    private List<ExampleDto> convertExampleItem(List<Item> items, /*List<ExampleDto> exDtos,*/ StringBuilder sb) {
        List<ExampleDto> exDtos = new ArrayList<ExampleDto>();
        ExampleDto exDto;
        String s = "";
        for (Item item : items) {
            exDto = new ExampleDto();
            switch (item.getNode()) {
                case EXAMPLE_ITEM:
                    for (Markup markup : item.getMarkupList()) {
                        switch (markup.getNode()) {
                            case EXAMPLE:
                                exDto.en = markup.getMarkupList().get(0).getText();
                                exDto.ru = markup.getMarkupList().get(1).getText();
                                exDtos.add(exDto);
                                s = convertSimpleParagraph(markup);
                                sb.append("EEEXXX").append(s).append("!*!");
                                System.out.println("   EX    " + s);
                                break;
                        }
                    }
                    exDtos.add(exDto);
                    break;
            }

        }
        return exDtos;
    }

    private StringBuilder convertBody(List<Body> bodies) {
        List<TranslWithExDto> twes = new ArrayList<TranslWithExDto>();
        StringBuilder sb = new StringBuilder();
        for (Body body : bodies) {
            switch (body.getNode()) {
                case LIST:
                    for (Item item : body.getItems()) {
                        twes.add(convertListItem(item, twes, sb));
                    }
                    break;
                case PARAGRAPH:
                    break;
            }
        }
        System.out.println("-------------------------");
       // System.out.println(sb.toString());
        System.out.println("*************************************************");
        for (TranslWithExDto twe : twes) {
            System.out.println(twe);
        }
        System.out.println("*************************************************");
        return sb;
    }


    private List<TranslWithExDto> convertSbToObj(StringBuilder sb) {
        List<TranslWithExDto> list = new LinkedList<>();
        String[] arr = sb.toString().split("!*!");
        TranslWithExDto twe = new TranslWithExDto();
        for (String s : arr) {
            if (s.startsWith("TTTRRR")) {
                s = s.substring(6).trim();
                if (s.startsWith("/") && s.endsWith("/")) {
                    twe.transl = "";
                   // continue;
                } else {
                    list.add(twe);
                    twe = new TranslWithExDto();
                    twe.transl = s;
                }
            } else if (s.startsWith("EEEXXX")) {
                s = s.substring(6);
                ExampleDto exDto = new ExampleDto();
                String[] exs = s.split("—");
                exDto.en = exs[0];
                exDto.ru = exs[1];
                twe.exs.add(exDto);
            }

        }
        list.remove(0);
        return list;
    }
}
