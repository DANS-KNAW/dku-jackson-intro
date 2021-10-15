package nl.knaw.dans.testjackson;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DataverseType {
  //@formatter:off
  RESEARCHERS("RESEARCHERS"),
  RESEARCH_PROJECTS("RESEARCH PROJECTS"),
  JOURNALS("JOURNALS"),
  ORGANIZATIONS_INSTITUTIONS("ORGANIZATIONS INSTITUTIONS"),
  TEACHING_COURSES("TEACHING COURSES"),
  UNCATEGORIZED("UNCATEGORIZED"),
  LABORATORY("LABORATORY"),
  RESEARCH_GROUP("RESEARCH GROUP"),
  DEPARTMENT("DEPARTMENT");
  //@formatter:on

  private String value;

  DataverseType(String displayValue) {
    value = displayValue;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}

