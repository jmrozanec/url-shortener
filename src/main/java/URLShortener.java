import java.util.HashMap;
import java.util.Map;

/**
 * Basic class. Can be adapted
 * - by doing a lookup to the DB where storing a URL/ID for persistent storage
 * - adding a cache in front of the application, to avoid most frequent requests hitting it
 */
public class URLShortener {
    private Map<String, Long> urls = new HashMap<>();
    private Long lastid = 0L;

    public String shorten(String url){
        Long id = 0L;
        if(urls.containsKey(url)){
            id = urls.get(url);
        }else{
            id = lastid++;
            urls.put(url, id);
        }
        return Long.toString(id, 36);
    }
}
