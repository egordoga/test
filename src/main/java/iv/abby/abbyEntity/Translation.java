package iv.abby.abbyEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Translation {
    public List<ArticleModel> translation = new ArrayList<ArticleModel>();
}
