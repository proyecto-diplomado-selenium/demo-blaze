package api.testcases;

import api.core.ApiManager;
import api.core.ApiMethod;
import api.core.ApiResponse;
import api.entities.teams.Teams;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamTest extends BaseTest{

    @Test()
    public void getNameTeam() {
        String expectedName = "Juan Pablo Gonzales's Workspace";
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/team").build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Teams teams = apiResponse.getBody(Teams.class);
        Assert.assertEquals(teams.getTeams().get(0).getName(),expectedName);
    }

    @Test()
    public void getAllTeam() {
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/team").build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test()
    public void getValidateSchemaTeam() {
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/team").build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        apiResponse.validateSchema("schemas/Teams.json");
    }
}
