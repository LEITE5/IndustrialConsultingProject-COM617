/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.time.Instant;
import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.junit.Test;
import static us.abstracta.jmeter.javadsl.JmeterDsl.httpSampler;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

/**
 *
 * @author leite
 */

public class PerformanceTest {
    

    // Ignore for now, used to run test without JMETER?
    
//      @Test
//  public void testPerformance() throws IOException {
//    TestPlanStats stats = testPlan(
//      threadGroup(2, 10,
//        httpSampler("http://my.service")
//          .post("{\"name\": \"test\"}", Type.APPLICATION_JSON)
//      ),
//      jtlWriter("test" + Instant.now().toString().replace(":", "-") + ".jtl")
//    ).run();
//    assertThat(stats.overall().elapsedTimePercentile99()).isLessThan(Duration.ofSeconds(5));
//  }
  
  // Main Test - JMeter will be placed on C: on host and used from there
  @Test
  public void jmeterPerformance() throws IOException {
    StandardJMeterEngine jmeter = new StandardJMeterEngine();
    JMeterUtils.loadJMeterProperties("D:\\Programs\\apache-jmeter-5.4.1\\bin\\jmeter.properties"); // /path/to/your/jmeter/bin/jmeter.properties
    JMeterUtils.setJMeterHome("D:\\Programs\\apache-jmeter-5.4.1"); // /path/to/your/jmeter
    JMeterUtils.initLocale();
    
    SaveService.loadProperties();
    
    HashTree testPlanTree = SaveService.loadTree(new File("./src/test/resources/solentTest.jmx")); // /path/to/your/jmeter/extras/Test.jmx
    Summariser summer = null;
    String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
    if (summariserName.length() > 0) {
        summer = new Summariser(summariserName);
    }

    String logFile = "./target/standardTest" + Instant.now().toString().replace(":", "-") + ".jtl\""; // /path/to/results/file.jtl
    ResultCollector logger = new ResultCollector(summer);
    logger.setFilename(logFile);
    testPlanTree.add(testPlanTree.getArray()[0], logger);

    jmeter.configure(testPlanTree);
    jmeter.run();
  }
  
}