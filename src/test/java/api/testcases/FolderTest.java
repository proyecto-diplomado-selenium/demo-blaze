package api.testcases;
import api.core.ApiManager;
import api.core.ApiMethod;
import api.core.ApiResponse;
import api.entities.folderResponse.FolderResponse;
import api.entities.folders.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FolderTest extends BaseTest{
    @Test(groups = {"getTeamsData","createSpace","deleteSpace"})
    public void getFoldersWithStatusCode200(){
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/space/{space_id}/folder")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"getTeamsData","createSpace","deleteSpace"})
    public void createFolder() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Folder folderTemp = new Folder();
        folderTemp.setName("Folder-Test");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/space/{space_id}/folder")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(folderTemp)).build();
        folderResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(FolderResponse.class);
        System.out.println(folderResponseEndToEnd.getId()+" "+folderResponseEndToEnd.getName());
        Assert.assertEquals(folderResponseEndToEnd.getName(), "Folder-Test");
    }

    @Test(groups = {"getTeamsData","createSpace","createFolder","deleteSpace"})
    public void updateFolder() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Folder folderTemp = new Folder();
        folderTemp.setName("Folder-Test-update");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.PUT).withEndpoint("/folder/{folder_id}")
                .withPathParams("folder_id", folderResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(folderTemp)).build();
        folderResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(FolderResponse.class);
        System.out.println(folderResponseEndToEnd.getId()+" "+folderResponseEndToEnd.getName());
        Assert.assertEquals(folderResponseEndToEnd.getName(), "Folder-Test-update");
    }

    @Test(groups = {"getTeamsData","createSpace","createFolder","deleteSpace"})
    public void deleteFolder() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();

        apiRequest = apiRequestBuilder.withMethod(ApiMethod.DELETE).withEndpoint("/folder/{folder_id}")
                .withPathParams("folder_id", folderResponseEndToEnd.getId().toString()).build();

        ApiResponse apiResponse  =  ApiManager.executeWithBody(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);

    }
}
