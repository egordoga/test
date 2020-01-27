
package iv.abby.abbyEntity.genereted;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GsonObj {

    @JsonProperty("ArticleId")
    private String articleId;
    @JsonProperty("Body")
    private List<Body> bodies;
    @JsonProperty("Dictionary")
    private String dictionary;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("TitleMarkup")
    private List<TitleMarkup> titleMarkupList;


}
