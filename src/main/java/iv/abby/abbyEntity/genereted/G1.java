
package iv.abby.abbyEntity.genereted;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class G1 {

    @JsonProperty("ArticleId")
    private String articleId;
    @JsonProperty("Body")
    private List<Body> body;
    @JsonProperty("Dictionary")
    private String dictionary;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("TitleMarkup")
    private List<TitleMarkup> titleMarkup;


}