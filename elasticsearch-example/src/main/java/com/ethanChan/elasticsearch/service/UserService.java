package com.ethanChan.elasticsearch.service;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ethanChan.elasticsearch.constant.Constant;
import com.ethanChan.elasticsearch.document.UserDocument;
import com.ethanChan.elasticsearch.dto.UserCityDto;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description es操作
 * @createTime 2022-08-28 23:13
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private RestHighLevelClient client;
    /**
     * 创建索引
     * @param index
     * @return
     * @throws IOException
     */
    public boolean createUserIndex(String index) throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 0)
        );
        createIndexRequest.mapping("{\n" +
                "  \"properties\": {\n" +
                "    \"city\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"sex\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"name\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"id\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"age\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    }\n" +
                "  }\n" +
                "}", XContentType.JSON);
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        return createIndexResponse.isAcknowledged();
    }

    /**
     * 删除索引
     * @param index
     * @return
     * @throws IOException
     */
    public Boolean deleteUserIndex(String index) throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
        AcknowledgedResponse deleteIndexResponse = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        return deleteIndexResponse.isAcknowledged();
    }

    /**
     * 创建文档
     * @param document
     * @return
     * @throws Exception
     */
    public Boolean createUserDocument(UserDocument document) throws Exception {
        UUID uuid = UUID.randomUUID();
        document.setId(uuid.toString());
        IndexRequest indexRequest = new IndexRequest(Constant.INDEX)
                .id(document.getId())
                .source(JSONUtil.toJsonStr(document), XContentType.JSON);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse.status().equals(RestStatus.OK);
    }

    /**
     * 批量创建文档
     * @param documents
     * @return
     * @throws IOException
     */
    public Boolean bulkCreateUserDocument(List<UserDocument> documents) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        for (UserDocument document : documents) {
            String id = UUID.randomUUID().toString();
            document.setId(id);
            IndexRequest indexRequest = new IndexRequest(Constant.INDEX)
                    .id(id)
                    .source(JSONUtil.toJsonStr(document), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        return bulkResponse.status().equals(RestStatus.OK);
    }

    /**
     * 查看文档
     * @param id
     * @return
     * @throws IOException
     */
    public UserDocument getUserDocument(String id) throws IOException {
        GetRequest getRequest = new GetRequest(Constant.INDEX, id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        UserDocument result = new UserDocument();
        if (getResponse.isExists()) {
            String sourceAsString = getResponse.getSourceAsString();
            result = JSONUtil.toBean(sourceAsString, UserDocument.class);
        } else {
            log.error("没有找到该 id 的文档");
        }
        return result;
    }

    /**
     * 更新文档
     * @param document
     * @return
     * @throws Exception
     */
    public Boolean updateUserDocument(UserDocument document) throws Exception {
        UserDocument resultDocument = getUserDocument(document.getId());
        UpdateRequest updateRequest = new UpdateRequest(Constant.INDEX, resultDocument.getId());
        updateRequest.doc(JSONUtil.toJsonStr(document), XContentType.JSON);
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        return updateResponse.status().equals(RestStatus.OK);
    }

    public List<UserDocument> getUserList() throws Exception {
        SearchRequest searchRequest = new SearchRequest(Constant.INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        return getSearchResult(searchResponse);
    }

    /**
     * 删除文档
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteUserDocument(String id) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest(Constant.INDEX, id);
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        return response.getResult().name();
    }

    /**
     * 搜索文档
     * @param city
     * @return
     * @throws Exception
     */
    public List<UserDocument> searchUserByCity(String city) throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(Constant.INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("city", city);
        searchSourceBuilder.query(termQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        return getSearchResult(searchResponse);
    }

    public List<UserCityDto> aggregationsSearchUser() throws Exception {
        SearchRequest searchRequest = new SearchRequest(Constant.INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_city")
                .field("city")
                .subAggregation(AggregationBuilders
                        .avg("average_age")
                        .field("age"));
        searchSourceBuilder.aggregation(aggregation);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        Aggregations aggregations = searchResponse.getAggregations();
        Terms byCityAggregation = aggregations.get("by_city");
        List<UserCityDto> userCityList = new ArrayList<>();
        for (Terms.Bucket buck : byCityAggregation.getBuckets()) {
            UserCityDto UserCityDto = new UserCityDto();
            UserCityDto.setCity(buck.getKeyAsString());
            UserCityDto.setCount(buck.getDocCount());
            // 获取子聚合
            Avg averageBalance = buck.getAggregations().get("average_age");
            UserCityDto.setAvgAge(averageBalance.getValue());
            userCityList.add(UserCityDto);
        }
        return userCityList;
    }
    private List<UserDocument> getSearchResult(SearchResponse response) {
        SearchHit[] searchHit = response.getHits().getHits();
        List<UserDocument> userDocuments = new ArrayList<>();
        for (SearchHit hit : searchHit) {
            userDocuments.add(JSONUtil.toBean(hit.getSourceAsString(), UserDocument.class));
        }
        return userDocuments;
    }
}
