package ElasticSearchAll;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class EsUtil {

	public String getEsResponse(String index, String key, String value) throws IOException {
		
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("URL")));
		BoolQueryBuilder matchQuery = QueryBuilders.boolQuery();
		matchQuery.must(QueryBuilders.matchQuery(key, value));
		SearchSourceBuilder ssBuilder = new SearchSourceBuilder();
		ssBuilder.query(matchQuery);
		
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices(index);
		searchRequest.source(ssBuilder);
		SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
		client.close();
		
		return response.toString();
	}
}



/*
Get udmIndex/_search
{
	"Query" : {
	"match" : { "consumerKey" : "12345"}
		}
}

// Search based on 2 conditions 
Post udmIndex/_search
{
	"Query" : {
	"bool" : { "must" : [ 
	{ "match" : { "consumerKey" : "12345"}},
	{ "match" : { "condition2" : "12345"}}
	]
	}
}
}

//Delete
 * 
 */

