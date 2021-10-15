/*
 * Copyright (C) 2021 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.testjackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class JacksonTest {

  private static final Logger log = LoggerFactory.getLogger(JacksonTest.class);

  @Test
  public void canWriteJavaBeanToString() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new ExampleBean("First example", 0));
    log.debug("JSON follows\n{}", s);
    // TODO: add assertions
  }

  @Test
  public void canReadStringtoJavaBean() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    ExampleBean e = mapper.readValue(new File("src/test/resources/example1.json"), ExampleBean.class);
    log.debug("Name = {}", e.getName());
    Assertions.assertEquals("Ejemplo1", e.getName());
    Assertions.assertEquals(1, e.getDifficulty());
  }

  @Test
  public void canReadDataverseBean() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    DataverseBean e = mapper.readValue(new File("src/test/resources/dataverse.json"), DataverseBean.class);
    log.debug("Name = {}", e.getName());
    log.debug("DataverseType = {}", e.getDataverseType());
    Assertions.assertEquals(DataverseType.UNCATEGORIZED, e.getDataverseType());
  }

  @Test
  public void failsToReadReadInvalidDataverseBean() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.readValue(new File("src/test/resources/dataverse-invalid-enum.json"), DataverseBean.class);
    }
    catch (InvalidFormatException e) {
      Assertions.assertEquals(e.getMessage(), "Cannot deserialize value of type `nl.knaw.dans.testjackson.DataverseType` from String \"BLABLA\": not one of the values accepted for Enum class: [UNCATEGORIZED, LABORATORY, TEACHING COURSES, RESEARCH GROUP, RESEARCHERS, JOURNALS, RESEARCH PROJECTS, DEPARTMENT, ORGANIZATIONS INSTITUTIONS]\n" + " at [Source: (File); line: 7, column: 20] (through reference chain: nl.knaw.dans.testjackson.DataverseBean[\"dataverseType\"])");
    }
  }

  @Test
  public void canReadReadReadSpacedDataverseBean() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    DataverseBean e = mapper.readValue(new File("src/test/resources/dataverse-research-projects.json"), DataverseBean.class);
    log.debug("Name = {}", e.getName());
    log.debug("DataverseType = {}", e.getDataverseType());
    Assertions.assertEquals(DataverseType.RESEARCH_PROJECTS, e.getDataverseType());
  }

  @Test
  public void canWriteDataverseBeanToString() throws Exception {

  }

  @Test
  public void canReadataverseBeanToString() throws Exception {

  }

}
