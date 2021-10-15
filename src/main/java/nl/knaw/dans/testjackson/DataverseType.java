package nl.knaw.dans.testjackson;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DataverseType {
  UNCATEGORIZED("UNCATEGORIZED"),
  ARCHEOLOGY("ARCH EOLOGY"),
  HUMANITIES("HUMANITIES");
  private String value;

  DataverseType(String displayValue) {
    value = displayValue;
  }

  @JsonValue
  public String value() { return value; }

  @Override public String toString() { return value; }
}

