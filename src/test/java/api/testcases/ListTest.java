package api.testcases;
import api.core.ApiManager;
import api.core.ApiMethod;
import api.core.ApiResponse;
import api.entities.lists.Lists;
import api.entities.listsResponse.ListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListTest extends BaseTest{
    @Test(groups = {"getTeamsData","createSpace","deleteSpace"})
    public void getListsWithStatusCode200(){
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/space/{space_id}/list")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"getTeamsData","createSpace","deleteSpace"})
    public void createList() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Lists listTemp = new Lists();
        listTemp.setName("List-Test");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/space/{space_id}/list")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(listTemp)).build();
        listResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(ListResponse.class);
        System.out.println(listResponseEndToEnd.getId()+" "+listResponseEndToEnd.getName());
        Assert.assertEquals(listResponseEndToEnd.getName(), "List-Test");
    }

    @Test(groups = {"getTeamsData","createSpace","createList","deleteSpace"})
    public void updateList() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Lists listTemp = new Lists();
        listTemp.setName("List-Test-update");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.PUT).withEndpoint("/list/{list_id}")
                .withPathParams("list_id", listResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(listTemp)).build();
        listResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(ListResponse.class);
        System.out.println(listResponseEndToEnd.getId()+" "+listResponseEndToEnd.getName());
        Assert.assertEquals(listResponseEndToEnd.getName(), "List-Test-update");
    }

    @Test(groups = {"getTeamsData","createSpace","createList","deleteSpace"})
    public void deleteList() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();

        apiRequest = apiRequestBuilder.withMethod(ApiMethod.DELETE).withEndpoint("/list/{list_id}")
                .withPathParams("list_id", listResponseEndToEnd.getId().toString()).build();

        ApiResponse apiResponse  =  ApiManager.executeWithBody(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);

    }
}
