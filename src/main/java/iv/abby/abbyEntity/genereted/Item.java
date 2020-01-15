
package iv.abby.abbyEntity.genereted;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("IsOptional")
    private Boolean isOptional;
    @JsonProperty("Markup")
    private List<Markup> markup;
    @JsonProperty("Node")
    private String node;
    @JsonProperty("Text")
    private Object text;

}
