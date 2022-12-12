package hartwig.interview.rps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RPSApplication.class, initializers = ConfigDataApplicationContextInitializer.class)
class RpsApplicationTests {

	@Test
	void contextLoads() {
	}

}
