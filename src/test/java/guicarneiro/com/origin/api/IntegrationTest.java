package guicarneiro.com.origin.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


@SpringBootTest
@AutoConfigureMockMvc
public abstract class IntegrationTest {

    private static WireMockServer wireMockServer;

    @BeforeAll
    static void proxyToWireMock() {
        wireMockServer = new WireMockServer(wireMockConfig().port(8080));
        wireMockServer.start();
    }

    @AfterEach
    public void resetWireMockInstance() {
        WireMock.reset();
    }

    @AfterAll
    static void noMoreWireMock() {
        wireMockServer.stop();
    }
}


