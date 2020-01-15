
package iv.abby.abbyEntity.genereted;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String node;
    @JsonProperty("Text")
    private Object text;
    @JsonProperty("Type")
    private long type;

}
