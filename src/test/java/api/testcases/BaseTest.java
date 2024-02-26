package api.testcases;

import api.core.*;
import api.entities.folderResponse.FolderResponse;
import api.entities.folders.Folder;
import api.entities.lists.Lists;
import api.entities.listsResponse.ListResponse;
import api.entities.spaces.*;
import api.entities.spacesResponse.SpaceResponse;
import api.entities.tasks.Task;
import api.entities.tasksResponse.TaskResponse;
import api.entities.teams.Teams;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Log;
import utils.ReportHelper;
import utils.ScreenShotHelper;

public class BaseTest {

    protected ApiRequest apiRequest = new ApiRequest();
    protected ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();

    Teams teamsEndToEnd = new Teams();
    Space spaceEndToEnd = new Space();
    SpaceResponse spaceResponseEndToEnd = new SpaceResponse();
    FolderResponse folderResponseEndToEnd = new FolderResponse();
    ListResponse listResponseEndToEnd = new ListResponse();
    TaskResponse taskResponseEndToEnd = new TaskResponse();

    @BeforeSuite
    public static void setUpSuite() throws Exception {
        ReportHelper.init("resource", "clickup");
    }
    @BeforeClass
    public void setup(){
        Log.info("Tests is starting!");
        ReportHelper.getInstance().startTest("API TESTING");
        apiRequest = apiRequestBuilder
                .withBaseUri("https://api.clickup.com/api/v2")
                .withHeaders("Authorization", "pk_3152928_8COTVONWADJ7JK1P5RD5ZUHIZY0PC898")
                .withHeaders("Content-Type", "application/json")
                .build();
    }

    @BeforeMethod(onlyForGroups = "getTeamsData")
    public void getTeamsDataBefore() throws JsonProcessingException {
        System.out.println("GET DATA TEAMS");
        ReportHelper.getInstance().startTest("API TESTS");
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/team").build();
        teamsEndToEnd = ApiManager.execute(apiRequest).getBody(Teams.class);
    }

    @BeforeMethod(dependsOnMethods = "getTeamsDataBefore",onlyForGroups = "createSpace")
    public void createdSpaceBefore() throws JsonProcessingException {
        System.out.println("CREATE SPACE BEFORE");
        Log.info("Tests is starting!");
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Space spaceTemp = new Space();
        spaceTemp.setName("Space-Test");
        spaceTemp.setMultiple_assignees(true);
        Features features = new Features();
        features.setDue_dates(new DueDates(true, false, true, false));
        features.setTime_tracking(new TimeTracking(false));
        features.setTags(new Tags(true));
        features.setTime_estimates(new TimeEstimates(true));
        features.setChecklists(new Checklists(true));
        features.setCustom_fields(new CustomFields(true));
        features.setRemap_dependencies(new RemapDependencies(true));
        features.setDependency_warning(new DependencyWarning(true));
        features.setPortfolios(new Portfolios(true));
        spaceTemp.setFeatures(features);
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/team/{team_id}/space")
                .withPathParams("team_id", teamsEndToEnd.getTeams().get(0).getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(spaceTemp)).build();

        spaceResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(SpaceResponse.class);
        System.out.println(spaceResponseEndToEnd.getId()+" "+spaceResponseEndToEnd.getName());

    }

    @AfterMethod(onlyForGroups = "deleteSpace")
    public void deleteSpaceAfter() {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.DELETE).withEndpoint("/space/{space_id}")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }


    /*
     * FOLDERS
     */

    @BeforeMethod(dependsOnMethods = "createdSpaceBefore",onlyForGroups = "createFolder")
    public void createFolderBefore() throws JsonProcessingException {
        System.out.println("CREATE FOLDER BEFORE");
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Folder folderTemp = new Folder();
        folderTemp.setName("Folder-Test");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/space/{space_id}/folder")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(folderTemp)).build();

        folderResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(FolderResponse.class);
        System.out.println(folderResponseEndToEnd.getId()+" "+folderResponseEndToEnd.getName());

    }

    /*
     * LISTS
     */

    @BeforeMethod(dependsOnMethods = "createdSpaceBefore",onlyForGroups = "createList")
    public void createListBefore() throws JsonProcessingException {
        System.out.println("CREATE LIST BEFORE");
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Lists listTemp = new Lists();
        listTemp.setName("List-Test");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/space/{space_id}/list")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(listTemp)).build();
        listResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(ListResponse.class);
        System.out.println(listResponseEndToEnd.getId()+" "+listResponseEndToEnd.getName());

    }

    /*
     * TASKS
     */

    @BeforeMethod(dependsOnMethods = "createListBefore",onlyForGroups = "createTask")
    public void createTaskBefore() throws JsonProcessingException {
        System.out.println("CREATE TASK BEFORE");
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Task taskTemp = new Task();
        taskTemp.setName("task-Test");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/list/{list_id}/task")
                .withPathParams("list_id", listResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(taskTemp)).build();
        taskResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(TaskResponse.class);
        System.out.println(listResponseEndToEnd.getId()+" "+listResponseEndToEnd.getName());

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        Log.info("Tests are ending!");
        try {
            switch (iTestResult.getStatus()){
                case ITestResult.FAILURE:
                    ReportHelper.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportHelper.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportHelper.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportHelper.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterSuite
    public void tearDown() {
        ReportHelper.getInstance().flush();
    }
}


