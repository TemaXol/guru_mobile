package helpers;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStack {

// https://temax1:UqZNRz4pXCbssrdUHfUD@api.browserstack.com/app-automate/sessions/6847779d26b878d39b2d212d14b4a51af97b8577.json

    public static String getVideoUrl(String sessionId) {
        String uri = format("https://owserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic("temax1", "UqZNRz4pXCbssrdUHfUD")
                .when()
                .get(uri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
