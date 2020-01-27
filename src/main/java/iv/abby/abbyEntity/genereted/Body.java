
package iv.abby.abbyEntity.genereted;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import iv.abby.abbyEntity.NodeType;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Body {

    @JsonProperty("IsOptional")
    private Boolean isOptional;
    @JsonProperty("Items")
    private List<Item> items;
    @JsonProperty("Node")
    private NodeType node;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("Type")
    private int type;

    @JsonProperty("Markup")
    private List<Markup> markups;

    @Override
    public String toString() {
        return "Body{" +
                "\n isOptional=" + isOptional +
                ",\n items=" + items +
                ",\n node='" + node + '\'' +
                ",\n text=" + text +
                ",\n type=" + type +
                ",\n markups=" + markups +
                '}';
    }
}
