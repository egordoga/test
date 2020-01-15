
package iv.abby.abbyEntity.genereted;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitleMarkup {

    @JsonProperty("IsAccent")
    private Boolean isAccent;
    @JsonProperty("IsItalics")
    private Boolean isItalics;
    @JsonProperty("IsOptional")
    private Boolean isOptional;
    @JsonProperty("Node")
    private String node;
    @JsonProperty("Text")
    private String text;

}
