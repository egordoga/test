
package iv.abby.abbyEntity.genereted;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class G2 {

    private String articleId;
    private List<Body> body;
    private String dictionary;
    private String title;
    private List<TitleMarkup> titleMarkup;

}
