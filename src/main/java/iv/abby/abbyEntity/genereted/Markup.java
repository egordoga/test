
package iv.abby.abbyEntity.genereted;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import iv.abby.abbyEntity.NodeType;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Markup {

    @JsonProperty("IsAccent")
    private Boolean isAccent;
    @JsonProperty("IsItalics")
    private Boolean isItalics;
    @JsonProperty("IsOptional")
    private Boolean isOptional;
    @JsonProperty("Markup")
    private List<Markup> markupList;
    @JsonProperty("Node")
    private NodeType node;
    @JsonProperty("Text")
    private String text;

    @JsonProperty("FileName")
    private String fileName;
    @JsonProperty("FullText")
    private String fullText;
    @JsonProperty("Type")
    private int type;
    @JsonProperty("Items")
    private List<Item> items;


    @Override
    public String toString() {
        return "Markup{" +
                "\nisAccent=" + isAccent +
                ",\n isItalics=" + isItalics +
                ",\n isOptional=" + isOptional +
                ",\n markup=" + markupList +
                ",\n node='" + node + '\'' +
                ",\n text='" + text + '\'' +
                ",\n fileName='" + fileName + '\'' +
                ",\n fullText='" + fullText + '\'' +
                '}';
    }
}
